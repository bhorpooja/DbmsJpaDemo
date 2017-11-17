package com.codekul.DbmsJpaDemo.repository;

import com.codekul.DbmsJpaDemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pooja on 16/11/17.
 */
public interface StudentRepo extends JpaRepository<Student,Integer> {



}
