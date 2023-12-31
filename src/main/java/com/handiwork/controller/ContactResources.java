package com.handiwork.controller;

import com.handiwork.dto.ContactDto;
import com.handiwork.dto.ResponseDto;
import com.handiwork.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactResources {
    private final ContactService service;


    @Operation(
            method = "Add contact",
            description = "Need to send ContactDto to this endpoint to add",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Contact info",
                    content = @Content(mediaType = "application/json")),
            summary = "Add"
    )
    @PostMapping
    public ResponseDto<ContactDto> add(@Valid @RequestBody ContactDto contactDto){
        return service.add(contactDto);
    }

    @Operation(
            method = "Get all contacts",
            description = "This endpoint return all ContactDto",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Contact info",
                    content = @Content(mediaType = "application/json")),
            summary = "Get all"
    )
    @GetMapping
    public ResponseDto<List<ContactDto>> getAll(){
        return service.getAll();
    }

    @PutMapping
    public ResponseDto<ContactDto> update(@Valid @RequestBody ContactDto contactDto){
        return service.update(contactDto);
    }

    @GetMapping("/{id}")
    public ResponseDto<?> getById(@PathVariable String id){
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseDto<?> delete(@PathVariable String id){
        return service.delete(id);
    }
}
