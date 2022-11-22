package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;



public class MainMenu implements Screen {


    private TankStarGame game;

    private Texture playInactive,loadInactive,exitInactive,playActive,loadActive,exitActive,sky,ground,tank,logo;
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

        playInactive=new Texture("button/play1.png");
        loadInactive=new Texture("button/load1.png");
        exitInactive=new Texture("button/exit1.png");
        playActive=new Texture("button/play2.png");
        loadActive=new Texture("button/load2.png");
        exitActive=new Texture("button/exit2.png");
        sky=new Texture("images/sky.png");
        ground=new Texture("images/ground.png");
        tank=new Texture("images/Blazer.png");
        logo=new Texture("button/logo.png");


       // white =new BitmapFont(Gdx.files.internal("font/White.fnt"),false);
        //black =new BitmapFont(Gdx.files.internal("font/Bold.fnt"),false);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.3f,0.2f,0.1f,0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();

        game.getBatch().draw(sky,0,Gdx.graphics.getHeight()/2,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/2);
        game.getBatch().draw(ground,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/2);
        game.getBatch().draw(tank,1000,Gdx.graphics.getHeight()/2,200,100);
        game.getBatch().draw(playInactive,px,py,w,h);
        game.getBatch().draw(loadInactive,lx,ly,w,h);
        game.getBatch().draw(exitInactive,ex,ey,w,h);
        game.getBatch().draw(logo,Gdx.graphics.getWidth()/2-200,Gdx.graphics.getHeight()-200,400,200);
        if(isButtonHovered(px,py)){
            game.getBatch().draw(playActive,px,py,w,h);
        }
        if(isButtonHovered(lx,ly)){
            game.getBatch().draw(loadActive,lx,ly,w,h);
        }
        if(isButtonHovered(ex,ey)){
            game.getBatch().draw(exitActive,ex,ey,w,h);
        }
        if(isButtonPressed(ex,ey)){
            this.dispose();
            game.dispose();

        }
        if(isButtonPressed(px,py)){
            this.dispose();
            game.setScreen(new TankScreen(game));

        }
        if(isButtonPressed(lx,ly)){
            this.dispose();
            game.setScreen(new LoadScreen(game));

        }
        game.getBatch().end();
        System.out.println("mainmenu");
    }

    public boolean isButtonHovered(float x,float y){
        float mouseX=Gdx.input.getX();
        float mouseY=Gdx.graphics.getHeight()-Gdx.input.getY();
        if(mouseX>=x && mouseX<=x+w && mouseY>=y && mouseY<=y+h){
            return true;
        }
        return false;
    }
    public boolean isButtonPressed(float x,float y){
        float mouseX=Gdx.input.getX();
        float mouseY=Gdx.graphics.getHeight()-Gdx.input.getY();
        if(mouseX>=x && mouseX<=x+w && mouseY>=y && mouseY<=y+h){
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
        playInactive.dispose();
        playActive.dispose();
        loadInactive.dispose();
        loadActive.dispose();
        exitInactive.dispose();
        exitActive.dispose();



    }
}
