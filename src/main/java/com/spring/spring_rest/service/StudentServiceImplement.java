package com.spring.spring_rest.service;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * Provides service operations for managing students.
 *
 */
@Service
public class StudentServiceImplement implements StudentService {

  private StudentRepository studentRepo;

  public StudentServiceImplement(StudentRepository studentRepo) {
    this.studentRepo = studentRepo;
  }

  /**
   * Creates a new student record.
   *
   * @param theStudentDto the student details to save
   * @return the saved student as a DTO
   */
  @Override
  public StudentDto createStudent(StudentDto theStudentDto) {
    Student theStudent = StudentMapper.mapToStudent(theStudentDto);
    Student saved = studentRepo.save(theStudent);

    return StudentMapper.mapToStudentDto(saved);
  }

  /**
   * Retrieves a student by their unique ID.
   *
   * @param theId the ID of the student to fetch
   * @return the student details as a DTO
   * @throws StudentNotFoundException if no student is found with the given ID
   */
  @Override
  public StudentDto getStudentById(Long theId) {
    Student student = studentRepo.findById(theId)
        .orElseThrow(() -> new StudentNotFoundException(
            "Student id " + theId + " not found!"));

    return StudentMapper.mapToStudentDto(student);
  }

  /**
   * Retrieves all students from the database.
   *
   * @return a list of all students as DTOs
   */
  @Override
  public List<StudentDto> getAllStudents() {
    List<Student> students = studentRepo.findAll();
    return students.stream().map(
        (student) -> StudentMapper.mapToStudentDto(student))
        .collect(Collectors.toList());
  }

  /**
   * Updates an existing student's details.
   *
   * @param theId the ID of the student to update
   * @param theStudentDto the updated student data
   * @return the updated student as a DTO
   * @throws StudentNotFoundException if no student is found with the given ID
   */
  @Override
  public StudentDto updateStudent(Long theId, StudentDto theStudentDto) {
    Student student = studentRepo.findById(theId)
        .orElseThrow(() -> new StudentNotFoundException(
            "Student id " + theId + " not found!"));

    student.setFirstName(theStudentDto.getFirstName());
    student.setLastName(theStudentDto.getLastName());
    student.setEmail(theStudentDto.getEmail());

    Student saved = studentRepo.save(student);
    return StudentMapper.mapToStudentDto(saved);
  }

  /**
   * Applies a partial update to an existing student.
   *
   * @param theId the ID of the student to update
   * @param theStudentDto the fields to update
   * @return the updated student as a DTO
   * @throws StudentNotFoundException if no student is found with the given ID
   */
  @Override
  public StudentDto patchStudent(Long theId, StudentDto theStudentDto) {
    Student student = studentRepo.findById(theId)
        .orElseThrow(() -> new StudentNotFoundException(
            "Student id " + theId + " not found!"));

    if (theStudentDto.getFirstName() != null) {
      student.setFirstName(theStudentDto.getFirstName());
    }
    if (theStudentDto.getLastName() != null) {
      student.setLastName(theStudentDto.getLastName());
    }
    if (theStudentDto.getEmail() != null) {
      student.setEmail(theStudentDto.getEmail());
    }

    Student saved = studentRepo.save(student);
    return StudentMapper.mapToStudentDto(saved);
  }

  /**
   * Deletes a student by their unique ID.
   *
   * @param theId the ID of the student to delete
   * @throws StudentNotFoundException if no student is found with the given ID
   */
  @Override
  public void deleteStudentById(Long theId) {
    studentRepo.findById(theId)
        .orElseThrow(() -> new StudentNotFoundException(
            "Student id " + theId + " is not found!"));
    studentRepo.deleteById(theId);
  }
}
