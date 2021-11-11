package dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MessageRequest {
    String name;
    String surname;
    String mobile;
    String email;
    String message;
}
