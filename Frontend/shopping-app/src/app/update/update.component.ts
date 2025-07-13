import { Component } from '@angular/core';
import { Product } from '../product.model';
import { ProductService } from '../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent {
  // Product object to store the product being updated
  p: Product = JSON.parse(localStorage.getItem("Product")!);
  cat: string[] = ["Existentialism Classics", "Classical Romance", "Dystopian Fiction", "Drama"];
  constructor(private service: ProductService, private router: Router) {
    // Constructor that injects ProductService and Router for dependency
  }

  update() {
    // Call the ProductService to update the product
    this.service.update(this.p);
    this.router.navigate(['admin-dash/list-products']);
  }
}
