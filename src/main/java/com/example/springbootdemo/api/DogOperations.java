package com.example.springbootdemo.api;


import com.example.springbootdemo.model.Dog;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dog")
public interface DogOperations {
    @GetMapping("")
    ResponseEntity getAllDogs();

    @GetMapping("/{id}")
    ResponseEntity getDog(@PathVariable(value = "id") Long id);

    @PostMapping("")
    ResponseEntity addDog(@RequestBody List<Dog> employeeList);

    @PutMapping("")
    ResponseEntity updateDog(@RequestBody List<Dog> employeeList);

    @DeleteMapping("/{id}")
    ResponseEntity deleteDog(@PathVariable(value = "id") Long id);
}
