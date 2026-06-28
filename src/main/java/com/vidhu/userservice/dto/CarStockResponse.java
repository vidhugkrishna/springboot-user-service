package com.vidhu.userservice.dto;

import lombok.Data;

@Data
public class CarStockResponse {
    private boolean stockAvailable;
    private String message;
    private String availableChassisNumber;
}
