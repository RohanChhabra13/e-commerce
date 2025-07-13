import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../customer.model';

@Injectable({
  //service indicates that the service should be provided as a singleton instance at the root level,
  // making it accessible throughout the entire application.
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }
  //injects the Angular HttpClient service, enabling the service to make HTTP requests for data retrieval and manipulation.

  add(c: Customer) {
    this.http.post("http://localhost:9002/customer/add", c).subscribe(data => data = c);
  }
  find(custid: String) {
    return this.http.get("http://localhost:9004/customer" + custid);
  }
  list() {
    return this.http.get<Customer[]>("http://localhost:9002/customer/all");
  }
  validate(custid: string, password: string) {

    return this.http.get<Customer>("http://localhost:9004/customer/login", { params: new HttpParams().append("custid", custid).append("password", password) });
  }
}
