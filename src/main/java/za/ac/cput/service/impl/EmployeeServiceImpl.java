package za.ac.cput.service.impl;
/*
    EmployeeServiceImpl.java
    Employee Service Imp
    Lana Africa (216166640)
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;
import za.ac.cput.service.IEmployeeService;
import za.ac.cput.util.Helper;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private final EmployeeRepository repository;

    @Autowired
    public  EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }
    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }
    @Override
    public Optional<Employee> read(String id){
        return this.repository.findById(id);
    }
    @Override
    public List<Employee> findAll(){
        return this.repository.findAll();
    }
    @Override
    public void deleteById(String id){
        repository.deleteById(id);
        Optional<Employee> employee = read(id);
        if (employee.isPresent()) delete(employee.get());
    }
    @Override
    public void delete(Employee employee){
        this.repository.delete(employee);
    }
    @Override
    public Optional<Employee> findEmployeeEmail(String email){
        Helper.emailValid(email);
        return repository.findEmployeeEmail(email);
    }
}
