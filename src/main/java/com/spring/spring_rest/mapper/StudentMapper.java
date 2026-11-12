package com.spring.spring_rest.mapper;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;

/**
 * Mapper utility for converting between
 * Student entities and StudentDto objects.
 */
public class StudentMapper {

  /**
   * Converts a Student entity to a StudentDto.
   *
   * @param theStudent the Student entity to convert
   * @return a StudentDto containing the mapped student data
   */
  public static StudentDto mapToStudentDto(Student theStudent) {
    return new StudentDto(theStudent.getId(), theStudent.getFirstName(),
        theStudent.getLastName(), theStudent.getEmail());
  }

  /**
   * Converts a StudentDto to a Student entity.
   *
   * @param theStudentDto the StudentDto to convert
   * @return a Student entity containing the mapped student data
   */
  public static Student mapToStudent(StudentDto theStudentDto) {
    return new Student(theStudentDto.getId(), theStudentDto.getFirstName(),
        theStudentDto.getLastName(), theStudentDto.getEmail());
  }
}
