package test.app.inovia.entity;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * supports Product entity
 * id - title - description - price - weightFactor
 */
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "WEIGHTFACTOR")
    private Float weightFactor;

    public Integer getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public float getWeightFactor() {
        return weightFactor;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setWeightFactor(float weightFactor) {
        this.weightFactor = weightFactor;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", description=" + description + ", price=" + price + ", weightFactor=" + weightFactor + "]";
    }
}
