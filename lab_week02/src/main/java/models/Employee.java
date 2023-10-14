package models;

import enums.EmployeeStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "findById", query = "Select e from Employee e where e.id = :id"),
        @NamedQuery(name = "getAllEmployee", query = "Select e from Employee e ")
})

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", columnDefinition = "BIGINT(20)")
    private long id;
    @Column(name = "full_name",nullable = false, columnDefinition = "VARCHAR(150)" )
    private String name;
    @Column(nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime dob;
    @Column(nullable = false,  columnDefinition = "VARCHAR(150)" )
    private String email;
    @Column(nullable = false, columnDefinition = "VARCHAR(15)" )
    private String phone;
    @Column(nullable = false,columnDefinition = "VARCHAR(250)" )
    private String address;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, columnDefinition = "INT(11)")
    private EmployeeStatus status;

    public Employee() {
    }

    public Employee(long id, String name, LocalDateTime dob, String email, String phone, String address, EmployeeStatus status) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
