import { Component } from '@angular/core';
import { Product } from '../product.model';
import { ProductService } from '../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent {

  // Array to store the list of products
  products : Product[] = [];
  // Temporary product object for updates
  p : Product = new Product();
   constructor(private productService: ProductService,private router : Router) {
    // Load the list of products when the component is initialized
    this.loadProducts();
   }
   // Function to load the list of products
  loadProducts(): void {
     // Subscribe to the ProductService to retrieve the list of products
    this.productService.list().subscribe((data) => {
      // Assign the retrieved data to the products array
    this.products = data;
    });
  }
  // Function to update a product
  update(p:Product){
     // Store the selected product in local storage for updating
    localStorage.setItem("Product",JSON.stringify(p));
    // Navigate to the update product page
    this.router.navigate(['/customer-dash/update']);
  }
  delete(id : number) {
     // Confirm the deletion action with a confirmation dialog
      if(confirm("Are you sure to delete!"))
        this.productService.delete(id).subscribe(()=>{
      // Reload the list of products after deletion
      this.loadProducts()
    });
   }
//When an async function is called, it returns a Promise.
// When the async function returns a value, the Promise will be resolved with the returned value.
// When the async function throws an exception or some value,
// the Promise will be rejected with the thrown value. 
// An async function can contain an await expression,
// that pauses the execution of the async function and waits for the past Promise’s resolution,
// and then resumes the async function’s execution and returns the resolved value.

}
