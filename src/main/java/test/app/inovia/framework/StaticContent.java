package test.app.inovia.framework;

import test.app.inovia.entity.Product;
import test.app.inovia.model.ProductModel;

/**
 * Collection of static methods
 */
public class StaticContent {


    /**
     * converts Product entity to model
     * @param product
     * @return
     */
    public static ProductModel productEntityToModel(Product product) {
        ProductModel productModel = new ProductModel();
        if (product!= null) {
            productModel.setId(product.getId());
            productModel.setName(product.getName());
            productModel.setPrice(product.getPrice());
            productModel.setDescription(product.getDescription());
            productModel.setWeightFactor(product.getWeightFactor());
        }
        return productModel;
    }

}
