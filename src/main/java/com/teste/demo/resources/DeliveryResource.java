package com.teste.demo.resources;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teste.demo.dto.DeliveryDto;
import com.teste.demo.entities.Delivery;
import com.teste.demo.services.DeliverySolicitationService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryResource {
    
    private DeliverySolicitationService service;


    @GetMapping
    public ResponseEntity<List<DeliveryDto>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Delivery solicition(@RequestBody Delivery delivery){
        return service.solitation(delivery);
    }

    

    



}
