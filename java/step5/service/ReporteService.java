package reto_clean_code_resp.java.step5.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

import reto_clean_code_resp.java.step5.Empleado;
import reto_clean_code_resp.java.step5.interfaces.GeneradorReporte;
import reto_clean_code_resp.java.step5.interfaces.Notificador;
import reto_clean_code_resp.java.step5.interfaces.RegistroReporteRepository;
import reto_clean_code_resp.java.step5.interfaces.RepositorioArchivo;

public class ReporteService {
    private final GeneradorReporte generador;
    private final RepositorioArchivo repositorioArchivo;
    private final Notificador notificador;
    private final RegistroReporteRepository registroRepo; // puede ser null si no se usa

    public ReporteService(GeneradorReporte generador,
            RepositorioArchivo repositorioArchivo,
            Notificador notificador,
            RegistroReporteRepository registroRepo) {
        this.generador = generador;
        this.repositorioArchivo = repositorioArchivo;
        this.notificador = notificador;
        this.registroRepo = registroRepo;
    }

    public String generarYDistribuirReporte(List<Empleado> empleados, String nombreArchivo,
            List<String> destinatarios) {
        // 1. Generar contenido (pure function)
        String contenido = generador.generarContenido(empleados);

        // 2. Guardar (persistencia delegada)
        repositorioArchivo.guardar(nombreArchivo, contenido);

        // 3. Registrar metadatos (opcional, solo si inyectado)
        if (registroRepo != null) {
            registroRepo.registrar(nombreArchivo, LocalDateTime.now(),
                    contenido.getBytes(StandardCharsets.UTF_8).length);
        }

        // 4. Notificar (delegado a notificador)
        String asunto = "Reporte de Empleados generado";
        for (String to : destinatarios) {
            notificador.notificar(to, asunto, "El reporte " + nombreArchivo + " está disponible.");
        }

        return nombreArchivo;
    }
}
