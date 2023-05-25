package com.example.racergame;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import javafx.scene.control.Button;
import javafx.scene.text.*;

public class GameLauncher {
    static Road road;
    static Racer racer;
    static CarTraffic carTraffic;
    public static void launch(Scene scene, Pane pane){
        road = new Road(scene, pane, 5);
        racer = new Racer(scene, pane);
        carTraffic = new CarTraffic(scene, pane, road, 4);
        Vars keyW=new Vars();
        Vars keyA=new Vars();
        Vars keyS=new Vars();
        Vars keyD=new Vars();

        int speed=10;
        AnimationTimer at = new AnimationTimer(){
            @Override
            public void handle(long now) {
                road.move(7);
                racer.moveY(5);
                carTraffic.move();
                if (keyW.isPressed())
                    racer.moveY(-13);
                if (keyA.isPressed())
                    racer.moveX(-8, road);
                if (keyS.isPressed())
                    racer.moveY(12);
                if (keyD.isPressed())
                    racer.moveX(8,road);
                if (carTraffic.isCrashed(racer.getX(), racer.getY())){
                    this.stop();
                    Rectangle crashed = new Rectangle(scene.getWidth()*0.5, scene.getHeight()*0.5);
                    crashed.setLayoutX(scene.getWidth()/2-crashed.getWidth()/2);
                    crashed.setLayoutY(scene.getHeight()/2-crashed.getHeight()/2);
                    crashed.setFill(AppSettings.SINGLETON.getColor("Crashed"));
                    Text gameOver = new Text("Game over");
                    gameOver.setTextAlignment(TextAlignment.CENTER);
                    gameOver.setWrappingWidth(crashed.getWidth());
                    gameOver.setLayoutX(crashed.getLayoutX());
                    gameOver.setLayoutY(crashed.getLayoutY()+50);
                    Button tryAgain = new Button("Try again");
                    gameOver.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 45));
                    tryAgain.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
                    tryAgain.setPrefSize (crashed.getWidth()*0.7, crashed.getHeight()*0.3);
                    pane.getChildren().add(crashed);
                    pane.getChildren().add(gameOver);
                    pane.getChildren().add(tryAgain);
                    tryAgain.setLayoutX(scene.getWidth()/2-tryAgain.getPrefWidth()/2);
                    tryAgain.setLayoutY(crashed.getLayoutY()+crashed.getHeight()-tryAgain.getPrefHeight()-20);
                    tryAgain.setOnMouseClicked(mouseEvent -> {
                        pane.getChildren().clear();
                        GameLauncher.launch(scene, pane);
                    });


                }
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        at.start();

        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode()== KeyCode.W)
                keyW.pressed();
            if (keyEvent.getCode()== KeyCode.S)
                keyS.pressed();
            if (keyEvent.getCode()== KeyCode.A)
                keyA.pressed();
            if (keyEvent.getCode()== KeyCode.D)
                keyD.pressed();
        });
        scene.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode()== KeyCode.W) {
                keyW.released();
                racer.stopNitro();
            }
            if (keyEvent.getCode()== KeyCode.S)
                keyS.released();
            if (keyEvent.getCode()== KeyCode.A)
                keyA.released();
            if (keyEvent.getCode()== KeyCode.D)
                keyD.released();
        });
    }

}
