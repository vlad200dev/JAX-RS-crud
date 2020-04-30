package com.example.services;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductRepository repository;

  @Override
  public List<Product> getAllProducts() {
    return repository.findAll();
  }

  @Override
  public Product getProductById(int id) {
    return repository.findById(id).get(); // bad practice
  }

  @Override
  public Response createProduct(Product product) {
    Product savedProduct = repository.save(product);
    return Response.ok(savedProduct).build(); // return whole info about product with instantiated id value
  }

  @Override
  public Response updateProduct(Product product) {
    repository.save(product); // since id came as well this method works as update
    return Response.status(Status.OK).build();
  }

  @Override
  public Response deleteProduct(int id) {
    repository.deleteById(id);
    return Response.status(Status.OK).build();
  }
}
