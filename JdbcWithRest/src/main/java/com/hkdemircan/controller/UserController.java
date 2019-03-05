package com.hkdemircan.controller;

import com.hkdemircan.exception.InternalServerException;
import com.hkdemircan.exception.UserNotFoundException;
import com.hkdemircan.model.User;
import com.hkdemircan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserController {
    @Autowired
    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        }catch (UserNotFoundException ex){
           throw ex;
        }catch (Exception ex){
            throw new InternalServerException(ex);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.findUsers();
       return ResponseEntity.ok(users);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User userRequest){
        try{
            User user = userService.findUser(id);
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            userService.updateUser(user);
        return ResponseEntity.ok().build();
        }catch (UserNotFoundException ex){
            return  ResponseEntity.notFound().build();
        }catch (Exception ex){
            throw new InternalServerException(ex);
        }
    }
    @PostMapping("/user")
    public ResponseEntity<URI> createUser(@RequestBody User user){
        try{
            userService.createUser(user);
            Long id = user.getId();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        }catch (Exception ex){
            throw new InternalServerException(ex);
        }
    }

}
