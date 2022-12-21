package com.tankstar.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import jdk.javadoc.internal.doclets.toolkit.PropertyUtils;

public class Tank{

    private boolean isfire;
    private float x;
    private float y;

    private float tankwidth;
    private float tankheight;
    private float tankhealth;
    private float angle,power;
    private String type;
    private int player;
    private Texture tank;

    public Tank(float x, float y,String type,int player) {
        this.x = x;
        this.y = y;
        this.tankwidth = 150;
        this.tankheight = 75;
        this.tankhealth = 980;
        this.type=type;
        this.player=player;
        this.isfire=false;
        this.create();
        this.power=0.5f;
        this.angle=45;



    }
    public void create(){
        if(type.equals("Mark1")) {
            if(player==1)
                tank = new Texture("images/Mark1.png");
            else
                tank = new Texture("images/Mark1Rotated.png");
        }
        else if(type.equals("Blazer")) {
            if(player==1)
                tank = new Texture("images/Blazer.png");
            else
                tank = new Texture("images/BlazerRotated.png");
        }
        else if(type.equals("Buratino")) {
            if(player==1)
                tank = new Texture("images/Buratino.png");
            else
                tank = new Texture("images/BuratinoRotated.png");
        }

    }

    public void update(){


            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                x=x-5;
            }
            if((Gdx.input.isKeyPressed(Input.Keys.RIGHT))){
                x=x+5;
            }
            if(x<0){
                x=0;
            }
            if(x>Gdx.graphics.getWidth()-tankwidth){
                x=Gdx.graphics.getWidth()-tankwidth;
            }




    }
    public void iscollide(Bullet bullet){
        if((x<=bullet.getX() && bullet.getX()<=tankwidth+x) &&(y<=bullet.getY() && bullet.getY()<=y+tankheight)){
            tankhealth-=0.3;
            bullet.setDestroyed(true);
        }


    }

    public boolean isIsfire() {
        return isfire;
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getTankwidth() {
        return tankwidth;
    }

    public float getTankheight() {
        return tankheight;
    }

    public float getTankhealth() {
        return tankhealth;
    }

    public String getType() {
        return type;
    }

    public int getPlayer() {
        return player;
    }

    public Texture getTank() {
        return tank;
    }

    public void fire(){


    }
    public void setX(float x){
        this.x=x;
    }

    public float getAngle() {
        return angle;
    }

    public float getPower() {
        return power;
    }

    public void setTankhealth(float tankhealth) {
        this.tankhealth= tankhealth;
    }

    public void setAngle(float a) {

        this.angle= a;
        if(angle>180){
            angle=180;
        }
        if(angle<0){
            angle=0;
        }

    }

    public void setPower(float power) {
        this.power= power;
    }
}