package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Bullet {
    private float x,y;
    private boolean isDestroyed;
    private float radius=8;
    private double velocityX, velocityY;
    private double velocity;
    private double angle;
    private double power;
    private float gravity;
    private float t;

    public Bullet(float x, float y, double angle, float power) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.power = power;
        this.velocity=138;
        this.gravity=-10.0f;
        this.t=0;
        this.isDestroyed=false;
        System.out.println("bullet x: "+x);
        System.out.println("y "+y );

    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public float getRadius() {
        return radius;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getAngle() {
        return angle;
    }

    public double getPower() {
        return power;
    }

    public float getGravity() {
        return gravity;
    }

    public float getT() {
        return t;
    }

    public void create(ShapeRenderer shape){
//        ShapeRenderer shape=new ShapeRenderer();
//        shape.begin();
        shape.setColor(Color.VIOLET);
        shape.circle(x,y,radius);

        //shape.dispose();

    }

    public void update(){
        t+= Gdx.graphics.getDeltaTime()*10;
        velocityX=velocity*power*Math.cos(Math.toRadians(angle));
        velocityY=velocity*power*Math.sin(Math.toRadians(angle));
        x+=(float)(velocityX*t);
        y+=(float)(velocityY*t+(0.5*gravity*t*t));
    }
}