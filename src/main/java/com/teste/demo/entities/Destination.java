package com.teste.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Destination {

    @NotBlank
    @Column(name = "destination_name")
    private String name;

    @NotBlank
    @Column(name = "destination_patio")
    private String patio;

    @NotBlank
    @Column(name = "destination_number")
    private String number;

    @NotBlank
    @Column(name = "destination_complement")
    private String complement;

    @NotBlank
    @Column(name = "destination_neighborhood")
    private String neighborhood;
}
