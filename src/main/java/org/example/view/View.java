package org.example.view;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.model.Brand;
import org.example.model.IndustrialProduct;
import org.example.model.Model;

import java.util.List;
import java.util.Set;

import static org.example.constants.Constants.BRANDS;
import static org.example.constants.Constants.MODELS;

public class View {

    private static Logger logger = LogManager.getLogger(View.class);

    public static final String PRODUCTS_BY_BRAND = "1. Get products by brand";
    public static final String PRODUCTS_BY_MODEL = "2. Get products by model";
    public static final String EXIT = "3. EXIT";

    public static final String ASK_INPUT_FILE_NAME = "\nPlease, enter file name if you want to save this information or press enter";

    public static final String EMPTY_RESULT = "Sorry, but there is not suitable product by this search. Try again with other request";


    public void printGreetingMessage() {
        System.out.println("All products: ");
    }

    public void printMainMenu() {
        System.out.println("\n Input a number to select an action: ");
        System.out.println(PRODUCTS_BY_BRAND);
        System.out.println(PRODUCTS_BY_MODEL);
        System.out.println(EXIT);
        logger.info("Showed main menu");

    }

    public void printProductsToConsole(List<IndustrialProduct> products) {
        System.out.println("\n" + String.format("|%10s |%52s |%17s |%16s |%13s |%19s |%17s |",
                "product id",
                "product name",
                "release date",
                "model", "brand",
                "registration number",
                "manufacture date"));
        System.out.println("-".repeat(159));

        products.forEach(System.out::println);
    }
    public void printBrandsToConsole(Set<String> brandNames){
        System.out.println("Brands: ");
        brandNames.forEach(System.out::println);
    }

    public void printBrandsToConsole() {
        System.out.println("\n Choose brand number: \n");
        System.out.println(String.format("|%7s |%6s |", "number", "name"));
        System.out.println("-".repeat(18));

        for (Brand brand : BRANDS.values()) {
            System.out.println(String.format("|%7s |%6s |", brand.getBrandId(), brand.getBrandName()));
        }
        logger.info("Showed all brands");
    }

    public void printModelsToConsole() {
        System.out.println("\n Choose model number: \n");
        System.out.println(String.format("|%7s |%16s |", "number", "name"));
        System.out.println("-".repeat(28));

        for (Model model : MODELS.values()) {
            System.out.println(String.format("|%7s |%16s |", model.getModelId(), model.getModelName()));
        }
        logger.info("Showed all models");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }


    public void printResultNotFound() {
        System.out.println(EMPTY_RESULT);
    }

    public void askForSaveFile() {
        System.out.println(ASK_INPUT_FILE_NAME);
    }
}
