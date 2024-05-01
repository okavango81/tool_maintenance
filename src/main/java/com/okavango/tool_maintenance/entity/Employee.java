package com.okavango.tool_maintenance.entity;

import com.okavango.tool_maintenance.enumeration.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    // construtor para EmployeeRegisterDTO
    public Employee(String name, String username, String password, String role) {
        this.name = name;
        this.username = username;
        this.password = password;

        if(role.equalsIgnoreCase("admin")){
            this.role = Role.ROLE_ADMIN;
        } else if (role.equalsIgnoreCase("supvr")) {
            this.role = Role.ROLE_SUPVR;
        } else if (role.equalsIgnoreCase("techn")) {
            this.role = Role.ROLE_TECHN;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
