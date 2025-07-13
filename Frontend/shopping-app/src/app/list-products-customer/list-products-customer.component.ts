import { Component } from '@angular/core';
import { Product } from '../product.model';
import { ProductService } from '../services/product.service';
import { Router } from '@angular/router';
import { Customer } from '../customer.model';
import { Cart } from '../cart.model';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-list-products-customer',
  templateUrl: './list-products-customer.component.html',
  styleUrls: ['./list-products-customer.component.css']
})
export class ListProductsCustomerComponent {

  // Array to store the list of products
  products: Product[] = [];
  // Cart object to add products to the cart
  cart: Cart = new Cart();
  // Customer object to store customer information
  c: Customer = new Customer();
  constructor(private service: ProductService, private cservice: CartService, private router: Router) {
    // Parse customer information from local storage
    this.c = JSON.parse(localStorage.getItem("User")!);
    // Load the list of products when the component is initialized
    this.service.list().subscribe(data => this.products = data);
  }
  add(id: number) {
    // Set the customer ID and product ID in the cart object
    this.cart.custid = this.c.custid;
    this.cart.id = id;
    // Call the CartService to add the product to the cart
    this.cservice.add(this.cart);
    // Navigate to the cart page after adding the product
    this.router.navigate(['/customer-dash/cart']);
  }
}
