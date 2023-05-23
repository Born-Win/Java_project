package org.example.validator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.exception.WrongNumberException;

public class NumberValidator {
    private static Logger logger = LogManager.getLogger(NumberValidator.class);

    public int validate(int number, int minValue, int maxValue) throws WrongNumberException {
        if (number >= minValue && number <= maxValue) {
            logger.info("User chose option %d".formatted(number));
            return number;
        } else {
            throw new WrongNumberException(minValue, maxValue);
        }
    }
}
