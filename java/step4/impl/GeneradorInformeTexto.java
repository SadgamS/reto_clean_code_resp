package reto_clean_code_resp.java.step4.impl;

import java.util.List;

import reto_clean_code_resp.java.step4.InformeData;
import reto_clean_code_resp.java.step4.interfaces.GeneradorInforme;

public class GeneradorInformeTexto implements GeneradorInforme {
    @Override
    public String generarContenido(List<InformeData> informeDatas) {
        StringBuilder sb = new StringBuilder("=== REPORTE ===\n");
        for (InformeData p : informeDatas) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}