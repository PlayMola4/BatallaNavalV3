package com.example.batallanavalv3;

import java.util.ArrayList;
import java.util.List;

public class ControlDeJuego {
    private static ControlDeJuego instance;
    private Escenario escenario;
    private List<Barco> barcos;

    private ControlDeJuego() {
        escenario = new Escenario();
        barcos = new ArrayList<>();
    }

    public static ControlDeJuego getInstance() {
        if (instance == null) {
            instance = new ControlDeJuego();
        }
        return instance;
    }

    public void detectarBarcosEnemigos(Barco barco) {
        for (Barco barcoEnemigo : barcos) {
            if (!barcoEnemigo.getEquipo().equals(barco.getEquipo())) {
                double distancia = calcularDistancia(barco, barcoEnemigo);
                if (distancia <= 20) {
                    System.out.println("Barco enemigo detectado cerca de " + barco.getxPos() + ", " + barco.getyPos());
                }
            }
        }
    }

    private double calcularDistancia(Barco barco1, Barco barco2) {
        double xDiff = barco1.getxPos() - barco2.getxPos();
        double yDiff = barco1.getyPos() - barco2.getyPos();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public void agregarBarco(Barco barco) {
        barcos.add(barco);
    }
}
