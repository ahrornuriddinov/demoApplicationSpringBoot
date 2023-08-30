package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;


    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll(){
        List<Employee> all = employeeRepository.findAll();
        return all;
    }
    public List<Employee> getAllId(String name){
        List<Employee> all = employeeRepository.findAllByNameLikeJPQL(name);
        return all;
    }
    public void delete(Integer id){

        employeeRepository.deleteById(id);
    }


}
