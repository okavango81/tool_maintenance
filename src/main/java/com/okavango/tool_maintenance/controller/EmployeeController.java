package com.okavango.tool_maintenance.controller;

import com.okavango.tool_maintenance.dto.EmployeeRegisterDTO;
import com.okavango.tool_maintenance.dto.EmployeeResponseDTO;
import com.okavango.tool_maintenance.pagination.ResponsePaginated;
import com.okavango.tool_maintenance.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> addEmployee(@Valid @RequestBody EmployeeRegisterDTO employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public ResponseEntity<ResponsePaginated<EmployeeResponseDTO>> getEmployees(@PageableDefault(size = 12) Pageable pageable) {
        return employeeService.getEmployees(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}
