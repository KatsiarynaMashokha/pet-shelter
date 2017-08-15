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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (id != animal.id) return false;
        if (!name.equals(animal.name)) return false;
        if (gender != null ? !gender.equals(animal.gender) : animal.gender != null) return false;
        if (admittanceDate != null ? !admittanceDate.equals(animal.admittanceDate) : animal.admittanceDate != null)
            return false;
        if (!type.equals(animal.type)) return false;
        return breed.equals(animal.breed);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (admittanceDate != null ? admittanceDate.hashCode() : 0);
        result = 31 * result + type.hashCode();
        result = 31 * result + breed.hashCode();
        return result;
    }
}
