package pro.sky.employeehw;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public ResponseEntity<Employee> add(@RequestParam String firstName,
                                        @RequestParam String lastName,
                                        @RequestParam String middleName,
                                        @RequestParam int salary,
                                        @RequestParam int department,
                                        @RequestParam int age) {
        try {
            return ResponseEntity.ok(employeeService.addEmployee(firstName, lastName, middleName, salary, department, age));
        } catch (EmployeeStoragelsFullException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String middleName) {
        return employeeService.removeEmployee(firstName, lastName, middleName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam String middleName) {
        return employeeService.getEmployee(firstName, lastName, middleName);
    }

    @GetMapping("/all")
    public Map<String, Employee> all() {
        return employeeService.getEmployees();
    }
}
