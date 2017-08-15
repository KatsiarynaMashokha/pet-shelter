package models;

/**
 * Created by Guest on 8/15/17.
 */
public class Animal {
    private int id;
    private String name;
    private String gender;
    private String admittanceDate;
    private String type;
    private String breed;


    public Animal(String name, String gender, String admittanceDate, String type, String breed) {
        this.name = name;
        this.gender = gender;
        this.admittanceDate = admittanceDate;
        this.type = type;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAdmittanceDate() {
        return admittanceDate;
    }

    public String getType() {
        return type;
    }

    public String getBreed() {
        return breed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
