package com.okavango.tool_maintenance.dto;

import com.okavango.tool_maintenance.entity.Employee;
import lombok.Getter;

@Getter
public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String username;
    private String role;

    public EmployeeResponseDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.username = employee.getUsername();
        this.role = employee.getRole().name().substring("ROLE_".length());
    }
}
