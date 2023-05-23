package org.example.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.model.Brand;
import org.example.model.IndustrialProduct;
import org.example.model.Model;
import org.example.service.ProductService;
import org.example.view.View;
import org.example.view.Input;
import org.example.validator.ResultValidator;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;



public class ProductController implements Runnable{

    private static Logger logger = LogManager.getLogger(ProductController.class);

    private Thread productController;

    private final AtomicBoolean running = new AtomicBoolean(false);

    private View view;
    private Input input;

    private ProductService productService;
    private ResultValidator validator;

    public ProductController(View view,
                             Input input,
                             ProductService productService,
                             ResultValidator validator) {
        this.view = view;
        this.input = input;
        this.productService = productService;
        this.validator = validator;
        logger.debug("ProductController created");
    }

    @Override
    public void run() {
        running.set(true);

        int userChoice;
        List<IndustrialProduct> result;
        Brand brand;
        Model model;

        view.printGreetingMessage();
        view.printProductsToConsole(productService.findAllProducts());
        logger.info("Showed all products");

        while(running.get()){
            view.printMainMenu();
            userChoice = input.readUserChoiceFromConsole(1, 3);

            switch(userChoice){
                case 1:
                    brand = input.readBrandFromConsole();
                    result = productService.findProductsByBrand(brand.getBrandId());
                    processResult(result);
                    break;
                case 2:
                    model = input.readModelFromConsole();
                    result = productService.findProductsByModel(model.getModelId());
                    processResult(result);
                    break;
                default:
                    stop();
                    break;
            }
        }
    }

    public void start(){
        productController = new Thread(this);
        productController.start();
        logger.debug("ProductController created");
    }

    public void stop(){
        running.set(false);
        logger.debug("Application is shutting down");
    }

    public void processResult(List<IndustrialProduct> result){
        if (validator.validate(result)) {
            view.printProductsToConsole(result);
            String fileNameFromConsole = input.readFileNameFromConsole();
            String saved = productService.saveProductsToFile(result, fileNameFromConsole);
            view.printMessage(saved);
        } else {
            view.printResultNotFound();
        }
    }
}
