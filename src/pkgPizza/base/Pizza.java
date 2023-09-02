package pkgPizza.base;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private double price = 50;
    private List<Topping> toppings = new ArrayList<>();

    // Constructor
    public Pizza(String name, Topping... toppings) {
        this.name = name;
        // Agregando los toppings y sumando el precio
        for (Topping top : toppings) {
            this.price += top.getPrice();
            this.toppings.add(top);
        }
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public void removeTopping(int index) {
        this.toppings.remove(index);
    }

    @Override
    public String toString() {
        return "Pizza: {"+ name + ", Precio =" + price + "}";
    }

    // Getters & Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public double setPrice(double price) {
        return this.price = price;
    }
    public List<Topping> getToppings() {
        return toppings;
    }
    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public void getToppingsList() {
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println((i + 1) + ". " +
                    toppings.get(i).getIngredientName() + " (Q" + toppings.get(i).getPrice() + ")");
        }
    }

    // Preparando la pizza
    public void prepare() {
        System.out.println("Preparando la pizza...");
        try {
            // Pausa de 3 segundos (3000 milisegundos)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("La pizza está lista.");
    }
}
