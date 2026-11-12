package com.spring.spring_rest.repository;

import com.spring.spring_rest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Student} entities.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
