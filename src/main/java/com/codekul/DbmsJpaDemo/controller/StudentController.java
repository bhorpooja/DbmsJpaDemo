package com.codekul.DbmsJpaDemo.controller;

import com.codekul.DbmsJpaDemo.model.Student;
import com.codekul.DbmsJpaDemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pooja on 16/11/17.
 */

@RestController
public class StudentController {


    @Autowired
    StudentRepo studentRepo;

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestBody Student student){

        studentRepo.save(student);
        return "data inserted successfully";
    }

    @PostMapping(value = "/insertStudent")
    public String insertStudent(@RequestBody List<Student> list){

        studentRepo.save(list);
        return "data inserted successfully";
    }

    @GetMapping(value = "/getStudent/{id}")
    public Student getStudent(@PathVariable Integer id){
        Student student=studentRepo.findOne(id);
        return student;
    }

    @GetMapping(value = "/getList")
    public List<Student> getList(){
        List<Student> list=studentRepo.findAll();
        return list;
    }


}

