
public class Persona {
    private int años;
    private String nombre; 

    public void setAños(int años) {
        this.años = años;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona(int años, String nombre) {
        this.años = años;
        this.nombre = nombre;
    }

    public int getAños() {
        return años;
    }

    public String getNombre() {
        return nombre;
    }
}
