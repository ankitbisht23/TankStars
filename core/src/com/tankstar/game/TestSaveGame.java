package com.tankstar.game;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestSaveGame {
    @Test
    public void test1() throws IOException, ClassNotFoundException {
        Tank t1=new Tank(300,400,"Mark1",1);
        Tank t2=new Tank(400,500,"Mark1",2);
        Container c1=new Container(t1,t2);
        SaveGame.serialize(c1,3);
        System.out.println("ss");
        Container c2= SaveGame.deserialize(3);
        assertEquals(300,c2.getT1().getX());
        assertEquals(400,c2.getT2().getX());

    }


}
