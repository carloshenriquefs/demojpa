package tech.buildrun.demojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.demojpa.entitiy.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
