package com.mygdx.game.utils;

import com.badlogic.gdx.math.Rectangle;


public class RectanglePerso extends Rectangle{
    private int survivability;
    public RectanglePerso(int survivability){

        super();

        this.survivability=survivability;
    }

    public int getSurvivability() {
        return survivability;
    }

    public void setSurvivability(int survivability) {
        this.survivability = survivability;
    }
}
