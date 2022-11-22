package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ButtonBackground {
    private float x,y,width,height;

    public ButtonBackground(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        System.out.println("construtor");

    }
    public void draw(ShapeRenderer shape,int i){
        if(i==1)
            shape.setColor(Color.GREEN);
        else if(i==2) shape.setColor(Color.RED);
        else shape.setColor(Color.ORANGE);
        shape.rect(x,y,width,height);

    }


}
