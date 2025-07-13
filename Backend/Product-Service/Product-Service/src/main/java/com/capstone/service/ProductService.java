package com.capstone.service;

import java.util.List;

import com.capstone.model.Product;

/**
 * The ProductService interface defines the contract for managing products in the system.
 * Implementations of this interface provide methods for adding, retrieving, updating,
 * and deleting products, as well as listing products by category.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-11
 */

public interface ProductService {

	/**
     * Adds a new product to the system.
     *
     * @param p The Product object to be added.
     * @return The added Product object.
     */
	Product add (Product p);
	
	/**
     * Retrieves a product by its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @return The Product object with the specified ID, or null if not found.
     */
	Product find (int id);
	
	/**
     * Retrieves a list of all products in the system.
     *
     * @return A list of Product objects.
     */
	List <Product> list();
	
	/**
     * Deletes a product by its unique identifier.
     *
     * @param id The unique identifier of the product to be deleted.
     */
	void delete (int id);
	
	/**
     * Updates an existing product.
     *
     * @param p The updated Product object.
     * @return The updated Product object, or null if the product does not exist.
     */
	Product update(Product p);
	
	/**
     * Retrieves a list of products by category.
     *
     * @param category The category of products to retrieve.
     * @return A list of Product objects belonging to the specified category.
     */
	List <Product> listByCategory(String category);
}
