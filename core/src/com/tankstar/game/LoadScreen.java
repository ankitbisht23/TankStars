package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class LoadScreen implements Screen {
    private TankStarGame game;
    private Texture b1,b2,b3,sky,logo;


    public LoadScreen(TankStarGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        b1=new Texture(Gdx.files.internal("button/loadgame11.png"));
        b2=new Texture(Gdx.files.internal("button/loadgame21.png"));
        b3=new Texture(Gdx.files.internal("button/loadgame31.png"));
        sky=new Texture(Gdx.files.internal("images/sky.png"));
        logo=new Texture("button/logo.png");

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f,0.2f,0.1f,0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(sky,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.getBatch().draw(b1,Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/2+70,200,100);
        game.getBatch().draw(b2,Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/2-50,200,100);
        game.getBatch().draw(b3,Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/2-170,200,100);
        game.getBatch().draw(logo,Gdx.graphics.getWidth()/2-200,Gdx.graphics.getHeight()-200,400,200);
        float tx=Gdx.graphics.getWidth()/2;
        float ty=Gdx.graphics.getHeight()/2;
        if(isButtonPressed(tx-100,ty+70)||isButtonPressed(tx-100,ty-50)||isButtonPressed(tx-100,ty-170)){
            game.setScreen(new GameScreen(game));
            this.dispose();
        }
        game.getBatch().end();
        System.out.println("loadscreen");

    }
    public boolean isButtonPressed(float x,float y){
        float mouseX=Gdx.input.getX();
        float mouseY=Gdx.graphics.getHeight()-Gdx.input.getY();
        if(mouseX>=x && mouseX<=x+200 && mouseY>=y && mouseY<=y+100){
            if(Gdx.input.isTouched())
                return true;
        }
        return false;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        b1.dispose();
        b2.dispose();
        b3.dispose();
        logo.dispose();

    }
}
