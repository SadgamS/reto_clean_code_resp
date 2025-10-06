package reto_clean_code_resp.java.step5.interfaces;

import java.time.LocalDateTime;

public interface RegistroReporteRepository {
    void registrar(String nombreArchivo, LocalDateTime fecha, int tamañoBytes);
}