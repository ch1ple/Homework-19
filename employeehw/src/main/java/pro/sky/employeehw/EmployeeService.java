package pro.sky.employeehw;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeService {
    private static final int SIZE = 10;
    private final Map<String,    Employee> employees = new HashMap<>();

    public Employee addEmployee(String firstName,
                                String lastName,
                                String middleName,
                                int salary,
                                int department,
                                int age) {
        if (!validateInput(firstName, lastName)) {
            throw new InvalidInputException();
        }
        var key = lastName + " " + firstName + " " + middleName;
        var employee = new Employee(firstName, lastName, middleName, salary, department, age);
        if (employees.size() > SIZE) {
            throw new EmployeeStoragelsFullException();
        }
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
            }
        employees.put(key, employee);
        return employee;
        }

    public Employee removeEmployee(String firstName, String lastName, String middleName) {

        if (!validateInput(firstName, lastName)) {
            throw new InvalidInputException();
        }
        var key = lastName + " " + firstName + " " + middleName;
        var removed = employees.remove(key);
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
        return removed;
    }

    public Employee getEmployee(String firstName, String lastName, String middleName) {

        if (!validateInput(firstName, lastName)) {
            throw new InvalidInputException();
        }
        var key = lastName + " " + firstName + " " + middleName;
        var employee = employees.get(key);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }


    private String getKey(String firstName, String lastName) {return firstName + " " + lastName; }

    private boolean validateInput(String firstName, String lastName) {
        return isAlpha(firstName) && isAlpha(lastName);
    }
}

