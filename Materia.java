public class Materia { // Definimos la clase Materia para el programa
    
    private String nombreMateria; // Definimos los atributos de la clase
    private String codigoMateria;
    private int semestre;
    private double nota; 


    public Materia (String nombreMateria, String codigoMateria, int semestre, double nota) { // Definimos el constructor de la clase

        this.nombreMateria = nombreMateria;
        this.codigoMateria = codigoMateria; 
        this.semestre = semestre;
        this.nota = nota;

    }

    // Métodos get y set de los atributos
    public String getNombreMateria (){ // Método para obtener el nombre de la materia 
        return this.nombreMateria;
    }
    public void setNombreMateria(String NombreMateria){ // Método para cambiar el nombre de la materia 
        this.nombreMateria = NombreMateria;
    }
    public String getCodigoMateria (){
        return this.codigoMateria;
    }
    public void setCodigoMateria(String codigoMateria){
        this.codigoMateria = codigoMateria;
    }
    public int getSemestre (){
        return this.semestre;
    }
    public void setSemestre(int semestre){
        this.semestre = semestre;
    }
    public double getNota(){
        return this.nota;
    }
    public void setNota(double nota){
        this.nota = nota;
    }
    
}
