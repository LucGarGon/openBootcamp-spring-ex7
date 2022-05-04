package com.openbootcamp.learnspring.ex7.controller;

import com.openbootcamp.learnspring.ex7.domain.Laptop;
import com.openbootcamp.learnspring.ex7.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private LaptopRepository laptop;

    public LaptopController(LaptopRepository laptop){
        this.laptop= laptop;
    }
    @GetMapping("/laptops")
    public ResponseEntity<List<Laptop>> laptops()
    {
        return ResponseEntity.ok(laptop.findAll());
    }
    @GetMapping("/laptop/{id}")
    public ResponseEntity<Laptop> findOneLaptop(@PathVariable Long id){
        Optional<Laptop> laptopOpt= laptop.findById(id);
        return laptopOpt.isPresent() ? ResponseEntity.ok(laptopOpt.get()) : ResponseEntity.notFound().build();
    }
    @PostMapping("/crearLaptop")
    public ResponseEntity<Laptop> crearLaptop(@RequestBody Laptop lap){
        laptop.save(lap);
        return ResponseEntity.ok(lap);
    }
    @DeleteMapping("/deleteLaptop/{id}")
    public ResponseEntity<Laptop> deleteLaptop(@PathVariable Long id){
        if(!laptop.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        laptop.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/updateLaptop")
    public ResponseEntity<Laptop> updateLaptop(@RequestBody Laptop lap){
        if(!laptop.existsById(lap.getId())){
            return ResponseEntity.badRequest().build();
        }
        laptop.save(lap);
        return ResponseEntity.ok(lap);
    }
    @DeleteMapping("/deleteAllLaptop")
    public ResponseEntity<Laptop> deleteAllLaptop(@RequestBody Laptop lap){
        laptop.save(lap);
        return ResponseEntity.noContent().build();
    }
}
