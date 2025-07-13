import { Component, OnInit } from '@angular/core';
import { Product } from '../product.model';
//import { Cart } from '../cart.model';
import { CartTemplate } from '../carttemplate.model';
import { CartService } from '../services/cart.service';
//import { ProductService } from '../services/product.service';
//import { CustomerService } from '../services/customer.service';
import { Router } from '@angular/router';
import { Customer } from '../customer.model';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit{
  // Define an array to store cart items
  cart:CartTemplate[]=[];
  // Define a Customer object to retrieve user information
  c:Customer=JSON.parse(localStorage.getItem("User")!);
  constructor(private service:CartService){
    // Load cart items for the current customer
  this.service.list(parseInt(this.c.custid)).subscribe(data=>this.cart=data);
  }
  ngOnInit() {
    // Load cart items for the current customer
    this.service.list(parseInt(this.c.custid)).subscribe(data => this.cart = data);
  }
  // Function to delete a product from the cart
 delete(cid:number){
    if( confirm("Are you sure you want to remove this item from your cart")){
      // Call the CartService to delete the item
    this.service.delete(cid).subscribe();
    }
    // reloading page after
  location.reload();
}}
