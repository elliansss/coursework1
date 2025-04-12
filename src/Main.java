import java.sql.SQLOutput;

public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Федоров Александр Васильевич", 1, 47650);
        employees[1] = new Employee("Журавлева Мария Николаевна", 2, 62980);
        employees[2] = new Employee("Яковлева Яна Валерьевна", 3, 77350);
        employees[3] = new Employee("Сабуров Александр Дмитриевич", 4, 88900);
        employees[4] = new Employee("Вольник Петр Сергеевич", 5, 90015);
        employees[5] = new Employee("Малинина Ева Петровна", 1, 45000);
        employees[6] = new Employee("Хрусталева Алина Леонидовна", 2, 57600);
        employees[7] = new Employee("Дельцов Владимир Ильич", 3, 55900);
        employees[8] = new Employee("Ульянова Эвелина Дмитриевна", 4, 76430);
        employees[9] = new Employee("Иванов Иван Иванович", 5, 100000);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }

        System.out.println("Сумма затрат на зп - " + calculateSumOfSalaries(employees));
        Employee employee = findEmployeeWithMinSalary(employees);
        System.out.println("Сотрудник с минимальной ЗП - " + employee.getFullName());
        Employee employeeWithMaxSalary = findEmployeeWithMaxSalary(employees);
        System.out.println("Сотрудник с максимальной ЗП - " + employeeWithMaxSalary.getFullName());
        System.out.println("Среднее значение зарплат - " + calculateAverageOfSalaries(employees));
        printAllEmployeeFullNames(employees);
    }

    private static int calculateSumOfSalaries(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary(Employee[] employees) {
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                    employeeWithMinSalary = employee;
                }
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalary(Employee[] employees) {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (employeeWithMaxSalary == null || employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                    employeeWithMaxSalary = employee;
                }
            }
        }
        return employeeWithMaxSalary;
    }

    private static int calculateAverageOfSalaries(Employee[] employees) {
        int sum2 = 0;
        int idCounter = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum2 += employee.getSalary();
                idCounter++;
            }
        }
        if (idCounter == 0) {
            return 0;
        }
        return (int) sum2 / idCounter;
    }

    private static void printAllEmployeeFullNames(Employee[] employees) {
        System.out.println("ФИО всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
            }
            System.out.println(employee.getFullName());
        }
    }

}