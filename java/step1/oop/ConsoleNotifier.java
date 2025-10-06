package reto_clean_code_resp.java.step1.oop;

/**
 * Implementación de Notifier que imprime notificaciones en la consola.
 */
class ConsoleNotifier implements Notifier {
    public void notify(String message) {
        System.out.println("[NOTIFY] " + message);
    }
}