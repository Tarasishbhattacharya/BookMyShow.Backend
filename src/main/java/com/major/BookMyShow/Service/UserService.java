package com.major.BookMyShow.Service;

import com.major.BookMyShow.Dtos.UserRequest;
import com.major.BookMyShow.Dtos.UserUpdateRequest;
import com.major.BookMyShow.Models.User;
import com.major.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String CreateUser(UserRequest userRequest){
        User user=User.builder().name(userRequest.getName()).mobile(userRequest.getMobile()).build();
        userRepository.save(user);
        return "User added succesfully";
    }
    public User getUser(int id){
        User user=userRepository.findById(id).get();
        return user;
    }
    public List<User> getAll(){
        List<User> allUser=userRepository.findAll();
        return allUser;
    }

    public String userUpdate(UserUpdateRequest userUpdateRequest){
        User user=userRepository.findById(userUpdateRequest.getId()).get();
        user.setMobile(userUpdateRequest.getMobile());
        userRepository.save(user);
        return "user mobile updated";
    }
    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "user deleted";
    }


}
