package com.example.racergame;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Objects;

public class CarTraffic {
    ArrayList<Car> carTraffic = new ArrayList<>();

    CarTraffic(Scene scene, Pane pane, Road road, int number) {
        for (int i = 0; i < number; i++) {
            carTraffic.add(new Car(AppSettings.SINGLETON.traffic1Img, road, scene, pane));
        }
    }
    void move(){
        for(int i=0;i<carTraffic.size();i++){
            carTraffic.get(i).move();
            for(int j=i+1;j<carTraffic.size();j++){

                if (carTraffic.get(i).car.getLayoutX()==carTraffic.get(j).car.getLayoutX()){
                    if ((Math.abs(carTraffic.get(i).car.getLayoutY()-carTraffic.get(j).car.getLayoutY())<
                            carTraffic.get(i).car.getFitHeight()+50)){
                        if(carTraffic.get(i).car.getLayoutY()<carTraffic.get(j).car.getLayoutY()) {
                            carTraffic.get(i).car.setLayoutY(carTraffic.get(j).car.getLayoutY() - carTraffic.get(i).car.getFitHeight() - 50);
                            carTraffic.get(i).speed = carTraffic.get(j).speed;
                        }
                        else{
                            carTraffic.get(j).car.setLayoutY(carTraffic.get(i).car.getLayoutY() - carTraffic.get(j).car.getFitHeight() - 50);
                            carTraffic.get(j).speed = carTraffic.get(i).speed;
                        }
                    }
                    if (Math.abs(carTraffic.get(i).car.getLayoutY() + carTraffic.get(i).car.getFitHeight()) - carTraffic.get(j).car.getLayoutY()<carTraffic.get(i).car.getFitHeight()){

                    }
                }
            }
        }
    }

    boolean isCrashed(double racerX, double racerY){
        for(int i=0;i<carTraffic.size();i++){
            if(Math.abs(carTraffic.get(i).car.getLayoutY()-racerY)<carTraffic.get(i).car.getFitHeight() &&
                    Math.abs(carTraffic.get(i).car.getLayoutX()-racerX)<carTraffic.get(i).car.getFitWidth()){
                return true;
            }
        }
        return false;
    }

}
