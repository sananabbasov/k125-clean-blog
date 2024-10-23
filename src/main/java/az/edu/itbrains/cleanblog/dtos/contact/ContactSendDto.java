package az.edu.itbrains.cleanblog.dtos.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContactSendDto {
    @NotNull
    @Size(min = 3, max = 20, message = "Ad minimum 3 maksimum 20 simvoldan ibaret olmalidir.")
    private String name;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",message = "Email formati duzgun deyil")
    private String email;
    @NotNull
//    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", message = "Telefon formati duzgun deyil")
    private String phoneNumber;
    @Size(min = 10, max = 1000, message = "Mesaj minimum 10 maksimum 1000  simvoldan ibaret olmalidir.")
    private String message;
}
