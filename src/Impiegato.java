public class Impiegato extends Person {

    private int salary;

    public Impiegato(String name, String surname, String cf, int salary) {

        super(name, surname, cf);

        setSalary(salary);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {

        this.salary = salary;
    }

    public void incSalary(int perc) {

        setSalary(getSalary() + getSalary() * perc / 100);
    }

    public int getYearSalary() {

        return getSalary() * 13;
    }

    @Override
    public String toString() {

        return super.toString() + " --> " + getYearSalary();
    }
}


