package com.mygdx.game.utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.objects.Player;
import com.mygdx.game.utils.RectanglePerso;


/**
 * Created by Guillaume on 06/03/2017.
 */

public class Collision {

    public int collisionEMP(Array<RectanglePerso> enemies, Array<Rectangle> missiles, Player p, Array<Rectangle> lifes) {

        for (RectanglePerso e : enemies) {
            // Collision ennemies/missiles=> petit bug de distance on a rajouté +20 pour que ça marche bien
            for (Rectangle m : missiles) {
                if ((e.getY() <= m.getY() + m.getHeight() && m.getY() + m.getHeight() <= e.getY() + e.getHeight())
                        && ((e.getX() <= m.getX() && m.getX() <= e.getX() + e.getWidth())
                        || (e.getX() <= m.getX() + m.getWidth() && m.getX() + m.getWidth() <= e.getX() + e.getWidth()))) {
                    if (e.getSurvivability() == 1) {
                        enemies.removeValue(e, false);
                        missiles.removeValue(m, false);
                        return 10;
                    } else {
                        missiles.removeValue(m, false);
                        e.setSurvivability(e.getSurvivability() - 1);
                    }

                }
            }
            // Collision ennemies/Player
            if ((e.getY() <= p.getY() && p.getY() <= e.getY() + e.getHeight())
                    && ((p.getX() <= p.getX() && p.getX() <= e.getX() + e.getWidth())
                    || (e.getX() <= p.getX() + p.getWidth() && p.getX() + p.getWidth() <= e.getX() + e.getWidth()))) {
                //Condition du bas
                enemies.removeValue(e, false);
                p.setLife(p.getLife() - 1);
                lifes.pop();
                return 0;

            } else if ((e.getY() <= p.getY() + p.getHeight() && p.getY() + p.getHeight() <= e.getY() + e.getHeight())
                    && ((e.getX() <= p.getX() && p.getX() <= e.getX() + e.getWidth())
                    || (e.getX() <= p.getX() + p.getWidth() && p.getX() + p.getWidth() <= e.getX() + e.getWidth()))) {
                //condition du haut
                enemies.removeValue(e, false);
                p.setLife(p.getLife() - 1);
                lifes.pop();
                return 0;
            } else if (((e.getHeight() / 4 + e.getX() <= p.getX() + p.getHeight() / 2) && (p.getX() + p.getHeight() / 2 <= e.getX() + 3 * e.getHeight() / 4))
                    && ((e.getY() <= p.getY() && p.getY() <= e.getY() + e.getWidth())
                    || (e.getY() <= p.getY() + p.getWidth()) && (p.getY() + p.getWidth() <= e.getY() + e.getWidth()))) {
                //condition du milieu
                enemies.removeValue(e, false);
                p.setLife(p.getLife() - 1);
                lifes.pop();
                return 0;
            }
        }
        return 0;
    }

    public void collisionCP(Array<Rectangle> presents, Player p, Array<Rectangle> lifes){

        for (Rectangle c : presents) {
            Rectangle recVie = new Rectangle();
            recVie.x = p.getLife()*54;
            recVie.y = 800 - 54;
            // Collision ennemies/Player
            if ((c.getY() <= p.getY() && p.getY() <= c.getY() + c.getHeight())
                    && ((p.getX() <= p.getX() && p.getX() <= c.getX() + c.getWidth())
                    || (c.getX() <= p.getX() + p.getWidth() && p.getX() + p.getWidth() <= c.getX() + c.getWidth()))) {
                presents.removeValue(c, false);
                p.setLife(p.getLife() + 1);
                lifes.add(recVie);
            } else if ((c.getY() <= p.getY() + p.getHeight() && p.getY() + p.getHeight() <= c.getY() + c.getHeight())
                    && ((c.getX() <= p.getX() && p.getX() <= c.getX() + c.getWidth())
                    || (c.getX() <= p.getX() + p.getWidth() && p.getX() + p.getWidth() <= c.getX() + c.getWidth()))) {
                presents.removeValue(c, false);
                p.setLife(p.getLife() + 1);
                lifes.add(recVie);
            } else if (((c.getHeight() / 4 + c.getX() <= p.getX() + p.getHeight() / 2) && (p.getX() + p.getHeight() / 2 <= c.getX() + 3 * c.getHeight() / 4))
                    && ((c.getY() <= p.getY() && p.getY() <= c.getY() + c.getWidth())
                    || (c.getY() <= p.getY() + p.getWidth()) && (p.getY() + p.getWidth() <= c.getY() + c.getWidth()))) {
                presents.removeValue(c, false);
                p.setLife(p.getLife() + 1);
                lifes.add(recVie);
            }
        }
    }
}
