package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.io.IOException;

public class SaveScreen implements Screen {
    private TankStarGame game;
    private Texture sky,logo;
    private Buttons b1,b2,b3;
    private Container container;



    public SaveScreen(TankStarGame game,Container c) {
        this.game = game;
        container=c;

    }

    @Override
    public void show() {
        b1=new Buttons(new Texture("button/savegame11.png"),new Texture("button/savegame12.png"),Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/2+70,100,200);
        b2=new Buttons(new Texture("button/savegame21.png"),new Texture("button/savegame22.png"),Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/2-50,100,200);
        b3=new Buttons(new Texture("button/savegame31.png"),new Texture("button/savegame32.png"),Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/2-170,100,200);

        sky=new Texture(Gdx.files.internal("images/sky.png"));
        logo=new Texture("button/logo.png");

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f,0.2f,0.1f,0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(sky,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        b1.draw(game);
        b2.draw(game);
        b3.draw(game);
        game.getBatch().draw(logo,Gdx.graphics.getWidth()/2-200,Gdx.graphics.getHeight()-200,400,200);
        float tx=Gdx.graphics.getWidth()/2;
        float ty=Gdx.graphics.getHeight()/2;
        if(b1.isButtonPressed()){
            try {
                SaveGame.serialize(container,1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            game.setScreen(new MainMenu(game));
        }
        if(b2.isButtonPressed()){
            try {
                SaveGame.serialize(container,2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            game.setScreen(new MainMenu(game));
        }
        if(b3.isButtonPressed()){
            try {
                SaveGame.serialize(container,3);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            game.setScreen(new MainMenu(game));
        }


        game.getBatch().end();
        // System.out.println("loadscreen");

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

        logo.dispose();

    }
}
