package com.example.springbootdemo.controller;

import com.example.springbootdemo.api.DogOperations;
import com.example.springbootdemo.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController implements DogOperations {
    @Autowired
    DogService dogService;

    public ResponseEntity getAllDogs() {
        try {
            List<Dog> dogResponse = dogService.getDogs();
            return new ResponseEntity(dogResponse, HttpStatus.OK);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "", e);
        }
    }

    public ResponseEntity getDog(@PathVariable(value = "id") Long id) {
        try {
            Dog dog = dogService.getDog(id);
            return new ResponseEntity(dog, HttpStatus.OK);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "", e);
        }
    }

    public ResponseEntity addDog(@RequestBody List<Dog> dogList) {
        try {
            List<Dog> createdDogs = dogService.updateDog(dogList);
            return new ResponseEntity(createdDogs, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "", e);
        }
    }

    public ResponseEntity updateDog(@RequestBody List<Dog> dogList) {
        try {
            List<Dog> updatedDogs = dogService.updateDog(dogList);
            return new ResponseEntity(updatedDogs, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "", e);
        }
    }

    public ResponseEntity deleteDog(@PathVariable(value = "id") Long id) {
        try {
            dogService.deleteDog(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "", e);
        }
    }
}
