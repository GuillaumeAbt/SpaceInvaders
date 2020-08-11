package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;


public class Star {
    private float x;
    private float y;
    private int height=2;
    private int width=2;
    public static Texture starImage;
    public static int velocity=100;
    public Rectangle star;


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public Star() {
        star = new Rectangle();
        this.x = MathUtils.random(0, 480 - width);// on genere un nombre de 0 à 480-2, 480 est la largeur de l'ecran
        this.y = 800 - height;
        star.x = this.x;
        star.y = this.y;

    }
    public Star(int y){ // surcharge pour effet jolie d'initialisation
        this.x = MathUtils.random(0, 480 - width);
        this.y = y;
        star.x = this.x;
        star.y = this.y;
            }


    public Rectangle getRec(){
        return star;
    }
}
