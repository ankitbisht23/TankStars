package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import javax.xml.transform.Templates;

public class WinLoseScreen implements Screen {
    private TankStarGame game;
    private Container container;
    private Tank t;
    private String winner;
    private Texture screens,sky,ground;
    private Buttons restart,exit;
    private float groundX,groundY,groundWidth,groundHeight,skyX,skyY,
            skyWidth,skyHeight;
    BitmapFont black;

    public WinLoseScreen(TankStarGame game, Container container) {
        this.game = game;
        this.container = container;
    }


    @Override
    public void show() {
        groundX=groundY=skyX=0;
        groundWidth=skyWidth= Gdx.graphics.getWidth();
        skyY=groundHeight=Gdx.graphics.getHeight()/3;
        skyHeight=Gdx.graphics.getHeight()-groundHeight;
        restart=new Buttons(new Texture("button/restart1.png"),new Texture("button/restart2.png"),Gdx.graphics.getWidth()/2-130,Gdx.graphics.getHeight()/2-395,85,85 );
        exit=new Buttons(new Texture("button/exit1.png"),new Texture("button/exit2.png"),Gdx.graphics.getWidth()/2-40,Gdx.graphics.getHeight()/2-400,100,200 );

        screens=new Texture("button/winner.png");
        sky=new Texture("images/sky.png");
        ground=new Texture("images/ground.png");
        if(container.getT2().getTankhealth()==0){
            winner="Player 1";
            t=container.getT1();
        }
        else {
            winner = "Player 2";
            t=container.getT2();
        }
        black =new BitmapFont(Gdx.files.internal("font/Bold.fnt"),false);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f,0.2f,0.1f,0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();

        game.getBatch().draw(sky,skyX,skyY,skyWidth,skyHeight);
        game.getBatch().draw(ground,groundX,groundY,groundWidth,groundHeight);
        game.getBatch().draw(t.getTank(),t.getX(),t.getY(),t.getTankwidth(),t.getTankheight());
        game.getBatch().draw(screens,Gdx.graphics.getWidth()/2-200,Gdx.graphics.getHeight()/2-200,400,400);
        black.draw(game.getBatch(), winner+" Wins",Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/2-250);
        restart.draw(game);
        exit.draw(game);
        if(restart.isButtonPressed()){
            game.setScreen(new GameScreen(game,container.getT1().getType(),container.getT2().getType()));
        }
        if(exit.isButtonPressed()){
            game.setScreen(new MainMenu(game));
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