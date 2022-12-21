package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Buttons {
    private Texture active,inActive;
    private float x,y,height,width;

    public Buttons(Texture inActive, Texture active, float x, float y, float height, float width) {
        this.inActive = inActive;
        this.active = active;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    public void draw(TankStarGame game){
        if(isButtonHovered()){
            game.getBatch().draw(active,x,y,width,height);
        }
        else {
            game.getBatch().draw(inActive,x,y,width,height);
        }
    }
    public boolean isButtonHovered(){
        float mouseX= Gdx.input.getX();
        float mouseY=Gdx.graphics.getHeight()-Gdx.input.getY();
        if(mouseX>=x && mouseX<=x+width && mouseY>=y && mouseY<=y+height){
            return true;
        }
        return false;
    }
    public boolean isButtonPressed(){
        float mouseX=Gdx.input.getX();
        float mouseY=Gdx.graphics.getHeight()-Gdx.input.getY();
        if(mouseX>=x && mouseX<=x+width && mouseY>=y && mouseY<=y+height){
            if(Gdx.input.justTouched())
                return true;
        }
        return false;
    }
}
