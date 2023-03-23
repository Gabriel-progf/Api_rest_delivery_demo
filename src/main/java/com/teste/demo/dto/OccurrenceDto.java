package com.teste.demo.dto;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OccurrenceDto {
    
    private Long id;
	private String description;
	private OffsetDateTime dateRegister;
	


}
