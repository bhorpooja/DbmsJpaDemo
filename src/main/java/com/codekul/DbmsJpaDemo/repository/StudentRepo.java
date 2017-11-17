package com.codekul.DbmsJpaDemo.repository;

import com.codekul.DbmsJpaDemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by pooja on 16/11/17.
 */
public interface StudentRepo extends JpaRepository<Student,Integer> {

        Student save(Student student);

        List<Student> save(List<Student> list);

        List<Student> findAll();

        Student findOne(Integer id);

        Student findByName(String name);

        Student findByCity(String city);

}
