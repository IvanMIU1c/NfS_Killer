package com.example.racergame;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Objects;
import java.util.Random;

public class Car {
    ImageView car;
    static Random random = new Random();
    Scene scene;
    Road road;
    double speed;
    Car(Image carImage, Road road, Scene scene, Pane pane) {
        car = new ImageView();
        pane.getChildren().add(car);
        car.setImage(carImage);
        this.road = road;
        car.setFitWidth(158*0.5);
        car.setFitHeight(326*0.5);
        this.spawn();
    }

    void spawn(){
        int i = random.nextInt(road.number);
        car.setLayoutX(road.asphalt.getLayoutX() + i*road.asphalt.getWidth()/road.number + road.asphalt.getWidth()/(road.number*2) - car.getFitWidth()/2);
        car.setLayoutY(-random.nextInt(500)-car.getFitHeight());
        this.speed=random.nextDouble(8,15);
    }

    void move(){
        car.setLayoutY(car.getLayoutY()+speed);
        if (car.getLayoutY()>road.asphalt.getHeight()){
            this.spawn();
        }
    }




}
