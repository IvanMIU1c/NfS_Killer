package com.example.racergame;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AppSettings {
    public static final AppSettings SINGLETON = new AppSettings();
    Image racerImg;
    Image nitroImg;
    Image traffic1Img;

    AppSettings() {
        colorMap = new HashMap<String, Color>();
        colorMap.put("Grass", Color.web("#197100",1)); //Зеленый
        colorMap.put("Sea", Color.web("#0047AB",1)); //Cиний
        colorMap.put("Asphalt", Color.web("#4A4A4A",1)); //Серый
        colorMap.put("Markup", Color.web("#B2B2B2",1)); //Грязнобелый
        colorMap.put("Crashed", Color.web("#9A0000",0.7)); //Красный
        racerImg = new Image(Objects.requireNonNull(this.getClass().getResource("racer.png")).toExternalForm());
        nitroImg = new Image(Objects.requireNonNull(this.getClass().getResource("nitro.png")).toExternalForm());
        traffic1Img = new Image(Objects.requireNonNull(this.getClass().getResource("traffic1.png")).toExternalForm());

    }
    private final HashMap<String, Color> colorMap;

    public HashMap<String, Color> getColorMap() {
        return colorMap;
    }
    public Color getColor(String colorName) {
        return this.colorMap.get(colorName);
    }
}

