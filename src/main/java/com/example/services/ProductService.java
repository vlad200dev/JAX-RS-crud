package com.example.services;

import com.example.model.Product;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/productservice")
@Consumes({"application/json","application/xml"})
@Produces({"application/json","application/xml"})
public interface ProductService {

  @Path("/products")
  @GET
  List<Product> getAllProducts();

  @Path("/products/{id}")
  @GET
  Product getProductById(@PathParam("id") int id);

  @Path("/products")
  @POST
  Response createProduct(Product product); // no id

  @Path("/products/")
  @PUT
  Response updateProduct(Product product); // with id

  @Path("/products/{id}")
  @DELETE
  Response deleteProduct(@PathParam("id") int id);

}
