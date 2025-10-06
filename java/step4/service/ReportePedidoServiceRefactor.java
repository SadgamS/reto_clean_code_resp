package reto_clean_code_resp.java.step4.service;

import java.util.List;

import reto_clean_code_resp.java.step4.InformeData;
import reto_clean_code_resp.java.step4.interfaces.GeneradorInforme;
import reto_clean_code_resp.java.step4.interfaces.Notificador;
import reto_clean_code_resp.java.step4.interfaces.RepositorioArchivo;

public class ReportePedidoServiceRefactor {
    private final GeneradorInforme generador;
    private final RepositorioArchivo repositorio;
    private final Notificador notificador;

    public ReportePedidoServiceRefactor(GeneradorInforme generador,
            RepositorioArchivo repositorio,
            Notificador notificador) {
        this.generador = generador;
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public void generarReporte(List<InformeData> informeDatas) {
        String contenido = generador.generarContenido(informeDatas);
        repositorio.guardar("reporte_pedidos.txt", contenido);
        notificador.notificar("Reporte generado exitosamente");
    }
}