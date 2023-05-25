package com.example.racergame;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class Racer {
    private ImageView racerView;
    private ImageView nitroView;

    Scene scene;
    Racer(Scene scene, Pane pane){
        this.scene = scene;
        racerView = new ImageView();
        nitroView = new ImageView();
        pane.getChildren().add(nitroView);
        pane.getChildren().add(racerView);
        racerView.setImage(AppSettings.SINGLETON.racerImg);
        nitroView.setImage(AppSettings.SINGLETON.nitroImg);
        racerView.setFitWidth(158*0.5);
        racerView.setFitHeight(326*0.5);
        racerView.setLayoutX(scene.getWidth()/2-racerView.getFitWidth()/2);
        racerView.setLayoutY(scene.getHeight()*0.6);
        nitroView.setFitWidth(360*0.3);
        nitroView.setFitHeight(400*0.3);
    }
    void moveY(double relSpeed){
        if (((racerView.getLayoutY()<=scene.getHeight()-racerView.getFitHeight())&&
                (racerView.getLayoutY()>=0))||
                (Math.abs(racerView.getLayoutY()-scene.getHeight()/2)>Math.abs(racerView.getLayoutY()-scene.getHeight()/2+relSpeed))){
            racerView.setLayoutY(racerView.getLayoutY()+relSpeed);
            placeNitro();
        }
        if (relSpeed<0){
            nitroView.setVisible(true);
        }
    }
    void moveX(double speed, Road road){
        if (((racerView.getLayoutX()>=road.asphalt.getLayoutX())&&
                (racerView.getLayoutX()<=road.asphalt.getLayoutX()+road.asphalt.getWidth()-racerView.getFitWidth()))||
                (Math.abs(racerView.getLayoutX()-scene.getWidth()/2)>Math.abs(racerView.getLayoutX()-scene.getWidth()/2+speed))){
            racerView.setLayoutX(racerView.getLayoutX()+speed);
            placeNitro();
        }
    }
    void stopNitro(){
        nitroView.setVisible(false);
    }

    void placeNitro(){
        nitroView.setLayoutX(racerView.getLayoutX()+racerView.getFitWidth()/2-nitroView.getFitWidth()/2);
        nitroView.setLayoutY(racerView.getLayoutY()+racerView.getFitHeight()*0.8);
    }

    double getX(){
        return racerView.getLayoutX();
    }
    double getY(){
        return racerView.getLayoutY();
    }

}
