package net.york.team3backend.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserEntityService {
    UserEntityRepository userEntityRepository;

    @Autowired
    public UserEntityService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public void register(UserEntity userEntity){
        if (userEntityRepository.findByEmail(userEntity.getEmail()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        } else {
            UserEntity newUser = new UserEntity();
            newUser.setName(userEntity.getName());
            newUser.setPassword(userEntity.getPassword());
            newUser.setEmail(userEntity.getEmail());
            newUser.setRole(userEntity.getRole());
            userEntityRepository.save(newUser);
        }
    }

    public UserEntity login(String user, String password){
        Optional<UserEntity> userEntity = userEntityRepository.findByNameAndPassword(user, password);
        if (userEntity.isPresent()){
            UUID token = UUID.randomUUID();
            UserEntity login = userEntity.get();
            login.setToken(token);
            userEntityRepository.save(login);
            return login;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
