package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MovingHelictoperState;

public class Helicopter extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	public static final String TITLE = "TDT4240 Exercise 1";

	private GameStateManager gsm;

	SpriteBatch batch;
	
	@Override
	public void create () {
		gsm = new GameStateManager();
		batch = new SpriteBatch();
		//Gdx.gl.glClearColor(1, 0,0.99607843f, 1);
		gsm.push(new MovingHelictoperState(gsm));

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
