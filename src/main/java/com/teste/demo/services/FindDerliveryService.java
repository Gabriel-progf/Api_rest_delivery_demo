package com.teste.demo.services;

import org.springframework.stereotype.Service;

import com.teste.demo.entities.Delivery;
import com.teste.demo.repositories.DeliveryRepository;
import com.teste.demo.services.exceptions.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FindDerliveryService {

    private DeliveryRepository repo;

    public Delivery find(Long id){
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Delivery not found."));
    }

    
    
}
