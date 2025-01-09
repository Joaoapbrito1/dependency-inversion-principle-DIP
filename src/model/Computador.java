package model;

public class Computador {
    private final DispositivoEntrada dispositivo;

    public Computador(DispositivoEntrada dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void usarDispositivo() {
        dispositivo.usar();
    }
}
