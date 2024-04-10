package KTGK;

public class XeTai extends Car {
    private String loadWeight;

    public XeTai(int id, String brand, String publishYear, String price, String color, CarType carType, String loadWeight) {
        super(id, brand, publishYear, price, color, carType);
        this.loadWeight = loadWeight;
    }

    public String getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(String loadWeight) {
        this.loadWeight = loadWeight;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Trong tai: " + loadWeight);
    }
}
