package staffmanagementproject;

public class Employee {
    static int idGenerator = 1;
    int id;
    String name;
    int age;
    String gender;
    int salary;
    int bonus;
    int yearsOfEmployment;

    public Employee(String name, int age, String gender, int salary, int yearsOfEmployment) {
        this.id = idGenerator++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.yearsOfEmployment = yearsOfEmployment;
        this.bonus = 5000;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getYearsOfEmployment() {
        return yearsOfEmployment;
    }

    public void setYearsOfEmployment(int yearsOfEmployment) {
        this.yearsOfEmployment = yearsOfEmployment;
    }

    public int calculateBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Age: " + age +
                " | Gender: " + gender +
                " | Salary: " + salary +
                " | Bonus: " + calculateBonus() +
                " | Years employed: " + yearsOfEmployment;


    }
}
