import { Component } from '@angular/core';
import { Product } from '../product.model';
import { ProductService } from '../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-products',
  templateUrl: './add-products.component.html',
  styleUrls: ['./add-products.component.css']
})
export class AddProductsComponent {

  // Initialize a new Product object
  p: Product = new Product();

  // Define an array of product categories
  cat: string[] = ["Existentialism Classics", "Classical Romance", "Dystopian Fiction", "Drama"];

  // Constructor function to initialize the AddProductsComponent
  constructor(private service: ProductService, private router: Router) {
    // The constructor is used for dependency injection of services and dependencies.
    // In this case, it injects the ProductService and Router.
  }


  // Function to save a new product
  save() {
    // Call the ProductService to add the new product
    this.service.add(this.p);
    // Navigate to the list-products route after adding the product
    this.router.navigate(['/admin-dash/list-products']);

  }
}
