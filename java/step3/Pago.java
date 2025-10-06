package reto_clean_code_resp.java.step3;

import java.math.BigDecimal;

public class Pago {
    private final String id;
    private final Pedido pedido;
    private final BigDecimal monto;
    private final String metodo;

    public Pago(String id, Pedido pedido, BigDecimal monto, String metodo) {
        this.id = id;
        this.pedido = pedido;
        this.monto = monto;
        this.metodo = metodo;
    }

    public void procesar() {
        pedido.marcarPagado();
        // Aquí podría integrarse con un gateway externo (PayPal, Stripe, etc.)
    }

    public String getId() {
        return id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public String getMetodo() {
        return metodo;
    }
}
