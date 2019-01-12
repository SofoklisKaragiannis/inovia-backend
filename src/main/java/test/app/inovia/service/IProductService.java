package test.app.inovia.service;


import org.springframework.stereotype.Service;
import test.app.inovia.entity.Product;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface IProductService {

	Optional<Product> findProductById(Integer id);

	Product addNewProduct(Product product);

	Product modifyProduct(Product product);

	void deleteProduct(Integer id);

	List<Product> findAllProducts();
}
