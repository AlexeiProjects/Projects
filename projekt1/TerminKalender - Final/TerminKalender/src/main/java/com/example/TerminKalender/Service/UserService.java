package com.example.TerminKalender.Service;

import com.example.TerminKalender.Model.User;
import com.example.TerminKalender.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    // Get all User from database
    public List<User> getallUsers(){
        List<User> users = new ArrayList<User>(userRepository.findAll());
        return users;
    }


    // Get User by userId
    public User getUser(Long userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return user.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user gibt es nicht");
    }

    // Get User by name (login)
    public User getUserbyname(String name){
        return userRepository.findUserByName(name);
    }

    // Create new User (register)
    public void createUser(User user){
        Optional<User> users = Optional.ofNullable(getUserbyname(user.getName()));
        if(users.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "username gibt es schon");
        }
        userRepository.save(user);
    }

    // get Username by userId (einladung)
    public String getNameByUserId(Long Id){
        User user = userRepository.findNameById(Id);
        return user.getName();
    }

}
