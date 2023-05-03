package com.gezakonczos.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    //GET /users
    @GetMapping("/users")
    public List<User> getUsers(){
        return userDaoService.findAll();
    }

    //GET /users
    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId){
        User user = userDaoService.findOne(userId);

        if(user == null){
            throw new UserNotFoundException("id: " + userId);
        }
        return user;
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId){
        userDaoService.deleteById(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUSer = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUSer.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
