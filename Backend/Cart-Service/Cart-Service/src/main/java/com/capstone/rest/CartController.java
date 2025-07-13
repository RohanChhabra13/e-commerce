package com.capstone.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.Cart;
import com.capstone.service.CartService;
import com.capstone.vo.CartTemplate;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService service;

	@PostMapping(value="/add",consumes="application/json")
	public Cart add(@RequestBody Cart c) {
		return service.add(c);
	}
	
	@DeleteMapping(value="/{id}",produces="application/json")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@GetMapping(value="/list/{custid}",produces="application/json")
	public List<CartTemplate> list(@PathVariable String custid) {
		return service.list(custid);
	}
}
