package staffmanagementproject;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);



    public static void createEmployee() {
        System.out.println("What kind of employee?");
        System.out.println("[1] Programmer");
        System.out.println("[2] Secretary");
        System.out.println("[3] Technician");

        int choice = intScanner();

        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = intScanner();
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Salary: ");
        int salary = intScanner();
        System.out.print("Years of employment: ");
        int years = intScanner();

        switch (choice) {
            case 1:
                System.out.print("Number of built programs: ");
                int builtPrograms = intScanner();
                Programmer programmer = new Programmer(name, age,gender,salary,years,builtPrograms);
                employees.add(programmer);
                break;
            case 2:
                Secretary secretary = new Secretary(name, age,gender,salary,years);
                employees.add(secretary);
                break;
            case 3:
                System.out.print("Number of crashed servers: ");
                int crashedServers = intScanner();
                Technician technician = new Technician(name, age,gender,salary,years,crashedServers);
                employees.add(technician);
                break;
            default:
                break;
        }
    }

    public static void deleteEmployee() {
        printAllEmployees();

        System.out.print("Remove the employee with id: ");
        int id = intScanner();

        employees.removeIf(employee -> employee.id == id);

    }

    public static void updateEmployee() {
        printAllEmployees();
        System.out.print("\nUpdate the employee with id: ");
        int id = intScanner();



        for (Employee e: employees) {
            if (e.getId() == id) {
                if (e instanceof Programmer) {
                    Programmer p = (Programmer) e;
                    updateMenu();
                    System.out.println("[6] Built Programs");

                    switch(intScanner()) {
                        case 1:
                            System.out.print("New name: ");
                            p.setName(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("New age: ");
                            p.setAge(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case 3:
                            System.out.print("New gender: ");
                            p.setGender(scanner.nextLine());
                            break;
                        case 4:
                            System.out.print("New salary: ");
                            p.setSalary(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case 5:
                            System.out.print("New number of years: ");
                            p.setYearsOfEmployment(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case 6:
                            System.out.print("New built programs: ");
                            p.setBuiltPrograms(scanner.nextInt());
                            scanner.nextLine();
                            p.setBonus(p.calculateBonus());
                            break;
                        default:
                            break;
                    }

                } else if (e instanceof Secretary) {
                    Secretary s = (Secretary) e;
                    updateMenu();

                    switch(intScanner()) {
                        case 1:
                            System.out.print("New name: ");
                            s.setName(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("New age: ");
                            s.setAge(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case 3:
                            System.out.print("New gender: ");
                            s.setGender(scanner.nextLine());
                            break;
                        case 4:
                            System.out.print("New salary: ");
                            s.setSalary(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case 5:
                            System.out.print("New number of years: ");
                            s.setYearsOfEmployment(scanner.nextInt());
                            scanner.nextLine();
                            s.setBonus(s.calculateBonus());
                            break;
                        default:
                            break;
                    }
                } else if (e instanceof Technician) {
                    Technician t = (Technician) e;
                    updateMenu();
                    System.out.println("[6] Crashed programs");

                    switch(intScanner()) {
                        case 1:
                            System.out.print("New name: ");
                            t.setName(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("New age: ");
                            t.setAge(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case 3:
                            System.out.print("New gender: ");
                            t.setGender(scanner.nextLine());
                            break;
                        case 4:
                            System.out.print("New salary: ");
                            t.setSalary(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case 5:
                            System.out.print("New number of years: ");
                            t.setYearsOfEmployment(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case 6:
                            System.out.print("New number of crashed servers: ");
                            t.setCrashedServers(scanner.nextInt());
                            scanner.nextLine();
                            t.setBonus(t.calculateBonus());
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    private static void updateMenu() {
        System.out.println("[1] Name");
        System.out.println("[2] Age");
        System.out.println("[3] Gender");
        System.out.println("[4] Salary");
        System.out.println("[5] Years of employment");
    }

    public static void printAllEmployees(){
        for (Employee e: employees) {
            if(e instanceof Programmer) {
                System.out.println(e);
                System.out.println("Job: Programmer");
            } else if (e instanceof Secretary) {
                System.out.println(e);
                System.out.println("Job: Secretary");
            } else if(e instanceof Technician) {
                System.out.println(e);
                System.out.println("Job: Technician");
            }

        }
    }

    public static void printProgrammers() {
        for (Employee e: employees) {
            if(e instanceof Programmer) {
                System.out.println(e);
            }
        }
    }

    public static void printSecretaries() {
        for (Employee e: employees) {
            if(e instanceof Secretary) {
                System.out.println(e);
            }
        }
    }

    public static void printTechnicians() {
        for (Employee e: employees) {
            if(e instanceof Technician) {
                System.out.println(e);
            }
        }
    }

    private static int intScanner() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static void salaryStats(String jobTitle) {
        int salarySum = 0;
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = 0;
        int counter = 0;
        switch (jobTitle) {
            case "pro":
                for (Employee e: employees) {
                    if (e instanceof Programmer) {
                        counter++;
                        salarySum += e.getSalary();
                        if(e.getSalary() < minSalary) {
                            minSalary = e.getSalary();
                        }
                        if(e.getSalary() > maxSalary) {
                            maxSalary = e.getSalary();
                        }
                    }
                }

                if(counter > 0) {
                    printSalaryStats(salarySum / counter, maxSalary, minSalary, "programmers:");
                } else {
                    System.out.println("\nThere are no programmers");
                }
                break;
            case "sec":
                for (Employee e: employees) {
                    if (e instanceof Secretary) {
                        counter++;
                        salarySum += e.getSalary();
                        if(e.getSalary() < minSalary) {
                            minSalary = e.getSalary();
                        }
                        if(e.getSalary() > maxSalary) {
                            maxSalary = e.getSalary();
                        }
                    }
                }

                if(counter > 0) {
                    printSalaryStats(salarySum / counter, maxSalary, minSalary, "secretaries:");
                } else {
                    System.out.println("\nThere are no secretaries");
                }
                break;
            case "tec":
                for (Employee e: employees) {
                    if (e instanceof Technician) {
                        counter++;
                        salarySum += e.getSalary();
                        if(e.getSalary() < minSalary) {
                            minSalary = e.getSalary();
                        }
                        if(e.getSalary() > maxSalary) {
                            maxSalary = e.getSalary();
                        }
                    }
                }
                if(counter > 0) {
                    printSalaryStats(salarySum / counter, maxSalary, minSalary, "technicians:");
                } else {
                    System.out.println("\nThere are no technicians");
                }
                break;
            default:
                for (Employee e: employees) {
                    counter++;
                    salarySum += e.getSalary();
                    if(e.getSalary() < minSalary) {
                        minSalary = e.getSalary();
                    }
                    if(e.getSalary() > maxSalary) {
                        maxSalary = e.getSalary();
                    }
                }
                if(counter > 0) {
                    printSalaryStats(salarySum / counter, maxSalary, minSalary, "all employees:");
                } else {
                    System.out.println("\nThere are no employees");
                }
                break;
        }
    }


    private static void printSalaryStats(int avg, int max, int min, String job) {
        System.out.println("Stats for " + job +
                "\nAverage salary: " + avg +
                "\nLowest salary: " + min +
                "\nHighest salary: " + max);
    }

    public static void printJobStats() {
        int programmers = 0;
        int secretaries = 0;
        int technicians = 0;

        for (Employee e: employees) {
            if (e instanceof Programmer) {
                programmers++;
            } else if (e instanceof Secretary) {
                secretaries++;
            } else if (e instanceof Technician) {
                technicians++;
            }
        }

        System.out.println("There are a total of " + employees.size() + " employees");
        System.out.println(programmers + " programmers");
        System.out.println(secretaries + " secretaries");
        System.out.println(technicians + " technicians");
    }

    public static void printGenderStats() {
        int male = 0;
        int female = 0;
        int nonBinary = 0;

        for (Employee e: employees) {
            if (e.getGender().equalsIgnoreCase("male")) {
                male++;
            } else if (e.getGender().equalsIgnoreCase("female")) {
                female++;
            } else {
                nonBinary++;
            }
        }

        System.out.println("There are a total of " + employees.size() + " employees");
        System.out.println(male + " male");
        System.out.println(female + " female");
        System.out.println(nonBinary + " non-binary");
    }

    public static void sortByAge(int order) {
        if (order == 1) {
            employees.sort((singer1, singer2) -> singer1.getAge() - singer2.getAge());
        } else if (order == 2) {
            employees.sort((singer1, singer2) -> singer2.getAge() - singer1.getAge());
        }
    }

    public static void sortByName(int order) {
        if (order == 1) {
            employees.sort((singer1, singer2) -> singer1.getName().toUpperCase().compareTo(singer2.getName().toUpperCase()));
        } else if (order == 2) {
            employees.sort((singer1, singer2) -> singer2.getName().toUpperCase().compareTo(singer1.getName().toUpperCase()));
        }
    }



}
