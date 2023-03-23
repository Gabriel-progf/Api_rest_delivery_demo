package com.teste.demo.services;


import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.teste.demo.dto.DeliveryDto;
import com.teste.demo.entities.Client;
import com.teste.demo.entities.Delivery;
import com.teste.demo.entities.DeliveryStatus;
import com.teste.demo.repositories.DeliveryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeliverySolicitationService extends GenericService<Delivery, DeliveryDto, Long> {

    private ClientService clientservice;

    private DeliveryRepository repo;

    @Transactional
    public Delivery solitation(Delivery delivery){

        Client client = clientservice.findClient(delivery.getClient().getId());

        delivery.setClient(client);
        delivery.setStatus(DeliveryStatus.PENDING);
        delivery.setOrderDate(OffsetDateTime.now());

        return repo.save(delivery);
    }

    
}
