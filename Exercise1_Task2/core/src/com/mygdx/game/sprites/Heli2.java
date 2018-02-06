package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Helicopter;

/**
 * Created by Amanda on 03.02.2018.
 */

public class Heli2 extends Sprite implements InputProcessor{

    private static final int MOVEMENT_X = 0;
    private static final int MOVEMENT_Y = 0;
    private static final String heli = "attackhelicopter.png";
    private static final String heli_flipped = "attackhelicopter2.png";
    private boolean flipped = true;
    private Vector3 position = new Vector3(100,100,0);
    private Vector3 velocity = new Vector3(MOVEMENT_X,MOVEMENT_Y,0);
    float origTouchX;
    float origTouchY;
    private int count = 1;
    private boolean inside = false;

    private Texture texture = new Texture(heli_flipped);


    public Heli2(Sprite sprite){
        set(sprite);
    }

    public Heli2(Texture texture){
        super(texture);
        this.texture = texture;
        this.setSize(100,70);

    }

    public void update(float dt){

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

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(count == 1) {
            if (this.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
                inside = true;
                count++;
            }
        }
        else{
            if (this.getBoundingRectangle().contains(screenX, Gdx.graphics.getHeight() - screenY + this.getHeight())) {
                inside = true;
            }
        }
        origTouchX = screenX;
        origTouchY = screenY;
        System.out.println("orig touch x:" + origTouchX + " orig touch Y:" + origTouchY);
        System.out.println("graphics height: "+ Gdx.graphics.getHeight());
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        position.set(getX(),getY(),0);
        inside = false;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("TouchDragged registered");
        System.out.println("screenx: "+screenX + " screenY: "+ screenY);
        if(inside) {
            float dt = Gdx.graphics.getDeltaTime();

            System.out.println("Touched" + " x:" + screenX + " y:" + screenY );
            //System.out.println("Curr pos x: " + position.x + " curr pos y: "+ position.y);
            float diffX = screenX-origTouchX;
            float diffY = screenY-origTouchY;
            if(getY()>=750 && diffY <0){
                System.out.print("reached 750");
                this.setPosition(position.x + diffX, 750);
            }
            else if(getY()<=0 && diffY >0){
                System.out.print("reached 0");
                this.setPosition(position.x + diffX,0);
            }
            else if(getX()+this.getWidth()>=480 && diffX > 0){
                this.setPosition(480-this.getWidth(), position.y - diffY);
            }
            else if(getX()<=0 && diffX < 0){
                this.setPosition(0, position.y - diffY);
            }
            else{
                this.setPosition(position.x+ diffX,position.y - diffY);
            }
            System.out.println("screenX-origTouchX: " + diffX + " screenY-origTouchY: " + diffY);
            //position.add(screenX-origTouchX,screenY-origTouchY,0);

            //this.setPosition(position.x,position.y);
            //this.setPosition(position.x+ diffX,position.y - diffY);

        }
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
