package com.capstone.service;

import java.util.List;

import com.capstone.entity.Cart;
import com.capstone.vo.CartTemplate;

public interface CartService {
	
	Cart add(Cart c);
	void delete (int cid);
	List<CartTemplate> list(String custid);
}
