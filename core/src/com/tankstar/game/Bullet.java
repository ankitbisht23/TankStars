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
    private float tX,tY;
    private int player;

    public Bullet(float x, float y, double angle, float power,int p) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.power = power;
        this.velocity=138;
        this.gravity=-10.0f;
        this.t=0;
        this.player=p;
        this.isDestroyed=false;
        System.out.println("bullet x: "+x);
        System.out.println("y "+y );
        tX=tY=0;

    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public float getX() {
        return tX;
    }

    public float getY() {
        return tY;
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
        shape.circle(tX,tY,radius);

        //shape.dispose();

    }

    public void update(){
      if(player==1){
          t+= Gdx.graphics.getDeltaTime()*10;
          velocityX=velocity*power*Math.cos(Math.toRadians(angle));
          velocityY=velocity*power*Math.sin(Math.toRadians(angle));
          tX=x+(float)(velocityX*t);
          tY=y+(float)(velocityY*t+(0.5*gravity*t*t));
      }
      else{
          t+= Gdx.graphics.getDeltaTime()*10;
          velocityX=velocity*power*Math.cos(Math.toRadians(angle));
          velocityY=velocity*power*Math.sin(Math.toRadians(angle));
          tX=x-(float)(velocityX*t);
          tY=y+(float)(velocityY*t+(0.5*gravity*t*t));

      }
    }
}