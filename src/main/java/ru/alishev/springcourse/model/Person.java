package ru.alishev.springcourse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message =  "Name should be between 2 and 30 characters")
    private String name;

    @Min(value = 0, message = "Age should be grater than 0!")
    @Max(value = 120, message = "Age should be less than 120!")
    private Integer age;

    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Email should be valid")
    private String email;
}
