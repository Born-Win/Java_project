package org.example.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.constants.Constants.DAY_TIME_FORMAT;

public class IndustrialProduct {
    private Long identificationNumber;
    private String name;
    private LocalDateTime releaseDate;
    private Model model;
    private Brand brand;
    private Long registrationNumber;
    private LocalDateTime manufactureData;


    public IndustrialProduct(Long identificationNumber,
                             String name, LocalDateTime releaseDate,
                             Model model, Brand brand,
                             Long registrationNumber,
                             LocalDateTime manufactureData) {
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.releaseDate = releaseDate;
        this.model = model;
        this.brand = brand;
        this.registrationNumber = registrationNumber;
        this.manufactureData = manufactureData;
    }

    public IndustrialProduct() {
    }

    public Long getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(Long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocalDateTime getManufactureData() {
        return manufactureData;
    }

    public void setManufactureData(LocalDateTime manufactureData) {
        this.manufactureData = manufactureData;
    }


    @Override
    public String toString() {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DAY_TIME_FORMAT);

        String formattedReleasedDateTime = releaseDate.format(formatter);
        String formattedManufactureDateTime = manufactureData.format(formatter);

        return String.format("|%10s |%52s |%17s |%16s |%13s |%19s |%17s |", identificationNumber, name, formattedReleasedDateTime, model.getModelName(), brand.getBrandName(), registrationNumber, formattedManufactureDateTime);
    }
}
