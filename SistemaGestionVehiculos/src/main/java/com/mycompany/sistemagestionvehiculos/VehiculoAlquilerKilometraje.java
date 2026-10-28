
package com.mycompany.sistemagestionvehiculos;


public class VehiculoAlquilerKilometraje extends Vehiculo {
    private int kilometrosRecorridos;
    private double tarifaPorKm;

    public VehiculoAlquilerKilometraje(
            int id,
            String marca,
            String modelo,
            String placa,
            int kilometrosRecorridos,
            double tarifaPorKm) {

        super(id, marca, modelo, placa);

        setKilometrosRecorridos(kilometrosRecorridos);
        setTarifaPorKm(tarifaPorKm);
    }

    public int getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setKilometrosRecorridos(int kilometrosRecorridos) {

        if (kilometrosRecorridos < 0 || kilometrosRecorridos > 5000) {
            throw new IllegalArgumentException("Los kilómetros deben estar entre 0 y 5000.");
        }
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public double getTarifaPorKm() {
        return tarifaPorKm;
    }

    public void setTarifaPorKm(double tarifaPorKm) {

        if (tarifaPorKm < 0) {
            throw new IllegalArgumentException("La tarifa por kilómetro no puede ser negativa.");
        }
        this.tarifaPorKm = tarifaPorKm;
    }

    @Override
    public double calcularCostoAlquiler() {

        return kilometrosRecorridos * tarifaPorKm;
    }

    @Override
    public void mostrarInformacion() {

         System.out.println("==============================================");
        System.out.println("[ALQUILER POR KILOMETRAJE]");
        System.out.println("ID: " + getId());
        System.out.println("Vehículo: " + getMarca() + " " + getModelo());
        System.out.println("Placa: " + getPlaca());
        System.out.println("Kilómetros recorridos: " + kilometrosRecorridos);
        System.out.printf("Tarifa por km: S/ %.2f%n", tarifaPorKm);
        System.out.printf("Costo total: S/ %.2f%n", calcularCostoAlquiler());
        System.out.println("==============================================");
        
    }
}
