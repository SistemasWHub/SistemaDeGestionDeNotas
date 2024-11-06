import java.util.ArrayList; // Importación de un ArrayList
import java.util.List;  // Importación de una lista

public class Estudiante { //Crear la clase estudiante 
    
    // añadir los atributos a la clase
    private String nombre;
    private String id;
    private List<Materia> materias; // Se emplea list como buena practica de programación para tener un código más flexible

    private double promedioAcumulado = 0.0;

    public Estudiante (String nombre, String id){  //Constructor para iniciar las variables
       this.nombre = nombre;
       this.id = id; 
       this.materias = new ArrayList<>(); // Inicializar el ArrayList de materias
    }

    // Métodos get y set de los atributos

    public String getNombre (){ // Para obtener el nombre del estudiante
        return nombre;
    }
    public void setNombre(String nombre){ // Método para cambiar el nombre  del estudiante
        this.nombre = nombre;
    }
    public String getId(){ // Método para obtener el id del estudiante
        return id;
    }
    public void setId(String id){ // Método para cambiar el id del estudiante
        this.id = id;
    }
    public List<Materia> getMaterias(){ //  Método para obtener las materias del estudiante
        return materias;
    }
    public void setMaterias(ArrayList <Materia> materias){ // Método para cambiar las materias del estudiante

        this.materias = new ArrayList<>(); // Inicializar el ArrayList de materias
    }
    public double getPromedioAcumidado (){ //  Método para obtener el promedio acumulado del estudiante
        return promedioAcumulado;
    } 
    
    // Métodos  para agregar materias y calcular el promedio acumulado

    public void agregarMateria(Materia materia){ // Método para agregar materias al estudiante
    this.materias.add(materia); // Agregar una materia al ArrayList de materias 
    }


    public double calcularPromedioAcumulado(){ // Método para calcular el promedio acumulado del estudiante
        double SumaTotalNotas = 0.0;
       if  (materias.size() > 0){ // Verificar si el ArrayList de materias no está vacío, sino, dividiriamos por 0
            for (Materia materia : materias) { //nos vamos a recorrer el arreglo 
                SumaTotalNotas =  SumaTotalNotas + materia.getNota(); //  Vamos a sumar la nota de cada materia
            }
            promedioAcumulado = SumaTotalNotas / materias.size(); // Calulamos el promedio de las notas.
        } else {
            promedioAcumulado = 0.0; // Si el ArrayList de materias está vacío 
        }
        return promedioAcumulado; // Retornamos el promedio acumulado
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre='" + nombre + '\'' +", id='" + id + '\'' +", promedio=" + promedioAcumulado +'}';
    }
}

/* Nota: 
 * El método de la línea 45 materia.getNota es un método de la clase Materia que se define en el código de dicha clase.
 * El uso de List en las primeras lineas es para no especificar qué tipo de lsita será.
 */