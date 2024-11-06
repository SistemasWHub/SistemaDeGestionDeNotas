import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>(); //  declaramos la lista de estudiantes
    private static Scanner scanner = new Scanner(System.in); // declaramos el scanner y estático porque queremos evitar tener multiples instancias de scanner y crear problemas

    public static void main(String[] args) { // Método Main
        int opcion = 0; // Declaramos e inicializamos la variable que nos guardará la elección del usuario en el menú
        
        do { // Como queremos que minimo se inicie el menú una vez, usaremos un ciclo do-while
            System.out.println("\nBienvenido al sistema de Notas y Estudiantes.");
            System.out.println("1. Agregar un estudiante.");
            System.out.println("2. Eliminar un estudiante.");
            System.out.println("3. Mostrar lista de estudiantes.");
            System.out.println("4. Calcular promedio.");
            System.out.println("5. Ordenar estudiantes.");
            System.out.println("6. Buscar un estudiante.");
            System.out.println("7. Salir del programa.");
            System.out.print("Seleccione una opción: ");
            
            String input = scanner.nextLine(); // 
            
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                continue;
            }
            
            switch(opcion) { // Menú 
                case 1:
                    agregarEstudiante(); // Caso para agregar un estudiante
                    break;
                case 2:
                    eliminarEstudiante(); // Caso para eliminar un estudiante
                    break;
                case 3:
                    mostrarEstudiantes(); // Caso para mostrar un estudiante
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del estudiante para calcular su promedio: "); //  Caso para calcular promedio

                    String nombreEstudiante = scanner.nextLine(); // Declaracion e inicialización de la variable que guardará el nombre del estudiante
                    Estudiante estudiante = buscarEstudiante(nombreEstudiante); //  Buscamos el estudiante en la lista de estudiantes llamando a la función buscarEstudiante
                    if (estudiante != null) {  // Si el estudiante existe en la lista
                        double promedio = estudiante.calcularPromedioAcumulado(); // Declaracion e inicicializacion de la variable promedio (llamamos a la función calcularPromedioAcumulado)
                        System.out.println("El promedio de " + nombreEstudiante + " es: " + promedio);
                    } else {
                        System.out.println("Estudiante no encontrado."); // En caso de que el estudiante no exista en la lista 
                    }
                    break;
                case 5:  // Caso para decidir si ordenarlos por nombre o por promedio 
                    System.out.println("Elija una opción: ");
                    System.out.println("1. Ordenar por nombre ");
                    System.out.println("2. Ordenar por promedio ");
                    String eleccionOrdenInput = scanner.nextLine(); // 
                    try {  // 
                        int eleccionOrden = Integer.parseInt(eleccionOrdenInput);
                        if (eleccionOrden == 1) { // podríamos hacer un switch para que el usuario elija la opción de ordenar por nombre o por promedio, pero son solo dos opciones, así que se usa un condicional
                            ordenarPorNombre(); // Llamamos a la función ordenar por nombre 
                        } else if (eleccionOrden == 2) { // Si el usuario elige la opción de ordenar por promedio
                            ordenarPorPromedio(); // Llamamos a la función que ordena en base al promedio 
                        } else {
                            System.out.println("Opción no válida"); // En caso de que la opción ingresada no sea válida
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Se requiere un número.");  // En caso de que el usuario ingrese algo que no sea un número (control de errores)

                    }
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del estudiante a buscar: "); //  Caso para buscar un estudiante

                    String nombreBuscar = scanner.nextLine(); //  Declaracion e inicialización de la variable que guardará el nombre del estudiante a buscar
                    Estudiante estudianteBuscado = buscarEstudiante(nombreBuscar);
                    if (estudianteBuscado != null) { // Condicional para ver si el estudiante es encontrado 
                        System.out.println(estudianteBuscado);
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 7:
                    System.out.println("Gracias por utilizar el sistema.");  // Caso para cerrar el sistema

                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo."); // En caso de que no sea opcion válida
            }
        } while (opcion != 7);
        
        scanner.close(); // Cerrar el scanner al finalizar el programa
    }

    public static void agregarEstudiante() { //  Método para agregar un estudiante a la lista
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese el ID del estudiante: ");
        String id = scanner.nextLine();
        
        Estudiante estudiante = new Estudiante(nombre, id); //  Crear un objeto de tipo estudiante con los datos ingresados por el usuario
        estudiantes.add(estudiante); //  Agregar el estudiante a la lista de estudiantes
        
        String nombreMateria;
        do {  //  Ciclo para agregar las materias del estudiante, minimo que agregue una materia
            System.out.print("Ingrese el nombre de la materia ('terminar' para finalizar): ");
            nombreMateria = scanner.nextLine();

            if (!nombreMateria.equalsIgnoreCase("terminar")) { // condicional para  ver si el usuario quiere agregar otra materia
                System.out.print("Ingrese el código de la materia: ");
                String codigoMateria = scanner.nextLine(); // Declaración e inicializacion  de la variable que guardará el código de la materia
                
                System.out.print("Ingrese el semestre de la materia: ");
                int semestre = Integer.parseInt(scanner.nextLine()); // Por si de pronto se da una excepcion 
    
                double nota;
            do { //  Ciclo para agregar materias

                System.out.print("Ingrese la nota del estudiante en la materia (0.0 - 5.0): ");
                nota = Double.parseDouble(scanner.nextLine());
                
                if (nota < 0 || nota > 5) { // Condicional para ver si la nota esta dentro del rango
                    System.out.println("Nota fuera de rango. Intente nuevamente.");
                }
            } while (nota < 0 || nota > 5); // Repite hasta que la nota esté en el rango 
                Materia materia = new Materia(nombreMateria, codigoMateria, semestre, nota);
                estudiante.agregarMateria(materia);
                System.out.println("¡Materia agregada con éxito!");
            }
        } while (!nombreMateria.equalsIgnoreCase("terminar"));  // Repite hasta que el usuario quiera terminar de agregar materias
        System.out.println("Estudiante agregado con éxito.");
    }

    public static void eliminarEstudiante() { //  Método para eliminar un estudiante de la lista

        System.out.print("Ingrese el ID del estudiante a eliminar: ");
        String id = scanner.nextLine();
        
        for (int i = 0; i < estudiantes.size(); i++) {  // Ciclo para buscar el estudiante a eliminar
            if (estudiantes.get(i).getId().equals(id)) {
                estudiantes.remove(i);
                System.out.println("Estudiante eliminado con éxito.");
                return;
            }
        }
        System.out.println("Estudiante no encontrado."); // Si no se encuentra  el estudiante

    }

    public static void mostrarEstudiantes() {   // Método para mostrar todos los estudiantes de la lista

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes aún para mostrar. Ingrese un estudiante"); // Si la lista está vacía
        } else {
            for (Estudiante estudiante : estudiantes) { // ciclo para recorrer la lista de estudiantes
                System.out.println(estudiante);
                for (Materia materia : estudiante.getMaterias()) {
                    System.out.println("  " + materia.getNombreMateria() + " - Nota: " + materia.getNota()); // Mostrar los estudiantes
                }
            }
        }
    }

    public static void ordenarPorNombre() { // Método para ordenar a los estudiantes por nombre
        estudiantes.sort(Comparator.comparing(Estudiante::getNombre));
        System.out.println("Estudiantes ordenados por nombre.");
    }

    public static void ordenarPorPromedio() { //  Método para ordenar a los estudiantes por promedio
        estudiantes.sort(Comparator.comparingDouble(Estudiante::calcularPromedioAcumulado).reversed());
        System.out.println("Estudiantes ordenados por promedio.");
    }

    public static Estudiante buscarEstudiante(String nombre) { //  Método para buscar un estudiante por nombre
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equals(nombre)) {
                return estudiante;
            }
        }
        return null; //  Si no se encuentra el estudiante, devuelve null, indicando que no existe. 
    }
}
/* Nota:
 * Usamos null como valor por defecto para que el código pueda ser reutilizado en un futuro, o más especificamente, el método.
 */