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
    public String getCodigoMateria (){ //  Método para obtener el código de la materia 
        return this.codigoMateria;
    }
    public void setCodigoMateria(String codigoMateria){ // Método para cambiar el código de la materia 
        this.codigoMateria = codigoMateria;
    }
    public int getSemestre (){ // Método para obtener el semestre de la materia 
        return this.semestre;
    }
    public void setSemestre(int semestre){ // Método para cambiar el semestre de la materia 
        this.semestre = semestre;
    }
    public double getNota(){ // Método para obtener la nota de la materia 
        return this.nota;
    }
    public void setNota(double nota){ // Método para cambiar la nota de la materia 
        this.nota = nota;
    }
    
}
