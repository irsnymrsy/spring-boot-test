package com.example.springBootTest.api.rest;

import com.example.springBootTest.domain.User;
import com.example.springBootTest.exception.UserNotFoundException;
import com.example.springBootTest.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id) {
        Optional<User> user = Optional.ofNullable(userService.findUserByID(id).orElseThrow(() -> new UserNotFoundException(id)));

        if(user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setBirthday(user.getBirthday());
        newUser.setSocialSecurityNumber(user.getSocialSecurityNumber());
        newUser.setDateCreated(new Date());
        newUser.setLastUpdated(new Date());
        newUser.setModifiedBy(user.getModifiedBy());
        newUser.setUpdatedBy(user.getUpdatedBy());
        newUser.setDeleted(user.getDeleted());

        return userService.saveUser(newUser);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return (List<User>) userService.findAllUser();
    }

    @PutMapping("/update/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return userService.replaceUser(newUser, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
 }
