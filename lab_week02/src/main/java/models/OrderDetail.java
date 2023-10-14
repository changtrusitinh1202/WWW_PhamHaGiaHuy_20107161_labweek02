package models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private  Product product;
    @Column(nullable = false)
    private double quantity;
    @Column (nullable = false)
    private double price;
    @Column(nullable = false)
    private String note;
}
