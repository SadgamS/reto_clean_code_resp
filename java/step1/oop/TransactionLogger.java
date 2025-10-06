package reto_clean_code_resp.java.step1.oop;

import java.util.List;

/**
 * Interfaz TransactionLogger para registrar entradas de transacciones.
 */
interface TransactionLogger {
    void log(String entry);

    List<String> getEntries();
}