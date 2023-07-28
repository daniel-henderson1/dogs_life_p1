package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class DogHandler {
    private DogsRepository dogsRepo;
    public DogHandler(DogsRepository repo) {
        dogsRepo = repo;
    }

    public long addDog(Dog theDog) {
        return dogsRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return dogsRepo.count();
    }

    public Dog getDogByName (String name) {
        Dog testDog = new Dog();
        testDog.setName(name);
        List<Dog> result = dogsRepo.findByName(testDog);

        if (result.size() == 0 || name.equals(null) || result.size() >= 2) {
            return null;
        }
        return result.get(0);
    }
}
