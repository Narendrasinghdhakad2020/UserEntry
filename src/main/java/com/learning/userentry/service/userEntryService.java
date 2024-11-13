package com.learning.userentry.service;

import com.learning.userentry.entity.userEntry;
import com.learning.userentry.repository.userEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userEntryService {
    @Autowired
    private userEntryRepository user_Entry_Repository;

    public void saveEntry(userEntry user){
         user_Entry_Repository.save(user);
    }
    public List<userEntry> getAllUser(){
        return user_Entry_Repository.findAll();
    }
    public Optional<userEntry> getUserById(Long id){
        return user_Entry_Repository.findById(id);
    }
    public void deleteUserById(Long id){
        user_Entry_Repository.deleteById(id);
    }
    public userEntry updateUserById(Long id,userEntry updatedUser){
        Optional<userEntry> existingUser= user_Entry_Repository.findById(id);
        if(existingUser.isPresent()){
            userEntry oldUser=existingUser.get();
            oldUser.setName(updatedUser.getName()!=null?updatedUser.getName(): oldUser.getName());
            oldUser.setEmail(updatedUser.getEmail()!=null?updatedUser.getEmail():oldUser.getEmail());
            user_Entry_Repository.save(oldUser);
            return oldUser;
        }
        else{
            throw new RuntimeException("User not found for given id "+id);
        }
    }
    public void deleteALlUser(){
        user_Entry_Repository.deleteAll();
    }

}
