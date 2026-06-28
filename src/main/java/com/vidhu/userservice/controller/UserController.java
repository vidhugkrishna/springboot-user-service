package com.vidhu.userservice.controller;


import com.vidhu.userservice.dto.CarModel;
import com.vidhu.userservice.dto.UserDto;
import com.vidhu.userservice.model.Users;
import com.vidhu.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("createUser")
    public ResponseEntity<String> createUser(@RequestBody UserDto user){
        return userService.createUser(user);
    }

    @DeleteMapping("deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam int id){
        return userService.deleteUser(id);
    }

    @GetMapping("allUsers")
    public ResponseEntity<List<Users>> getAllUsers(){
        return userService.getAllUser();
    }

//    @GetMapping("userInfo")
//    public ResponseEntity<CarModel> getUserInfo(@RequestParam int id){
//        return userService.getUserInfo(id);
//    }

    @GetMapping("purchase/{make}/{model}")
    public ResponseEntity<?> doCarPurchase(@RequestParam int userId, @PathVariable String make, @PathVariable String model){
        return userService.stockCheck(userId,make,model);
    }




}
