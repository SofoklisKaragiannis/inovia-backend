package test.app.inovia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot application
 * Implements RESTful service back-end
 *
 * Support 5 API calls:
 *
 * * 1. Products retrieve done by call ProductsController
 * * Method: GET Url: https://{host}/rest/v1/getProducts
 * * which responds AvailableProducts in JSON format
 *
 * * 2. Adds a product if it doesn't exist
 * * Method: POST Url: https://{host}/rest/v1/addProduct
 * * which responds Basket in JSON format
 *
 * * 3. Removes a product if product id exists
 * * Method: GET Url: https://{host}/rest/v1/removeProduct?id={productId}
 * * which responds SelectedProduct in JSON format
 *
 * * 4. Updates a product if it exists
 * * Method: POST Url: https://{host}/rest/v1/updateProduct
 * * which responds SelectedProduct in JSON format
 *
 * * 5. Returns a product if product id exists
 * * Method: GET Url: https://{host}/rest/v1/findProduct?id={productId}
 * * which responds SelectedProduct in JSON format
 */

@SpringBootApplication
public class InoviaApplication {

    public static void main(String[] args) {
        SpringApplication.run(InoviaApplication.class, args);
    }

}

