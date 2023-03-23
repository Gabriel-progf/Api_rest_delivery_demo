package com.teste.demo.dto;

import java.io.Serializable;

import com.teste.demo.entities.Client;
import com.teste.demo.util.Convertible;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
public class ClientDto implements Serializable, Convertible<Client> {

    public ClientDto(Client client) {
        setId(client.getId());
        setName(client.getName());
        setEmail(client.getEmail());
        setPhone(client.getPhone());
    }

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

    @Override
    public Client convert() {
        return new Client(this);
    }

}
