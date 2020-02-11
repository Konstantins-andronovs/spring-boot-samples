package com.example.graphqlapi.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqlapi.entity.Dog;
import com.example.graphqlapi.exception.BreedNotFoundException;
import com.example.graphqlapi.exception.DogNotFoundException;
import com.example.graphqlapi.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

//    newDog(name: String!, breed: String) : Dog!
//    deleteDog(id:ID!) : Boolean
//    updateDogName(newName: String!, id:ID!) : Dog!
//    deleteDogBreed(breed:String!) : Boolean
//    updateDogName(newName: String!, id:ID!) : Dog!

    public Dog newDog(String name, String breed, String origin) {
        Dog dog = new Dog(name, breed, origin);
        return dogRepository.save(dog);
    }

    public boolean deleteDog(Long id) {
        dogRepository.deleteById(id);
        return true;
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        // Loop through all dogs to check their breed
        for (Dog d:allDogs) {
            if (d.getBreed().equals(breed)) {
                // Delete if the breed is found
                dogRepository.delete(d);
                deleted = true;
            }
        }
        // Throw an exception if the breed doesn't exist
        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return deleted;
    }


    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog not found", id);
        }
    }

}
