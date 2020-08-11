package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;


public class Player {
    private float y=getHeight();
    private float x=240 - 65/2;
    private Array<Rectangle> Player;
    private int height=62;
    private int width=85;

    private int life = 3;

    public int getLife(){return  life;}
    public void setLife(int life){this.life=life ;}



    public static Texture shipImage;

    public float getY() {
        return y;
    }
    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y=y;
    }
    public void setX(float x){ this.x=x; }

    public int getHeight() {
        return height;
    }


    public int getWidth() {
        return width;
    }


}
