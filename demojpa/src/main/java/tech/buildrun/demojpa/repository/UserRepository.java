package tech.buildrun.demojpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.buildrun.demojpa.entitiy.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findByName(String name, PageRequest pageRequest);

    Page<UserEntity> findByAgeGreaterThanEqual(Long age, PageRequest pageRequest);

    Page<UserEntity> findByNameAndAgeGreaterThanEqual(String name, Long age, PageRequest pageRequest);
}
