package org.example.constants;

import org.example.model.Brand;
import org.example.model.Model;

import java.util.HashMap;
import java.util.Map;

public interface Constants {

    String STORAGE_FILE_NAME = "storage.json";

    String INPUT_NOT_A_NUMBER_ERROR_MESSAGE = "Input is not a number. Please, provide number.";

    String DAY_TIME_FORMAT = "yyyy-MM-dd HH:mm";


    Map<Long, Brand> BRANDS = new HashMap<>() {{
        put(1L, new Brand(1L, "Adidas"));
        put(2L, new Brand(2L, "Puma"));
        put(3L, new Brand(3L, "IKEA"));
        put(4L, new Brand(4L, "LG"));
    }};

    Map<Long, Model> MODELS = new HashMap<Long, Model>() {{
        put(1L, new Model(1L, "Sneakers"));
        put(2L, new Model(2L, "Clothes"));
        put(3L, new Model(3L, "Furniture"));
        put(4L, new Model(4L, "Washing machines"));
    }};
}
