package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoCS {

    @Test
     void shouldOpen() {
        String date = "28.11.2020";


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);


        assertEquals(DayOfWeek.SATURDAY, localDate.getDayOfWeek());
    }

}
