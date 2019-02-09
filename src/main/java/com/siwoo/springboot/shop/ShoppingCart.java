package com.siwoo.springboot.shop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    public List<Product> carts;

    public void addItem(Product product) {
        if (carts == null)
            carts = new ArrayList<>();
        carts.add(product);
    }

    public List<Product> getItems() {
        return new ArrayList<>(carts);
    }

}
