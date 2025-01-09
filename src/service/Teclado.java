package service;

import model.DispositivoEntrada;

public class Teclado implements DispositivoEntrada {
    @Override
    public void usar() {
        System.out.println("Digitando...");
    }
}