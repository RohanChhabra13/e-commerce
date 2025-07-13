import { Component } from '@angular/core';
import { Customer } from '../customer.model';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-list-customers',
  templateUrl: './list-customers.component.html',
  styleUrls: ['./list-customers.component.css']
})
export class ListCustomersComponent {

  // Array to store the list of customers
  customers : Customer[] = [];

  constructor(private service : CustomerService) { 
   // Load the list of customers when the component is initialized
    this.service.list().subscribe(data => this.customers = data);
  }

}
