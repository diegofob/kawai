package pe.edu.utp.electroplus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.utp.electroplus.dao.ProductDao;
import pe.edu.utp.electroplus.model.Product;

public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public void agregarProducto(Product product) {

        productDao.save(product);
    }

}
