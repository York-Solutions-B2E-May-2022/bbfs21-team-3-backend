package net.york.team3backend.Entry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByName(String username);

    Optional<UserEntity> findByNameAndPassword(String username, String password);
}
