package com.example.angeliv.sis;

/**
 * Created by AngeLiv on 05/08/2018.
 */

public class Product {
    private int id;
    private String title, shortdesc;
    private double rating;
    private String price;
    private int image;

    public Product(int id, String title, String shortdesc, double rating, String price, int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getRating() {
        return rating;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
