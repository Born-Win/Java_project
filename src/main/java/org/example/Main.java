package org.example;

import org.example.controller.ProductController;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.example.validator.NumberValidator;
import org.example.validator.ResultValidator;
import org.example.view.Input;
import org.example.view.View;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        View view = new View();
        ResultValidator resultValidator = new ResultValidator();
        NumberValidator numberValidator = new NumberValidator();
        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductService(productRepository);
        Input input = new Input(view, new Scanner(System.in), numberValidator);

        ProductController controller = new ProductController(view, input, productService, resultValidator);
        controller.start();
    }
}