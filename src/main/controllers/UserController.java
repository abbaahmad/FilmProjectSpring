package com.flexisaf.fip.filmproject.controllers;

import com.flexisaf.fip.filmproject.models.User;
import com.flexisaf.fip.filmproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
//        user.setPassword(bCryptPasswordEncoder.
//                encode(user.getUsername()));
        userService.addUser(user);

    }

    @DeleteMapping(path="{username}")
    public void deleteUser(@PathVariable("username") String username){
        userService.deleteUser(username);
    }

    @PutMapping(path="{username}" )
    public void updateUser(@PathVariable("username") String username,
                           @RequestParam(required = true) String currentPassword,
                           @RequestParam(required = true) String newPassword){
        userService.updateUser(username, currentPassword, newPassword);
    }
    /*@GetMapping("/login")
    public String loginUser(@RequestBody User user){
        Optional<User> validUser = userService.getUser(user.getUsername());
        if(validUser.isEmpty()) throw new IllegalStateException("No such user: "+ user.getUsername());
        if(validUser.get().getPassword().equals(user.getPassword()))
            return "login";
        return "loginError";
    }*/
}
