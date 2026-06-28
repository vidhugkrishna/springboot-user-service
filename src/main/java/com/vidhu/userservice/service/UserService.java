package com.vidhu.userservice.service;

import com.vidhu.userservice.dto.CarModel;
import com.vidhu.userservice.dto.CarStockResponse;
import com.vidhu.userservice.dto.UserDto;
import com.vidhu.userservice.feign.CarService;
import com.vidhu.userservice.model.Users;
import com.vidhu.userservice.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    CarService carService;

    public ResponseEntity<String> createUser(UserDto user){

        Users userWithSameEmail = userRepo.findByEmail(user.getEmail());
        if(userWithSameEmail!=null){
            return new ResponseEntity<>("user exist with same email", HttpStatus.CONFLICT);
        }else{
            Users userObject  = new Users(null,user.getFirstName(),user.getLastName(),user.getEmail(),user.getMobile());
            userRepo.save(userObject);
            return new ResponseEntity<>("created",HttpStatus.CREATED);
        }
    }

    public ResponseEntity<List<Users>> getAllUser() {
        List<Users> users = userRepo.findAll();
        return new ResponseEntity<>( users,users.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    public ResponseEntity<String> deleteUser(int id){
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return new ResponseEntity<>("User deleted with id:"+id, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        }

    }

//    public ResponseEntity<CarModel> getUserInfo(int id) {
//        if(userRepo.existsById(id)){
//
//        }
//    }

    public ResponseEntity<?> stockCheck(int id, String make, String model) {
        if(!userRepo.existsById(id)) {
            return new ResponseEntity("Please create an user", HttpStatus.NOT_ACCEPTABLE);
        }
        ResponseEntity<CarStockResponse> carPurchaseRequest = carService.carPurchase(id,make,model);
        if(!carPurchaseRequest.getBody().isStockAvailable()){
            return new ResponseEntity(carPurchaseRequest.getBody().getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity("Car available for purchase:"+carPurchaseRequest.getBody().getAvailableChassisNumber(), HttpStatus.OK);


    }
}
