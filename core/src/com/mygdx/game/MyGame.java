package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screens.*;

/**
 * Created by Guillaume on 04/04/2017.
 */

public class MyGame extends Game {

    public MenuScreen menuscreen;
    public PlayScreen playscreen;
    public StopScreen stopscreen;
    public MenuOptionScreen menuoptionscreen;
    public MenuDifficultyScreen menudifficultyscreen;
    public MenuShipScreen menushipscreen;



    public void create(){

        menuscreen= new MenuScreen(this);
        playscreen= new PlayScreen(this);
        stopscreen=new StopScreen(this);
        menuoptionscreen = new MenuOptionScreen(this);
        //menudifficultyscreen = new MenuDifficultyScreen(this);
        menushipscreen = new MenuShipScreen(this);

        menuscreen.create();
        setScreen(menuscreen);
    }
}
