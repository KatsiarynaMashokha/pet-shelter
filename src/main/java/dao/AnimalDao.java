package dao;

import models.Animal;

import java.util.List;

/**
 * Created by Guest on 8/15/17.
 */
public interface AnimalDao {
    // create
    void add(Animal animal);

    // get all Animals
    List<Animal> getAllAnimals();

    // update an Animal
    void updateAnimal(int id, String name);

    // delete an Animal
    void deleteAnimal(int id);

    // delete all Animals
    void deleteAllAnimals();

    // find by ID
    Animal findById(int id);
}
