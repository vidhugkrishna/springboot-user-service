package com.vidhu.userservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private long mobile;

    public UserDto(Integer userId, long mobile, String email, String lastName, String firstName) {
        this.mobile = mobile;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
    }


    private List<CarModel> carsOwned;
}
