package com.example.price.tracking.controller;

import com.example.price.tracking.service.PriceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public String getPrice(){
        return price.getLatestPrice();
    }

    @RequestMapping("/**")
    public String fallback() {
        return "Invalid endpoint!";
    }
}
