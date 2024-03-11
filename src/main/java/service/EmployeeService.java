package service;

import model.Employee;
import respository.EmployeeRepo;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmploy();

    Optional<Employee> getEmployById(int id);

    Employee saveEmploy(Employee employee);

    void deleteEmployById(int id);

}
