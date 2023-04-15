abstract class Employee {
    String firstName;
    String lastName;
    double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public double calculateTax() {
        return 0.17 * salary;
    }

    public abstract double calculateBonus();

    public double calculateSalary() {
        double grossSalary = salary + calculateBonus();
        double tax = calculateTax();
        double netSalary = grossSalary - tax;
        return netSalary;
    }
}

class Accountant extends Employee {
    public Accountant(String firstName, String lastName, double salary) {
        super(firstName, lastName, salary);
    }

    @Override
    public double calculateBonus() {
        return 0.1 * salary;
    }
}

class ITEmployee extends Employee {
    int experience;

    public ITEmployee(String firstName, String lastName, double salary, int experience) {
        super(firstName, lastName, salary);
        this.experience = experience;
    }

    @Override
    public double calculateBonus() {
        if (experience < 2) {
            return 500;
        } else if (experience < 5) {
            return 2000;
        } else {
            return 5000;
        }
    }
}

class Programmer extends ITEmployee {
    public Programmer(String firstName, String lastName, double salary, int experience) {
        super(firstName, lastName, salary, experience);
    }

    @Override
    public double calculateBonus() {
        double bonus = super.calculateBonus();
        double creativeActivityDiscount = 0.5 * calculateTax();
        return bonus - creativeActivityDiscount;
    }
}
public class Main {
    public static void main(String[] args) {
        Employee adam = new Accountant("Adam", "Wiśniewski", 6000);
        Employee agata = new ITEmployee("Agata", "Wróbel", 7500, 3);
        Employee pawel = new ITEmployee("Paweł", "Kowalski", 5000, 1);
        Employee ada = new Programmer("Ada", "Nowak", 8000, 6);

        System.out.println(adam.firstName + " " + adam.lastName + ": " + adam.calculateSalary());
        System.out.println(agata.firstName + " " + agata.lastName + ": " + agata.calculateSalary());
        System.out.println(pawel.firstName + " " + pawel.lastName + ": " + pawel.calculateSalary());
        System.out.println(ada.firstName + " " + ada.lastName + ": " + ada.calculateSalary());
    }
}
