package pro.sky.employeehw;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() > 300) {
            throw new EmployeeStoragelsFullException();
        }
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        employees.add(new Employee(firstName, lastName));
        return null;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee e = null;
        var it = employees.iterator();
        while (it.hasNext()) {
            var employee = it.next();
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                it.remove();
                System.out.println(employee);
            }
        }
        if (e != null) {
            throw new EmployeeNotFoundException();
        }
        return e;
    }

    public Employee getEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }
}
