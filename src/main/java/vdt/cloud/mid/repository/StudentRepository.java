package vdt.cloud.mid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vdt.cloud.mid.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
