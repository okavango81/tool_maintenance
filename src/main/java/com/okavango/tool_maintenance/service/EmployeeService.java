package com.okavango.tool_maintenance.service;

import com.okavango.tool_maintenance.dto.EmployeeRegisterDTO;
import com.okavango.tool_maintenance.dto.EmployeeResponseDTO;
import com.okavango.tool_maintenance.entity.Employee;
import com.okavango.tool_maintenance.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional
    public ResponseEntity<EmployeeResponseDTO> addEmployee(EmployeeRegisterDTO e ) {
        Employee employee = new Employee(e.getName(), e.getUsername().toLowerCase(), e.getPassword(), e.getRole());
        employeeRepository.save(employee);
        return ResponseEntity.ok(new EmployeeResponseDTO(employee));
    }

}
