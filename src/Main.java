import pkgPizza.base.Pizza;
import pkgPizza.base.Topping;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        // Obteniendo los ingredientes de la clase Topping
//        List<Topping> ingredientes = Arrays.asList(Topping.toppings);

        // Creando lista de ingredientes para la pizza
        List<Topping> ingredientes = new ArrayList<>();
        ingredientes.add(new Topping("Pepperoni", 20));
        ingredientes.add(new Topping("Champiñones", 25));
        ingredientes.add(new Topping("Cebolla", 5));
        ingredientes.add(new Topping("Tomate", 15));
        ingredientes.add(new Topping("Chile", 10));
        ingredientes.add(new Topping("Aceitunas", 15));

        // Mostrando los ingredientes disponibles
        System.out.println("El valor de la pizza básica sin toppings es de Q50.0. \nSelecciona los toppings:");

        for (int i = 0; i < ingredientes.size(); i++) {
            System.out.println((i + 1) + ". " +
                    ingredientes.get(i).getIngredientName() + " (Q" + ingredientes.get(i).getPrice() + ")");
        }

        // Creando conjunto de ingredientes seleccionados
        // Utilizando Set y HashSet en lugar de List y ArrayList para evitar duplicados
        Set<Topping> chosenToppings = new HashSet<>();

        while (true) {
            try {
                System.out.print("Ingresa el número de topping que deseas (0 para finalizar): ");
                int seleccion = scanner.nextInt();
                scanner.nextLine();

                if (seleccion < 0 || seleccion > ingredientes.size()) {
                    System.out.println(">>> Seleccion inválida. Intente de nuevo.");
                    continue;
                }

                if (seleccion == 0) {
                    System.out.println(">>> Selección finalizada.");
                    break;
                }

                // Creando el topping seleccionado
                Topping selectedTopping = ingredientes.get(seleccion - 1);

                // Agregando el topping seleccionado al conjunto de toppings
                if (!chosenToppings.contains(selectedTopping)) {
                    chosenToppings.add(selectedTopping);
                    System.out.println(">>> El topping ha sido añadido.");
                } else {
                    System.out.println(">>> Topping ya seleccionado. Intente de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.out.println(">>> Acción inválida. Debes ingresar un número entero.");
                scanner.nextLine();
            }

        }

        // Creando la pizza
        String pizzaName = "";
        while (pizzaName.trim().isEmpty()) {
            System.out.println("\nIngresa el nombre de la pizza:");
            pizzaName = scanner.nextLine().trim();

            if (pizzaName.isEmpty()) {
                System.out.println(">>> El nombre de la pizza no puede estar vacío.");
            }
        }
        Pizza pizza1 = new Pizza(pizzaName, chosenToppings.toArray(new Topping[0]));

        // Mostrando la pizza creada
        System.out.println("\nHas creado una " + pizza1.getName() + " con los siguientes toppings:");
        pizza1.getToppingsList();
        System.out.println("Precio total: Q" + pizza1.getPrice());
        pizza1.prepare();

        scanner.close();
    }
}