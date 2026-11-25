package com.julian262626.proyectoprogramacion;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    // Registrar producto
    public void registrarProducto(String nombre, int stock) {

        if (buscarProducto(nombre) != null) {
            System.out.println("El producto ya existe.");
        } else if (stock < 0) {
            System.out.println("Stock no valido.");
        } else {
            Producto nuevo = new Producto(nombre, stock);
            productos.add(nuevo);
            System.out.println("Producto registrado.");
        }
    }

    // Buscar producto por nombre
    public Producto buscarProducto(String nombre) {

        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }

        return null;
    }

    // Consultar producto
    public void consultarProducto(String nombre) {

        Producto p = buscarProducto(nombre);

        if (p != null) {
            p.mostrarProducto();
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Registrar entrada
    public void registrarEntrada(String nombre, int cantidad) {

        Producto p = buscarProducto(nombre);

        if (p != null) {
            p.entrada(cantidad);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Registrar salida
    public void registrarSalida(String nombre, int cantidad) {

        Producto p = buscarProducto(nombre);

        if (p != null) {
            p.salida(cantidad);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Mostrar inventario completo
    public void mostrarInventario() {

        if (productos.isEmpty()) {
            System.out.println("Inventario vacio.");
        }

        for (Producto p : productos) {
            p.mostrarProducto();
        }
    }
}
