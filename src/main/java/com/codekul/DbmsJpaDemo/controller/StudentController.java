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

    @GetMapping(value = "/getByCity/{city}")
    public Student getByCity(@PathVariable String city){
        Student student=studentRepo.findByCity(city);
        return student;
    }

    @GetMapping(value = "/getNameList/{name}")
    public List<Student> getNameList(@PathVariable String name){
        List<Student> student=studentRepo.findByName(name);
        return student;
    }

    @GetMapping(value = "/getByCityAndName/")
    public List<Student> getNameAndCity(@RequestParam("city") String city,@RequestParam("name") String name){
        List<Student> student=studentRepo.findByCityAndName(city,name);
        return student;
    }

    @GetMapping(value = "/getByCityOrName/")
    public List<Student> getNameOrCity(@RequestParam("city") String city,@RequestParam("name") String name){
        List<Student> student=studentRepo.findByCityOrName(city,name);
        return student;
    }

    @GetMapping(value = "/getByIdLessThan")
    public List<Student> getByIdLessThan(@RequestParam("id") Integer id){
        List<Student> student=studentRepo.findByIdLessThan(id);
        return student;
    }

    @GetMapping(value = "/getByIdGreaterThan/")
    public List<Student> getByIdGreaterThan(@RequestParam("id") Integer id){
        List<Student> student=studentRepo.findByIdGreaterThan(id);
        return student;
    }

    @GetMapping(value = "/getByIdAfter/")
    public List<Student> getByIdAfter(@RequestParam("id") Integer id){
        List<Student> student=studentRepo.findByIdAfter(id);
        return student;
    }

    @GetMapping(value = "/getByIdBefore/")
    public List<Student> getByIdBefore(@RequestParam("id") Integer id){
        List<Student> student=studentRepo.findByIdBefore(id);
        return student;
    }


    @GetMapping(value = "/getByIdBetween/")
    public List<Student> getByIdBetween(@RequestParam("id1") Integer id1,@RequestParam("id2") Integer id2){
        List<Student> student=studentRepo.findByIdBetween(id1,id2);
        return student;
    }

    @GetMapping(value = "/getByNameNotLike")
    public List<Student> getByNameNotLike(@RequestParam("name") String name){
        List<Student> student=studentRepo.findByNameNotLike(name);
        return student;
    }

    @GetMapping(value = "/getByNameLike")
    public List<Student> getByNameLike(@RequestParam("name") String name){
        List<Student> student=studentRepo.findByNameLike(name);
        return student;
    }

    @GetMapping(value = "/getByNameStartWith")
    public List<Student> getByNameStartWith(@RequestParam("name") String name){
        List<Student> student=studentRepo.findByNameStartingWith(name);
        return student;
    }

    @GetMapping(value = "/getByNameEndWith")
    public List<Student> getByNameEndWith(@RequestParam("name") String name){
        List<Student> student=studentRepo.findByNameEndingWith(name);
        return student;
    }

    @GetMapping(value = "/getByNameDesc")
    public List<Student> getByNameDesc(@RequestParam("id") Integer id){
        List<Student> student=studentRepo.findByIdOrderByNameDesc(id);
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

