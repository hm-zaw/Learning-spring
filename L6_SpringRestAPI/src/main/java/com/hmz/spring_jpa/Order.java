package com.hmz.spring_jpa;

import lombok.Data;

@Data
public class Order {

    private String customerName;

    private String productName;

    private int quantity;

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
