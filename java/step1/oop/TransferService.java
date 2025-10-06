package reto_clean_code_resp.java.step1.oop;

import java.math.BigDecimal;

/**
 * Caso de uso: realiza la transferencia entre dos cuentas.
 */
class TransferService {
    private final TransactionLogger logger;
    private final Notifier notifier;

    public TransferService(TransactionLogger logger, Notifier notifier) {
        this.logger = logger;
        this.notifier = notifier;
    }

    public void transfer(Account from, Account to, BigDecimal amount) {
        // Validación y reglas de negocio están en Account (encapsuladas)
        from.debit(amount);
        to.credit(amount);

        String entry = String.format("Transfer %s -> %s : %s", from.getId(), to.getId(), amount.toPlainString());
        logger.log(entry); // Persistencia/registro delegada
        notifier.notify(entry); // Notificación delegada (adaptador)
    }
}
