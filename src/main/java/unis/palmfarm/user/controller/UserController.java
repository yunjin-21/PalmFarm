package unis.palmfarm.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unis.palmfarm.user.dto.LoginDTO;
import unis.palmfarm.user.dto.UserDTO;
import unis.palmfarm.user.message.LoginMessage;
import unis.palmfarm.user.service.UserService;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(path = "/signup")
    public String signupUser(@RequestBody UserDTO userDTO){
        String nickname = userService.signup(userDTO);
        return nickname;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        LoginMessage loginMessage = userService.login(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }


}
