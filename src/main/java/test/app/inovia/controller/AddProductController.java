package test.app.inovia.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import test.app.inovia.entity.Product;
import test.app.inovia.framework.StaticContent;
import test.app.inovia.framework.V1;
import test.app.inovia.model.ProductModel;
import test.app.inovia.model.ResponseStatusMessageModel;
import test.app.inovia.service.IProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * ProductsController takes care calls of type
 * Method: POST Url: https://{host}/rest/v1/addProduct
 * Request Body Content type: application/json
 * {
 *   "id": Integer,
 *   "name": String,
 *   "description": String,
 *   "price": BigDecimal,
 *   "weightFactor": Float
 * }
 *
 *  Response body of type ProductModel in JSON format
 *
 */
@CrossOrigin
@RestController
@RequestMapping(V1.URI_ADD_PRODUCT_ABSOLUTE)
public class AddProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Operation to add a product ")
    public DeferredResult<ResponseEntity<ProductModel>> addProduct(@RequestBody Product product,
                                                                       HttpServletRequest request) {

        DeferredResult<ResponseEntity<ProductModel>> deferredResult = new DeferredResult<>();

        ProductModel productModel = new ProductModel();
        ResponseStatusMessageModel statusMessage = new ResponseStatusMessageModel();
        if (product != null && product.getId() != null && productService.findProductById(product.getId()).equals(Optional.empty())) {
            productModel = StaticContent.productEntityToModel(productService.addNewProduct(product));
        } else {
            statusMessage.setStatus(HttpStatus.BAD_REQUEST.name());
            statusMessage.setMessage("Wrong product!");
            productModel.setStatusMessage(statusMessage);
        }

        deferredResult.setResult(new ResponseEntity<>(productModel, HttpStatus.OK));
        return deferredResult;
    }
}
