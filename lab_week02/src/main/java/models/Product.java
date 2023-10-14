package models;

import enums.ProductStatus;
import jakarta.persistence.*;
import jdk.jfr.Name;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name="getAllProduct", query = "Select p from Product p"),
        @NamedQuery(name="getAllProductIsAcive", query = "Select p from Product p where p.status = 1")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "BIGINT(20)")
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String unit;
    @Column(nullable = false, name = "manufacturer_name")
    private String manufacturer;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, columnDefinition = "INT(11)")
    private ProductStatus status;

    public Product(long id, String name, String description, String unit, String manufacturer, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.status = status;
    }

    public Product(long id) {
        this.id = id;
    }

    public Product() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", status=" + status +
                '}';
    }
}
