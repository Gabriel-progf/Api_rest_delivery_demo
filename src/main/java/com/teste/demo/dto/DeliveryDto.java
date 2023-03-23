package com.teste.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.teste.demo.entities.Client;
import com.teste.demo.entities.Delivery;
import com.teste.demo.entities.DeliveryStatus;
import com.teste.demo.entities.Destination;
import com.teste.demo.entities.ValidationGroups;
import com.teste.demo.util.Convertible;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DeliveryDto implements Serializable, Convertible<Delivery> {
    
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
    @NotNull
    private Client client;

    @Valid
    @NotNull
    private Destination destination;

    @JsonProperty(access = Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @NotNull
    private BigDecimal fee;
    
    @JsonProperty(access = Access.READ_ONLY)
    private OffsetDateTime orderDate;
    
    
    @JsonProperty(access = Access.READ_ONLY)
    private OffsetDateTime finalizationDate;


    public DeliveryDto(Delivery delivery) {
        setId(delivery.getId());
        setClient(delivery.getClient());
        setDestination(delivery.getDestination());
        setStatus(delivery.getStatus());
        setFee(delivery.getFee());
        setOrderDate(delivery.getOrderDate());
        setFinalizationDate(delivery.getFinalizationDate());
    }


    @Override
    public Delivery convert() {
        return new Delivery(this);
    }
    

}
