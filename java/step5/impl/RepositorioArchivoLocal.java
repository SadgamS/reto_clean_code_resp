package reto_clean_code_resp.java.step5.impl;

import java.io.FileWriter;
import java.io.IOException;

import reto_clean_code_resp.java.step5.interfaces.RepositorioArchivo;

public class RepositorioArchivoLocal implements RepositorioArchivo {
    @Override
    public void guardar(String nombreArchivo, String contenido) {
        try (FileWriter fw = new FileWriter(nombreArchivo)) {
            fw.write(contenido);
        } catch (IOException e) {
            throw new RuntimeException("Error guardando archivo", e);
        }
    }
}
