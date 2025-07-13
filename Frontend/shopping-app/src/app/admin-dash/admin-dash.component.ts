import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dash',
  templateUrl: './admin-dash.component.html',
  styleUrls: ['./admin-dash.component.css']
})
export class AdminDashComponent {

  constructor(private router: Router) {
    // Constructor function for the AdminDashComponent.
    // It injects the Router service for navigation.
  }

  // Function to handle logout
  logout() {
    // Navigate to the login route when the user logs out
    this.router.navigate(['/login']);

  }
}
