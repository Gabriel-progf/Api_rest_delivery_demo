package com.teste.demo.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teste.demo.assembler.OccurrenceAssembler;
import com.teste.demo.dto.OccurrenceDto;
import com.teste.demo.entities.Delivery;
import com.teste.demo.entities.Occurrence;
import com.teste.demo.entities.requests.OccurrenceRequest;
import com.teste.demo.services.FindDerliveryService;
import com.teste.demo.services.RegisterOccurrenceService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery/{id}/occurrence")
public class OccurrenceResource {

    private RegisterOccurrenceService registerOccurrenceService;

    private FindDerliveryService derliveryService;

    private OccurrenceAssembler occurrenceAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurrenceDto register(@PathVariable Long id, @Valid @RequestBody OccurrenceRequest occurrenceRequest) {

        Occurrence occurrence = registerOccurrenceService.register(id, occurrenceRequest.getDescription());

        return occurrenceAssembler.toDto(occurrence);

    }

    @GetMapping
    public List<OccurrenceDto> findAll(@PathVariable Long id){
        Delivery delivery = derliveryService.find(id);

        return occurrenceAssembler.toCollectionDto(delivery.getOcurrences());
    }





}
