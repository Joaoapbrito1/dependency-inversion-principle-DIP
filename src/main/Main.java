package main;

import model.Computador;
import model.DispositivoEntrada;
import service.Mouse;
import service.Teclado;

public class Main {
    public static void main(String[] args) {

        DispositivoEntrada teclado = new Teclado();
        Computador computador = new Computador(teclado);
        computador.usarDispositivo();

        DispositivoEntrada mouse = new Mouse();
        computador = new Computador(mouse);
        computador.usarDispositivo();
    }
}