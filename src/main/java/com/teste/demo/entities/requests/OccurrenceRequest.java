package com.teste.demo.entities.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OccurrenceRequest {
    
    @NotBlank
    private String description;

}
