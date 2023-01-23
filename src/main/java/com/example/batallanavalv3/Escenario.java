package com.example.batallanavalv3;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Escenario extends Canvas {
    private ArrayList<Barco> barcos;

    public Escenario() {
        barcos = new ArrayList<>();
    }

    public void agregarBarco(Barco barco) {
        barcos.add(barco);
    }

    public void actualizar() {
        for (Barco barco : barcos) {
            // Actualizar la posición del barco según su rumbo
            barco.setxPos(barco.getxPos() + Math.cos(Math.toRadians(barco.getRumbo())));
            barco.setyPos(barco.getyPos() + Math.sin(Math.toRadians(barco.getRumbo())));

            // Detectar colisiones con los bordes del escenario
            if (barco.getxPos() <= 0 || barco.getxPos() >= getWidth()) {
                barco.setRumbo(180 - barco.getRumbo());
            }
            if (barco.getyPos() <= 0 || barco.getyPos() >= getHeight()) {
                barco.setRumbo(360 - barco.getRumbo());
            }
        }
    }

    public void paint() {
        GraphicsContext gc = this.getGraphicsContext2D();
        for (Barco barco : barcos) {
            barco.dibujar(gc);
        }
    }
}
