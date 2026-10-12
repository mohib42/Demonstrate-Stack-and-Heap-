# Java Lab Assignment: Stack and Heap Memory

## Overview

This repository contains two Java lab practice problems demonstrating **Stack Memory, Heap Memory, Instance Variables, Local Variables, Object Identity Hash Codes, Method Frames, and Local Inner Classes**.

## Table of Contents

1. [Problem 1: Stack and Heap Memory](#problem-1-stack-and-heap-memory)
2. [Problem 2: Stack Frames, Heap Objects, and Inner Classes](#problem-2-stack-frames-heap-objects-and-inner-classes)
3. [How to Compile and Run](#how-to-compile-and-run)
4. [Key Concepts](#key-concepts)
5. [Conclusion](#conclusion)

---

## Problem 1: Stack and Heap Memory

### Objective

Write a Java program that creates a `Student` class with an instance variable `age` and a method `display()`. Declare a local variable `marks` inside the method, create a `Student` object, and display its identity hash code.

### Source Code

**File name:** `Main.java`

```java
class Student {
    int age = 20;

    void display() {
        int marks = 85;

        System.out.println("Instance Variable (age): " + age);
        System.out.println("Local Variable (marks): " + marks);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();

        System.out.println("Student Object Created");
        System.out.println("Object Identity Hash Code: "
                + System.identityHashCode(s));

        s.display();
    }
}
```

### Sample Input

The values are initialized directly in the program.

```text
Age: 20
Marks: 85
```

### Sample Output

```text
Student Object Created
Object Identity Hash Code: 12345678
Instance Variable (age): 20
Local Variable (marks): 85
```

**Note:** The identity hash code shown above is illustrative. The actual value may differ each time the program runs.

### Explanation

- **Student class:** Defines the structure of a student object.
- **Instance variable (`age`):** Stores the student's age as part of the object.
- **Local variable (`marks`):** Declared inside `display()` and exists as a local variable during method execution.
- **Object creation:** `Student s = new Student();` creates a student object.
- **Identity hash code:** `System.identityHashCode(s)` returns the identity hash code associated with the object.

### Memory Analysis

| Component | Memory concept |
|---|---|
| Student object | Heap |
| `age` | Instance field within the object |
| `s` | Local reference variable in `main()` |
| `marks` | Local variable in `display()` |
| `display()` | Executes using a method frame |

---

## Problem 2: Stack Frames, Heap Objects, and Inner Classes

### Objective

Write a Java program that defines an `Employee` class with an instance variable `salary` and an instance method `display()`. Inside `display()`, declare a local inner class named `Report` with a method `show()`.

The program must:

1. Create an `Employee` object and display its identity hash code.
2. Display the instance variable `salary` and local variable `bonus`.
3. Create a `Report` object and display its identity hash code.
4. Display a report message using the `show()` method.
5. Explain the relevant memory concepts.

### Source Code

**File name:** `Main.java`

```java
import java.util.Scanner;

class Employee {
    int salary;

    Employee(int salary) {
        this.salary = salary;
    }

    void display(int bonus) {
        System.out.println("\nInside display() Method:");
        System.out.println("Salary (Instance Variable): " + salary);
        System.out.println("Bonus (Local Variable): " + bonus);

        class Report {
            void show() {
                System.out.println(
                    "Report: Employee salary is " + salary
                );
            }
        }

        Report r = new Report();

        System.out.println("\nReport Object Created");
        System.out.println("Report Identity Hash Code: "
                + System.identityHashCode(r));

        r.show();
    }
}

public class Main {
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
        System.out.println("bonus -> Local variable in display()");
        System.out.println("show() -> Executes in its own method frame");

        sc.close();
    }
}
```

### Sample Input

```text
Enter salary: 30000
Enter bonus: 5000
```

### Sample Output

```text
Enter salary: 30000
Enter bonus: 5000

Employee Object Created
Employee Identity Hash Code: 12345678

Inside display() Method:
Salary (Instance Variable): 30000
Bonus (Local Variable): 5000

Report Object Created
Report Identity Hash Code: 87654321
Report: Employee salary is 30000

Memory Concept:
Employee object -> Heap
Report object -> Heap
salary -> Instance field
bonus -> Local variable in display()
show() -> Executes in its own method frame
```

**Note:** The identity hash codes are illustrative and may differ between executions.

### Explanation

- **Employee class:** Defines the `salary` instance variable and the `display()` method.
- **Constructor:** Initializes `salary` when an `Employee` object is created.
- **Bonus:** The `bonus` parameter is a local variable associated with the `display()` method invocation.
- **Local inner class (`Report`):** Defined inside `display()`. Its `show()` method accesses the enclosing employee's `salary`.
- **Report object:** Created using `new Report()` and allocated on the heap.
- **Identity hash codes:** `System.identityHashCode(e)` and `System.identityHashCode(r)` display the identity hash codes of the two objects.
- **Method frames:** Calls to `display()` and `show()` execute using their respective method frames.

### Memory Analysis

| Component | Memory concept |
|---|---|
| Employee object | Heap |
| Report object | Heap |
| `salary` | Instance field of `Employee` |
| `bonus` | Parameter/local variable in the `display()` method frame |
| `e` | Local reference variable in `main()` |
| `r` | Local reference variable in `display()` |
| `display()` | Uses a method frame during execution |
| `show()` | Uses its own method frame during execution |

---

## How to Compile and Run

### Prerequisites

- Java Development Kit (JDK) installed.
- A text editor or IDE, such as VS Code, IntelliJ IDEA, or Eclipse.
- A terminal or command prompt.

### Step 1: Verify Java Installation

Open a terminal and run:

```bash
java -version
javac -version
```

### Step 2: Save the Source Code

Save the first program as `Main.java` and run it before replacing the file contents with the second program.

### Step 3: Compile the Program

```bash
javac Main.java
```

### Step 4: Run the Program

```bash
java Main
```

For Problem 2, enter the requested salary and bonus when prompted.

**Important:** Both programs use the public class name `Main`. Keep them in separate directories or run them one at a time to avoid overwriting the source file.

---

## Key Concepts

### 1. Stack Memory

The JVM uses method frames to manage method execution, local variables, and other execution information.

### 2. Heap Memory

Objects created using `new`, such as `Student`, `Employee`, and `Report`, are allocated on the heap under the usual JVM object model.

### 3. Instance Variables

Instance variables belong to individual objects. Each `Employee` object has its own `salary` field.

### 4. Local Variables

Local variables are declared within a method or block. The `marks` variable belongs to `display()` in Problem 1, while `bonus` is a parameter in Problem 2.

### 5. Object Identity Hash Code

`System.identityHashCode(object)` returns the identity hash code of an object, regardless of whether its class overrides `hashCode()`. It is not the actual memory address and is not guaranteed to be unique.

### 6. Local Inner Classes

A local inner class is declared inside a method or block. In Problem 2, `Report` is declared inside `Employee.display()` and can access the enclosing employee's instance field.

---

## Conclusion

These two lab exercises demonstrate how Java handles objects, instance fields, local variables, identity hash codes, method execution frames, and local inner classes.

The programs illustrate the distinction between objects allocated on the heap and method execution information managed through JVM stack frames.

**Learning Outcome:** After completing these exercises, students should be able to identify the roles of stack and heap memory and explain how Java objects and methods work together.
