package reto_clean_code_resp.java.step3;

public class Cliente {
    private final String id;
    private final String nombre;
    private final String tipo; // REGULAR, VIP, PREMIUM

    public Cliente(String id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}
