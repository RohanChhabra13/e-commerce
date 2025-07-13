import { Component } from '@angular/core';
import { Product } from '../product.model';
import { ProductService } from '../services/product.service';
import { Customer } from '../customer.model';
import { Cart } from '../cart.model';
import { CartService } from '../services/cart.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-categories',
  templateUrl: './list-categories.component.html',
  styleUrls: ['./list-categories.component.css']
})
export class ListCategoriesComponent {
  products:Product[]=[];

  cat: string[] = ["Existentialism Classics", "Classical Romance", "Dystopian Fiction", "Drama"];
 
  category:string='';
 
  c:Customer=JSON.parse(localStorage.getItem("User")!);
   c1:Cart=new Cart();
   constructor(private service:ProductService,private cservice:CartService,private router:Router){
    this.service.list().subscribe(data=>this.products=data);
    this.c1.custid=this.c.custid;
   }
   
   search(){
     this.service.listByCategory(this.category).subscribe((data: Product[]) => {this.products = data;})
   }
   add(id:number){
    this.c1.id=id;
    this.cservice.add(this.c1);
    // Navigate to the cart page after adding the product
    this.router.navigate(['/customer-dash/cart']);
  }
}
