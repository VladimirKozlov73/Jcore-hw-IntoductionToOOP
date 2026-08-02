package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount; // в процентах, от 0 до 100

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта должна быть строго больше 0");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно");
        }
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice * (100 - discount) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}