import { Component } from '@angular/core';
import { Customer } from '../customer.model';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {

  c: Customer = new Customer();
  custid:string='';
  constructor(private service : CustomerService) {
    this.c = JSON.parse(localStorage.getItem("User")!);

  };
}
