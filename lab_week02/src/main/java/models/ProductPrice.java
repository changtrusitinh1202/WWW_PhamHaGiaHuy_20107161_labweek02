package models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@NamedQueries({
        @NamedQuery(name="getPriceOfProduct", query = "Select p.Price from ProductPrice p where p.product.id = :id "),
})
@Entity
@Table(name = "product_price")
public class ProductPrice {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Id
    @Column(name = "price_date_time")
    private LocalDateTime priceDateTime;
    @Column(nullable = false)
    private double Price;
    @Column(nullable = false)
    private String note;

    public ProductPrice(Product product, LocalDateTime priceDateTime, double price, String note) {
        this.product = product;
        this.priceDateTime = priceDateTime;
        Price = price;
        this.note = note;
    }

    public ProductPrice() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "product=" + product +
                ", priceDateTime=" + priceDateTime +
                ", Price=" + Price +
                ", note='" + note + '\'' +
                '}';
    }
}
