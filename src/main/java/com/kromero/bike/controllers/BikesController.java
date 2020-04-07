package com.kromero.bike.controllers;

import com.kromero.bike.models.Bike;
import com.kromero.bike.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    @Autowired
    private BikeRepository bikeRepository;


    @GetMapping
    public List<Bike> list() {
        return bikeRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Bike create(@RequestBody Bike bike){
        return bikeRepository.save(bike);
    }

    @GetMapping("/{id}")
    public Bike get(@PathVariable Integer id){
        return bikeRepository.getOne(id);
    }
}
