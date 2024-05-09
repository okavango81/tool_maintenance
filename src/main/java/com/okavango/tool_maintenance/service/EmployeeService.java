package com.okavango.tool_maintenance.service;

import com.okavango.tool_maintenance.dto.EmployeeRegisterDTO;
import com.okavango.tool_maintenance.dto.EmployeeResponseDTO;
import com.okavango.tool_maintenance.entity.Employee;
import com.okavango.tool_maintenance.pagination.ResponsePaginated;
import com.okavango.tool_maintenance.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional
    public ResponseEntity<EmployeeResponseDTO> addEmployee(EmployeeRegisterDTO e) {
        Employee employee = new Employee(e.getName().toUpperCase(), e.getUsername().toLowerCase(), e.getPassword(), e.getRole());
        employeeRepository.save(employee);
        return ResponseEntity.ok(new EmployeeResponseDTO(employee));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return ResponseEntity.ok(new EmployeeResponseDTO(employee.get()));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ResponsePaginated<EmployeeResponseDTO>> getEmployees(Pageable pageable) {
        Page<Employee> empPage = employeeRepository.findAll(pageable);
        List<EmployeeResponseDTO> empList = empPage.getContent().stream().map(EmployeeResponseDTO::new).collect(Collectors.toList());
        ResponsePaginated<EmployeeResponseDTO> empResponse = new ResponsePaginated<>();

        empResponse.setContent(empList);
        empResponse.setFirst(empPage.isFirst());
        empResponse.setLast(empPage.isLast());
        empResponse.setNumber(empPage.getNumber());
        empResponse.setSize(empPage.getSize());
        empResponse.setNumberOfElements(empPage.getNumberOfElements());
        empResponse.setTotalPages(empPage.getTotalPages());
        empResponse.setTotalElements(empPage.getTotalElements());

        return ResponseEntity.ok(empResponse);
    }

    @Transactional
    public ResponseEntity<Void> deleteEmployee(Long id) {
        getEmployeeById(id);
        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
