package org.example;

import org.example.controller.ProductController;

import static org.example.utility.Initializer.*;

public class Main {
    public static void main(String[] args) {
        ProductController controller = new ProductController(getCalculateView(), getInputView(), getProductService(), getValidator());
        controller.start();
    }
}