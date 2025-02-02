package tech.buildrun.demojpa.service;

import org.springframework.stereotype.Service;
import tech.buildrun.demojpa.controller.dto.CreateUserDto;
import tech.buildrun.demojpa.entitiy.UserEntity;
import tech.buildrun.demojpa.repository.UserRepository;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserEntity createUser(CreateUserDto dto) {

        var entity = new UserEntity();

        entity.setName(dto.name());
        entity.setAge(dto.age());
        entity.setCreatedAt(LocalDateTime.now());

        return userRepository.save(entity);
    }
}
