package com.capstone;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.capstone.entity.Customer;
import com.capstone.exception.CustomerAlreadyExistsException;
import com.capstone.exception.CustomerNotFoundException;
import com.capstone.repo.CustomerRepository;
import com.capstone.service.CustomerServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)@ContextConfiguration(classes=CustomerServiceApplication.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository repo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddNewCustomer() {
        // Create a sample customer
        Customer sampleCustomer = new Customer();
        sampleCustomer.setCustid("sampleCustId");
        sampleCustomer.setName("John Doe");
        sampleCustomer.setMobile("1234567890");
        sampleCustomer.setPassword("password123");
        sampleCustomer.setEmail("johndoe@example.com");

        // Mock the behavior of the repo.existsById method
        when(repo.existsById(sampleCustomer.getCustid())).thenReturn(false);

        // Mock the behavior of the repo.save method
        when(repo.save(sampleCustomer)).thenReturn(sampleCustomer);

        try {
            // Test when the customer doesn't already exist
            Customer addedCustomer = customerService.add(sampleCustomer);
            assertEquals(sampleCustomer, addedCustomer);
        } catch (CustomerAlreadyExistsException e) {
            fail("Customer should not already exist.");
        }
    }
    
    @Test
    public void testFindExistingCustomer() {
        // Create a sample customer
        Customer sampleCustomer = createSampleCustomer("1", "John Doe");

        // Mock the behavior of the repo.findById method
        when(repo.findById(sampleCustomer.getCustid())).thenReturn(Optional.of(sampleCustomer));

        try {
            // Test when the customer with the given custid exists
            Customer foundCustomer = customerService.find(sampleCustomer.getCustid());
            assertEquals(sampleCustomer, foundCustomer);
        } catch (CustomerNotFoundException e) {
            fail("Customer should exist.");
        }
    }

    @Test(expected = CustomerNotFoundException.class)
    public void testFindNonExistingCustomer() {
        // Define the custid of a non-existing customer
        String nonExistingCustid = "nonExistingId";

        // Mock the behavior of the repo.findById method to return an empty optional
        when(repo.findById(nonExistingCustid)).thenReturn(Optional.empty());

        // Call the find method with the non-existing custid, which should throw a CustomerNotFoundException
        customerService.find(nonExistingCustid);
    }

    @Test
    public void testListCustomers() {
        // Create a list of sample customers
        List<Customer> sampleCustomers = new ArrayList<>();
        sampleCustomers.add(createSampleCustomer("1", "John Doe"));
        sampleCustomers.add(createSampleCustomer("2", "Jane Smith"));
        sampleCustomers.add(createSampleCustomer("3", "Alice Johnson"));

        // Mock the behavior of the repo.findAll method
        when(repo.findAll()).thenReturn(sampleCustomers);

        // Call the list method to get the list of customers
        List<Customer> listedCustomers = customerService.list();

        // Assert that the returned list matches the sample list
        assertEquals(sampleCustomers, listedCustomers);
    }

    private Customer createSampleCustomer(String custId, String name) {
        Customer customer = new Customer();
        customer.setCustid(custId);
        customer.setName(name);
        // Set other properties as needed
        return customer;
    }

    @Test
    public void testAuthenticateCustomer() {
        // Create a sample customer
        Customer sampleCustomer = createSampleCustomer("John Doe", "password123");

        // Mock the behavior of the repo.findByCustidAndPassword method
        when(repo.findByCustidAndPassword(sampleCustomer.getCustid(), sampleCustomer.getPassword())).thenReturn(Optional.of(sampleCustomer));

        try {
            // Test when the customer with the given custid and password exists
            Customer authenticatedCustomer = customerService.authenticate(sampleCustomer.getCustid(), sampleCustomer.getPassword());
            assertEquals(sampleCustomer, authenticatedCustomer);
        } catch (CustomerNotFoundException e) {
            fail("Customer should exist with the provided credentials.");
        }
    }

    @Test(expected = CustomerNotFoundException.class)
    public void testAuthenticateNonExistingCustomer() {
        // Define the custid and password of a non-existing customer
        String nonExistingCustid = "nonExistingId";
        String password = "password123";

        // Mock the behavior of the repo.findByCustidAndPassword method to return an empty optional
        when(repo.findByCustidAndPassword(nonExistingCustid, password)).thenReturn(Optional.empty());

        // Call the authenticate method, which should throw a CustomerNotFoundException
        customerService.authenticate(nonExistingCustid, password);
    }
   }
