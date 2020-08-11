package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.utils.RectanglePerso;



public class EnemyEasy implements Enemy {

    private float y;
    private float x;
    private int height=60;
    private int width=63;
    public static int velocity=200;
    public static Texture enemyImage;
    public RectanglePerso enemy;
    public int survivability=1;


    public EnemyEasy(){
        enemy= new RectanglePerso(survivability);
        this.x=MathUtils.random(0,480-width);// on genere un nombre de 0 à 480-2, 480 est la largeur de l'ecran
        this.y=800+height;
        enemy.width=width;
        enemy.height=height;
        enemy.x=this.x;
        enemy.y=this.y;
        enemy.setSurvivability(survivability);
    }

    public RectanglePerso getRec(){
        return enemy;
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

