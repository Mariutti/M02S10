package br.senai.lab365.exerciciom02s10.mappers;

import br.senai.lab365.exerciciom02s10.dto.pet.PetRequestPostDto;
import br.senai.lab365.exerciciom02s10.dto.pet.PetResponseDto;
import br.senai.lab365.exerciciom02s10.model.PetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PetMapper {
    PetEntity map(PetRequestPostDto source);
    PetResponseDto mapToPetResponseDto(PetEntity source);

}