package org.example.model;

public class Model {
    private Long modelId;
    private String modelName;

    public Model(Long modelId, String modelName) {
        this.modelId = modelId;
        this.modelName = modelName;
    }

    public Model() {
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "Model{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
