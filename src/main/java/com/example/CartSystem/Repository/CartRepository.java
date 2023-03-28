package com.example.CartSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CartSystem.ModalDTO.CartEntities;



@Repository
public interface CartRepository extends JpaRepository<CartEntities,Integer> {

}
