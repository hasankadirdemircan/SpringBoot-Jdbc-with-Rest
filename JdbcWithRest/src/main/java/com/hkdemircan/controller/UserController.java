package com.hkdemircan.controller;

import com.hkdemircan.exception.InternalServerException;
import com.hkdemircan.exception.UserNotFoundException;
import com.hkdemircan.model.User;
import com.hkdemircan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
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

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.findUsers();
       return ResponseEntity.ok(users);
    }

}
