package vdt.cloud.mid.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import vdt.cloud.mid.StudentDTO;
import vdt.cloud.mid.entity.Student;
import vdt.cloud.mid.service.StudentService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StudentTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    public StudentTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStudents() {
        List<Student> students = Arrays.asList(new Student(1L, "John Doe", "Male", "University A"));
        when(studentService.listAllStudents()).thenReturn(students);

        ResponseEntity<List<Student>> response = studentController.getStudents();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testGetStudent() {
        Student student = new Student(1L, "John Doe", "Male", "University A");
        when(studentService.getStudent(1L)).thenReturn(student);

        ResponseEntity<Student> response = studentController.getStudent(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(student, response.getBody());
    }

    @Test
    public void testCreateStudent() {
        StudentDTO studentDTO = new StudentDTO("Hoang Tuan", "Male", "University Ligma");
        Student student = new Student(1L, "Hoang Tuan", "Male", "University Ligma");
        when(studentService.createStudent(studentDTO)).thenReturn(student);

        ResponseEntity<Student> response = studentController.createStudent(studentDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(student, response.getBody());
    }

    @Test
    public void testUpdateStudent() {
        StudentDTO studentDTO = new StudentDTO("Hoang Tuan", "Male", "University Ligma");
        Student student = new Student(1L, "Hoang Tuan", "Male", "University Ligma");
        when(studentService.updateStudent(1L, studentDTO)).thenReturn(student);

        ResponseEntity<Student> response = studentController.updateStudent(1L, studentDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(student, response.getBody());
    }

    @Test
    public void testDeleteStudent() {
        doNothing().when(studentService).deleteStudent(1L);

        ResponseEntity<?> response = studentController.deleteStudent(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Student deleted successfully", response.getBody());
    }
}