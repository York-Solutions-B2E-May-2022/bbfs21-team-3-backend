package net.york.team3backend.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@CrossOrigin
public class UserEntityController {
    UserEntityService userEntityService;

    @Autowired
    public UserEntityController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserEntity user){
         userEntityService.register(user);
    }

    @GetMapping("/login")
    public UserEntity login(@RequestParam String user, @RequestParam String password){
        return userEntityService.login(user, password);
    }

    @GetMapping("/logout")
    public void logout(@RequestParam UUID token){
        userEntityService.logout(token);
    }
    //Cookie Login Please Keep
    @GetMapping("/")
    public String getCookie(@CookieValue(name = "user-id") String userId) {
        System.out.println(userId);
            return userId;
    }
}
