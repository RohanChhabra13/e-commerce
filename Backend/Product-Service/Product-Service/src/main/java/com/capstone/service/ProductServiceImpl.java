package com.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.exception.ProductAlreadyExist;
import com.capstone.exception.ProductNotFound;
import com.capstone.model.Product;
import com.capstone.repo.ProductRepository;

/**
 * The ProductServiceImpl class implements the ProductService interface and provides
 * the concrete implementation of methods for managing products in the system.
 * It interacts with the database (via ProductRepository) to perform CRUD operations on products.
 * This service class handles exceptions such as ProductAlreadyExist and ProductNotFound.
 *
 * @author Rohan Chhabra
 * @version 1.0
 * @since 2023-10-11
 */

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	 //(DAO) responsible for interacting with the database to perform CRUD 
	
	
	/**
     * Adds a new product to the system.
     *
     * @param p The Product object to be added.
     * @return The added Product object.
     * @throws ProductAlreadyExist If a product with the same ID already exists in the system.
     */
	@Override
	public Product add(Product p) throws ProductAlreadyExist {
		if(repo.existsById(p.getId())) {
			throw new ProductAlreadyExist("Product with id:"+p.getId()+"\talready exist");
		}
		else {
		return repo.save(p);
		}
	}

	/**
     * Retrieves a product by its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @return The Product object with the specified ID.
     * @throws ProductNotFound If no product with the given ID is found.
     */
	@Override
	public Product find(int id) {
		return repo.findById(id).orElseThrow(()-> new ProductNotFound("Invalid Product ID"+id));
	}
	
	/**
     * Retrieves a list of all products in the system.
     *
     * @return A list of Product objects.
     */
	@Override
	public List<Product> list() {
		return repo.findAll();
	}
	
	/**
     * Deletes a product by its unique identifier.
     *
     * @param id The unique identifier of the product to be deleted.
     */
	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}
	/**
     * Updates an existing product.
     *
     * @param p The updated Product object.
     * @return The updated Product object.
     * @throws ProductNotFound If the product to be updated is not found.
     */
	@Override
	public Product update(Product p) {
		if(repo.existsById(p.getId())) {
		return repo.save(p);	
		}
		else {
			throw new ProductNotFound("Product not found"+p.getId());
		}
	}
	/**
     * Retrieves a list of products by category.
     *
     * @param category The category of products to retrieve.
     * @return A list of Product objects belonging to the specified category.
     */
	@Override
	public List<Product> listByCategory(String category) {
		
		return repo.findByCategory(category);
	}

}
