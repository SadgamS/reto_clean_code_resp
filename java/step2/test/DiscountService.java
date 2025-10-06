package reto_clean_code_resp.java.step2.test;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Servicio para calcular descuentos basados en el tipo de cliente.
 * Tipos de cliente:
 * - REGULAR: Sin descuento.
 * - VIP: 10% de descuento.
 * - PREMIUM: 20% de descuento.
 */
public class DiscountService {
       private static final Map<String, BigDecimal> DISCOUNT_RATES = Map.of(
            "REGULAR", BigDecimal.ZERO,
            "VIP", new BigDecimal("0.10"),
            "PREMIUM", new BigDecimal("0.20")
    );

    public BigDecimal calculateTotalWithDiscount(String clientType, BigDecimal total) {
        BigDecimal rate = DISCOUNT_RATES.getOrDefault(clientType.toUpperCase(), BigDecimal.ZERO);
        return total.subtract(total.multiply(rate)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
