package com.codekul.DbmsJpaDemo.controller;

import com.codekul.DbmsJpaDemo.model.Student;
import com.codekul.DbmsJpaDemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @GetMapping(value = "/getList")
    public List<Student> getList(){
        List<Student> list=studentRepo.findAll();
        return list;
    }

    @GetMapping(value = "/getStudent/{id}")
    public Student getStudent(@PathVariable Integer id){
        Student student=studentRepo.findOne(id);
        return student;
    }

    @GetMapping(value = "/getByName/{name}")
    public Student getByName(@PathVariable String name){
        Student student=studentRepo.findByName(name);
        return student;
    }

    @GetMapping(value = "/getByCity/{city}")
    public Student getByCity(@PathVariable String city){
        Student student=studentRepo.findByCity(city);
        return student;
    }

    @PostMapping("/uploadFile/file")
    public String uploadFile(@RequestParam("file") MultipartFile file){

        File f=new File("/home/pooja/Desktop/Images/"+file.getOriginalFilename());
        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "File Uploaded Successfully";
    }


}

