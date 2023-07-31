package br.senai.lab365.exerciciom02s10.service;

import br.senai.lab365.exerciciom02s10.dto.pet.PetRequestPostDto;
import br.senai.lab365.exerciciom02s10.dto.pet.PetResponseDto;
import br.senai.lab365.exerciciom02s10.mappers.PetMapper;
import br.senai.lab365.exerciciom02s10.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final PetMapper petMapper;


    public PetResponseDto create(PetRequestPostDto pet) {
        return petMapper.mapToPetResponseDto(
                petRepository.save(
                        petMapper.map(pet)
                )
        );
    }

    public List<PetResponseDto> findAll() {
        return petRepository.findAll()
                .stream()
                .map(petMapper::mapToPetResponseDto)
                .toList();
    }
}
