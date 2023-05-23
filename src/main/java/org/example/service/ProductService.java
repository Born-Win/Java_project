package org.example.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.model.IndustrialProduct;
import org.example.repository.IProductRepository;
import org.example.repository.implementation.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.utility.FilePathManager.getFilePath;

public class ProductService {
    private Logger logger = LogManager.getLogger(ProductService.class);
    private IProductRepository repository;

    public ProductService(IProductRepository repository) {
        this.repository = repository;
        logger.debug("ProductService created");
    }

    public List<IndustrialProduct> findProductsByBrand(Long id) {
        return repository.getProducts().stream().filter(x -> x.getBrand().getBrandId().equals(id)).collect(Collectors.toList());
    }

    public List<IndustrialProduct> findProductsByModel(Long id) {
        return repository.getProducts().stream().filter(x -> x.getModel().getModelId().equals(id)).collect(Collectors.toList());
    }

    public List<IndustrialProduct> findAllProducts() {
        return repository.getProducts();
    }

    public String saveProductsToFile(List<IndustrialProduct> products, String fileName) {
        if (!fileName.isEmpty()) {
            repository.saveProducts(products, fileName + ".json");
            logger.info("result was saved");
            return "saved to file: " + getFilePath(fileName + ".json");
        }
        logger.info("result was not saved, because of user option");
        return "return result was not saved";
    }

}
