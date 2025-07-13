import { Component } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { Router } from '@angular/router';
import { catchError, of } from 'rxjs';
import { Customer } from '../customer.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  cust : Customer = new Customer();
  custid : string = '';
  password : string = '';
  error: string = '';
  
  constructor(private service : CustomerService, private router : Router) { }

  authenticate() {
    // Check if the user is an admin
    if(this.custid === 'admin' && this.password === 'admin123')
     // Navigate to the admin dashboard if admin credentials are correct
      this.router.navigate(['/admin-dash']);
    else {
      // Call the CustomerService to validate customer credentials
      this.service.validate(this.custid, this.password).pipe(
        catchError(error => {
          // Handle authentication errors
          this.error = error.error.message;
          
          alert(this.error);
          return of();
        })
      ).subscribe(data => {
        // Store customer information in local storage
        localStorage.setItem("User", JSON.stringify(data));
        // Navigate to the customer dashboard after successful authentication
        this.router.navigate(['/customer-dash']);
    });
    }
  }

}
