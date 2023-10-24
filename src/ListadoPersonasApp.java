import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        //Definimos la lista fuera del ciclo while
        List<Persona> personas = personas = new ArrayList<>();
        //Empezamos con el menu
        var salir = false;
        while (!salir) {
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    //Funciones
    private static void mostrarMenu() {
        //Mostramos las opciones
        System.out.print("""
                *** Listado Personas App ***
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Proporciona una opcion: ");
    }
    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        //Revisamos la opcion proporcionada
        switch (opcion) {
            case 1 -> { //Agregar persona a la lista
                System.out.println("Proporciona el nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Proporciona el telefono: ");
                var tel = consola.nextLine();
                System.out.println("Proporciona el email: ");
                var email = consola.nextLine();
                //Crear el objeto Persona
                var persona = new Persona(nombre, tel, email);
                //Lo agregamos a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");
            }
            case 2 -> { //Listar las personas
                System.out.println("Listado de Personas: ");
                //Mejora usando lambda y metodo de referencia
                // Esta es una forma, la que sigue es mejor personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
            }
            case 3 -> { //Salir del ciclo
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion erronea: " + opcion + " , escoga una de estas opciones: 1, 2, 3");
        } //Fin switch
        return salir;
    }
}