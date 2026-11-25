package com.julian262626.proyectoprogramacion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();

        System.out.println("================================");
        System.out.println("     SISTEMA DE INVENTARIO");
        System.out.println("================================");
        System.out.println("¡Bienvenidos a nuestra tienda!");

        int opcion;

        do {

            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Entrada de stock");
            System.out.println("6. Salida de stock");
            System.out.println("7. Reporte de inventario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("\n===== REGISTRAR PRODUCTO =====");

                    System.out.print("Código del producto: ");
                    int codigo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Nombre del producto: ");
                    String nombre = sc.nextLine();

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();

                    Producto producto = new Producto(codigo, nombre, cantidad);

                    inventario.registrarProducto(producto);

                    break;

                case 2:

                    System.out.println("\n===== MOSTRAR INVENTARIO =====");

                    inventario.mostrarInventario();

                    break;

                case 3:

                    System.out.println("\n===== BUSCAR PRODUCTO =====");

                    System.out.print("Ingrese el código: ");
                    int codigoBuscar = sc.nextInt();

                    Producto encontrado = inventario.buscarProducto(codigoBuscar);

                    if (encontrado != null) {
                        encontrado.mostrarProducto();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 4:

                    System.out.println("\n===== ELIMINAR PRODUCTO =====");

                    System.out.print("Ingrese el código del producto: ");
                    int codigoEliminar = sc.nextInt();

                    inventario.eliminarProducto(codigoEliminar);

                    break;

                case 5:

                    System.out.println("\n===== ENTRADA DE STOCK =====");

                    System.out.print("Código del producto: ");
                    int codigoEntrada = sc.nextInt();

                    System.out.print("Cantidad que entra: ");
                    int cantidadEntrada = sc.nextInt();

                    inventario.entradaStock(codigoEntrada, cantidadEntrada);

                    break;

                case 6:

                    System.out.println("\n===== SALIDA DE STOCK =====");

                    System.out.print("Código del producto: ");
                    int codigoSalida = sc.nextInt();

                    System.out.print("Cantidad que sale: ");
                    int cantidadSalida = sc.nextInt();

                    inventario.salidaStock(codigoSalida, cantidadSalida);

                    break;

                case 7:

                    System.out.println("\n===== REPORTE DE INVENTARIO =====");

                    inventario.generarReporte();

                    break;

                case 0:

                    System.out.println("\nGracias por usar el sistema.");

                    break;

                default:

                    System.out.println("\nOpción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
