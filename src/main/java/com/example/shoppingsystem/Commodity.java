package com.example.shoppingsystem;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class Commodity {
    public String type;
    public double price , ratio;
    public String brand , title;
    public Image image;
    public Label Properties;
    public int number;

    public Commodity() {
    }

    public Commodity(String type, double price, double ratio, String brand, String title, int number) {
        this.type = type;
        this.price = price;
        this.ratio = ratio;
        this.brand = brand;
        this.title = title;
        this.number = number;
    }

    public Commodity(String type, double price, double ratio, String brand, String title) {
        this.type = type;
        this.price = price;
        this.ratio = ratio;
        this.brand = brand;
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Label getProperties() {
        return Properties;
    }

    public void setProperties(Label properties) {
        Properties = properties;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", ratio=" + ratio +
                ", brand='" + brand + '\'' +
                ", title='" + title + '\'' +
                ", image=" + image +
                ", Properties=" + Properties +
                ", number=" + number +
                '}';
    }

}
