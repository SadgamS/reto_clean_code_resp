package reto_clean_code_resp.java.step5.interfaces;

import java.util.List;

import reto_clean_code_resp.java.step5.Empleado;

public interface GeneradorReporte {
    String generarContenido(List<Empleado> empleados);
}