package com.tankstar.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jdk.tools.jmod.Main;


public class TankStarGame extends Game {
	private SpriteBatch batch;

	//Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
	//	img = new Texture("badlogic.jpg");
		this.setScreen(new MainMenu(this));


	}
	public SpriteBatch getBatch(){
		return this.batch;
	}



	@Override
	public void render () {
		//System.out.println("tankstar const");
//
		super.render();
		//System.out.println("1");
	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		img.dispose();
	}
}
