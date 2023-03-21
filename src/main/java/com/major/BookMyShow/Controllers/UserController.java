package com.major.BookMyShow.Controllers;

import com.major.BookMyShow.Dtos.UserRequest;
import com.major.BookMyShow.Dtos.UserUpdateRequest;
import com.major.BookMyShow.Models.User;
import com.major.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/add_user")
    public String addUser(@RequestBody()UserRequest userRequest){

        userService.CreateUser(userRequest);
        return "user added succesfully";
    }
    @GetMapping("/get_user_by_id")
    public User getUserById(@RequestParam("id") int id){
        User user= userService.getUser(id);
        return user;
    }

    @GetMapping("/get_all_user")
    public List<User> getAllUser(){
         return userService.getAll();
    }

    @PutMapping("/update_user_number")
    public String updateNumber(@RequestBody()UserUpdateRequest userUpdateRequest){
       return  userService.userUpdate(userUpdateRequest);
    }

    @DeleteMapping("/delete_by_id")
    public String deleteById(@RequestParam("id") int id){
        return userService.deleteUser(id);
    }
}
