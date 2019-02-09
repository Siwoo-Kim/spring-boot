package com.siwoo.springboot.shop;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString(callSuper = true)
public class Disc extends Product {
    private int capacity;
    private double discount = 0.0D;

    public Disc() {
    }

    public Disc(String name, double price) {
        super(name, price);
    }

    public Disc(String name, double price, double discount) {
        super(name, price);
        this.discount = discount;
    }

}
