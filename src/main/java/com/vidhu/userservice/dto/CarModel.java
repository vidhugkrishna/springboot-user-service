package com.vidhu.userservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModel {

    private String chassisNumber;
    private String make;
    private String model;
    private LocalDate dateOfManufacture;
    private LocalDate dateOfPurchase ;
    private Integer userId;
}
