package dao;

import models.Animal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/15/17.
 */
public class Sql2oAnimalDaoTest {
    private Sql2oAnimalDao animalDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        animalDao = new Sql2oAnimalDao(sql2o);

        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    // helper
    public Animal createAnimal() {
        return new Animal("Kitty", "F", "8-1-2017", "Cat", "Orange");
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void getAllAnimals() throws Exception {
        Animal animal = createAnimal();
        animalDao.add(animal);
        assertEquals(1, animalDao.getAllAnimals().size());
    }

    @Test
    public void updateAnimal() throws Exception {
        Animal animal = createAnimal();
        animalDao.add(animal);
        animalDao.updateAnimal(animal.getId(), "Doggy");

    }

    @Test
    public void deleteAnimal() throws Exception {
        Animal animal = createAnimal();
        Animal animal1 = createAnimal();
        animalDao.add(animal);
        animalDao.add(animal1);
        animalDao.deleteAnimal(animal.getId());
        assertEquals(1,animalDao.getAllAnimals().size());
    }

    @Test
    public void deleteAllAnimals() throws Exception {
        Animal animal = createAnimal();
        Animal animal1= createAnimal();
        Animal animal2= createAnimal();
        animalDao.add(animal);
        animalDao.add(animal1);
        animalDao.add(animal2);
        animalDao.deleteAllAnimals();
        assertEquals(0, animalDao.getAllAnimals().size());
    }

}