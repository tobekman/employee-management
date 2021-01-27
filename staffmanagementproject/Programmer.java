package staffmanagementproject;

public class Programmer extends Employee {
    int builtPrograms;

    public Programmer(String name, int age, String gender, int salary, int yearsOfEmployment, int builtPrograms) {
        super(name, age, gender, salary, yearsOfEmployment);
        this.builtPrograms = builtPrograms;
    }

    public int getBuiltPrograms() {
        return builtPrograms;
    }

    public void setBuiltPrograms(int builtPrograms) {
        this.builtPrograms = builtPrograms;
    }

    public int calculateBonus() {
        return super.calculateBonus() + 500 * builtPrograms;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPrograms built: " + builtPrograms;
    }
}
