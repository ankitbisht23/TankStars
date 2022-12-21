package com.tankstar.game;

import java.io.*;




public class SaveGame {


public SaveGame(){}
    public static void serialize(Container container,int i) throws IOException {
        TankState s1;
        Tank t1=container.getT1();
        Tank t2=container.getT2();
        s1=new TankState(t1.getX(),t2.getX(),t1.getY(),t2.getY(),t1.getTankhealth(),t2.getTankhealth(),t1.getType(),t2.getType(),container.getTurn());
        ObjectOutputStream out=null;

        try{

            out=new ObjectOutputStream(new FileOutputStream("game"+i+".txt"));


            out.writeObject(s1);

        }
        finally {
            out.close();
        }
    }
    public static Container deserialize(int i)throws IOException,ClassNotFoundException{
        ObjectInputStream in=null;
        try{
            in=new ObjectInputStream(new FileInputStream("game"+i+".txt"));
            TankState c1=(TankState) in.readObject();
            Tank t1,t2;
            t1=new Tank(c1.getTank1X(),c1.getTank1Y(),c1.getType1(),1);
            t2=new Tank(c1.getTank2X(),c1.getTank2Y(),c1.getType2(),2);
            t1.setTankhealth(c1.getTank1health());
            t2.setTankhealth(c1.getTank2Health());
            Container c=new Container(t1,t2);
            c.setTurn(c1.getTurn());
            return c;


        }
        finally {
            in.close();

        }
    }


}


