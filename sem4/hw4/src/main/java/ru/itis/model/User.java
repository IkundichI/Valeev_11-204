package ru.itis.model;


import jakarta.validation.constraints.*;

import lombok.*;
import ru.itis.annotation.FieldMatch;
import ru.itis.annotation.ValidPassword;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword",
                message = "The password fields must be match")
})
@Data
public class User {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @ValidPassword
    private String password;

    @NotBlank(message = "Please confirm your password")
    private String confirmPassword;

    @AssertTrue(message = "You must agree with the terms")
    private boolean terms;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\+7-\\d{3}-\\d{3}-\\d{2}-\\d{2}$",
            message = "Phone number must match the pattern +7-XXX-XXX-XX-XX")
    private String phoneNumber;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    private int age;
}
