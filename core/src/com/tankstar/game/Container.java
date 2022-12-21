package com.tankstar.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Container extends Player {
    private Tank t1,t2;
    private Texture health;
    private BitmapFont black;
    private boolean isbullet;
    private Bullet bullet;
    private int turn;
    private GraphicDesign power1,power2;
    private GraphicDesign health1,health2;

    public Container(Tank t1, Tank t2) {
        this.t1 = t1;
        this.t2 = t2;
        this.bullet = null;
        this.turn=0;
        this.isbullet=false;
        black =new BitmapFont(Gdx.files.internal("font/Bold.fnt"),false);
        health=new Texture("images/health.png");
        power2=new GraphicDesign(Gdx.graphics.getWidth()-105,Gdx.graphics.getHeight()/3-100,100,20);
        power1=new GraphicDesign(110,Gdx.graphics.getHeight()/3-100,100,20);
        health1=new GraphicDesign(5,0,980,20);
        health2=new GraphicDesign(1010,0,980,20);
    }
    public void changePower(){
        if(turn==0){
            if(Gdx.input.isKeyPressed(Input.Keys.Z)){
                power1.setWidth(power1.getWidth()-1);

            }
            if(Gdx.input.isKeyPressed(Input.Keys.A)){
                power1.setWidth(power1.getWidth()+1);

            }
            float temp= power1.getWidth()/100;
            t1.setPower(temp);

        }
        else {
            if(Gdx.input.isKeyPressed(Input.Keys.Z)){
                power2.setWidth(power2.getWidth()-1);

            }
            if(Gdx.input.isKeyPressed(Input.Keys.A)){
                power2.setWidth(power2.getWidth()+1);

            }
            float temp= power2.getWidth()/100;
            t2.setPower(temp);
        }
    }
    public void changeAngle(){
        float d=Gdx.graphics.getDeltaTime()*13;
        if(turn==0){
            if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){

                t1.setAngle(t1.getAngle()-d);


            }
            if(Gdx.input.isKeyPressed(Input.Keys.UP)){
                t1.setAngle(t1.getAngle()+d);


            }


        }
        else {
            if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                t2.setAngle(t2.getAngle()-d);

            }
            if(Gdx.input.isKeyPressed(Input.Keys.UP)){
                t2.setAngle(t2.getAngle()+d);

            }
            float temp= power2.getWidth()/100;
            t2.setPower(temp);
        }
    }
    public void changePosition(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && bullet==null) {

            // tankcollision();
            if(turn==0) {
                bullet = new Bullet(t1.getX()+2*t1.getTankwidth()/3, t1.getY()+t1.getTankheight()-4, t1.getAngle(), t1.getPower(),1);
                System.out.println("t1 x: "+t1.getX());
                isbullet = true;

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
        health1.setWidth(t1.getTankhealth());
        health2.setWidth(t2.getTankhealth());
        health1.draw(shape);
        health2.draw(shape);

    }
    public void printFont(TankStarGame game){
        if(turn==0){
            game.getBatch().draw(health,110,Gdx.graphics.getHeight()/3-100,100,20);
            black.draw(game.getBatch(), "Power ",10,Gdx.graphics.getHeight()/3-80);
            black.draw(game.getBatch(), "Angle  "+(int)(t1.getAngle()),10,Gdx.graphics.getHeight()/3-110);
            black.draw(game.getBatch(), "Player 1 turn ",Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/4);
        }
        else {
            game.getBatch().draw(health,Gdx.graphics.getWidth()-105,Gdx.graphics.getHeight()/3-100,100,20);
            black.draw(game.getBatch(), "Power ",Gdx.graphics.getWidth()-205,Gdx.graphics.getHeight()/3-80);
            black.draw(game.getBatch(), "Angle  "+(int)(t2.getAngle()),Gdx.graphics.getWidth()-205,Gdx.graphics.getHeight()/3-110);
            black.draw(game.getBatch(), "Player 2 turn ",Gdx.graphics.getWidth()/2-100,Gdx.graphics.getHeight()/4);
        }
        game.getBatch().draw(health,5,0,980,20);
        game.getBatch().draw(health,1010,0,980,20);

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
                reduceHealth(t1,1);
                this.bullet = null;
                this.isbullet = false;

            }
        }
        else {
            if (t2.getX() <= bullet.getX() && (t2.getX() + t2.getTankwidth() >= bullet.getX()) && t2.getY() + t2.getTankheight() >= bullet.getY()) {
                reduceHealth(t2,2);
                this.bullet = null;
                this.isbullet = false;

            }
        }
        if(bullet!=null && bullet.getY()<Gdx.graphics.getHeight()/3){
            if(turn==0){
                reduceHealth(t1,1);
            }
            else {
                reduceHealth(t2,2);
            }
            this.bullet=null;
            this.isbullet=false;

        }


    }
    public void reduceHealth(Tank t,int i){
        if (t.getX() <= bullet.getX() && (t.getX() + t.getTankwidth() >= bullet.getX()) && t.getY() + t.getTankheight() >= bullet.getY()) {
            if(t.getX()+t.getTankwidth()/2<bullet.getX()){
                t.setX(t.getX()-10);
            }
            else {
                t.setX(t.getX()+10);
            }

            t.setTankhealth(t.getTankhealth()-220);
            if(i==1){
                health1.setWidth(health1.getWidth()-220);
            }
            else {
                health2.setWidth(health2.getWidth()-220);
            }

        }
        else {
            int m1, m2, min;
            m1 = Math.abs((int) (t.getX() - bullet.getX()));
            m2 = Math.abs((int) (t.getX() + t.getTankwidth() - bullet.getX()));
            min = Math.min(m1, m2);// bullet ka tank se distance
            int shift=10-(min/10);
            float damage=220-(min*4);

            if (min < 40) {
                if(m1>m2){
                    t.setX(t.getX()-shift);                }
                else{
                    t.setX(t.getX()+shift);
                }

                if (i == 1) {
                    health1.setWidth(health1.getWidth() - damage);
                } else {
                    health2.setWidth(health2.getWidth() - damage);
                }
                t.setTankhealth(t.getTankhealth()-damage);
            }
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

    public int getTurn() {
        return turn;
    }





    public void setTurn(int turn) {
        this.turn = turn;
    }


    public boolean getIsbullet() {
        return isbullet;
    }

    public Tank getT1() {
        return t1;
    }

    public Tank getT2() {
        return t2;
    }
}
