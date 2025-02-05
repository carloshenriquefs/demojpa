package tech.buildrun.demojpa.service;

import org.springframework.stereotype.Service;
import tech.buildrun.demojpa.controller.dto.CreateUserDto;
import tech.buildrun.demojpa.controller.dto.UpdateUserDto;
import tech.buildrun.demojpa.entitiy.UserEntity;
import tech.buildrun.demojpa.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.hasText;

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

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public Optional<UserEntity> updateById(Long userId, UpdateUserDto dto) {

        var user = userRepository.findById(userId);

        if (user.isPresent()) {

            updateFields(dto, user);

            userRepository.save(user.get());
        }

        return user;
    }

    public boolean deleteById(Long userId) {

        var exists = userRepository.existsById(userId);

        if (exists) {
            userRepository.deleteById(userId);
        }

        return exists;
    }

    private static void updateFields(UpdateUserDto dto, Optional<UserEntity> user) {
        if (hasText(dto.name())) {
            user.get().setName(dto.name());
        }

        if (!isNull(dto.age())) {
            user.get().setAge(dto.age());
        }
    }
}
