package dk.ek.studentdtodate24c.service;


import dk.ek.studentdtodate24c.dto.StudentRequestDTO;
import dk.ek.studentdtodate24c.dto.StudentResponseDTO;
import dk.ek.studentdtodate24c.mapper.StudentMapper;
import dk.ek.studentdtodate24c.model.Student;
import dk.ek.studentdtodate24c.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    // Constructor injection
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentResponseDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();


        // Using a for-loop to convert each Student to a StudentResponseDTO

        List<StudentResponseDTO> studentResponses = students.stream()
                .map(studentMapper::toStudentResponseDTO)
                .toList();

        return studentResponses;
    }

    public StudentResponseDTO getStudentById(Long id) {
        /*Optional<Student> optionalStudent = studentRepository.findById(id);

        // Throw RuntimeException if student is not found
        if (optionalStudent.isEmpty()) {
            throw new RuntimeException("Student not found with id " + id);
        }

        Student studentResponse = optionalStudent.get();

        return studentResponse;*/
        Student student = studentRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Student with id " + id + " not found")
                );

        return studentMapper.toStudentResponseDTO(student);

    }

    public StudentResponseDTO createStudent(StudentRequestDTO studentRequest) {
        Student studentToSave = studentMapper.toStudent(studentRequest);
        Student studentResponse = studentRepository.save(studentToSave);

        return studentMapper.toStudentResponseDTO(studentResponse);
    }

    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO studentRequest) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        // Throw RuntimeException if student is not found
        if (optionalStudent.isEmpty()) {
            throw new RuntimeException("Student not found with id " + id);
        }

        Student studentToUpdate = optionalStudent.get();

        Student updateInfo = studentMapper.toStudent(studentRequest);
        studentToUpdate.setName(updateInfo.getName());
        studentToUpdate.setPassword(updateInfo.getPassword());
        studentToUpdate.setBornDate(updateInfo.getBornDate());
        studentToUpdate.setBornTime(updateInfo.getBornTime());


        Student studentResponse = studentRepository.save(studentToUpdate);
        return studentMapper.toStudentResponseDTO(studentResponse);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            // Throw RuntimeException if student is not found
            throw new RuntimeException("Student not found with id " + id);
        }
        studentRepository.deleteById(id);
    }
}

