package reto_clean_code_resp.java.step4.impl;

import reto_clean_code_resp.java.step4.interfaces.Notificador;

public class NotificadorConsola implements Notificador {
    @Override
    public void notificar(String mensaje) {
        System.out.println("[NOTIFICACIÓN] " + mensaje);
    }
}