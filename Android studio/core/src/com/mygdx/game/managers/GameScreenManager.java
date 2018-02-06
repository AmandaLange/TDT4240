package com.mygdx.game.managers;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.AbstractScreen;
import com.mygdx.game.screens.GameScreen;

import java.util.HashMap;

/**
 * Created by lykkebergsli on 06/02/2018.
 */

public class GameScreenManager {

    private final MyGdxGame app;

    private HashMap<STATE, AbstractScreen> gameScreens;

    public enum STATE {
        MAIN_MENU,
        PLAY,
        SETTINGS
    }

    public GameScreenManager(final MyGdxGame app){
        this.app = app;

        initGameScreens();
        setScreen(STATE.PLAY);
    }

    private void initGameScreens(){
        this.gameScreens = new HashMap<STATE, AbstractScreen>();
        this.gameScreens.put(STATE.PLAY, new GameScreen(app));
    }

    public void setScreen(STATE nextScreen){
        app.setScreen(gameScreens.get(nextScreen));
    }

    public void dispose(){
        for(AbstractScreen screen : gameScreens.values()){
            if (screen != null){
                screen.dispose();
            }
        }
    }
}
