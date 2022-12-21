package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ResumeScreen extends GameScreen implements Screen  {

    private Container container;

    private Tank t1,t2;

    ResumeScreen(TankStarGame game,Container container){

        super(game,container.getT1().getType(),container.getT2().getType());

        this.container=container;

    }
    @Override
    public void show(){
       super.show();
        t1=container.getT1();
        t2=container.getT2();

    }

    @Override
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

        container.printPower(shape);
        if(pause.isButtonPressed()){
            game.setScreen(new PauseScreen(game,container));
            //this.dispose();
        }
        shape.end();

        if(t1.getTankhealth()==0 || t2.getTankhealth()==0){
            game.setScreen(new WinLoseScreen(game,container));
        }
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