package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;

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
}
