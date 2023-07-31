package br.senai.lab365.exerciciom02s10.controller;

import br.senai.lab365.exerciciom02s10.dto.pet.PetRequestPostDto;
import br.senai.lab365.exerciciom02s10.dto.pet.PetResponseDto;
import br.senai.lab365.exerciciom02s10.dto.user.UserRequestPostDto;
import br.senai.lab365.exerciciom02s10.dto.user.UserResponseDto;
import br.senai.lab365.exerciciom02s10.service.PetService;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    static final String MESSAGE_ERROR_INVALID_DATA = "Invalid data";

    @PostMapping
    public ResponseEntity<PetResponseDto> create(@RequestBody PetRequestPostDto pet) {
        try {
            PetResponseDto newPet = petService.create(pet);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(newPet.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (ConstraintViolationException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, MESSAGE_ERROR_INVALID_DATA, ex);
        }
    }

    @GetMapping
    public ResponseEntity<List<PetResponseDto>> listAllPets(){
        return ResponseEntity.ok(petService.findAll());
    }

}
