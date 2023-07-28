package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DogsHandlerTest {

    private DogsRepository dogRepo = new DogsRepositoryStub();
    @BeforeEach
    public void makeSureRepoIsEmpty(){
        dogRepo.deleteAll();
    }
    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one(){
        //arrange
        DogHandler cut = new DogHandler(dogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        int expectedResult = 1;

        //act
        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public void retrieve_dog_by_name_if_exists_without_duplicates(){
        //arrange
        DogHandler cut = new DogHandler(dogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        Dog expectedResult = theDog;

        //act
        Dog actualResult = cut.getDogByName("Bruno");

        //assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public void retrieve_dog_by_name_if_exists_with_duplicates(){
        //arrange
        DogHandler cut = new DogHandler(dogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        Dog secondDog = new Dog();
        secondDog.setName("Bruno");
        cut.addDog( secondDog );

        Dog expectedResult = null;

        //act
        Dog actualResult = cut.getDogByName("Bruno");

        //assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public void check_if_no_matching_dogs() {
        //arrange
        DogHandler cut = new DogHandler(dogRepo);

        Dog expectedResult = null;

        //act
        Dog actualResult = cut.getDogByName("NonexistantDog");

        //assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public  void    find_dog_by_valid_id_returns_one_dog()
    {
        // arrange
        DogHandler cut = new DogHandler( dogRepo );
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        long uniqueId = cut.addDog( theDog );
        Dog expectedDog = theDog;
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );

        // act
        Dog actualResult = cut.getDogById( uniqueId );

        // assert
        assertEquals( expectedDog.getId(), actualResult.getId() );
        assertEquals( expectedDog.getName(), actualResult.getName() );
    }

    @Test
    public  void    find_dog_by_invalid_id_returns_null_dog()
    {
        // arrange
        DogHandler cut = new DogHandler( dogRepo );
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        long uniqueId = cut.addDog( theDog );
        Dog expectedDog = theDog;
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );

        // act
        Dog actualResult = cut.getDogById( 33 );

        // assert
        assertNull( actualResult );
    }
    @Test
    public  void    update_dog_that_exists_returns_dog_id()
    {
        // arrange
        DogHandler cut = new DogHandler( dogRepo );
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        long expectedResult = cut.addDog( theDog );
        Dog dogToUpdate = theDog;
        String dogToFind = "Frank";
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );

        // act
        dogToUpdate.setName("Charlie");
        long actualResult = cut.updateDogDetails( dogToUpdate );

        // assert
        assertEquals( expectedResult, actualResult );
    }
    @Test
    public  void    add_dog_and_remove_dog_that_doess_not_exist_return_number_of_dogs_is_one()
    {
        // arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        long uniqueId = cut.addDog( theDog );

        long expectedResult = 1;
        boolean expectedStatus = false;


        // act
        // There is no dog with ID == 33
        boolean actualStatus = cut.removeDog( 33 );
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
    }
}


