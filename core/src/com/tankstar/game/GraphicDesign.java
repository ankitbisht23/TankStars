package com.tankstar.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GraphicDesign {
    private float x,y,width,height;

    public GraphicDesign(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
      //  System.out.println("construtor");

    }
    public void draw(ShapeRenderer shape){
        if(width>=50)
            shape.setColor(Color.GREEN);
        else if(width>=30) shape.setColor(Color.ORANGE);
        else shape.setColor(Color.RED);
        shape.rect(x,y,width,height);

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width+= width;

        if(this.width>100){
            this.width=100;

        }
        if(this.width<0){
           this.width=0;
        }
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
