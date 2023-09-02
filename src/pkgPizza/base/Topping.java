package pkgPizza.base;

public class Topping {
    private String ingredientName;
    private double price;

    // Constructor
    public Topping(String ingredientName, double price) {
        this.ingredientName = ingredientName;
        this.price = price;
    }

//    // Creando lista de ingredientes para la pizza
//    public static Topping[] toppings = {
//        new Topping("Pepperoni", 20),
//        new Topping("Champiñones", 25),
//        new Topping("Cebolla", 5),
//        new Topping("Tomate", 15),
//        new Topping("Chile", 10),
//        new Topping("Aceitunas", 15)
//    };

    // Getters & Setters
    public String getIngredientName() {
        return ingredientName;
    }
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ingredientName;
    }
}
