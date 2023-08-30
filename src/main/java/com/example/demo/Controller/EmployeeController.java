package com.example.demo.Controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity create(@RequestBody Employee employee){
        Employee save = employeeService.save(employee);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/employee")
    public ResponseEntity find(){
        List<Employee> all = employeeService.getAll();
        return ResponseEntity.ok(all);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        employeeService.delete(id);
        return ResponseEntity.ok("o'chdi");
    }
    @GetMapping("/employee/all")
    public ResponseEntity find(@RequestParam String name){
        List<Employee> all = employeeService.getAllId(name);
        return ResponseEntity.ok(all);
    }


}
