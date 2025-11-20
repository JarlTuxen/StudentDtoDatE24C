package dk.ek.studentdtodate24c.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record StudentRequestDTO(String name, String password, LocalDate date, LocalTime time) {
}
