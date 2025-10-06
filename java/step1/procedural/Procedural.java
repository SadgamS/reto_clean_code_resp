package reto_clean_code_resp.java.step1.procedural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/*
 * Código procedural que mezcla de responsabilidades (validación, persistencia, logging, notificación) 
 * en una sola función; datos expuestos como estructuras mutables externas; difícil de testear y extender.
 */
public class Procedural {
    public static void main(String[] args) {
        Map<String, Long> accounts = new HashMap<>();
        accounts.put("A1", 1000L);
        accounts.put("A2", 500L);

        List<String> transactionLog = new ArrayList<>();

        transfer(accounts, transactionLog, "A1", "A2", 300L); // OK
        transfer(accounts, transactionLog, "A2", "A1", 800L); // Insuficiente

        System.out.println("Accounts: " + accounts);
        System.out.println("Log: " + transactionLog);
    }

    // Función procedural: mezcla validación, actualización, logging y notificación
    static void transfer(Map<String, Long> accounts, List<String> log, String fromId, String toId, long amount) {
        if (!accounts.containsKey(fromId) || !accounts.containsKey(toId)) {
            log.add("Transfer failed: account not found");
            System.out.println("Account not found");
            return;
        }

        long fromBalance = accounts.get(fromId);
        if (fromBalance < amount) {
            String entry = String.format("Transfer failed: insufficient funds %s -> %s amount=%d", fromId, toId,
                    amount);
            log.add(entry);
            System.out.println("Insufficient funds");
            return;
        }

        // Actualiza balances (persistencia simulada en Map)
        accounts.put(fromId, fromBalance - amount);
        accounts.put(toId, accounts.get(toId) + amount);

        String entry = String.format("Transfer %s -> %s : %d", fromId, toId, amount);
        log.add(entry);

        // Notificación por consola (mezclada aquí)
        System.out.println(entry);
    }
}
