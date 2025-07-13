import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CustomerDashComponent } from './customer-dash/customer-dash.component';
import { AdminDashComponent } from './admin-dash/admin-dash.component';
import { ListProductsComponent } from './list-products/list-products.component';
import { ListCategoriesComponent } from './list-categories/list-categories.component';
import { CartComponent } from './cart/cart.component';
import { AddProductsComponent } from './add-products/add-products.component';
import { ListCustomersComponent } from './list-customers/list-customers.component';
import { UpdateComponent } from './update/update.component';
import { ListProductsCustomerComponent } from './list-products-customer/list-products-customer.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { PasswordPipe } from './pipes/password.pipe';
import { InrPipe } from './pipes/inr.pipe';
import { ProfileComponent } from './profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    CustomerDashComponent,
    AdminDashComponent,
    ListProductsComponent,
    ListCategoriesComponent,
    CartComponent,
    AddProductsComponent,
    ListCustomersComponent,
    UpdateComponent,
    ListProductsCustomerComponent,
    PasswordPipe,
    InrPipe,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
