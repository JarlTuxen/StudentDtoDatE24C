package dk.ek.studentdtodate24c.config;


import dk.ek.studentdtodate24c.model.Student;
import dk.ek.studentdtodate24c.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        //ChatGPT testdata
        studentRepository.save(new Student("Mikkel", "4321", LocalDate.of(1998, 3, 12), LocalTime.of(9, 15, 20)));
        studentRepository.save(new Student("Freja", "9876", LocalDate.of(2001, 7, 8), LocalTime.of(10, 45, 10)));
        studentRepository.save(new Student("Jonas", "5566", LocalDate.of(1997, 11, 2), LocalTime.of(7, 50, 5)));
        studentRepository.save(new Student("Laura", "7788", LocalDate.of(1999, 1, 25), LocalTime.of(11, 5, 55)));
        studentRepository.save(new Student("Kasper", "8899", LocalDate.of(2003, 4, 19), LocalTime.of(6, 40, 30)));
        studentRepository.save(new Student("Sofie", "2211", LocalDate.of(1996, 6, 14), LocalTime.of(13, 20, 45)));
        studentRepository.save(new Student("Emil", "9900", LocalDate.of(2002, 9, 3), LocalTime.of(8, 10, 15)));
        studentRepository.save(new Student("Astrid", "3344", LocalDate.of(1995, 12, 1), LocalTime.of(14, 33, 5)));
        studentRepository.save(new Student("Rasmus", "6677", LocalDate.of(2000, 2, 28), LocalTime.of(15, 25, 40)));
        studentRepository.save(new Student("Ida", "5533", LocalDate.of(2004, 10, 29), LocalTime.of(7, 5, 25)));

    }
}
