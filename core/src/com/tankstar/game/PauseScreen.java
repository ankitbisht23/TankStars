package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PauseScreen implements Screen {
    private TankStarGame game;
    private ShapeRenderer shape;
    private GraphicDesign health1,health2;
    private Texture sky,ground,tank1,tank2,health;
    private Buttons resume,save,restart,exit;

    private float groundX,groundY,groundWidth,groundHeight,skyX,skyY,tankWidth,tankHeight,
            skyWidth,skyHeight,pauseX,pauseY,pauseWidth,pauseHeight;
    private Container container;
    private Tank t1,t2;
    PauseScreen(TankStarGame game,Container c){
        this.game=game;
        this.container=c;
        groundX=groundY=skyX=0;
        groundWidth=skyWidth=Gdx.graphics.getWidth();
        skyY=groundHeight=Gdx.graphics.getHeight()/3;
        skyHeight=Gdx.graphics.getHeight()-groundHeight;
        pauseX=Gdx.graphics.getWidth()-75;
        pauseY=Gdx.graphics.getHeight()-75;
        pauseHeight=pauseWidth=75;
        tankWidth=150;
        tankHeight=75;
        health1=new GraphicDesign(5,0,700,20);
        health2=new GraphicDesign(1200,0,980,20);
        this.t1=container.getT1();
        this.t2=container.getT2();
    }

    @Override
    public void show() {
        restart=new Buttons(new Texture("button/restart1.png"),new Texture("button/restart2.png"),Gdx.graphics.getWidth()/2+3,Gdx.graphics.getHeight()/2-85,85,85 );
        resume=new Buttons(new Texture("button/resume1.png"),new Texture("button/resume2.png"),Gdx.graphics.getWidth()/2-88,Gdx.graphics.getHeight()/2-85,85,85 );
        save=new Buttons(new Texture("button/save1.png"),new Texture("button/save2.png"),Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/2-185,100,200 );
        exit=new Buttons(new Texture("button/exit1.png"),new Texture("button/exit2.png"),Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/2-285,100,200 );


        sky=new Texture("images/sky.png");

        ground=new Texture("images/ground.png");
        tank1=new Texture("images/Buratino.png");
        tank2=new Texture("images/Mark1Rotated.png");
        health=new Texture("images/health.png");
        shape=new ShapeRenderer();


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f,0.2f,0.1f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        Texture bb=t1.getTank();

        game.getBatch().draw(sky,skyX,skyY,skyWidth,skyHeight);
        game.getBatch().draw(ground,groundX,groundY,groundWidth,groundHeight);
        game.getBatch().draw(t1.getTank(), t1.getX(),t1.getY(),t1.getTankwidth(),t1.getTankheight());
        game.getBatch().draw(t2.getTank(),t2.getX(),t2.getY(),t2.getTankwidth(),t2.getTankheight());
        container.printFont(game);

      //  game.getBatch().draw(tank1,300,groundHeight-2,tankWidth,tankHeight);
        //game.getBatch().draw(tank2,groundWidth-900,groundHeight-2,tankWidth,tankHeight);
        //game.getBatch().draw(health,5,0,980,20);
      //  game.getBatch().draw(health,1010,0,980,20);
        save.draw(game);
        exit.draw(game);
        resume.draw(game);
        restart.draw(game);
        game.getBatch().end();
        shape.begin(ShapeRenderer.ShapeType.Filled);
       container.printPower(shape);


        if(exit.isButtonPressed()){
          //  System.out.println("exit");
            game.setScreen(new MainMenu(game));
        }
        if(restart.isButtonPressed()){
         //   System.out.println("exit");
            game.setScreen(new GameScreen(game,t1.getType(),t2.getType()));
        }
        if(resume.isButtonPressed()){
            //System.out.println("exit");
            game.setScreen(new ResumeScreen(game,container));
        }
        if(save.isButtonPressed()){
            System.out.println("exit");
            game.setScreen(new MainMenu(game));
        }



        shape.end();
       // System.out.println("pausescreen");


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
        health.dispose();
      //  shape.dispose();
        tank1.dispose();
        tank2.dispose();

    }
}
