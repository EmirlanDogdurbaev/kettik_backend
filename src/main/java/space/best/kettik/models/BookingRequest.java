package space.best.kettik.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Setter
@Getter
public class BookingRequest {
    private String name;
    private String email;
    private String phone;
        private int numberOfPersons;
    private String tourName;
    private String data;

    // Геттеры и сеттеры

    // Конструкторы
}

