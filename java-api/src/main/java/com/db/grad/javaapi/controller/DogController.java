package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    @Autowired
    private DogService dogService;

    @GetMapping("/status")
    public String getStatus() {
        return "Alls good";
    }

    @GetMapping("/count")
    public int getCount() {
        return dogService.getAllDogs().size();
    }

    @GetMapping("/returnnames")
    public List<Dog> getDogNames() {
        return dogService.getAllDogs();
    }


    @PostMapping ("/senddog")
    public HttpStatus addDog(@RequestBody Dog d) {
         Dog result = dogService.addDog(d);
        if(result == null)
        {
            return HttpStatus.PRECONDITION_FAILED;
        }
        else
        {
            return HttpStatus.CREATED;
        }

    }



}
