package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameScreen implements Screen {
    protected TankStarGame game;
    protected Container container;
    protected ShapeRenderer shape;
    protected GraphicDesign health1,health2,power;
    protected Texture sky,ground,health;
    protected Buttons pause;
    private Tank t1,t2;
    protected BitmapFont black;
    protected String s1,s2;
    protected float groundX,groundY,groundWidth,groundHeight,skyX,skyY,tankWidth,tankHeight,
            skyWidth,skyHeight,pauseX,pauseY,pauseWidth,pauseHeight;
    GameScreen(TankStarGame game,String s1,String s2){
        this.s1=s1;
        this.s2=s2;
        this.game=game;
        groundX=groundY=skyX=0;
        groundWidth=skyWidth=Gdx.graphics.getWidth();
        skyY=groundHeight=Gdx.graphics.getHeight()/3;
        skyHeight=Gdx.graphics.getHeight()-groundHeight;
        pauseX=Gdx.graphics.getWidth()-75;
        pauseY=Gdx.graphics.getHeight()-75;
        pauseHeight=pauseWidth=75;
        tankWidth=150;
        tankHeight=75;
        health1=new GraphicDesign(5,0,300,20);
        health2=new GraphicDesign(1030,0,980,20);
        power=new GraphicDesign(Gdx.graphics.getWidth()-105,Gdx.graphics.getHeight()/3-100,80,20);

    }


    public void show() {
        pause=new Buttons(new Texture("button/pause1.png"),new Texture("button/pause2.png"),pauseX,pauseY,pauseHeight,pauseWidth);
        // pauseActive=new Texture("button/pause2.png");
        sky=new Texture("images/sky.png");
        ground=new Texture("images/ground.png");
        // tank1=new Texture("images/Blazer.png");
        // tank2=new Texture("images/Mark1Rotated.png");
        health=new Texture("images/health.png");
        shape=new ShapeRenderer();
        //white = new BitmapFont(Gdx.files.internal("font/White.fnt"), false);
        black =new BitmapFont(Gdx.files.internal("font/Bold.fnt"),false);

        t1=new Tank(400,groundHeight-2,s1,1);
        t2=new Tank(groundWidth-500,groundHeight-2,s2,2);
        container=new Container(t1,t2);


    }


    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f,0.2f,0.1f,0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();

        game.getBatch().draw(sky,skyX,skyY,skyWidth,skyHeight);
        game.getBatch().draw(ground,groundX,groundY,groundWidth,groundHeight);
        pause.draw(game);

        container.update();

        game.getBatch().draw(t1.getTank(),t1.getX(),t1.getY(),t1.getTankwidth(),t1.getTankheight());
        game.getBatch().draw(t2.getTank(),t2.getX(),t2.getY(),t2.getTankwidth(),t2.getTankheight());
         container.printFont(game);
        black.draw(game.getBatch(), "Player 2 ",Gdx.graphics.getWidth()-205,Gdx.graphics.getHeight()/3-10);
        black.draw(game.getBatch(), "Player 1 ",60,Gdx.graphics.getHeight()/3-10);
        game.getBatch().end();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        if(container.getIsbullet()){
            container.updateBullet(shape);

        }
//
        container.printPower(shape);
        if(pause.isButtonPressed()){
            game.setScreen(new PauseScreen(game,container));

        }
        shape.end();


        if(t1.getTankhealth()==0 || t2.getTankhealth()==0){
            game.setScreen(new WinLoseScreen(game,container));
        }

    }



    public void resize(int width, int height) {

    }


    public void pause() {

    }


    public void resume() {

    }


    public void hide() {

    }


    public void dispose() {

        ground.dispose();

        black.dispose();


    }
}
