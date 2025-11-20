package dk.ek.studentdtodate24c.mapper;

import dk.ek.studentdtodate24c.dto.StudentRequestDTO;
import dk.ek.studentdtodate24c.dto.StudentResponseDTO;
import dk.ek.studentdtodate24c.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toStudent(StudentRequestDTO studentRequestDTO) {
        return new Student(
                studentRequestDTO.name(),
                studentRequestDTO.password(),
                studentRequestDTO.date(),
                studentRequestDTO.time()
        );
    }

    public StudentResponseDTO toStudentResponseDTO(Student student) {
        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getBornDate(),
                student.getBornTime()
        );
    }
}
