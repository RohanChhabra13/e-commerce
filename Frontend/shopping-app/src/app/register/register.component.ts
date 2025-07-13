import { Component } from '@angular/core';
import { Customer } from '../customer.model';
import { CustomerService } from '../services/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  // Customer object to store customer information
  c: Customer = new Customer();

  constructor(private service: CustomerService, private router: Router) { }
  // Function to save customer registration data
  save() {
    // Call the CustomerService to add the customer information
    this.service.add(this.c);
    // Navigate to the login page after successful registration
    this.router.navigate(['/login']);
  }

  
}

