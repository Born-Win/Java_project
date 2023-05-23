package org.example.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.model.IndustrialProduct;
import org.example.repository.ProductRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.utility.FilePathManager.getFilePath;

public class ProductService {
    private Logger logger = LogManager.getLogger(ProductService.class);
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
        logger.debug("ProductService created");
    }

    public List<IndustrialProduct> findProductsByBrand(Long id) {
        return repository.getProducts().stream().filter(x -> x.getBrand().getBrandId().equals(id)).collect(Collectors.toList());
    }

    public Set<String> findProductsByModel(Long id) {
        return repository.getProducts().stream().filter(x -> x.getModel().getModelId().equals(id)).flatMap(x -> Stream.of(x.getBrand().getBrandName())).collect(Collectors.toSet());
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

    public String saveProductsToFile(Set<String> products, String fileName) {
        if (!fileName.isEmpty()) {
            repository.saveProducts(products, fileName + ".json");
            logger.info("result was saved");
            return "saved to file: " + getFilePath(fileName + ".json");
        }
        logger.info("result was not saved, because of user option");
        return "return result was not saved";
    }

}
