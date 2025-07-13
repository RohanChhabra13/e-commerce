import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cart } from '../cart.model';
import { CartTemplate } from '../carttemplate.model';

@Injectable({
  //service indicates that the service should be provided as a singleton instance at the root level,
  // making it accessible throughout the entire application.
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) { }
  //injects the Angular HttpClient service, enabling the service to make HTTP requests for data retrieval and manipulation.

  add(c: Cart) {
    this.http.post("http://localhost:9003/cart/add/", c).subscribe(data => data = c);
  }
  delete(cid: number) {
    return this.http.delete("http://localhost:9003/cart/" + cid);
  }
  list(id: number) {
    return this.http.get<CartTemplate[]>("http://localhost:9004/cart/list/" + id);
  }
}
