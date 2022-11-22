package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameScreen implements Screen {
    private TankStarGame game;
    private ShapeRenderer shape;
    private ButtonBackground health1,health2,power;
    private Texture pauseInactive,pauseActive,sky,ground,tank1,tank2,health;
    private BitmapFont black;
    private float groundX,groundY,groundWidth,groundHeight,skyX,skyY,tankWidth,tankHeight,
                skyWidth,skyHeight,pauseX,pauseY,pauseWidth,pauseHeight;
    GameScreen(TankStarGame game){
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
        health1=new ButtonBackground(5,0,300,20);
        health2=new ButtonBackground(1030,0,980,20);
        power=new ButtonBackground(Gdx.graphics.getWidth()-105,Gdx.graphics.getHeight()/3-100,80,20);

    }


    public void show() {
        pauseInactive=new Texture("button/pause1.png");
       // pauseActive=new Texture("button/pause2.png");
        sky=new Texture("images/sky.png");
        ground=new Texture("images/ground.png");
        tank1=new Texture("images/Blazer.png");
        tank2=new Texture("images/Mark1Rotated.png");
        health=new Texture("images/health.png");
        shape=new ShapeRenderer();
        //white = new BitmapFont(Gdx.files.internal("font/White.fnt"), false);
        black =new BitmapFont(Gdx.files.internal("font/Bold.fnt"),false);


    }


    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f,0.2f,0.1f,0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();

        game.getBatch().draw(sky,skyX,skyY,skyWidth,skyHeight);
        game.getBatch().draw(ground,groundX,groundY,groundWidth,groundHeight);
        game.getBatch().draw(pauseInactive,pauseX,pauseY,pauseWidth,pauseHeight);
        game.getBatch().draw(tank1,400,groundHeight-2,tankWidth,tankHeight);
        game.getBatch().draw(tank2,groundWidth-500,groundHeight-2,tankWidth,tankHeight);
        game.getBatch().draw(health,5,0,980,20);
        game.getBatch().draw(health,1010,0,980,20);
        game.getBatch().draw(health,Gdx.graphics.getWidth()-105,Gdx.graphics.getHeight()/3-100,100,20);
        black.draw(game.getBatch(), "Power ",Gdx.graphics.getWidth()-205,Gdx.graphics.getHeight()/3-80);
        black.draw(game.getBatch(), "Angle  50",Gdx.graphics.getWidth()-205,Gdx.graphics.getHeight()/3-110);
        black.draw(game.getBatch(), "Player 2 turn ",Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/4);
        black.draw(game.getBatch(), "Player 2 ",Gdx.graphics.getWidth()-205,Gdx.graphics.getHeight()/3-10);
        black.draw(game.getBatch(), "Player 1 ",60,Gdx.graphics.getHeight()/3-10);
        game.getBatch().end();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        health1.draw(shape,2);
        health2.draw(shape,1);
        power.draw(shape,1);
        if(isButtonPressed(pauseX,pauseY)){
            game.setScreen(new PauseScreen(game));
            this.dispose();
        }
        shape.end();
        System.out.println("gamescreen");


    }
    public boolean isButtonPressed(float x,float y){
        float mouseX=Gdx.input.getX();
        float mouseY=Gdx.graphics.getHeight()-Gdx.input.getY();
        if(mouseX>=x && mouseX<=x+pauseWidth && mouseY>=y && mouseY<=y+pauseHeight){
            if(Gdx.input.isTouched())
                return true;
        }
        return false;
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
        pauseInactive.dispose();
        sky.dispose();
        ground.dispose();
        shape.dispose();
        tank1.dispose();
        tank2.dispose();
        black.dispose();
        health.dispose();

    }
}
