package reto_clean_code_resp.java.step3;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items = new ArrayList<>();

    public Carrito() {
    }

    public void agregarItem(Producto producto, int cantidad) {
        items.add(new ItemCarrito(producto, cantidad));
    }

    public double calcularTotal() {
        return items.stream()
                .mapToDouble(i -> i.getProducto().getPrecio() * i.getCantidad())
                .sum();
    }
}
