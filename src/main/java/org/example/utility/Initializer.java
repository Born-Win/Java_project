package org.example.utility;

import org.example.model.Brand;
import org.example.model.Model;
import org.example.repository.implementation.ProductRepository;
import org.example.service.ProductService;
import org.example.validator.NumberValidator;
import org.example.validator.ResultValidator;
import org.example.view.Input;
import org.example.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Initializer {
    public static Map<Long, Brand> BRANDS = new HashMap<>() {{
        put(1L, new Brand(1L, "Adidas"));
        put(2L, new Brand(2L, "Puma"));
        put(3L, new Brand(3L, "IKEA"));
        put(4L, new Brand(4L, "LG"));
    }};

    public static Map<Long, Model> MODELS = new HashMap<Long, Model>() {{
        put(1L, new Model(1L, "Sneakers"));
        put(2L, new Model(2L, "Clothes"));
        put(3L, new Model(3L, "Furniture"));
        put(4L, new Model(4L, "Washing machines"));
    }};


    private static View view;

    public static View getCalculateView() {
        if (view == null) {
            view = new View();
        }
        return view;
    }

    private static Input input;

    public static Input getInputView() {
        if (input == null) {
            input = new Input(getCalculateView(), new Scanner(System.in), getNumberValidator());
        }
        return input;
    }

    private static ProductService productService;

    public static ProductService getProductService() {
        if (productService == null) {
            productService = new ProductService(getProductRepository());
        }
        return productService;
    }

    public static ResultValidator validator;

    public static ResultValidator getValidator() {
        if (validator == null) {
            validator = new ResultValidator();
        }
        return validator;
    }

    public static NumberValidator numberValidator;

    public static NumberValidator getNumberValidator() {
        if (numberValidator == null) {
            numberValidator = new NumberValidator();
        }
        return numberValidator;
    }

    private static ProductRepository productRepository;

    public static ProductRepository getProductRepository() {
        if (productRepository == null) {
            productRepository = new ProductRepository();
        }
        return productRepository;
    }

}
