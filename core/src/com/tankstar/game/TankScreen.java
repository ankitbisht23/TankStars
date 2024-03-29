package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TankScreen implements Screen {

    private TankStarGame game;

    private String s1,s2;
    private int choose;

    private Texture sky,ground,tank1,tank2,tank3;
    private BitmapFont white;


    TankScreen(TankStarGame game){
        this.game=game;


    }

    @Override
    public void show() {
        ground=new Texture("images/ground.png");
        sky=new Texture("images/sky.png");
        tank1=new Texture("images/Mark1.png");
        tank2=new Texture("images/Blazer.png");
        tank3=new Texture("images/Buratino.png");
        white=new BitmapFont(Gdx.files.internal("font/Bold.fnt"),false);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f,0.2f,0.1f,0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(ground,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/2);
        game.getBatch().draw(sky,0,Gdx.graphics.getHeight()/2,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/2);
        game.getBatch().draw(tank1,200,Gdx.graphics.getHeight()/2,200,100);
        game.getBatch().draw(tank2,900,Gdx.graphics.getHeight()/2,200,100);
        game.getBatch().draw(tank3,1600,Gdx.graphics.getHeight()/2,200,100);
        white.draw(game.getBatch(), "Mark1",250,Gdx.graphics.getHeight()/2-40);
        white.draw(game.getBatch(), "Blazer",950,Gdx.graphics.getHeight()/2-40);
        white.draw(game.getBatch(), "Buratino",1650,Gdx.graphics.getHeight()/2-40);

        if(choose==0)
            white.draw(game.getBatch(), "Choose Tank for Player 1",850,Gdx.graphics.getHeight()/3);
       else
            white.draw(game.getBatch(), "Choose Tank for Player 2",850,Gdx.graphics.getHeight()/3);

        if(isButtonPressed(200,Gdx.graphics.getHeight()/2)){
            if(choose==0){
                s1="Mark1";
            }
            if(choose==1){
                s2="Mark1";
            }
            choose++;
        }
        if(isButtonPressed(900,Gdx.graphics.getHeight()/2)){
            if(choose==0){
                s1="Blazer";
            }
            if(choose==1){
                s2="Blazer";
            }
            choose++;

        }
        if(isButtonPressed(1600,Gdx.graphics.getHeight()/2)){
            if(choose==0){
                s1="Buratino";
            }
            if(choose==1){
                s2="Buratino";
            }
            choose++;

        }
        if(choose==2){

            game.setScreen(new GameScreen(game,s1,s2));
            this.dispose();
        }

        game.getBatch().end();
       // System.out.println("tankscreen");


    }
    public boolean isButtonPressed(float x,float y){
        float mouseX=Gdx.input.getX();
        float mouseY=Gdx.graphics.getHeight()-Gdx.input.getY();
        if(mouseX>=x && mouseX<=x+200 && mouseY>=y && mouseY<=y+100){
            if(Gdx.input.justTouched())
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
        sky.dispose();
        ground.dispose();
        white.dispose();
        tank1.dispose();
        tank2.dispose();
        tank3.dispose();

    }
}
