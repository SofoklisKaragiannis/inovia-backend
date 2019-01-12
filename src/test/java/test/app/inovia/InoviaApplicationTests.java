package test.app.inovia;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import test.app.inovia.framework.V1;
import test.app.inovia.model.AvailableProductsModel;
import test.app.inovia.model.ProductModel;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InoviaApplicationTests {

    @Autowired
    private WebApplicationContext ctx;

    @Autowired
    ObjectMapper objectMapper;

    private MockMvc mockMvc;
    private final String PRODUCT1 = "{\"id\":1,\"name\":\"name1\",\"description\":\"description1\",\"price\":1,\"weightFactor\":0.1}";
    private final String PRODUCT2 = "{\"id\":1,\"name\":\"name2\",\"description\":\"description2\",\"price\":2,\"weightFactor\":0.2}";

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.ctx)
                .build();
    }


    @Test
    public void TestTotalControllerOK() throws Exception {
        TestAddProductControllerOK();
        TestFindProductControllerOK();
        TestUpdateProductControllerOK();
        TestProductsControllerOK();
        TestRemoveProductControllerOK();
    }

    /**
     * Test AddProductController
     * @throws Exception
     */
    public void TestAddProductControllerOK() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(
                post(V1.URI_ADD_PRODUCT_ABSOLUTE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(PRODUCT1))
                .andExpect(request().asyncStarted())
                .andReturn();

        ResponseEntity<ProductModel> productModelEntity = (ResponseEntity<ProductModel>)mvcResult.getAsyncResult();
        ProductModel productModel = productModelEntity.getBody();

        assertEquals(productModel.getPrice().toString(), "1");
        assertEquals(productModelEntity.getStatusCode(), HttpStatus.OK);
    }

    /**
     * Test FindProductController
     * @throws Exception
     */
    public void TestFindProductControllerOK() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(
                get(V1.URI_FIND_PRODUCT_ABSOLUTE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .param("id", "1"))
                .andExpect(request().asyncStarted())
                .andReturn();

        ResponseEntity<ProductModel> productModelEntity = (ResponseEntity<ProductModel>)mvcResult.getAsyncResult();
        ProductModel productModel = productModelEntity.getBody();

        assertEquals(productModel.getPrice().toString(), "1.00");
        assertEquals(productModelEntity.getStatusCode(), HttpStatus.OK);
    }

    /**
     * Test UpdateProductController
     * @throws Exception
     */
    public void TestUpdateProductControllerOK() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(
                post(V1.URI_UPDATE_PRODUCT_ABSOLUTE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(PRODUCT2))
                .andExpect(request().asyncStarted())
                .andReturn();

        ResponseEntity<ProductModel> productModelEntity = (ResponseEntity<ProductModel>)mvcResult.getAsyncResult();
        ProductModel productModel = productModelEntity.getBody();

        assertEquals(productModel.getPrice().toString(), "2");
        assertEquals(productModelEntity.getStatusCode(), HttpStatus.OK);
    }

    /**
     * Test ProductsController
     * @throws Exception
     */
    public void TestProductsControllerOK() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(
                get(V1.URI_GET_PRODUCTS_ABSOLUTE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(request().asyncStarted())
                .andReturn();

        ResponseEntity<AvailableProductsModel> availableProductsResponseEntity = (ResponseEntity<AvailableProductsModel>)mvcResult.getAsyncResult();
        AvailableProductsModel availableProducts = availableProductsResponseEntity.getBody();

        assertEquals(availableProducts.getResults().size(), 1);
        assertEquals(availableProductsResponseEntity.getStatusCode(), HttpStatus.OK);
    }

    /**
     * Test RemoveProductController
     * @throws Exception
     */
    public void TestRemoveProductControllerOK() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(
                get(V1.URI_REMOVE_PRODUCT_ABSOLUTE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .param("id", "1"))
                .andExpect(request().asyncStarted())
                .andReturn();

        ResponseEntity<ProductModel> productModelEntity = (ResponseEntity<ProductModel>)mvcResult.getAsyncResult();
        ProductModel productModel = productModelEntity.getBody();

        assertEquals(productModel.getPrice().toString(), "2.00");
        assertEquals(productModelEntity.getStatusCode(), HttpStatus.OK);
    }

}

