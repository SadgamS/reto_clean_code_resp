package reto_clean_code_resp.java.step5.impl;

import reto_clean_code_resp.java.step5.interfaces.Notificador;

public class NotificadorConsola implements Notificador {
    @Override
    public void notificar(String destinatario, String asunto, String cuerpo) {
        System.out.println("[NOTIFICACIÓN A " + destinatario + "] " + asunto + " - " + cuerpo);
    }
}