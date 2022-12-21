package com.tankstar.game;


import java.io.Serializable;

public class TankState implements Serializable {
    private float Tank1X,Tank2X,Tank1Y,Tank2Y,Tank1health,Tank2Health;
    private String type1,type2;
    private int turn;

    public TankState(float tank1X, float tank2X, float tank1Y, float tank2Y, float tank1health, float tank2Health, String type1, String type2, int turn) {
        Tank1X = tank1X;
        Tank2X = tank2X;
        Tank1Y = tank1Y;
        Tank2Y = tank2Y;
        Tank1health = tank1health;
        Tank2Health = tank2Health;
        this.type1 = type1;
        this.type2 = type2;
        this.turn = turn;
    }

    public float getTank1X() {
        return Tank1X;
    }

    public float getTank2X() {
        return Tank2X;
    }

    public float getTank1Y() {
        return Tank1Y;
    }

    public float getTank2Y() {
        return Tank2Y;
    }

    public float getTank1health() {
        return Tank1health;
    }

    public float getTank2Health() {
        return Tank2Health;
    }


    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public int getTurn() {
        return turn;
    }
}
