package com.capstone.service;

 

import java.util.ArrayList;
import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.capstone.entity.Cart;
import com.capstone.repo.CartRepository;
import com.capstone.vo.CartTemplate;
import com.capstone.vo.Product;

 

@Service
public class CartServiceImpl implements CartService {

 

	@Autowired
	private CartRepository repo;
	 //(DAO) responsible for interacting with the database to perform CRUD 

	@Autowired
	private RestTemplate rest;

 

	@Override
	public Cart add(Cart c) {
		return repo.save(c);
	}

 

	@Override
	public void delete(int cid) {
		repo.deleteById(cid);
	}

 

	@Override
	public List<CartTemplate> list(String custid) {
		List<Cart> carts = repo.findByCustid(custid);
		// Make the REST API call to retrieve a list of products
		ResponseEntity<List<Product>> productResponse = rest.exchange(
				"http://localhost:9001/product/all",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Product>>() {
				});
		List<Product> products = productResponse.getBody();
		List<CartTemplate> items = new ArrayList<>();
		// Logic to filter products list based on cart product ids
		for (Cart c : carts) {
			CartTemplate ct = new CartTemplate();
			ct.setCart(c);
			// Find the product that matches the cart's product id
			Product cartProduct = products.stream().filter(p -> p.getId() == c.getId()).findFirst().orElse(null);
			ct.setProduct(cartProduct);
			items.add(ct);
		}
		return items;
	}

 

}