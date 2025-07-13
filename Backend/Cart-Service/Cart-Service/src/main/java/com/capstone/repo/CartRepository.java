package com.capstone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
		
	List<Cart> findByCustid(String custid);
}
