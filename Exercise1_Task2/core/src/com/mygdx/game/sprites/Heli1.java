package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Helicopter;

/**
 * Created by Amanda on 03.02.2018.
 */

public class Heli1{
    //private static final int GRAVITY = -15;
    private static final int MOVEMENT_X = 100;
    private static final int MOVEMENT_Y = 100;
    private static final String heli = "attackhelicopter.png";
    private static final String heli_flipped = "attackhelicopter2.png";
    private boolean flipped;
    private Vector3 position;
    private Vector3 velocity;

    private Texture texture;


    public Heli1(int x, int y){
        flipped = true;
        position = new Vector3(x,y,0);
        velocity = new Vector3(MOVEMENT_X,MOVEMENT_Y,0);
        texture = new Texture(heli_flipped);

    }

    public void update(float dt){
       //if(Gdx.input.getX()> position.x || Gdx.input.getX() < position.x +texture.getWidth()  )



        /*
        velocity.scl(dt);
        if(position.y < 0 || position.y > Helicopter.HEIGHT-texture.getHeight()*1.9){
            System.out.println("registrert y-posisjon");
            velocity.set(velocity.x/dt,-velocity.y/dt, 0);
            velocity.scl(dt);
        }
        if(position.x < 0 || position.x > Helicopter.WIDTH - texture.getWidth()){
            System.out.println("Registrert x-posisjon");
            flip();
            if(flipped){flipped = false;}
            else{flipped = true;}
            velocity.set(-velocity.x/dt,velocity.y/dt, 0);
            System.out.println(velocity);
            velocity.scl(dt);
        }
       position.add(velocity.x,velocity.y,0);

       /* if(position.y < 0){
            position.y = 0;
        }
*/
        velocity.scl(1/dt);
       // bounds.setPosition(position.x,position.y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }

    public void flip(){
        if(flipped){
            texture = new Texture(heli);
        }
        else{
            texture = new Texture(heli_flipped);
        }
    }

    public void dispose(){
        texture.dispose();
    }

}
