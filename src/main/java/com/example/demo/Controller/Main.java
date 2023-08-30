package com.example.demo.Controller;

import com.example.demo.model.Course;
import com.example.demo.model.Students;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Main {
//
//    @GetMapping("/students")
//    public String hello(){
//        return "Hello world fuck";
//    }
    @PostMapping("/students")
    public ResponseEntity<Students> addStudent(@RequestBody Students students){
        return ResponseEntity.ok(students);
    }
    @PutMapping("/students")
    public ResponseEntity<Students> update(@RequestBody Students students){
        return ResponseEntity.ok(students);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Students> getone(@PathVariable Integer id){
        Students students = new Students();
        students.setId(id);
        return ResponseEntity.ok(students);
    }
    @GetMapping("/students")
    public ResponseEntity getAll(@RequestParam Integer id,@RequestParam String name,@RequestParam String lastname,@RequestParam Integer age){
        List<Students> list =new ArrayList<>();
        Course course = new Course();
        course.setId(1);
        course.setName("Test");
        list.add(new Students(id,name,lastname,age,course));
        list.add(new Students(2,"Ahror","Nuriddinov",23,course));
        list.add(new Students(3,"Timur","NOsirov",25,course));
        return ResponseEntity.ok(list);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        return ResponseEntity.ok(id+"malumot ochdi");
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity patchstudent(@PathVariable Integer id,@RequestBody Students students){
        return ResponseEntity.ok(students);
    }
}
