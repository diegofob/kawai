package pe.edu.utp.electroplus.dao;

import org.springframework.data.repository.CrudRepository;

import pe.edu.utp.electroplus.model.Product;

public interface ProductDao extends CrudRepository<Product, Long> {

}
