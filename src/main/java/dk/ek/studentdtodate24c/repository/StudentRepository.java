package dk.ek.studentdtodate24c.repository;

import dk.ek.studentdtodate24c.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
