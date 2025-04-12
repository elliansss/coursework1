import java.util.Objects;

public class Employee {
    private String fullName;
    private int salary;
    private int department;
    private static int idCounter = 0;

    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Номер отдела - от 1 до 5");
        }
    }

    public String getFullName() {
        return fullName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, salary, department);
    }

    public String toString() {
        return "ФИО - " + this.fullName + ", отдел - " + this.department + ", зарплата - " + this.salary;
    }
}

