package Controller;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("all")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmploy();
    }

    @GetMapping("employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        return employeeService.getEmployById(id);
    }

    @PostMapping("employee")
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeService.saveEmploy(employee);
    }

    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee)
    {
        Optional<Employee> updateEmployee = employeeService.getEmployById(employee.getId());

        if (updateEmployee.isPresent()) {
            Employee employeeToUpdate = updateEmployee.get();

            if (employee.getName() != null && !employee.getName().isEmpty()) {
                employeeToUpdate.setName(employee.getName());
            }
            if (employee.getSalary() != null && !employee.getSalary().isEmpty()) {
                employeeToUpdate.setSalary(employee.getSalary());
            }
            return ResponseEntity.ok(employeeService.saveEmploy(employeeToUpdate));

        } else {
            return ResponseEntity.notFound().build();
        }


    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        employeeService.deleteEmployById(id);
        return ResponseEntity.ok("Sucess");
    }

}
