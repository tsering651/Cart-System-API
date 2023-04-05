package com.example.CartSystem.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CartSystem.CustomException.ResourceNotFoundException;
import com.example.CartSystem.ModalDTO.CartEntities;
import com.example.CartSystem.Service.CartService;


@RestController
@RequestMapping("/api/v1")
public class MainController {
    
	@Autowired
	private CartService cartservice;
	
	 @GetMapping("/getAllItems")
     public List<CartEntities> getItems() {
		 return cartservice.getAllItems();
    	
     }
	 @PostMapping("/addItem")
	 public CartEntities addItem(@RequestBody CartEntities item) {
		 
		 return cartservice.addEntity(item);
	 }
	 @GetMapping("/getItem/{id}")
	 public CartEntities getItems(@PathVariable int id) throws ResourceNotFoundException {
		 return cartservice.getItem(id);
	 }
	 @PutMapping("/update")
	 public CartEntities updateItem(@RequestBody CartEntities item) {
		 return cartservice.updateItem(item);
	 }
	 @DeleteMapping("/deleteItem/{id}")
	 
	 public ResponseEntity<String> deleteItem(@PathVariable int id) throws ResourceNotFoundException{
		 return cartservice.deleteAItem(id);
	 }
	 
}
