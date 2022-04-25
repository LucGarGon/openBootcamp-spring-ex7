package com.openbootcamp.learnspring.ex7.controller;

import com.openbootcamp.learnspring.ex7.domain.Laptop;
import com.openbootcamp.learnspring.ex7.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class HelloController {

    private LaptopRepository laptop;

    public HelloController(LaptopRepository laptop){
        this.laptop = laptop;
    }
    @GetMapping("/hello")
    public String helloWorld(){
        return  "hello world";
    }

    @GetMapping("/laptops")
    public List<Laptop> laptops(){
        return laptop.findAll();
    }

    @PostMapping("/crearLaptop")
    public ResponseEntity<Laptop> crearLaptop(@RequestBody Laptop lap){

        laptop.save(lap);
        return ResponseEntity.ok(lap);
    }
}
