package com.tankstar.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Container {
    private Tank t1,t2;
    private Texture health;
    private BitmapFont black;
    private boolean isbullet;
    private Bullet bullet;
    private int turn;
    private GraphicDesign power1,power2;

    public Container(Tank t1, Tank t2) {
        this.t1 = t1;
        this.t2 = t2;
        this.bullet = null;
        this.turn=0;
        this.isbullet=false;
        black =new BitmapFont(Gdx.files.internal("font/Bold.fnt"),false);
        health=new Texture("images/health.png");
        power2=new GraphicDesign(Gdx.graphics.getWidth()-105,Gdx.graphics.getHeight()/3-100,100,20);
        power1=new GraphicDesign(110,Gdx.graphics.getHeight()/3-100,30,20);
    }
    public void changePower(){
        if(turn==0){
            if(Gdx.input.isKeyPressed(Input.Keys.Z)){
                power1.setWidth(-1);

            }
            if(Gdx.input.isKeyPressed(Input.Keys.A)){
                power1.setWidth(1);

            }
            float temp= power1.getWidth()/100;
            t1.setPower(temp);

        }
        else {
            if(Gdx.input.isKeyPressed(Input.Keys.Z)){
                power2.setWidth(-1);

            }
            if(Gdx.input.isKeyPressed(Input.Keys.A)){
                power2.setWidth(1);

            }
            float temp= power2.getWidth()/100;
            t2.setPower(temp);
        }
    }
    public void changeAngle(){
        if(turn==0){
            if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
               t1.setAngle(t1.getAngle()-1);
                System.out.println("1");

            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
                t1.setAngle(t1.getAngle()+1);
                System.out.println("2");

            }


        }
        else {
            if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
                t2.setAngle(t2.getAngle()-1f);

            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
                t2.setAngle(t2.getAngle()+1);

            }
            float temp= power2.getWidth()/100;
            t2.setPower(temp);
        }
    }

    public void update() {
        changePower();
        changeAngle();
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && bullet==null) {

           // tankcollision();
            if(turn==0) {
                bullet = new Bullet(t1.getX()+2*t1.getTankwidth()/3, t1.getY()+t1.getTankheight()-4, t1.getAngle(), t1.getPower(),1);
                System.out.println("t1 x: "+t1.getX());
                isbullet = true;
                System.out.println("bullet");
            }
            else {
                bullet = new Bullet(t2.getX()+t2.getTankwidth()/3, t2.getY()+t2.getTankheight()-4, t2.getAngle(), t2.getPower(),2);
                isbullet=true;
            }
            turn=(turn+1)%2;
            System.out.println(turn);

        }
        if(bullet!=null){
          bullet.update();
        }
        else {
            if (turn == 0)
                t1.update();
            else
                t2.update();
            tankcollision();
        }



    }
    public void printPower(ShapeRenderer shape){
        if(turn==0){
            power1.draw(shape);
        }
        else {
            power2.draw(shape);
        }

    }
    public void printFont(TankStarGame game){
        if(turn==0){
            game.getBatch().draw(health,110,Gdx.graphics.getHeight()/3-100,100,20);
            black.draw(game.getBatch(), "Power ",10,Gdx.graphics.getHeight()/3-80);
            black.draw(game.getBatch(), "Angle  "+t1.getAngle(),10,Gdx.graphics.getHeight()/3-110);
            black.draw(game.getBatch(), "Player 1 turn ",Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/4);
        }
        else {
            game.getBatch().draw(health,Gdx.graphics.getWidth()-105,Gdx.graphics.getHeight()/3-100,100,20);
            black.draw(game.getBatch(), "Power ",Gdx.graphics.getWidth()-205,Gdx.graphics.getHeight()/3-80);
            black.draw(game.getBatch(), "Angle  "+t2.getAngle(),Gdx.graphics.getWidth()-205,Gdx.graphics.getHeight()/3-110);
            black.draw(game.getBatch(), "Player 2 turn ",Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/4);
        }

    }
    public void updateBullet(ShapeRenderer shapeRenderer){
//        bullet=new Bullet(t1.getX(),t1.getY(),t1.getAngle(),t1.getPower());

        this.bullet.create(shapeRenderer);
       destroyBullet();
//        this.bullet.update();
    }
    public void destroyBullet(){
        if(turn==0) {
            if (t1.getX() <= bullet.getX() && (t1.getX() + t1.getTankwidth() >= bullet.getX()) && t1.getY() + t1.getTankheight() >= bullet.getY()) {
                this.bullet = null;
                this.isbullet = false;
                System.out.println("by 1");
            }
        }
        else {
            if (t2.getX() <= bullet.getX() && (t2.getX() + t2.getTankwidth() >= bullet.getX()) && t2.getY() + t2.getTankheight() >= bullet.getY()) {
                this.bullet = null;
                this.isbullet = false;
                System.out.println("by 2");
            }
        }
         if(bullet!=null && bullet.getY()<Gdx.graphics.getHeight()/3){
            this.bullet=null;
            this.isbullet=false;
             System.out.println("by 3");
        }


    }
    public void tankcollision(){
        if(t1.getX()+t1.getTankwidth()>=t2.getX()){
            if(turn==0)
                t1.setX(t1.getX()-5);
            else
                t2.setX(t2.getX()+5);
        }

    }

    public boolean getIsbullet() {
        return isbullet;
    }
}
