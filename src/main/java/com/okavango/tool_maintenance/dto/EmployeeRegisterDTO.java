package com.okavango.tool_maintenance.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class EmployeeRegisterDTO {

    @NotBlank
    @Size(min = 6, message = "deve conter no mínimo 6 caracteres")
    private String name;

    @NotBlank
    @Email(message = "deve ser o formato de um email válido", regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String username;

    @NotBlank
    @Size(min = 6, max = 6, message = "deve conter exatamente 6 caracteres")
    private String password;

    @NotBlank
    @Pattern(regexp = "admin|supvr|techn",flags = Flag.CASE_INSENSITIVE, message = "os valores permitidos são: admin, supvr ou techn")
    private String role;
}
