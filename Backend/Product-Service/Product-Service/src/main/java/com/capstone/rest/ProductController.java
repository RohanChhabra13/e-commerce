package com.capstone.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.model.Product;
import com.capstone.service.ProductService;
/**
 * The ProductController class handles HTTP requests related to products.
 * It provides RESTful endpoints for adding, retrieving, updating, and deleting products.
 *
 * @author Rohan Chhabra
 * @version 1.0
 * @since 2023-10-11
 */



//is a security concept that allows restricting the resources implemented in web browsers.
//It prevents the JavaScript code producing or consuming the requests against different origin.
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController //making restful web services
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	//service can hold an object of type ProductService
	//used for dependency injection to interact with services
	
	
	/**
     * Adds a new product to the system.
     *
     * @param p The Product object to be added.
     * @return The added Product object.
     */
	@PostMapping(value="/add",consumes="application/json")
	public Product add(@RequestBody Product p) {
		return service.add(p);
		
	}
	
	/**
     * Retrieves a product by its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @return The Product object with the specified ID.
     */
	@GetMapping(value="/{id}",produces="application/json")
	public Product find(@PathVariable int id){
		return	service.find(id);	
	}
	
	/**
     * Deletes a product by its unique identifier.
     *
     * @param id The unique identifier of the product to be deleted.
     */
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
	
	/**
     * Retrieves a list of all products in the system.
     *
     * @return A list of Product objects.
     */
	@GetMapping(value="/all",produces="application/json")
	public List<Product> list(){
		return service.list();
	}
	
	/**
     * Updates an existing product.
     *
     * @param p The updated Product object.
     * @return The updated Product object.
     */
	@PutMapping(value="/update",consumes="application/json")
	public Product Update(@RequestBody Product p) {
		return service.update(p);
	}
	
	/**
     * Retrieves a list of products by category.
     *
     * @param category The category of products to retrieve.
     * @return A list of Product objects belonging to the specified category.
     */
	@GetMapping(value="/category/{category}",produces="application/json")
	public List<Product> listbycategory(@PathVariable String category){
		return service.listByCategory(category);
	}
}
