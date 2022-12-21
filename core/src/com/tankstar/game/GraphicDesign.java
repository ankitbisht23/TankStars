package com.tankstar.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GraphicDesign {
    private float x,y,width,height,MAX_WIDTH;

    public GraphicDesign(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.MAX_WIDTH=width;
      //  System.out.println("construtor");

    }
    public void draw(ShapeRenderer shape){
        if(width>=(MAX_WIDTH/2))
            shape.setColor(Color.GREEN);
        else if(width>=((3*MAX_WIDTH)/10)) shape.setColor(Color.ORANGE);
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
        this.width= width;

        if(this.width>MAX_WIDTH){
            this.width=MAX_WIDTH;

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
