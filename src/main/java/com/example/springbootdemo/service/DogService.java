package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.DogEntity;
import com.example.springbootdemo.model.Dog;
import com.example.springbootdemo.repository.DogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DogService {

    @Autowired
    DogRepository dogRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<Dog> getDogs() {
        List<DogEntity> dogEntityList = dogRepository.findAll();
        return transformDogEntityToModel(dogEntityList);
    }

    public Dog getDog(Long id) {
        Optional<DogEntity> dog = dogRepository.findById(id);
        Optional<Dog> first = transformDogEntityToModel(Arrays.asList(dog.get())).stream().findFirst();
        return first.get();
    }

    public List<Dog> updateDog(List<Dog> dogList) {
        List<DogEntity> dogEntityList = transformDogModelToEntity(dogList);
        List<DogEntity> createdDogs = dogRepository.saveAll(dogEntityList);

        return transformDogEntityToModel(createdDogs);
    }

    public void deleteDog(Long id) {
        DogEntity dog = dogRepository.findById(id).get();
        dogRepository.delete(dog);
    }

    private List<Dog> transformDogEntityToModel(List<DogEntity> dogEntityList) {
        return dogEntityList
                .stream()
                .map(dogEntity -> modelMapper.map(dogEntity, Dog.class))
                .collect(Collectors.toList());
    }

    private List<DogEntity> transformDogModelToEntity(List<Dog> dogList) {
        return dogList
                .stream()
                .map(dog -> modelMapper.map(dog, DogEntity.class))
                .collect(Collectors.toList());
    }
}
