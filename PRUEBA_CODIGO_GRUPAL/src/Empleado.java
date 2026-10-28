/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
public class Empleado extends Persona {
    private double dinero;

    public Empleado(double sueldo, int años, String nombre) {
        super(años, nombre);
        this.dinero = sueldo;
    }

    public double getSueldo() {
        return dinero;
    }

    public void setSuelod(double sueldo) {
        this.dinero = sueldo;
    }
    
}
