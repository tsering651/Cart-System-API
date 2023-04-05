package com.example.CartSystem.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.CartSystem.CustomException.ResourceNotFoundException;

//import org.springframework.http.HttpStatusCode;

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
	public CartEntities getItem(int id) throws ResourceNotFoundException {
		try {
			
			CartEntities cartentity= cartrepository.findById(id).get();
			return cartentity;
		}
		catch(NoSuchElementException e) {
			throw new ResourceNotFoundException("No item exits with this Id","404");
		}
		
	}
	public CartEntities updateItem(CartEntities item) {
		return cartrepository.save(item);
	}
	public ResponseEntity<String> deleteAItem(int id) throws ResourceNotFoundException{
		try {
			cartrepository.deleteById(id);
			return new ResponseEntity<>("success",HttpStatus.OK);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Cannot delete","404");
		}
		
	}
}
