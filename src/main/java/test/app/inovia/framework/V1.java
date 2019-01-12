package test.app.inovia.framework;

/**
 * Back-end URI collection
 */
public class V1 {

    private static final String URI_BASE = "/rest/v1/";

    private static final String URI_GET_PRODUCTS = "getProducts";
    public static final String URI_GET_PRODUCTS_ABSOLUTE = URI_BASE + URI_GET_PRODUCTS;

    private static final String URI_ADD_PRODUCT = "addProduct";
    public static final String URI_ADD_PRODUCT_ABSOLUTE = URI_BASE + URI_ADD_PRODUCT;

    private static final String URI_REMOVE_PRODUCT = "removeProduct";
    public static final String URI_REMOVE_PRODUCT_ABSOLUTE = URI_BASE + URI_REMOVE_PRODUCT;

    private static final String URI_FIND_PRODUCT = "findProduct";
    public static final String URI_FIND_PRODUCT_ABSOLUTE = URI_BASE + URI_FIND_PRODUCT;

    private static final String URI_UPDATE_PRODUCT = "updateProduct";
    public static final String URI_UPDATE_PRODUCT_ABSOLUTE = URI_BASE + URI_UPDATE_PRODUCT;

    private V1() {
    }
}
