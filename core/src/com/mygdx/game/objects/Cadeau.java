package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Cadeau {

    private float y;
    private float x;
    private int height=216;
    private int width=233;
    public static int velocity=100;
    public static Texture presentImage;
    public Rectangle present;

    public Cadeau(){
        present= new Rectangle();
        this.x= MathUtils.random(0,480-width);
        this.y=800+height;
        present.width=width;
        present.height=height;
        present.x=this.x;
        present.y=this.y;
    }
    public Rectangle getRec(){
        return present;
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
