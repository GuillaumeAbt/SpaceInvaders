package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;


public class Missile {
    private float y;
    private float x;
    private int height=29;
    private int width=63;
    public static int velocity=200;
    public static Texture missileImage;
    private Rectangle missile;

    public Missile(float shipx, float shipy){
        missile= new Rectangle();
        this.x=shipx;
        this.y= shipy;
        missile.x=this.x;
        missile.width=width;
        missile.height=height;
        missile.y=this.y;

    }
    public Rectangle getRec(){
        return missile;
    }


    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
