package com.example.racergame;

public class Vars {
    boolean pressed = false;
    Vars(){
        pressed=false;
    }
    void pressed(){
        this.pressed=true;
    }
    boolean isPressed(){
        return this.pressed;
    }
    void released(){
        this.pressed=false;
    }
}
