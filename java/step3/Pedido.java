package reto_clean_code_resp.java.step3;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {
    private final String id;
    private final Cliente cliente;
    private final List<ItemCarrito> items;
    private EstadoPedido estado;
    private BigDecimal total;

    public Pedido(String id, Cliente cliente, List<ItemCarrito> items) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        this.estado = EstadoPedido.PENDIENTE;
        this.total = calcularTotal();
    }

    private BigDecimal calcularTotal() {
        return items.stream()
                .map(ItemCarrito::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void confirmar() {
        if (estado == EstadoPedido.PENDIENTE) {
            estado = EstadoPedido.CONFIRMADO;
        }
    }

    public void marcarPagado() {
        if (estado == EstadoPedido.CONFIRMADO) {
            estado = EstadoPedido.PAGADO;
        }
    }

    // getters
    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
}
