package com.teste.demo.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.teste.demo.dto.OccurrenceDto;
import com.teste.demo.entities.Occurrence;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Component
public class OccurrenceAssembler {
    
    private ModelMapper modelMapper;

    public OccurrenceDto toDto(Occurrence occurrence){
        return modelMapper.map(occurrence, OccurrenceDto.class);
    }

    public List<OccurrenceDto> toCollectionDto(List<Occurrence> occurrences){
        return occurrences.stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

}
