public abstract class Person {

    private String name;
    private String surname;
    private String cf;

    public Person(String name, String surname, String cf) {

        setName(name);
        setSurname(surname);
        setCf(cf);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {

        this.cf = cf;
    }

    @Override
    public String toString() {

        return getName() + " " + getSurname() + ": " + getCf();
    }
}

