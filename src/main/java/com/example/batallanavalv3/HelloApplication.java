package com.example.batallanavalv3;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private ControlDeJuego controlDeJuego;

    @Override
    public void start(Stage primaryStage) {
        Escenario escenario = new Escenario();
        escenario.setWidth(1024);
        escenario.setHeight(768);
        controlDeJuego = ControlDeJuego.getInstance();

        // Agregar barcos al escenario y al control de juego
        Barco barcoRojo = new Barco(0, 0, 45, "rojo", 100);
        Barco barcoAzul = new Barco(1024, 768, 135, "azul", 100);
        escenario.agregarBarco(barcoRojo);
        escenario.agregarBarco(barcoAzul);
        controlDeJuego.agregarBarco(barcoRojo);
        controlDeJuego.agregarBarco(barcoAzul);

        // Crear un ciclo de animación para actualizar el escenario y detectar colisiones
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                escenario.actualizar();
                escenario.paint();
                // Utilizar el método detectarBarcosEnemigos del control de juego para detectar barcos enemigos
            }
        };
        animationTimer.start();
        Scene scene = new Scene(escenario);
        primaryStage.setTitle("Simulador de Batallas Navales");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
