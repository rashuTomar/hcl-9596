package package1;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeCRUD {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();

                    employees.add(new Employee(id, name, salary));
                    System.out.println("Employee added.");
                    break;

                case 2:
                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        for (Employee e : employees) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    boolean updated = false;

                    for (Employee e : employees) {
                        if (e.id == updateId) {
                            sc.nextLine();
                            System.out.print("Enter new name: ");
                            e.name = sc.nextLine();
                            System.out.print("Enter new salary: ");
                            e.salary = sc.nextDouble();
                            System.out.println("Employee updated.");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean deleted = false;

                    for (int i = 0; i < employees.size(); i++) {
                        if (employees.get(i).id == deleteId) {
                            employees.remove(i);
                            System.out.println("Employee deleted.");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
