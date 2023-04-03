import java.io.Serializable;

public class Products implements Serializable {
    private  int id;
    private String name;
    private String  manufacturer;
    private double price;


    public Products() {
    }

    public Products(int id, String name,  double price, String manufacturer ){
        this.id = id;
        this.name = name;
        this.manufacturer= manufacturer;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Products[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ']';
    }

    public void add(Products products) {
    }
}
