
package com.mycompany.sistemagestionvehiculos;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaGestionVehiculos {
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static int contadorId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        do {

            mostrarMenu();

            try {

                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {

                    case 1:
                        agregarVehiculoDiario();
                        break;

                    case 2:
                        agregarVehiculoKilometraje();
                        break;

                    case 3:
                        listarVehiculos();
                        break;

                    case 4:
                        calcularCosto();
                        break;

                    case 5:
                        System.out.println("\nGracias por usar el sistema! Hasta luego.");
                        break;

                    default:
                        System.out.println("\nOpción inválida:La opción debe estar entre 1 y 5.");

                }

            } catch (InputMismatchException e) {

                System.out.println("Error de validación: " + "La opción debe estar entre 1 y 5.");

                scanner.nextLine();
                opcion = 0;

            } catch (IllegalArgumentException e) {

                System.out.println("Error de validación: " + e.getMessage());

            }

        } while (opcion != 5);
        
        scanner.close();
    }

    public static void mostrarMenu() {

        System.out.println("\n========================================");
        System.out.println("       MENÚ PRINCIPAL");
        System.out.println("========================================");
        System.out.println("1. Agregar Vehículo - Alquiler Diario");
        System.out.println("2. Agregar Vehículo - Alquiler por Kilometraje");
        System.out.println("3. Listar todos los vehículos");
        System.out.println("4. Calcular costo de un vehículo");
        System.out.println("5. Salir");
        System.out.println("========================================");
    }

    public static void agregarVehiculoDiario() {

       
            System.out.println();
            System.out.println("==============================================");
            System.out.println(" REGISTRO - VEHÍCULO ALQUILER DIARIO");
            System.out.println("==============================================");

            System.out.print("Ingrese la marca: ");
            String marca = scanner.nextLine();

            System.out.print("Ingrese el modelo: ");
            String modelo = scanner.nextLine();

            System.out.print("Ingrese la placa: ");
            String placa = scanner.nextLine();

            System.out.print("Ingrese los días de alquiler: ");
            int dias = scanner.nextInt();

            System.out.print("Ingrese la tarifa diaria: ");
            double tarifa = scanner.nextDouble();

            scanner.nextLine();

            Vehiculo vehiculo = new VehiculoAlquilerDiario(
                    contadorId,
                    marca,
                    modelo,
                    placa,
                    dias,
                    tarifa
            );

            vehiculos.add(vehiculo);

             System.out.println();
             System.out.println("Vehículo registrado exitosamente!");
             vehiculo.mostrarInformacion();

            contadorId++;
    }

      
    public static void agregarVehiculoKilometraje() {

            System.out.println();
            System.out.println("==============================================");
            System.out.println(" REGISTRO - VEHÍCULO ALQUILER POR KILOMETRAJE");
            System.out.println("==============================================");

           
            System.out.print("Ingrese la marca: ");
            String marca = scanner.nextLine();

            System.out.print("Ingrese el modelo: ");
            String modelo = scanner.nextLine();

            System.out.print("Ingrese la placa: ");
            String placa = scanner.nextLine();

            System.out.print("Ingrese los kilómetros recorridos: ");
            int kilometros = scanner.nextInt();

            System.out.print("Ingrese la tarifa por Km: ");
            double tarifa = scanner.nextDouble();

            scanner.nextLine();

            Vehiculo vehiculo = new VehiculoAlquilerKilometraje(
                    contadorId,
                    marca,
                    modelo,
                    placa,
                    kilometros,
                    tarifa
            );

            vehiculos.add(vehiculo);
            contadorId++;

        System.out.println();
        System.out.println("Vehículo registrado exitosamente!");
        vehiculo.mostrarInformacion();
    }

          
    public static void listarVehiculos() {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("          LISTADO DE VEHÍCULOS");
        System.out.println("==============================================");

        if (vehiculos.isEmpty()) {

            System.out.println("No hay vehículos registrados.");

        } else {

            System.out.println("Total de vehículos: " + vehiculos.size());

            for (Vehiculo vehiculo : vehiculos) {
                vehiculo.mostrarInformacion();
            }
        }
    }

    public static void calcularCosto() {
        System.out.println();
        System.out.println("==============================================");
        System.out.println("          CÁLCULO DE COSTO");
        System.out.println("==============================================");

        System.out.print("Ingrese el ID del vehículo: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Vehiculo vehiculoEncontrado = buscarVehiculoPorId(id);

        if (vehiculoEncontrado != null) {

            System.out.println();
            System.out.println("Vehículo encontrado:");
            vehiculoEncontrado.mostrarInformacion();

            System.out.printf("Costo calculado: S/ %.2f%n",
                    vehiculoEncontrado.calcularCostoAlquiler());

        } else {

            System.out.println();
            System.out.println("Error: No se encontró un vehículo "
                    + "con el ID " + id + ".");
        }
    }
    private static Vehiculo buscarVehiculoPorId(int id) {

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.getId() == id) {
                return vehiculo;
            }
        }

        return null;
    }
}

       