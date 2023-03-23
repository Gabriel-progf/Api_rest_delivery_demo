package com.teste.demo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.teste.demo.dto.DeliveryDto;
import com.teste.demo.services.exceptions.ResourceNotFoundException;
import com.teste.demo.util.Convertible;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Delivery implements Serializable, Convertible<DeliveryDto> {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class) // É usado para válidar somente um grupo de propriedades declarada.
    @NotNull
    @ManyToOne
    private Client client;

    @Valid
    @NotNull
    @Embedded
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

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrence> ocurrences = new ArrayList<>();

    @Override
    public DeliveryDto convert() {
        return new DeliveryDto(this);
    }

    public Delivery(DeliveryDto dto){
        setId(dto.getId());
        setClient(dto.getClient());
        setDestination(dto.getDestination());
        setStatus(dto.getStatus());
        setFee(dto.getFee());
        setOrderDate(dto.getOrderDate());
        setFinalizationDate(dto.getFinalizationDate());
    }

    public Occurrence addOccurrence(String description){
        Occurrence occurrence = new Occurrence();
        occurrence.setDescription(description);
        occurrence.setRegisterDate(OffsetDateTime.now());
        occurrence.setDelivery(this);

        this.getOcurrences().add(occurrence);

        return occurrence;

    }

    public void finalization(){
        if (canNotFinalizantion()){
            throw new ResourceNotFoundException("Delivery not be finalized.");
        }

        setStatus(DeliveryStatus.FINALIZED);
        setFinalizationDate(OffsetDateTime.now());
    }

    public boolean canFinalizantion(){
        return DeliveryStatus.PENDING.equals(getStatus());
    }


    public boolean canNotFinalizantion(){
        return !canFinalizantion();
    }


    
}
