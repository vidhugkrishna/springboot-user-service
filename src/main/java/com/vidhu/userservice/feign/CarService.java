package com.vidhu.userservice.feign;

import com.vidhu.userservice.dto.CarStockResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("CAR-SERVICE")
public interface CarService {

    @GetMapping("car/stockCheck/{make}/{model}")
    public ResponseEntity<CarStockResponse> stockCheck(@RequestParam int userId, @PathVariable String make, @PathVariable String model);

    @PutMapping("car/purchase")
    public ResponseEntity<?> carPurchase(@RequestParam int userId, @RequestParam String chaseNumber);
}
