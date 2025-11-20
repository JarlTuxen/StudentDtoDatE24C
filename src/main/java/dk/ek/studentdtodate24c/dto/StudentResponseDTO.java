package dk.ek.studentdtodate24c.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record StudentResponseDTO(Long id, String name, LocalDate date, LocalTime time) {
}
