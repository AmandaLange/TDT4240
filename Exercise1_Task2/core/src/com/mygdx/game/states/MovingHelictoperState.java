package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Helicopter;
import com.mygdx.game.sprites.Heli1;

/**
 * Created by Amanda on 27.01.2018.
 */

public class MovingHelictoperState extends State {

    private Heli1 helicopter;
    private Rectangle bounds;

    public MovingHelictoperState(GameStateManager gsm) {
        super(gsm);
        Gdx.gl.glClearColor(1, 0,0.99607843f, 1);
        //bounds = new Rectangle(0,0, Helicopter.WIDTH, Helicopter.HEIGHT);

        helicopter = new Heli1(0,0);



    }

    @Override
    protected void handleInput() {
        /*if(Gdx.input.justTouched()){
            helicopter.flip();
        }*/

    }

    @Override
    protected void update(float dt) {
        handleInput();
        helicopter.update(dt);


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(helicopter.getTexture(), helicopter.getPosition().x, helicopter.getPosition().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
