import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AdminDashComponent } from './admin-dash/admin-dash.component';
import { AddProductsComponent } from './add-products/add-products.component';
import { ListProductsComponent } from './list-products/list-products.component';
import { ListCustomersComponent } from './list-customers/list-customers.component';
import { UpdateComponent } from './update/update.component';
import { CustomerDashComponent } from './customer-dash/customer-dash.component';
import { ListProductsCustomerComponent } from './list-products-customer/list-products-customer.component';
import { ListCategoriesComponent } from './list-categories/list-categories.component';
import { CartComponent } from './cart/cart.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {path:'login',component:LoginComponent},
  {path:'home',component:HomeComponent},
  {path:'admin-dash',component:AdminDashComponent,children:[
    {path:'add-products',component:AddProductsComponent},
    {path:'list-products',component:ListProductsComponent},
    {path:'list-customers',component:ListCustomersComponent},
    {path:'update',component:UpdateComponent}
  ]},
  {path:'customer-dash',component:CustomerDashComponent, children:[
    {path:'list-products-customer',component:ListProductsCustomerComponent},
    {path:'list-categories',component:ListCategoriesComponent},
    {path:'cart',component:CartComponent},
    {path:'profile',component:ProfileComponent}
  ]},
  {path:'register',component:RegisterComponent},
  {path:'**',redirectTo:'/home',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
