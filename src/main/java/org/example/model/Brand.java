package org.example.model;

public class Brand {
    private Long brandId;
    private String brandName;

    public Brand(Long brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    public Brand() {
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
