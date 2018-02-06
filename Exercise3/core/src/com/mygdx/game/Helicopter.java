package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.sprites.Heli1;
import com.mygdx.game.states.GameStateManager;


public class Helicopter extends ApplicationAdapter {
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    public static final String TITLE = "TDT4240 Exercise 1";

    //private GameStateManager gsm;
    private Heli1 helicopter;

    SpriteBatch batch;

    @Override
    public void create () {
        //gsm = new GameStateManager();
        batch = new SpriteBatch();
        //Gdx.gl.glClearColor(1, 0,0.99607843f, 1);
        //gsm.push(new MovingHelictoperState(gsm));
        helicopter = new Heli1(0,0);
        Gdx.gl.glClearColor(1, 0,0.99607843f, 1);


    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //gsm.update(Gdx.graphics.getDeltaTime());
        //gsm.render(batch);
        helicopter.update(Gdx.graphics.getDeltaTime());

        batch.begin();
        batch.draw(helicopter.getSprite(), helicopter.getPosition().x, helicopter.getPosition().y);
        batch.end();

    }


}