package staffmanagementproject;

public class Secretary extends Employee {


    public Secretary(String name, int age, String gender, int salary, int yearsOfEmployment) {
        super(name, age, gender, salary, yearsOfEmployment);
    }

    @Override
    public int calculateBonus() {
        return super.calculateBonus() + 500 * yearsOfEmployment;
    }

    @Override
    public String toString() {
        return super.toString() + " | Job: Secretary";
    }
}
