package vdt.cloud.mid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vdt.cloud.mid.StudentDTO;
import vdt.cloud.mid.entity.Student;
import vdt.cloud.mid.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> listAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(StudentDTO studentDTO){
        Student student = new Student();
        student.setFullName(studentDTO.getFullName());
        student.setGender(studentDTO.getGender());
        student.setSchool(studentDTO.getSchool());
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, StudentDTO studentDTO){
        Student studentToUpdate = studentRepository.findById(id).orElse(null);
        if(studentToUpdate != null){
            studentToUpdate.setFullName(studentDTO.getFullName());
            studentToUpdate.setGender(studentDTO.getGender());
            studentToUpdate.setSchool(studentDTO.getSchool());
            return studentRepository.save(studentToUpdate);
        }
        return null;
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
