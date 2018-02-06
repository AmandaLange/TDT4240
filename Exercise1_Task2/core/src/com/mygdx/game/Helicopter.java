package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.sprites.Heli1;
import com.mygdx.game.sprites.Heli2;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MovingHelictoperState;

public class Helicopter extends ApplicationAdapter  {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	public static final String TITLE = "TDT4240 Exercise 1";

	public OrthographicCamera camera = new OrthographicCamera();
	Vector3 touchPoint=new Vector3();

	private Heli2 helicopter;

	SpriteBatch batch;
	
	@Override
	public void create () {
		//gsm = new GameStateManager();
		batch = new SpriteBatch();
		//Gdx.gl.glClearColor(1, 0,0.99607843f, 1);
		//gsm.push(new MovingHelictoperState(gsm));
		helicopter = new Heli2(new Texture("attackhelicopter.png"));
		helicopter.setPosition(100,100);
		Gdx.gl.glClearColor(1, 0,0.99607843f, 1);
		camera.setToOrtho(false, WIDTH,HEIGHT);
		Gdx.input.setInputProcessor(helicopter);


	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//gsm.update(Gdx.graphics.getDeltaTime());
		//gsm.render(batch);
		batch.setProjectionMatrix(camera.combined);
		update(Gdx.graphics.getDeltaTime());
		batch.begin();

		helicopter.draw(batch);
		batch.end();
		/*batch.begin();
		batch.draw(helicopter.getTexture(), helicopter.getPosition().x, helicopter.getPosition().y);
		batch.end();*/

	}

	public void update(float dt) {
		if(Gdx.input.justTouched())
		{
			camera.unproject(touchPoint.set(Gdx.input.getX(),Gdx.input.getY(),0));
			if(helicopter.getBoundingRectangle().contains(touchPoint.x,touchPoint.y))
			{
				System.out.println("Touched " + touchPoint.x + " "+ touchPoint.y );

			}
		}

	}


}
