package br.senai.lab365.exerciciom02s10.mappers;

import br.senai.lab365.exerciciom02s10.dto.user.UserRequestPostDto;
import br.senai.lab365.exerciciom02s10.dto.user.UserResponseDto;
import br.senai.lab365.exerciciom02s10.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserEntity map(UserRequestPostDto source);
    UserResponseDto mapToUserResponseDto(UserEntity source);

}