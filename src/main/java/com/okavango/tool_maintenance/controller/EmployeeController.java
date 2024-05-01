package com.okavango.tool_maintenance.controller;

import com.okavango.tool_maintenance.dto.EmployeeRegisterDTO;
import com.okavango.tool_maintenance.dto.EmployeeResponseDTO;
import com.okavango.tool_maintenance.entity.Employee;
import com.okavango.tool_maintenance.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> addEmployee(@Valid @RequestBody EmployeeRegisterDTO employee) {
        return employeeService.addEmployee(employee);
    }
}
