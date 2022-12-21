package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;



public class MainMenu implements Screen {


    private TankStarGame game;

    private Buttons play,load,exit;
    private Texture sky,ground,tank,logo;
    private final float px,py,lx,ly,ex,ey,h,w,gap;
    // private BitmapFont black,white;

    MainMenu(TankStarGame game){
        this.game=game;
        h=100;
        w=200;
        gap=15;
        py=Gdx.graphics.getHeight()/2-h-75;
        ly=py-h-gap;
        ey=ly-h-gap;
        px=ex=lx=Gdx.graphics.getWidth()/2-w/2;

    }
    @Override
    public void show() {

        play=new Buttons(new Texture("button/play1.png"),new Texture("button/play2.png"),px,py,h,w);
        load=new Buttons(new Texture("button/load1.png"),new Texture("button/load2.png"),lx,ly,h,w);
        exit=new Buttons(new Texture("button/exit1.png"),new Texture("button/exit2.png"),ex,ey,h,w);


        sky=new Texture("images/sky.png");
        ground=new Texture("images/ground.png");
        tank=new Texture("images/Blazer.png");
        logo=new Texture("button/logo.png");




    }

    @Override
    public void render(float delta) {


        Gdx.gl.glClearColor(0.3f,0.2f,0.1f,0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();

        game.getBatch().draw(sky,0,Gdx.graphics.getHeight()/2,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/2);
        game.getBatch().draw(ground,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/2);
        game.getBatch().draw(tank,1000,Gdx.graphics.getHeight()/2,200,100);
        play.draw(game);
        exit.draw(game);
        load.draw(game);
        game.getBatch().draw(logo,Gdx.graphics.getWidth()/2-200,Gdx.graphics.getHeight()-200,400,200);

        if(exit.isButtonPressed()){
            this.dispose();
            game.dispose();
            return;

        }
        if(play.isButtonPressed()){

            game.setScreen(new TankScreen(game));
            this.dispose();

        }
        if(load.isButtonPressed()){

            this.dispose();
            game.setScreen(new LoadScreen(game));

        }
        game.getBatch().end();

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



    }
}
