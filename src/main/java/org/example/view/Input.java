package org.example.view;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.exception.WrongNumberException;
import org.example.model.Brand;
import org.example.model.Model;
import org.example.validator.NumberValidator;

import java.util.Scanner;

import static org.example.constants.Constants.*;
import static org.example.utility.Initializer.BRANDS;
import static org.example.utility.Initializer.MODELS;


public class Input {

    private static Logger logger = LogManager.getLogger(Input.class);
    private Scanner scanner;
    private View view;
    private NumberValidator numberValidator;


    public Input(View view, Scanner scanner, NumberValidator numberValidator) {
        this.scanner = scanner;
        this.view = view;
        this.numberValidator = numberValidator;
    }

    public int readUserChoiceFromConsole(int minValue, int maxValue) {
        int number = 0;
        while (true) {
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                numberValidator.validate(number, minValue, maxValue);
                return number;
            } catch (WrongNumberException wrongNumberException) {
                view.printMessage(wrongNumberException.getMessage());
                logger.info("User chose not appropriate option. Message: " + wrongNumberException.getMessage());
            } catch (Exception e) {
                view.printMessage(INPUT_NOT_A_NUMBER_ERROR_MESSAGE);
                scanner.nextLine();
                logger.info("User input exception. Retrying to receive result");
            }
        }
    }


    public Brand readBrandFromConsole() {
        view.printBrandsToConsole();
        int userChoice = readUserChoiceFromConsole(1, BRANDS.size());
        logger.info("User successfully chose station");

        return BRANDS.get((long) userChoice);
    }

    public Model readModelFromConsole() {
        view.printModelsToConsole();
        int userChoice = readUserChoiceFromConsole(1, MODELS.size());
        logger.info("User successfully chose station");

        return MODELS.get((long) userChoice);
    }

    public String readFileNameFromConsole() {
        view.askForSaveFile();
        String result = scanner.nextLine();
        return result;
    }
}
