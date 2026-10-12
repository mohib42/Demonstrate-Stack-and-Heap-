
import java.util.Scanner;

class Employee {
    int salary; // Instance variable

    Employee(int salary) {
        this.salary = salary;
    }

    void display(int bonus) {
        System.out.println("\nInside display() Method:");
        System.out.println("Salary (Instance Variable): " + salary);
        System.out.println("Bonus (Local Variable): " + bonus);

        // Local inner class
        class Report {
            void show() {
                System.out.println("Report: Employee salary is " + salary);
            }
        }

        Report r = new Report();

        System.out.println("\nReport Object Created");
        System.out.println("Report Identity Hash Code: "
                + System.identityHashCode(r));

        r.show();
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter salary: ");
        int salary = sc.nextInt();

        System.out.print("Enter bonus: ");
        int bonus = sc.nextInt();

        Employee e = new Employee(salary);

        System.out.println("\nEmployee Object Created");
        System.out.println("Employee Identity Hash Code: "
                + System.identityHashCode(e));

        e.display(bonus);

        System.out.println("\nMemory Concept:");
        System.out.println("Employee object -> Heap");
        System.out.println("Report object -> Heap");
        System.out.println("salary -> Instance field");
        System.out.println("bonus -> Parameter (Local variable)");
        System.out.println("show() -> Executes in its own method frame");

        sc.close();
    }
}

