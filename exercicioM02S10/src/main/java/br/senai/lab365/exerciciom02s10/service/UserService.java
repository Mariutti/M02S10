package br.senai.lab365.exerciciom02s10.service;

import br.senai.lab365.exerciciom02s10.dto.user.UserRequestPostDto;
import br.senai.lab365.exerciciom02s10.dto.user.UserResponseDto;
import br.senai.lab365.exerciciom02s10.mappers.UserMapper;
import br.senai.lab365.exerciciom02s10.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDto create(UserRequestPostDto user) {
        return userMapper.mapToUserResponseDto(
                userRepository.save(
                        userMapper.map(user)
                )
        );
    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapToUserResponseDto)
                .toList();
    }
}
