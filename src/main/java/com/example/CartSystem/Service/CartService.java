package com.example.CartSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CartSystem.ModalDTO.CartEntities;
import com.example.CartSystem.Repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartrepository;
	
  
	public List<CartEntities> getAllItems(){
		 return cartrepository.findAll();
	}
	
	public CartEntities addEntity(CartEntities item) {
		cartrepository.save(item);
		return item;
	}
}
