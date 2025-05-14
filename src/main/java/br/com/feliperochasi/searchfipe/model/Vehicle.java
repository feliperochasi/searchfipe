package br.com.feliperochasi.searchfipe.model;

public class Vehicle {
    private String price;
    private String brand;
    private String model;
    private Integer yearModel;
    private String fuel;

    public Vehicle(String price, String brand, String model, String yearModel, String fuel) {
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.yearModel = Integer.valueOf(yearModel);
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "Veiculo " +
                "preco= " + price +
                ", marca= " + brand +
                ", modelo= " + model +
                ", ano= " + yearModel +
                ", combustivel= " + fuel;
    }
}
