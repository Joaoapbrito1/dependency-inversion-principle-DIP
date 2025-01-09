package service;

import model.DispositivoEntrada;

public class Mouse implements DispositivoEntrada {
    @Override
    public void usar() {
        System.out.println("Movendo o ponteiro...");
    }
}
