package br.senai.lab365.exerciciom02s10.dto.user;

import br.senai.lab365.exerciciom02s10.model.RoleEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {
    private int id;
    private String name;

    private String username;

    private List<RoleEntity> roles;
}
