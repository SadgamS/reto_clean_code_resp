package reto_clean_code_resp.java.step1.oop;

import java.math.BigDecimal;

/**
 *  Entidad: representa una cuenta bancaria del dominio. Encapsula balance y reglas.
 */
class Account {
    private final String id;
    private BigDecimal balance;

    public Account(String id, BigDecimal initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    // Operación de dominio: debita (lanza si insuficiente)
    public synchronized void debit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (balance.compareTo(amount) < 0) throw new IllegalStateException("Insufficient funds");
        balance = balance.subtract(amount);
    }

    // Operación de dominio: acredita
    public synchronized void credit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance = balance.add(amount);
    }

    public String getId() { return id; }
    public BigDecimal getBalance() { return balance; }

    @Override
    public String toString() { return id + ":" + balance.toPlainString(); }
}
