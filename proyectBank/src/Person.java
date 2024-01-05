import java.util.ArrayList;
import java.util.List;

public class Person {
    private int codPerson;
    private String namePerson;
    private String lastnamePerson;
    private String passwordPerson;
    private int rolPerson;



    public static List<Person> getPeople() {
        return people;
    }

    public static void setPeople(List<Person> people) {
        Person.people = people;
    }

    private int document;

    static List<Person> people = new ArrayList<>();



    public Person() {}

    public int getCodPerson() {
        return codPerson;
    }

    public void setCodPerson(int codPerson) {
        this.codPerson = codPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getLastnamePerson() {
        return lastnamePerson;
    }

    public void setLastnamePerson(String lastnamePerson) {
        this.lastnamePerson = lastnamePerson;
    }

    public String getPasswordPerson() {
        return passwordPerson;
    }

    public void setPasswordPerson(String passwordPerson) {
        this.passwordPerson = passwordPerson;
    }

    public int getRolPerson() {
        return rolPerson;
    }

    public void setRolPerson(int rolPerson) {
        this.rolPerson = rolPerson;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

}
