package KTGK;

public class XeMay extends Car {
    private String capacity;

    public XeMay(int id, String brand, String publishYear, String price, String color, CarType carType, String capacity) {
        super(id, brand, publishYear, price, color, carType);
        this.capacity = capacity;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Cong suat: " + capacity);
    }
}
