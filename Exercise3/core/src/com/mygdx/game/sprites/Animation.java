package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Amanda on 03.02.2018.
 */

public class Animation {
   // private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;
    private Texture texture1;
    private Texture texture2;
    private Texture texture3;
    private Texture texture4;

    public Animation(int frameCount, float cycleTime){
       // frames = new Array<TextureRegion>();
       // int frameWidth = region1.getRegionWidth() / frameCount;
       // for(int i = 0; i < frameCount; i++){
         //   frames.add(new TextureRegion(region1,i * frameWidth,0 ,frameWidth, region1.getRegionHeight()));
       // }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime/frameCount;

    }

    public void update(float dt){
        currentFrameTime += dt;
        if(currentFrameTime > maxFrameTime){
            frame ++;
            currentFrameTime = 0;
        }
        if(frame >= frameCount){
            frame = 0;
        }
        for (int i=0; i<4;i++){

        }

    }

    //public TextureRegion getFrame(){
    //    return frames.get(frame);
   // }
}