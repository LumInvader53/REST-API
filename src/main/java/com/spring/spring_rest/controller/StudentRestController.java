package com.spring.spring_rest.controller;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.service.StudentService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing student records.
 */
@RestController
@RequestMapping("/api/students")
public class StudentRestController {

  private StudentService studentService;

  public StudentRestController(StudentService studentService) {
    this.studentService = studentService;
  }

  /**
   * Creates a new student record.
   *
   * @param theStudentDto the student data to create
   * @return a ResponseEntity containing the created student and
   *         HTTP 201 Created status
   */
  @PostMapping
  public ResponseEntity<StudentDto> createStudents(
      @Valid @RequestBody StudentDto theStudentDto) {
    StudentDto saved = studentService.createStudent(theStudentDto);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
  }

  /**
   * Fetches a student by their ID.
   *
   * @param id the unique ID of the student
   * @return a ResponseEntity containing the student data with HTTP 200 OK
   */
  @GetMapping("{id}")
  public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
    StudentDto studentDto = studentService.getStudentById(id);
    return ResponseEntity.ok(studentDto);
  }

  /**
   * Fetches all students.
   *
   * @return a ResponseEntity containing the
   *         list of all students with HTTP 200 OK
   */
  @GetMapping
  public ResponseEntity<List<StudentDto>> getAllStudents() {
    List<StudentDto> students = studentService.getAllStudents();
    return ResponseEntity.ok(students);
  }

  /**
   * Updates an existing student completely.
   *
   * @param id            the ID of the student to update
   * @param theStudentDto the updated student data
   * @return a ResponseEntity containing the updated student with HTTP 200 OK
   */
  @PutMapping("{id}")
  public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,
      @Valid @RequestBody StudentDto theStudentDto) {
    StudentDto studentDto = studentService.updateStudent(
        id, theStudentDto);
    return ResponseEntity.ok(studentDto);
  }

  /**
   * Updates selected fields of an existing student.
   *
   * @param id            the ID of the student to update
   * @param theStudentDto the partial student data to patch
   * @return a ResponseEntity containing the patched student with HTTP 200 OK
   */
  @PatchMapping("{id}")
  public ResponseEntity<StudentDto> patchStudent(@PathVariable Long id,
      @Valid @RequestBody StudentDto theStudentDto) {
    StudentDto studentDto = studentService.patchStudent(
        id, theStudentDto);
    return ResponseEntity.ok(studentDto);
  }

  /**
   * Deletes a student by their ID.
   *
   * @param id the ID of the student to delete
   * @return a ResponseEntity with a success message and HTTP 200 OK
   */
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
    studentService.deleteStudentById(id);
    return ResponseEntity.ok("Student deleted successfully");
  }
}
