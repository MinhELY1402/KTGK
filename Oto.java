package KTGK;

public class Oto extends Car {
    private int slots;
    private String engineType;

    public Oto(int id, String brand, String publishYear, String price, String color, CarType carType, int slots, String engineType) {
        super(id, brand, publishYear, price, color, carType);
        this.slots = slots;
        this.engineType = engineType;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("So cho ngoi: " + slots);
        System.out.println("Kieu dong co: " + engineType);
    }
}
