import dao.Sql2oAnimalDao;
import models.Animal;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 * Created by Guest on 8/15/17.
 */
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/todolist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oAnimalDao animalDao = new Sql2oAnimalDao(sql2o);

        // show all the animals
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animalList = animalDao.getAllAnimals();
            model.put("animals", animalList);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        // show a form to add a new animal
        get("/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        // process a form for adding pets
        post("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String petName = request.queryParams("name");
            String petBreed = request.queryParams("breed");
            String petType = request.queryParams("type");
            String petGender = request.queryParams("gender");
            String date = request.queryParams("date");
            Animal animal = new Animal(petName, petGender, date, petType, petBreed);
            animalDao.add(animal);
            model.put("newAnimal", animal);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());






    }
}
