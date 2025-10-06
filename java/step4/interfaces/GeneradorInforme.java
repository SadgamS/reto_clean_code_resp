package reto_clean_code_resp.java.step4.interfaces;

import reto_clean_code_resp.java.step4.InformeData;

import java.util.List;

public interface GeneradorInforme {
    String generarContenido(List<InformeData> informeDatas);
}