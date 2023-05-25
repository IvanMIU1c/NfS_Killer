package com.example.racergame;

import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Road {
    Pane pane = new Pane();
    Rectangle asphalt;
    ArrayList<Rectangle> markup = new ArrayList<>();
    Scene scene;
    int number;
    Road(Scene scene, Pane pane, int number){
        this.scene = scene;
        this.number=number;
        scene.setFill(AppSettings.SINGLETON.getColor("Grass"));
        pane.setBackground(Background.fill(AppSettings.SINGLETON.getColor("Grass")));
        asphalt = new Rectangle(scene.getWidth()*0.7,scene.getHeight());
        pane.getChildren().add(asphalt);
        asphalt.setFill(AppSettings.SINGLETON.getColor("Asphalt"));
        asphalt.setLayoutX(scene.getWidth()/2-asphalt.getWidth()/2);
        for(int j=0;j<number-1;j++) {
            for (int i = 0; i < 5; i++) {
                markup.add(new Rectangle(asphalt.getWidth()/number*0.05, 130));
                markup.get(j*5+i).setLayoutY(i * scene.getHeight() / 4);
                markup.get(j*5+i).setLayoutX(asphalt.getLayoutX()+asphalt.getWidth()*(j+1)/number-markup.get(j*5+i).getWidth()/2);
                markup.get(j*5+i).setFill(AppSettings.SINGLETON.getColor("Markup"));
                pane.getChildren().add(markup.get(j*5+i));
            }
        }
    }

    public void move(double speed){
        for(int j=0;j<number-1;j++) {
            for (int i = 0; i < 5; i++) {
                markup.get(j*5+i).setLayoutY(markup.get(j*5+i).getLayoutY()+speed);
                if(markup.get(j*5+i).getLayoutY()>=scene.getHeight()+scene.getHeight()/4-markup.get(j*5+i).getHeight()){
                    markup.get(j*5+i).setLayoutY(-markup.get(j*5+i).getHeight());
                }
            }
        }
    }

}
