package models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orderr")
public class Order {
    @Id
    @Column(name = "order_id", columnDefinition = "BIGINT(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "order_date", nullable = false, columnDefinition = "DATETIME(6)")
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private  Customer customer;
}
