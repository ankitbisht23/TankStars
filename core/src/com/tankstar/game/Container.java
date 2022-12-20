package com.tankstar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Container {
    private Tank t1,t2;
    private boolean isbullet;
    private Bullet bullet;
    private int turn;

    public Container(Tank t1, Tank t2) {
        this.t1 = t1;
        this.t2 = t2;
        this.bullet = null;
        this.turn=0;
        this.isbullet=false;
    }

    public void update() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && bullet==null) {

           // tankcollision();
            if(turn==0) {
                bullet = new Bullet(t1.getX(), t1.getY(), t1.getAngle(), t1.getPower());
                System.out.println("t1 x: "+t1.getX());
                isbullet = true;
                System.out.println("bullet");
            }
            else {
                bullet = new Bullet(t2.getX(), t2.getY(), t2.getAngle(), t2.getPower());
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
    public void updateBullet(ShapeRenderer shapeRenderer){
//        bullet=new Bullet(t1.getX(),t1.getY(),t1.getAngle(),t1.getPower());

        this.bullet.create(shapeRenderer);
      //  destroyBullet();
//        this.bullet.update();
    }
    public void destroyBullet(){
        if(bullet.getY()<Gdx.graphics.getHeight()/3){
            this.bullet=null;
            this.isbullet=false;
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
