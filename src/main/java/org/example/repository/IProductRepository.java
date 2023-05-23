package org.example.repository;

import org.example.model.IndustrialProduct;

import java.util.List;

public interface IProductRepository {

    List<IndustrialProduct> getProducts();

    List<IndustrialProduct> saveProducts(List<IndustrialProduct> products, String fileName);

}
