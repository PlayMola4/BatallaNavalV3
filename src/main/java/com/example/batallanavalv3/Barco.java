package com.example.batallanavalv3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Barco {
    private double xPos;
    private double yPos;
    private double rumbo;
    private String equipo;
    private int vida;
    private double rangoDisparo;
    private double punteria;

    private String impacto;
    private int dano;

    public Barco(double xPos, double yPos, double rumbo, String equipo, int vida) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rumbo = rumbo;
        this.equipo = equipo;
        this.vida = vida;

    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public double getRumbo() {
        return rumbo;
    }

    public void setRumbo(double rumbo) {
        this.rumbo = rumbo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public double getRangoDisparo() {
        return rangoDisparo;
    }

    public void setRangoDisparo(double rangoDisparo) {
        this.rangoDisparo = rangoDisparo;
    }

    public double getPunteria() {
        return punteria;
    }

    public void setPunteria(double punteria) {
        this.punteria = punteria;
    }

    public String getImpacto() {
        return impacto;
    }

    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void dibujar(GraphicsContext gc) {
        // Utilizar el objeto GraphicsContext para dibujar el barco en la posición actual
        // Puedes usar el método fillRect para dibujar un rectángulo en la posición del barco
        // y cambiar el color según el equipo del barco
        gc.setFill(equipo.equals("rojo") ? Color.RED : Color.BLUE);
        gc.fillRect(xPos, yPos, 20, 20);
    }


    public void disparar(Barco objetivo) {
        if (calcularDistancia(objetivo) <= rangoDisparo) {
            double aleatorio = Math.random();
            if (aleatorio <= punteria) {
                // Calcular el impacto y el daño según la tabla establecida
                objetivo.recibirDano(dano);
            } else {
                System.out.println("Disparo fallido");
            }
        } else {
            System.out.println("Barco fuera de rango");
        }
    }

    private void calcularImpacto(Barco objetivo) {
        double aleatorio = Math.random();
        if (aleatorio <= 0.25) {
            impacto = "torre de control";
            dano = 75;
        } else if (aleatorio <= 0.5) {
            impacto = "linea de flotacion";
            dano = 50;
        } else {
            impacto = "resto";
            dano = 25;
        }
    }

    public double calcularDistancia(Barco otroBarco) {
        return Math.sqrt(Math.pow(xPos - otroBarco.getxPos(), 2) + Math.pow(yPos - otroBarco.getyPos(), 2));
    }

    public void recibirDano(int dano) {
        vida -= dano;
        if (vida <= 0) {
            System.out.println("El barco ha sido destruido");
        }
    }
}
