
package com.mycompany.sistemagestionvehiculos;

public class VehiculoAlquilerDiario extends Vehiculo {
     private int diasAlquiler;
     private double tarifaDiaria;

    public VehiculoAlquilerDiario(
            int id,
            String marca,
            String modelo,
            String placa,
            int diasAlquiler,
            double tarifaDiaria) {

        super(id, marca, modelo, placa);

        setDiasAlquiler(diasAlquiler);
        setTarifaDiaria(tarifaDiaria);
    }

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setDiasAlquiler(int diasAlquiler) {

        if (diasAlquiler < 1 || diasAlquiler > 90) {
            throw new IllegalArgumentException("Los días de alquiler deben estar entre 1 y 90.");
        }
        this.diasAlquiler = diasAlquiler;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public void setTarifaDiaria(double tarifaDiaria) {

        if (tarifaDiaria < 0) {
            throw new IllegalArgumentException("La tarifa diaria no puede ser negativa." );
        }

        this.tarifaDiaria = tarifaDiaria;
    }

    @Override
    public double calcularCostoAlquiler() {

        double total = diasAlquiler * tarifaDiaria;

        if (diasAlquiler >= 7) {
            total = total * 0.90;
        }

        return total;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("==============================================");
        System.out.println("[ALQUILER DIARIO]");
        System.out.println("ID: " + getId());
        System.out.println("Vehículo: " + getMarca() + " " + getModelo());
        System.out.println("Placa: " + getPlaca());
        System.out.println("Días de alquiler: " + diasAlquiler);
        System.out.printf("Tarifa diaria: S/ %.2f%n", tarifaDiaria);
        System.out.printf("Costo total: S/ %.2f%n", calcularCostoAlquiler());
        System.out.println("==============================================");
        
    }
}
