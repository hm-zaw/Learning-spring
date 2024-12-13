package com.hmz.spring_jpa;

public record ProductRecord(
        String productName,

        String originCountry,

        boolean isAvailable) {
}
