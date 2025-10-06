package reto_clean_code_resp.java.step5.impl;

import java.time.LocalDateTime;
import java.util.List;

import reto_clean_code_resp.java.step5.Empleado;
import reto_clean_code_resp.java.step5.interfaces.GeneradorReporte;

public class GeneradorReporteCSV implements GeneradorReporte {
    @Override
    public String generarContenido(List<Empleado> empleados) {
        StringBuilder sb = new StringBuilder();
        sb.append("fecha_generacion,").append(LocalDateTime.now()).append("\n");
        sb.append("nombre,salario\n");
        for (Empleado e : empleados) {
            sb.append(e.getId()).append(",")
                    .append(e.getNombre()).append(",")
                    .append(e.getSalario()).append("\n");
        }
        return sb.toString();
    }
}