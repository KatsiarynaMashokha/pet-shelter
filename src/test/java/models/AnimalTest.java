//package models;
//
//import dao.Sql2oAnimalDao;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//
//import static org.junit.Assert.*;
//
///**
// * Created by Guest on 8/15/17.
// */
//public class AnimalTest {
//    private Sql2oAnimalDao animalDao;
//    private Connection conn;
//
//
//    @Before
//    public void setUp() throws Exception {
//        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "", "");
//        animalDao = new Sql2oAnimalDao(sql2o);
//
//        conn = sql2o.open();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        conn.close();
//    }
//
//
////    // helper
////    public Animal createAnimal() {
////        return new Animal("Kitty", 'F', "8-1-2017", "Cat", "Orange");
////    }
//
//    @Test
//    public void AnimalInstantiatesCorrectly_true() {
//        Animal animal = createAnimal();
//        assertTrue(animal instanceof Animal);
//    }
//
//    @Test
//    public void AnimalPropertiesSetUpProperly_true() {
//        Animal animal = createAnimal();
//        assertEquals("Kitty", animal.getName());
//        assertEquals('F', animal.getGender());
//        assertEquals("8-1-2017", animal.getAdmittanceDate());
//        assertEquals("Cat", animal.getType());
//        assertEquals("Orange", animal.getBreed());
//    }
//
//
//
//}