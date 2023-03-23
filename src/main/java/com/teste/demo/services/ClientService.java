package com.teste.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.demo.dto.ClientDto;
import com.teste.demo.entities.Client;
import com.teste.demo.repositories.ClientRepository;
import com.teste.demo.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ClientService extends GenericService<Client, ClientDto, Long> {

    @Autowired
    private ClientRepository repo;

    @Transactional
    public ClientDto save(ClientDto clientdto) {

        Client client = fromDto(clientdto);

        boolean ClientExist = repo.findByEmail(client.getEmail()).stream().anyMatch(c -> !c.equals(client));

        if (ClientExist) {
            throw new ResourceNotFoundException("Client already exist");
        }

        repo.save(client);

        return clientdto;

    }
    
    public static Client fromDto(ClientDto clientDto) {
        return new Client(clientDto.getId(), clientDto.getName(), clientDto.getEmail(), clientDto.getPhone());
    }

    public Client findClient(Long id){
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found"));

    }

}
