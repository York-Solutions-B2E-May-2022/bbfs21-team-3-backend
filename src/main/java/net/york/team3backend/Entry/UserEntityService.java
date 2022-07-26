package net.york.team3backend.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserEntityService {
    UserEntityRepository userEntityRepository;
    HttpServletResponse response;
    private HashMap<UUID, Long> tokenMap;



    @Autowired
    public UserEntityService(UserEntityRepository userEntityRepository, HttpServletResponse response) {
        this.userEntityRepository = userEntityRepository;
        this.tokenMap = new HashMap<>();
        this.response = response;
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
            //Cookie Logic Please Keep
            UUID token = UUID.randomUUID();
            tokenMap.put(token, userEntity.getId());

            Cookie jwtTokenCookie = new Cookie("user-id", token.toString());
            jwtTokenCookie.setMaxAge(86400);
            jwtTokenCookie.setSecure(false);
            jwtTokenCookie.setHttpOnly(false);
            jwtTokenCookie.setPath("/");
            jwtTokenCookie.setDomain("localhost");
            response.addCookie(jwtTokenCookie);

            //NOTES
//            The request cookie is what is send from the client to the server
//            (thus what the browser provides). The response cookie are the cookies
//            that you want to place in the browser.The next connection from the browser
//            that accepted the cookie from the response object will provide the cookie in
//            the request object.


//            ResponseCookie resCookie = ResponseCookie.from("token", token.toString())
//                    .httpOnly(false)
////                    .sameSite("None")
//                    .secure(false)
//                    .path("/")
//                    .maxAge(Math.toIntExact(86400))
//                    .build();
//            response.addHeader("Set-Cookie", resCookie.toString());

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
