package reto_clean_code_resp.java.step1.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementación de TransactionLogger que almacena las entradas en memoria.
 */
class InMemoryTransactionLogger implements TransactionLogger {
    private final List<String> entries = new ArrayList<>();

    public void log(String entry) {
        entries.add(entry);
    }

    public List<String> getEntries() {
        return Collections.unmodifiableList(entries);
    }
}