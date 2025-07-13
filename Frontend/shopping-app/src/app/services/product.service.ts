import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../product.model';

@Injectable({
  //service indicates that the service should be provided as a singleton instance at the root level,
  // making it accessible throughout the entire application.
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }
  //injects the Angular HttpClient service, enabling the service to make HTTP requests for data retrieval and manipulation.

  add(p: Product) {
    this.http.post("http://localhost:9001/product/add", p).subscribe(data => data = p);
  }

  find(id: number) {
    this.http.get<Product[]>("http://localhost:9004/product/" + id);
  }
  list() {
    return this.http.get<Product[]>("http://localhost:9004/product/all");
  }
  delete(id: number) {
    return this.http.delete("http://localhost:9001/product/" + id);
  }
  listByCategory(category: string) {
    return this.http.get<Product[]>("http://localhost:9001/product/category/" + category);
  }
  update(p: Product) {
    this.http.put("http://localhost:9001/product/update", p).subscribe(data => data = p);
  }
}
