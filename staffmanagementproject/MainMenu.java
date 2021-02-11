package staffmanagementproject;

import java.util.Scanner;

public class MainMenu {

    static Scanner scanner = new Scanner(System.in);

    public static void menu() {

        while(true) {
            System.out.println("\n[1] Manage employees");
            System.out.println("[2] Show stats");
            System.out.println("[0] Exit");

            switch (intScanner()) {
                case 1:
                    manageEmployeeMenu();
                    break;
                case 2:
                    statsMenu();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void manageEmployeeMenu() {
        System.out.println("\n[1] Add employee");
        System.out.println("[2] Update employee");
        System.out.println("[3] Remove employee");
        System.out.println("[4] Show employees");
        System.out.println("[5] Sort employees");
        System.out.println("[0] Back");

        switch (intScanner()) {
            case 1:
                EmployeeManagement.createEmployee();
                break;
            case 2:
                EmployeeManagement.updateEmployee();
                break;
            case 3:
                EmployeeManagement.deleteEmployee();
                break;
            case 4:
                printMenu();
                break;
            case 5:
                sortMenu();
                break;
            default:
                break;
        }
    }

    private static void printMenu() {
        System.out.println("\nWhat do you want to see?");
        jobMenu();

        switch (intScanner()) {
            case 1:
                EmployeeManagement.printAllEmployees();
                break;
            case 2:
                EmployeeManagement.printProgrammers();
                break;
            case 3:
                EmployeeManagement.printSecretaries();
                break;
            case 4:
                EmployeeManagement.printTechnicians();
                break;
            default:
                manageEmployeeMenu();
                break;
        }
    }

    private static void statsMenu() {
        System.out.println("[1] Salary");
        System.out.println("[2] Jobs");
        System.out.println("[3] Gender");
        System.out.println("[0] Back");

        switch(intScanner()) {
            case 1:
                System.out.println("Show stats for: ");
                jobMenu();
                switch (intScanner()) {
                    case 1:
                        EmployeeManagement.salaryStats("all");
                        break;
                    case 2:
                        EmployeeManagement.salaryStats("pro");
                        break;
                    case 3:
                        EmployeeManagement.salaryStats("sec");
                        break;
                    case 4:
                        EmployeeManagement.salaryStats("tec");
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                EmployeeManagement.printJobStats();
                break;
            case 3:
                EmployeeManagement.printGenderStats();
                break;
            default:
                break;
        }
    }

    private static int intScanner() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private static void jobMenu() {
        System.out.println("[1] All employees");
        System.out.println("[2] Programmers");
        System.out.println("[3] Secretaries");
        System.out.println("[4] Technicians");
        System.out.println("[0] Back");
    }

    private static void sortMenu() {
        boolean wrongInput = true;
        while(wrongInput) {
            System.out.println("\n[1] Sort by name");
            System.out.println("[2] Sort by age");
            System.out.println("[3] Sort by salary");
            switch (intScanner()) {
                case 1:
                    while(wrongInput) {
                        System.out.println("\n[1] A to Z");
                        System.out.println("[2] Z to A");
                        switch(intScanner()) {
                            case 1:
                                EmployeeManagement.sortByName(true);
                                wrongInput = false;
                                break;
                            case 2:
                                EmployeeManagement.sortByName(false);
                                wrongInput = false;
                                break;
                            default:
                                System.out.println("You need to pick [1] or [2]");
                                break;
                        }
                    }
                    break;
                case 2:
                    while (wrongInput) {
                        System.out.println("\n[1] Youngest first");
                        System.out.println("[2] Oldest first");
                        switch(intScanner()) {
                            case 1:
                                EmployeeManagement.sortByAge(true);
                                wrongInput = false;
                                break;
                            case 2:
                                EmployeeManagement.sortByAge(false);
                                wrongInput = false;
                                break;
                            default:
                                System.out.println("You need to pick [1] or [2]");
                                break;
                        }
                    }
                    break;
                case 3:
                    while (wrongInput) {
                        System.out.println("\n[1] Lowest first");
                        System.out.println("[2] Highest first");
                        switch(intScanner()) {
                            case 1:
                                EmployeeManagement.sortBySalary(true);
                                wrongInput = false;
                                break;
                            case 2:
                                EmployeeManagement.sortBySalary(false);
                                wrongInput = false;
                                break;
                            default:
                                System.out.println("You need to pick [1] or [2]");
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("You need to pick [1], [2] or [3]");
                    break;
            }
        }
        EmployeeManagement.printAllEmployees();
    }



}
