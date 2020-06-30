package com.geekbrains.geekmarketwinter.entites;

public class Message {
    private Long id;
    private Long quantity;
    private Double cost;
    private Double totalCost;
    private String message;

    public Message(Long id, Long quantity, Double cost, Double totalCost) {
        this.id = id;
        this.quantity = quantity;
        this.cost = cost;
        this.totalCost = totalCost;
    }
    public Message(String message) {
        this.message = message;
    }
    public Long getId() {
        return id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Double getCost() {
        return cost;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
