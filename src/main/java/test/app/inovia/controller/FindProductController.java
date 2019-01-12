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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * ProductsController takes care calls of type
 * Method: GET Url: https://{host}/rest/v1/findProduct?id={productId}
 *
 *  Response body of type ProductModel in JSON format
 *
 */
@CrossOrigin
@RestController
@RequestMapping(V1.URI_FIND_PRODUCT_ABSOLUTE)
public class FindProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Operation to retrieve a product by given id")
    public DeferredResult<ResponseEntity<ProductModel>> findProduct(@RequestParam Map<String, String> parameters,
                                                                       HttpServletRequest request) {

        DeferredResult<ResponseEntity<ProductModel>> deferredResult = new DeferredResult<>();
        // receive parameter values
        Map<String, String> requestParameters = new HashMap<>(parameters);
        String id = requestParameters.get("id");

        ProductModel productModel = new ProductModel();
        ResponseStatusMessageModel statusMessage = new ResponseStatusMessageModel();
        Optional<Product> product = productService.findProductById(Integer.valueOf(id));
        if (!product.equals(Optional.empty())) {
            productModel = StaticContent.productEntityToModel(product.get());
        } else {
            statusMessage.setStatus(HttpStatus.BAD_REQUEST.name());
            statusMessage.setMessage("Wrong product!");
            productModel.setStatusMessage(statusMessage);
        }

        deferredResult.setResult(new ResponseEntity<>(productModel, HttpStatus.OK));
        return deferredResult;
    }
}
