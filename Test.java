package KTGK;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

import static KTGK.Car.*;

public class Test {
    public static void writeCarsToFile(List<Car> cars, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(cars);
            System.out.println("Cars have been written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> readCarsFromFile(String fileName) {
        List<Car> cars = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            cars = (List<Car>) ois.readObject();
            System.out.println("Cars have been read from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public static Oto inputOto(Scanner scanner) {
        System.out.println("Enter ID:");
        int ID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Brand:");
        String brand = scanner.nextLine();
        System.out.println("Enter publishYear:");
        String publishYear = scanner.nextLine();
        System.out.println("Enter price:");
        String price = scanner.nextLine();
        System.out.println("Enter color:");
        String color = scanner.nextLine();
        System.out.println("Enter slots:");
        int slots = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter engineType:");
        String engineType = scanner.nextLine();

        return new Oto(ID, brand, publishYear, price, color, CarType.OTO, slots, engineType);
    }

    public static XeMay inputxemay(Scanner scanner) {
        System.out.println("Enter ID:");
        int ID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Brand:");
        String brand = scanner.nextLine();
        System.out.println("Enter publishYear:");
        String publishYear = scanner.nextLine();
        System.out.println("Enter price:");
        String price = scanner.nextLine();
        System.out.println("Enter color:");
        String color = scanner.nextLine();
        System.out.println("Enter capacity:");
        String capacity = scanner.nextLine();

        return new XeMay(ID, brand, publishYear, price, color, CarType.XEMAY, capacity);
    }

    public static XeTai inputxetai(Scanner scanner) {
        System.out.println("Enter ID:");
        int ID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Brand:");
        String brand = scanner.nextLine();
        System.out.println("Enter publishYear:");
        String publishYear = scanner.nextLine();
        System.out.println("Enter price:");
        String price = scanner.nextLine();
        System.out.println("Enter color:");
        String color = scanner.nextLine();
        System.out.println("Enter loadWeight:");
        String loadWeight = scanner.nextLine();

        return new XeTai(ID, brand, publishYear, price, color, CarType.XETAI, loadWeight);
    }

    public static void main(String[] args) {
        // Example usage:
        List<Car> cars = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean ktra = true;
        while (ktra) {
            System.out.println("Choose what you need:");
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. File");
            System.out.println("6. Leave");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 6:
                    ktra = false;
                    break;
                case 1: {
                    System.out.println("Choose the type of car to input:");
                    System.out.println("1. Xe oto");
                    System.out.println("2. Xe may");
                    System.out.println("3. Xe tai");
                    System.out.println("4. Exit");

                    System.out.print("Your choice: ");
                    int choicecar = scanner.nextInt();
                    scanner.nextLine();
                    switch (choicecar) {
                        case 1: {
                            System.out.println("Enter information for Oto:");
                            cars.add(inputOto(scanner));
                            break;
                        }
                        case 2: {
                            System.out.println("Enter information for Xe May:");
                            cars.add(inputxemay(scanner));
                            break;
                        }
                        case 3: {
                            System.out.println("Enter information for Xe Tai:");
                            cars.add(inputxetai(scanner));
                            break;
                        }
                        case 4:
                            break;
                    }
                    break;
                }
                case 2: {
                    System.out.println("Nhap id can tim:");
                    int id = scanner.nextInt();
                    for (int i = 0; i < cars.size(); i++) {
                        cars.forEach(car -> {
                            if (car.getId()==id)
                                car.showInfo();
                        });
                    }
                    break;
                }
                case 3: {
                    System.out.println("Nhap id can update:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < cars.size(); i++) {
                        int finalI = i;
                        cars.forEach(car -> {
                            if (car.getId()==id && car.getCarType()==CarType.OTO)
                                cars.set(finalI,inputOto(scanner));
                            if (car.getId()==id && car.getCarType()==CarType.XEMAY)
                                cars.set(finalI,inputxemay(scanner));
                            if (car.getId()==id && car.getCarType()==CarType.XETAI)
                                cars.set(finalI,inputxetai(scanner));
                        });
                    }
                    break;
                }
                case 4: {
                    System.out.println("Nhap id can delete:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < cars.size(); i++) {
                        int finalI = i;
                        cars.forEach(car -> {
                            if (car.getId()==id)
                                cars.remove(finalI);
                        });
                    }
                    break;
                }
                case 5: {
                    System.out.println("Choose you need:");
                    System.out.println("1. Write file");
                    System.out.println("2. Read file");
                    System.out.println("3. Exit");

                    System.out.print("Your choice: ");
                    int choicefile = scanner.nextInt();
                    scanner.nextLine();
                    switch (choicefile) {
                        case 1: {
                            writeCarsToFile(cars, "cars.txt");
                        }
                        case 2: {
                            List<Car> carsFromFile = readCarsFromFile("cars.txt");

                            // Display employees read from file
                            for (Car car : carsFromFile) {
                                car.showInfo();
                            }
                        }
                        case 3: {
                            break;
                        }
                    }
                }
            }
        }
    }
}
