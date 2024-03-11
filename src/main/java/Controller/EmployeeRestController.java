package Controller;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class EmployeeRestController {

    private final String URI_EMPLOYEE = "http://localhost:8081/employee/";
    private final String URI_EMPLOYEE_ID = "http://localhost:8081/employee/{id}";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/r1/allemp")
    public ResponseEntity getAllr1()
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<> (httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE, HttpMethod.GET, entity, Employee[].class);
    }
    @GetMapping("/r2/employees/{id}")
    public ResponseEntity getEmpId(@PathVariable final Integer id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity < String > entity = new HttpEntity < > (httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE + id, HttpMethod.GET, entity, Employee.class);
    }

    @PostMapping("/r3/employee")
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Employee> entity = new HttpEntity<>(employee, httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE, HttpMethod.POST, entity, Employee.class);
    }

    @PutMapping("/r4/employee/{id}")
    public ResponseEntity updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Employee> entity = new HttpEntity<>(employee, httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE + id, HttpMethod.PUT, entity, Employee.class);
    }

    @DeleteMapping("/r5/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE + id, HttpMethod.DELETE, entity, String.class);
    }

}
