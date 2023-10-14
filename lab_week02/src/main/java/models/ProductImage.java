package models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @Column(name = "image_id", nullable = false)
    private long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(nullable = false)
    private String path;
    @Column(nullable = false)
    private String alternative;
}
