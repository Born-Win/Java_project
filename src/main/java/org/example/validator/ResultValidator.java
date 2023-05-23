package org.example.validator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.model.IndustrialProduct;

import java.util.List;
import java.util.Set;

public class ResultValidator {
    private static Logger logger = LogManager.getLogger(ResultValidator.class);

    public ResultValidator() {
        logger.debug("ResultValidator created");
    }

    public boolean validate(List<IndustrialProduct> products) {
        return products != null && !products.isEmpty();
    }

    public boolean validate(Set<String> products) {
        return products != null && !products.isEmpty();
    }
}
