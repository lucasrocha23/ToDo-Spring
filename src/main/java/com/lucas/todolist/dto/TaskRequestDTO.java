package com.lucas.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDTO {
    @NotBlank(message = "O título não pode estar vazio.")
    private String title;

    @NotBlank(message = "O status não pode estar vazio.")
    private String description;

    private String status;
}
