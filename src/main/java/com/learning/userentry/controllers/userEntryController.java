package com.learning.userentry.controllers;

import com.learning.userentry.entity.userEntry;
import com.learning.userentry.service.userEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class userEntryController {
    @Autowired
    private userEntryService user_Entry_Service;

    @PostMapping("create-user")
    public String createUser(@RequestBody userEntry user){
        user_Entry_Service.saveEntry(user);
        return "User Successfully Registered";
    }

    @GetMapping("getAllUser")
    public List<userEntry> getAllUser(){
        return user_Entry_Service.getAllUser();
    }
    @GetMapping("id/{id}")
    public Optional<userEntry> getUserById(@PathVariable Long id){
        return user_Entry_Service.getUserById(id);
    }
    @GetMapping("delete/id/{id}")
    public String deleteUserById(@PathVariable Long id){
        user_Entry_Service.deleteUserById(id);
        return "Successfully delete the user";
    }
    @PutMapping("update/id/{id}")
    public userEntry updateById(@PathVariable Long id,@RequestBody userEntry updatedUser){
        return user_Entry_Service.updateUserById(id,updatedUser);
    }
    @GetMapping("deleteAll")
    public String deleteAllUser(){
        user_Entry_Service.deleteALlUser();
        return "Successfully deleted All user from MySql";
    }


}
