package com.julian262626.proyectoprogramacion;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;

    // Constructor
    public Inventario() {
        productos = new ArrayList<>();
    }

    // Registrar un producto
    public void registrarProducto(Producto producto) {

        if (buscarProducto(producto.getCodigo()) != null) {
            System.out.println("El código ya existe.");
            return;
        }

        productos.add(producto);
        System.out.println("Producto registrado correctamente.");
    }

    // Mostrar todos los productos
    public void mostrarInventario() {

        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        System.out.println("\n===== INVENTARIO DE LA TIENDA =====");

        for (Producto producto : productos) {
            producto.mostrarProducto();
        }
    }

    // Buscar producto por código
    public Producto buscarProducto(int codigo) {

        for (Producto producto : productos) {

            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }

        return null;
    }

    // Eliminar producto
    public void eliminarProducto(int codigo) {

        Producto producto = buscarProducto(codigo);

        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Registrar entrada de productos
    public void entradaStock(int codigo, int cantidad) {

        Producto producto = buscarProducto(codigo);

        if (producto != null && cantidad > 0) {

            producto.setCantidad(
                producto.getCantidad() + cantidad
            );

            System.out.println("Entrada registrada correctamente.");

        } else {
            System.out.println("Producto no encontrado o cantidad inválida.");
        }
    }

    // Registrar salida de productos
    public void salidaStock(int codigo, int cantidad) {

        Producto producto = buscarProducto(codigo);

        if (producto != null && cantidad > 0) {

            if (producto.getCantidad() >= cantidad) {

                producto.setCantidad(
                    producto.getCantidad() - cantidad
                );

                System.out.println("Salida registrada correctamente.");

            } else {
                System.out.println("No hay suficiente stock.");
            }

        } else {
            System.out.println("Producto no encontrado o cantidad inválida.");
        }
    }

    // Reporte general
    public void generarReporte() {

        int totalUnidades = 0;
        int agotados = 0;

        for (Producto producto : productos) {

            totalUnidades += producto.getCantidad();

            if (producto.getCantidad() == 0) {
                agotados++;
            }
        }

        System.out.println("\n===== REPORTE DE INVENTARIO =====");
        System.out.println("Referencias registradas: " + productos.size());
        System.out.println("Unidades disponibles: " + totalUnidades);
        System.out.println("Productos agotados: " + agotados);
    }
}
