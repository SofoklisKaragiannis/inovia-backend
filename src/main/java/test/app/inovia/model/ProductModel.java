package test.app.inovia.model;

import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;
import java.util.Objects;


/**
 * supports Product json contents
 * id - title - description - price - weightFactor - statusMessage
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProductModel {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("weightFactor")
    private Float weightFactor;

    @JsonProperty("statusMessage")
    private ResponseStatusMessageModel statusMessage;

    public BigDecimal getPrice() {
        return price;
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

    public void setWeightFactor(Float weightFactor) {
        this.weightFactor = weightFactor;
    }

    public void setStatusMessage(ResponseStatusMessageModel statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductModel that = (ProductModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price) &&
                Objects.equals(weightFactor, that.weightFactor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name , description, price, weightFactor);
    }
}
