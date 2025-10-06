package reto_clean_code_resp.java.step1.oop;

import java.math.BigDecimal;

/**
 * Diseño OOP:
 * - Account encapsula estado (balance) y operaciones (debit/credit).
 * - TransferService coordina la operación de transferencia (caso de uso).
 * - TransactionLogger y Notifier son interfaces que separan adaptadores
 * (inyección de dependencias).
 * 
 * 
 * Account oculta el balance y ofrece operaciones seguras (debit, credit). Esto
 * evita manipulaciones directas e inconsistentes del estado.
 * 
 * 
 * TransferService implementa el caso de uso: coordina entidades y delega
 * persistencia/notificación a interfaces.
 * 
 * -> Eso facilita probar TransferService inyectando mocks/stubs para
 * TransactionLogger y Notifier.
 * 
 */
public class Oop {
    public static void main(String[] args) {
        Account a1 = new Account("A1", new BigDecimal("1000.00"));
        Account a2 = new Account("A2", new BigDecimal("250.00"));

        InMemoryTransactionLogger logger = new InMemoryTransactionLogger();
        ConsoleNotifier notifier = new ConsoleNotifier();
        TransferService service = new TransferService(logger, notifier);

        try {
            service.transfer(a1, a2, new BigDecimal("300.00")); // OK
            service.transfer(a2, a1, new BigDecimal("1000.00")); // lanzará excepción por fondos
        } catch (Exception e) {
            System.out.println("Transfer error: " + e.getMessage());
        }

        System.out.println("Balances: " + a1 + " | " + a2);
        System.out.println("Log: " + logger.getEntries());
    }
}
