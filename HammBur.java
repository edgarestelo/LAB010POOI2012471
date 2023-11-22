package hammbur;
import java.util.*;

public class HammBur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, HashMap<String, Double>> menu = new HashMap<>();

        
        menu.put("Pizza", createPizzaMenu());
        menu.put("Burguer", createBurguerMenu());
        menu.put("Sandwich", createSandwichMenu());
        menu.put("Extras", createExtrasMenu());
        menu.put("Bebidas", createDrinksMenu());

        ArrayList<HashMap<String, Integer>> pedidos = new ArrayList<>();

        boolean hacerPedido = true;
        while (hacerPedido) {
            mostrarMenu(menu);

            System.out.println("\nIngrese la categoría del pedido:");
            String categoria = scanner.nextLine();

            if (menu.containsKey(categoria)) {
                System.out.println("Opciones disponibles y sus precios:");
                mostrarOpciones(menu.get(categoria));

                System.out.println("\nIngrese el pedido:");
                String pedido = scanner.nextLine();

                System.out.println("Ingrese la cantidad:");
                int cantidad = scanner.nextInt();
                scanner.nextLine(); 

                HashMap<String, Integer> itemPedido = new HashMap<>();
                itemPedido.put(pedido, cantidad);

            
                if (categoria.equals("Extras")) {
                    System.out.println("Ingrese los extras separados por coma (si no hay, presione Enter):");
                    String extras = scanner.nextLine();
                    if (!extras.isEmpty()) {
                        String[] extrasArray = extras.split(", ");
                        for (String extra : extrasArray) {
                            if (menu.get(categoria).containsKey(extra)) {
                                itemPedido.put(extra, 1); // Agregar el extra al pedido
                            }
                        }
                    }
                }

               
                pedidos.add(itemPedido);

                System.out.println("¿Desea hacer otro pedido? (s/n):");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("n")) {
                    hacerPedido = false;
                }
            } else {
                System.out.println("Categoría inválida. Por favor, ingrese una categoría válida.");
            }
        }

      
        System.out.println("\nResumen de pedidos:");
        for (HashMap<String, Integer> pedido : pedidos) {
            for (Map.Entry<String, Integer> entry : pedido.entrySet()) {
                System.out.println(entry.getKey() + " - Cantidad: " + entry.getValue());
            }
        }
    }

    // Métodos para crear el menú de cada categoría con sus respectivos precios
    public static HashMap<String, Double> createPizzaMenu() {
        HashMap<String, Double> pizzaMenu = new HashMap<>();
        pizzaMenu.put("Pizza Americana", 13.00);
        pizzaMenu.put("Pizza Pepperoni", 16.00);
        
        return pizzaMenu;
    }

    public static HashMap<String, Double> createBurguerMenu() {
        HashMap<String, Double> burguerMenu = new HashMap<>();
        burguerMenu.put("Hamburguesa Simple de carne", 10.00);
        burguerMenu.put("Hamburguesa royal de carne", 30.00);
        
        return burguerMenu;
    }

    public static HashMap<String, Double> createSandwichMenu() {
        HashMap<String, Double> sandwichMenu = new HashMap<>();
        sandwichMenu.put("Sandwich de Pollo", 7.99);
        sandwichMenu.put("Sandwich de Carne", 9.99);
        // Agregar más opciones de sandwiches según sea necesario
        return sandwichMenu;
    }

    public static HashMap<String, Double> createExtrasMenu() {
        HashMap<String, Double> extrasMenu = new HashMap<>();
        extrasMenu.put("Huevo", 5.00);
        extrasMenu.put("Plátano", 5.00);
        extrasMenu.put("Chorizo", 5.00);
        // Agregar más opciones de extras según sea necesario
        return extrasMenu;
    }

    public static HashMap<String, Double> createDrinksMenu() {
        HashMap<String, Double> drinksMenu = new HashMap<>();
        drinksMenu.put("Coca Cola", 1.99);
        drinksMenu.put("Inka Cola", 1.99);
        drinksMenu.put("Sprite", 1.99);
        drinksMenu.put("Chicha Morada", 2.50);
        // Agregar más opciones de bebidas según sea necesario
        return drinksMenu;
    }

    // Métodos para mostrar el menú y opciones disponibles
    public static void mostrarMenu(HashMap<String, HashMap<String, Double>> menu) {
        System.out.println("==== Menú HammBur ====");
        for (String categoria : menu.keySet()) {
            System.out.println("- " + categoria);
        }
    }

    public static void mostrarOpciones(HashMap<String, Double> opciones) {
        for (Map.Entry<String, Double> entry : opciones.entrySet()) {
            System.out.println(entry.getKey() + " - Precio: $" + entry.getValue());
        }
    }
} 


