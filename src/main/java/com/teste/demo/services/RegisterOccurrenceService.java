package com.teste.demo.services;

import org.springframework.stereotype.Service;

import com.teste.demo.entities.Delivery;
import com.teste.demo.entities.Occurrence;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;



@AllArgsConstructor
@Service
public class RegisterOccurrenceService {

    private FindDerliveryService service;


    @Transactional
    public Occurrence register(Long id, String description){
        Delivery delivery = service.find(id);

        return delivery.addOccurrence(description);

    }
    
}
