package staffmanagementproject;

public class EmployeeDb {

    public static void addEmployees() {
        Programmer p = new Programmer("per",32, "male", 21232, 3, 2);
        Programmer p2 = new Programmer("Eriksson",56, "male", 52345, 29, 52);
        Programmer p3 = new Programmer("Ludmila",40, "female", 49234, 13, 19);
        Secretary s = new Secretary("Pernilla", 12, "female", 42999, 10);
        Technician t = new Technician("Roger", 123, "male", 12345, 65, 12);
        Technician t2 = new Technician("Arvika", 25, "female", 22345, 5, 0);
        Secretary s2 = new Secretary("Robocop", 67, "robotics", 100000, 10);

        EmployeeManagement.employees.add(p);
        EmployeeManagement.employees.add(s);
        EmployeeManagement.employees.add(p2);
        EmployeeManagement.employees.add(t);
        EmployeeManagement.employees.add(p3);
        EmployeeManagement.employees.add(t2);
        EmployeeManagement.employees.add(s2);

    }

}
