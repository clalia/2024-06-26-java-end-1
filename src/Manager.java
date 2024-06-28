public class Manager extends Impiegato {

    private int bonus;

    public Manager(String name, String surname, String cf, int salary, int bonus) {

        super(name, surname, cf, salary);

        setBonus(bonus);
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {

        this.bonus = bonus;
    }

    @Override
    public int getYearSalary() {

        return super.getYearSalary() + getBonus();
    }

    @Override
    public String toString() {

        return super.toString() + " (" + getBonus() + ")";
    }
}

