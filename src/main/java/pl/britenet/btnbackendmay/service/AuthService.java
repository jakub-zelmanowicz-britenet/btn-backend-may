package pl.britenet.btnbackendmay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.britenet.campus.obj.model.User;
import pl.britenet.campus.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private final Map<String, User> loggedInUsers;
    private final UserService userService;

    @Autowired
    public AuthService(UserService userService) {
        this.loggedInUsers = new HashMap<>();
        this.userService = userService;
    }

    public Map<String, String> login(String username, String password) {
        Optional<User> oUser = this.userService.retrieve(username, password);
        User user = oUser.orElseThrow();

        String token = UUID.randomUUID().toString();
        this.loggedInUsers.put(token, user);

        Map<String, String> result = new HashMap<>();
        result.put("token", token);
        result.put("userId", String.valueOf(user.getId()));

        return result;
    }

}
