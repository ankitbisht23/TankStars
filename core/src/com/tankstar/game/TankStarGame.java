package com.tankstar.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jdk.tools.jmod.Main;

// Singleton Class
public class TankStarGame extends Game {
	private SpriteBatch batch;
	private static TankStarGame game=null;
	private TankStarGame(){

	}
	public static TankStarGame getInstance(){
		if(game==null){
			game=new TankStarGame();
		}
		return game;
	}



	
	@Override
	public void create () {
		batch = new SpriteBatch();

		this.setScreen(new MainMenu(TankStarGame.getInstance()));
	}
	public SpriteBatch getBatch(){
		return this.batch;
	}



	@Override
	public void render () {

//
		super.render();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
