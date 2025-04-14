import java.sql.SQLOutput;

public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        fillEmployeesArray();
        printEmployeeDetails(employees);

        double percentageIncrease = 10.0;
        increaseSalaries(employees, percentageIncrease);

        System.out.println("\nПосле индексации зарплат:");
        printEmployeeDetails(employees);

        int departmentNumber = 2;

        increaseSalariesByDepartment(employees, departmentNumber, percentageIncrease);
        printEmployeesWithoutDepartment(employees, departmentNumber);

        int salaryNumber = 70500;

        System.out.println("Сотрудники с зарплатой меньше " + salaryNumber + ":");
        printEmployeesWithSalaryLess(employees, salaryNumber);

        System.out.println("\nСотрудники с зарплатой больше или равной " + salaryNumber + ":");
        printEmployeesWithSalaryGreater(employees, salaryNumber);
    }

    private static void printEmployeesWithSalaryLess(Employee[] employees, int salaryThreshold) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salaryThreshold) {
                System.out.println("ID: " + i + ", ФИО: " + employees[i].getFullName() + ", Зарплата: " + employees[i].getSalary());
            }
        }
    }

    private static void printEmployeesWithSalaryGreater(Employee[] employees, int salaryThreshold) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= salaryThreshold) {
                System.out.println("ID: " + i + ", ФИО: " + employees[i].getFullName() + ", Зарплата: " + employees[i].getSalary());
            }
        }
    }


    private static void fillEmployeesArray() {
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
    }

    private static void printEmployeeDetails(Employee[] employees) {
        System.out.println("Информация о всех сотрудниках:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
        System.out.println();
    }


    private static void increaseSalaries(Employee[] employees, double percentage) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.increaseSalary(percentage);
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
                System.out.println(employee.getFullName());
            }
        }
    }

    private static Employee findEmployeeWithMinSalaryInDepartment(Employee[] employees, int departmentNumber) {
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                    employeeWithMinSalary = employee;
                }
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalaryInDepartment(Employee[] employees, int departmentNumber) {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                if (employeeWithMaxSalary == null || employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                    employeeWithMaxSalary = employee;
                }
            }
        }
        return employeeWithMaxSalary;
    }

    private static int calculateSumOfSalariesByDepartment(Employee[] employees, int departmentNumber) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    private static double calculateAverageSalaryByDepartment(Employee[] employees, int departmentNumber) {
        int sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                sum += employee.getSalary();
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return (double) sum / count;
    }

    private static void increaseSalariesByDepartment(Employee[] employees, int departmentNumber, double percentage) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                employee.increaseSalary(percentage);
            }
        }
    }

    private static void printEmployeesWithoutDepartment(Employee[] employees, int departmentNumber) {
        System.out.println("Сотрудники отдела " + departmentNumber);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                System.out.println("ФИО: " + employee.getFullName() + ", Зарплата: " + employee.getSalary());
            }
        }
    }
}



