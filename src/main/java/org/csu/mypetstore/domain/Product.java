package org.csu.mypetstore.domain;

public class Product {
    private String productId;
    private String categoryId;
    private String name;
    private String description;
    private String descriptionIamge;
    private String descriptionText;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionIamge() {
        return descriptionIamge;
    }

    public void setDescriptionIamge(String descriptionIamge) {
        this.descriptionIamge = descriptionIamge;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }
}
