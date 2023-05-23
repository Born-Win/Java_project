package org.example.repository.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.model.IndustrialProduct;
import org.example.repository.IProductRepository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.example.constants.Constants.STORAGE_FILE_NAME;
import static org.example.utility.FilePathManager.getFilePath;

public class ProductRepository implements IProductRepository {

    private static Logger logger = LogManager.getLogger(ProductRepository.class);
    private ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule())
            .registerModule(new ParameterNamesModule());

    @Override
    public List<IndustrialProduct> getProducts() {
        String productJSON;
        List<IndustrialProduct> products = new LinkedList<>();

        try {
            productJSON = new String(Files.readAllBytes(Paths.get(getFilePath(STORAGE_FILE_NAME))), StandardCharsets.UTF_8);
            products = Arrays.asList(objectMapper.readValue(productJSON, IndustrialProduct[].class));
            logger.info("All products obtained from shop");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return products;
    }

    @Override
    public List<IndustrialProduct> saveProducts(List<IndustrialProduct> products, String fileName) {
        String filePath = getFilePath(fileName);

        try {
            objectMapper.writeValue(new File(filePath), products);
        } catch (IOException e) {
            logger.warn("Not saved the result " + e.getMessage());
            return new LinkedList<>();
        }
        logger.info("Result was saved to file: " + filePath);

        return products;
    }
}
