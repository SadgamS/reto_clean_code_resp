package reto_clean_code_resp.java.step2.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

/**
 * Tests para la clase DiscountService.
 */
public class DiscountTest {
    @Test
    void testRegularClient_NoDiscount() {
        DiscountService service = new DiscountService();
        BigDecimal result = service.calculateTotalWithDiscount("REGULAR", new BigDecimal("100.00"));
        assertEquals(new BigDecimal("100.00"), result);
    }

    @Test
    void testVipClient_10PercentDiscount() {
        DiscountService service = new DiscountService();
        BigDecimal result = service.calculateTotalWithDiscount("VIP", new BigDecimal("100.00"));
        assertEquals(new BigDecimal("90.00"), result);
    }

    @Test
    void testPremiumClient_20PercentDiscount() {
        DiscountService service = new DiscountService();
        BigDecimal result = service.calculateTotalWithDiscount("PREMIUM", new BigDecimal("100.00"));
        assertEquals(new BigDecimal("80.00"), result);
    }

    @Test
    void testUnknownClientType_NoDiscountApplied() {
        DiscountService service = new DiscountService();
        BigDecimal result = service.calculateTotalWithDiscount("STUDENT", new BigDecimal("100.00"));
        assertEquals(new BigDecimal("100.00"), result);
    }
}
