package test.app.inovia.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * supports AvailableProducts json contents
 * results - statusMessage
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvailableProductsModel {

    @JsonProperty("results")
    private List<ProductModel> results;

    @JsonProperty("statusMessage")
    private ResponseStatusMessageModel statusMessage;

    public void setResults(List<ProductModel> results) {
        this.results = results;
    }

    public List<ProductModel> getResults() {
        if (results == null) {
            results = new ArrayList<>();
        }
        return results;
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
        AvailableProductsModel that = (AvailableProductsModel) o;
        return Objects.equals(results, that.results) &&
                Objects.equals(statusMessage, that.statusMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results, statusMessage);
    }
}
