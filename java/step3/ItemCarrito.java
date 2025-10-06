package reto_clean_code_resp.java.step3;

import java.math.BigDecimal;

public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public BigDecimal getSubtotal() {
        return BigDecimal.valueOf(producto.getPrecio()).multiply(BigDecimal.valueOf(cantidad));
    }

    public int getCantidad() {
        return cantidad;
    }

    public void incrementarCantidad(int valor) {
        cantidad += valor;
    }
}
