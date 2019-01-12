package test.app.inovia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import test.app.inovia.framework.StaticContent;
import test.app.inovia.framework.V1;
import test.app.inovia.model.AvailableProductsModel;
import test.app.inovia.model.ResponseStatusMessageModel;
import test.app.inovia.service.IProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ProductsController takes care calls of type
 * Method: GET Url: https://{host}/rest/v1/getProducts
 *
 *  Response body of type AvailableProducts in JSON format
 *
 */
@CrossOrigin
@RestController
@RequestMapping(V1.URI_GET_PRODUCTS_ABSOLUTE)
public class ProductsController {

    @Autowired
    private IProductService productService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DeferredResult<ResponseEntity<AvailableProductsModel>> getAllProducts(@RequestParam Map<String, String> parameters,
                                                                              HttpServletRequest request) {

        DeferredResult<ResponseEntity<AvailableProductsModel>> deferredResult = new DeferredResult<>();
        // receive parameter values
        Map<String, String> requestParameters = new HashMap<>(parameters);

        AvailableProductsModel availableProducts = new AvailableProductsModel();
        ResponseStatusMessageModel statusMessage = new ResponseStatusMessageModel();
        // if invalid parameters --> bad request
        if (!requestParameters.isEmpty())  {
            statusMessage.setStatus(HttpStatus.BAD_REQUEST.name());
            statusMessage.setMessage("Wrong parameters!");
            availableProducts.setStatusMessage(statusMessage);
            deferredResult.setResult(new ResponseEntity<>(availableProducts, HttpStatus.BAD_REQUEST));
            return deferredResult;
        }

        availableProducts.setResults(productService.findAllProducts().stream().map(product -> StaticContent.productEntityToModel(product)).collect(Collectors.toList()));
        deferredResult.setResult(new ResponseEntity<>(availableProducts, HttpStatus.OK));

        return deferredResult;
    }
}
