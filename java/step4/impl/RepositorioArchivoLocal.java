package reto_clean_code_resp.java.step4.impl;

import java.io.FileWriter;

import reto_clean_code_resp.java.step4.interfaces.RepositorioArchivo;

public class RepositorioArchivoLocal implements RepositorioArchivo {
    @Override
    public void guardar(String nombreArchivo, String contenido) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(contenido);
        } catch (Exception e) {
            throw new RuntimeException("Error guardando archivo", e);
        }
    }
}
