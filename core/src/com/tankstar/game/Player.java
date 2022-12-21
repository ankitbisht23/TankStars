package com.tankstar.game;
// Templete for players
public abstract class Player {
    public abstract void changePower();
    public abstract void changeAngle();
    public abstract void changePosition();
    public void update(){
        changePosition();
        changePower();
        changeAngle();


    }
}
