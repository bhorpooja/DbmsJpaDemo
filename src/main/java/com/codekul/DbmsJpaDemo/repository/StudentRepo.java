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

        Student findByCity(String city);

        List<Student> findByName(String name);

        List<Student> findByCityAndName(String city,String name);

        List<Student> findByCityOrName(String city,String name);

        List<Student> findByIdLessThan(Integer id);

        List<Student> findByIdGreaterThan(Integer id);

        List<Student> findByIdBefore(Integer id);

        List<Student> findByIdAfter(Integer id);

        List<Student> findByIdBetween(Integer id1,Integer id2);

}
