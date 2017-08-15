package dao;

import models.Animal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

/**
 * Created by Guest on 8/15/17.
 */
public class Sql2oAnimalDao implements AnimalDao {

    private final Sql2o sql2o;

    public Sql2oAnimalDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Animal animal) {

        String sql = "INSERT INTO animals (name, gender, admittanceDate, type, breed) VALUES (:name, :gender, :admittanceDate, :type, :breed)";
        try(Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(sql)
                    .addParameter("name", animal.getName())
                    .addParameter("gender", animal.getGender())
                    .addParameter("admittanceDate", animal.getAdmittanceDate())
                    .addParameter("type", animal.getType())
                    .addParameter("breed", animal.getBreed())
                    .executeUpdate()
                    .getKey();

            animal.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<Animal> getAllAnimals() {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM animals")
                    .executeAndFetch(Animal.class);
        }
    }

    @Override
    public void updateAnimal(int id, String name) {
        String sql = "UPDATE animals SET (name) = (:name) WHERE id=:id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("name", name)
                    .executeUpdate();
        } catch(Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void deleteAnimal(int id) {
        String sql = "DELETE from animals WHERE id=:id";
        try ( Connection conn = sql2o.open())    {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }


    }

    @Override
    public void deleteAllAnimals() {
        try(Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from animals")
                   .executeUpdate();
           } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Animal findById(int id) {
        String sql = "SELECT * FROM animals WHERE id=:id";
        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
        }
    }
}
