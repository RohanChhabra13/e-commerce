import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListProductsCustomerComponent } from './list-products-customer.component';

describe('ListProductsCustomerComponent', () => {
  let component: ListProductsCustomerComponent;
  let fixture: ComponentFixture<ListProductsCustomerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListProductsCustomerComponent]
    });
    fixture = TestBed.createComponent(ListProductsCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
