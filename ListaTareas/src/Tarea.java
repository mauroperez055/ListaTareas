import java.time.LocalDate;

public class Tarea {
    
    private int id;
    String nombre;
    private boolean completado;
    public LocalDate fechaFin, fechaInicio;
    public LocalDate endDate;
    public boolean completed;
    public String startDate;
    public static int cont;

    public Tarea( String nombre, LocalDate fechaFin) {
        this.id = ++cont;
        this.nombre = nombre;
        this.completado = false;
        this.fechaFin = fechaFin;
        this.fechaInicio = LocalDate.now();
    }

    public int getId(){
        return id;
    }
}
