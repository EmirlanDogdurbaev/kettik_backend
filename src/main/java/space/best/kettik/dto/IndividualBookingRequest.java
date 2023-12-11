package space.best.kettik.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class IndividualBookingRequest {
    private String name;
    private String email;
    private String phone;
    private String note;


}