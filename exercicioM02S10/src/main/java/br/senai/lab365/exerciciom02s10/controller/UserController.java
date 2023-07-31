package br.senai.lab365.exerciciom02s10.controller;

import br.senai.lab365.exerciciom02s10.dto.user.UserRequestPostDto;
import br.senai.lab365.exerciciom02s10.dto.user.UserResponseDto;
import br.senai.lab365.exerciciom02s10.mappers.UserMapper;
import br.senai.lab365.exerciciom02s10.model.UserEntity;
import br.senai.lab365.exerciciom02s10.service.UserService;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    static final String MESSAGE_ERROR_INVALID_DATA = "Invalid data";

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestPostDto user) {
        try {
            UserResponseDto newUser = this.userService.create(user);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(newUser.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (ConstraintViolationException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, MESSAGE_ERROR_INVALID_DATA, ex);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> listUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

}
