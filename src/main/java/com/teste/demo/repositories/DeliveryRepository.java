package com.teste.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.demo.entities.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {

    
}
