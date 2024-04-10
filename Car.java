package KTGK;

import java.io.Serializable;

public class Car implements ICar, Serializable {
    private static final long serialVersionUID = -6500665823330706018L;
    private int id;
    private String brand;
    private String publishYear;
    private String price;
    private String color;
    private CarType carType;

    public Car(int id, String brand, String publishYear, String price, String color, CarType carType) {
        this.id = id;
        this.brand = brand;
        this.publishYear = publishYear;
        this.price = price;
        this.color = color;
        this.carType = carType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Hang san xuat: " + brand);
        System.out.println("Nam san xuat: " + publishYear);
        System.out.println("Gia ban: " + price);
        System.out.println("Mau xe: " + color);
        System.out.println("Kieu xe: " + carType);
    }
}