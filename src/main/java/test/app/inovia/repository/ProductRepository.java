package test.app.inovia.repository;


import org.springframework.data.repository.CrudRepository;
import test.app.inovia.entity.Product;

/**
 * Supports CRUD operations
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
