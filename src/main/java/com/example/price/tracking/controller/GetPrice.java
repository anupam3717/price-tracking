package com.example.price.tracking.controller;

import com.example.price.tracking.dto.Error;
import com.example.price.tracking.dto.PriceDto;
import com.example.price.tracking.service.PriceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GET")
public class GetPrice {
    @Autowired
    private PriceImplement price;
    @GetMapping("/price")
    public ResponseEntity<?> getPrice(){
        PriceDto priceDto=PriceDto.builder()
                .price(price.getLatestPrice())
                .build();

        return ResponseEntity.ok().body(priceDto);
    }

    @RequestMapping("/**")
    public ResponseEntity<?> fallback() {
        Error error=Error.builder()
                .error("Invalid endpoint!")
                .build();
        return ResponseEntity.status(404).body(error);
    }
}
