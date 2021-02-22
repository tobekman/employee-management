package staffmanagementproject;

public class Technician extends Employee {
    int crashedServers;

    public Technician(String name, int age, String gender, int salary, int yearsOfEmployment, int crashedServers) {
        super(name, age, gender, salary, yearsOfEmployment);
        this.crashedServers = crashedServers;
    }

    public int getCrashedServers() {
        return crashedServers;
    }

    public void setCrashedServers(int crashedServers) {
        this.crashedServers = crashedServers;
    }

    @Override
    public int calculateBonus() {
        return super.calculateBonus() - 500 * crashedServers;
    }

    @Override
    public String toString() {
        return super.toString() + " | Crashed servers: " + crashedServers
                + " | Job: Technician";
    }
}
