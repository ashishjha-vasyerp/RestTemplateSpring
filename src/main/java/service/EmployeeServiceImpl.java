package service;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import respository.EmployeeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmploy() {
        List<Employee> emp = employeeRepo.findAll();
        return emp;
    }

    @Override
    public Optional<Employee> getEmployById(int id) {
       return employeeRepo.findById(id);
    }


    @Override
    public Employee saveEmploy(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployById(int id) {

        employeeRepo.deleteById(id);

    }
}
