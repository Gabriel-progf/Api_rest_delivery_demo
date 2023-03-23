package com.teste.demo.entities;

import java.io.Serializable;

import com.teste.demo.dto.ClientDto;
import com.teste.demo.util.Convertible;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
public class Client implements Serializable, Convertible<ClientDto>{

    @NotNull(groups = ValidationGroups.ClientId.class) //
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 20)
    private String phone;


    public Client(ClientDto client){
        setId(client.getId());
        setName(client.getName());
        setEmail(client.getEmail());
        setPhone(client.getPhone());
    }

    @Override
    public ClientDto convert() {
       return new ClientDto(this);
    }

}
