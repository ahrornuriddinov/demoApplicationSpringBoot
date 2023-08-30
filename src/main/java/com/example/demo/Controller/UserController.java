package com.example.demo.Controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody User user){
        if (userService.checkUser(user.getLogin())){
            return new ResponseEntity<>("bu login mavjud", HttpStatus.BAD_REQUEST);
        }
        if (userService.checkPasswordLength(user.getPassword())){
            return new ResponseEntity<>("password uzunligi 4 dan kam",HttpStatus.BAD_REQUEST);
        }
        User user1 = userService.saveUser(user);
        return ResponseEntity.ok(user1);
    }
}
