package pro.sky.employeehw;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findMaxSalaryEmployee(int departmentId) {
        return employeeService.getEmployees().values()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee findMinSalaryEmployee(int departmentId) {
        return employeeService.getEmployees().values()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }
    public Collection<Employee> findByDepartment(int departmentId) {
        return employeeService.getEmployees().values()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }
    public Map<Integer, List<Employee>> groupByDepartment() {
        return employeeService.getEmployees().values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
