package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.managers.GameScreenManager;

public class MyGdxGame extends Game {

	// Application Vars
	public static String APP_TITLE = "Pong";
	public static double APP_VERSION = 0.1;
	public static int APP_DESKTOP_WIDTH = 720;
	public static int APP_DEKSTOP_HEIGHT = 420;
	public static int APP_FPS = 60;

	// Game Vars
	public static int V_WIDTH = 720;
	public static int V_HEIGHT = 420;

	// Managers
	public GameScreenManager gsm;
	public AssetManager assets;

	// Batches
	public SpriteBatch batch;
	public ShapeRenderer shapeBatch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeBatch = new ShapeRenderer();

		// Setup managers
		assets = new AssetManager();
		gsm = new GameScreenManager(this);
	}

	@Override
	public void render () {
		super.render();
		
//		Gdx.gl.glClearColor(1, 1, 1, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();

		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
		shapeBatch.dispose();
		assets.dispose();
		gsm.dispose();
	}
}
