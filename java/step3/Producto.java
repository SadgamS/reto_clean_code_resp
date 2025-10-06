package reto_clean_code_resp.java.step3;

/**
 * Clase que representa un producto en el inventario.
 */
public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void actualizarStock(int nuevaCantidad) {
        this.stock = nuevaCantidad;
    }
}
