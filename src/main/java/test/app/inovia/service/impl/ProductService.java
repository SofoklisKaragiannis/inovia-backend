package test.app.inovia.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.app.inovia.entity.Product;
import test.app.inovia.repository.ProductRepository;
import test.app.inovia.service.IProductService;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService implements IProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Optional<Product> findProductById(Integer id) {
		return productRepository.findById(id);
	}

	@Override
	public Product addNewProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product modifyProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		if (productRepository.existsById(id)) {
			LOGGER.debug("Found product with product id {} , deleting same product", id);
			productRepository.deleteById(id);
		} else {
			LOGGER.debug("Product with product id {} not found ", id);
		}
	}

	@Override
	public List<Product> findAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

}
