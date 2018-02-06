package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Helicopter;

/**
 * Created by Amanda on 03.02.2018.
 */

public class Heli1 extends Sprite{

    private static final int MOVEMENT_X = 100;
    private static final int MOVEMENT_Y = 100;
    private boolean flipped;
    private Vector3 position;
    private Vector3 velocity;

    private Rectangle bounds;

    private Texture texture;
    private Sprite sprite;

    private int i = 2;

    public Heli1(int x, int y) {
        flipped = true;
        position = new Vector3(x, y, 0);
        velocity = new Vector3(MOVEMENT_X, MOVEMENT_Y, 0);
        texture = new Texture("heli1.png");
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
        sprite = new Sprite(texture);

    }


    public void update(float dt) {
        if(Gdx.input.getX()> position.x || Gdx.input.getX() < position.x +texture.getWidth()  )
            velocity.scl(dt);
        if(position.y < 0 || position.y > Helicopter.HEIGHT-texture.getHeight()*2.5){
            velocity.set(velocity.x/dt,-velocity.y/dt, 0);
            velocity.scl(dt);
        }
        if(position.x < 0 || position.x > Helicopter.WIDTH - texture.getWidth()){
            flip();
            if(flipped){flipped = false;}
            else{flipped = true;}
            velocity.set(-velocity.x/dt,velocity.y/dt, 0);
            System.out.println(velocity);
            velocity.scl(dt);
        }
        change();
        position.add(velocity.x,velocity.y,0);

        velocity.scl(1/dt);
    }

    public void change() {
                if (i == 2) {
                    texture = new Texture("heli1.png");
                    sprite = new Sprite(texture);
                    flip();
                } else if (i == 10) {
                    texture = new Texture("heli2.png");
                    sprite = new Sprite(texture);
                    flip();
                } else if (i == 18) {
                    texture = new Texture("heli3.png");
                    sprite = new Sprite(texture);
                    flip();
                } else if (i == 26) {
                    texture = new Texture("heli4.png");
                    sprite = new Sprite(texture);
                    flip();
                } else if (i>26) {
                    i = 0;
                }
                i++;
            }

    public Vector3 getPosition() {
                return position;
            }

    public Texture getTexture() {
                return texture;
            }


    public Rectangle getBounds() {
                return bounds;
            }

    public void flip(){
        if(flipped){
            sprite.flip(true, false);
        }
    }

    public Sprite getSprite() {
            return sprite;

        }

    public void dispose() {
                texture.dispose();
            }

    }
