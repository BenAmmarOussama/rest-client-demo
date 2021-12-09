package org.eniso.oussama.models;

public class Equipment {

    private long id;
    private String title;
    private int quantity;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Equipment(String title) {
        this.title = title;
    }

    public Equipment(long id, String title, int quantity, String description) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.description = description;
    }
}
