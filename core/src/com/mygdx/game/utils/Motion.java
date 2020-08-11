package com.mygdx.game.utils;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.objects.EnemyEasy;
import com.mygdx.game.objects.EnemyHard;
import com.mygdx.game.objects.EnemyMedium;
import com.mygdx.game.objects.Missile;
import com.mygdx.game.objects.Player;
import com.mygdx.game.objects.Star;
import com.mygdx.game.screens.PlayScreen;
import com.mygdx.game.objects.Cadeau;

import java.util.Iterator;


public class Motion {
    private long lastStarTime;
    private long lastEnemyTime;
    private long lastShotTime;
    private long lastCadeauTime;


    public void spawnStar(Array<Rectangle> stars) { // fonction boucle
        stars.add(new Star().getRec());
        lastStarTime = TimeUtils.millis();

    }

    public void spawnStar(Array<Rectangle> stars, int y) { // surcharge fonction pour l'initialisation

        stars.add(new Star(y).getRec());
        lastStarTime = TimeUtils.millis();
    }

    public void spawnEnemies(Array<RectanglePerso> enemies) {
        if (PlayScreen.enemyType == 1) {
            enemies.add(new EnemyEasy().getRec());
        } else {
            if (PlayScreen.enemyType == 2) {
                enemies.add(new EnemyMedium().getRec());
            } else enemies.add(new EnemyHard().getRec());
        }
        ;
        lastEnemyTime = TimeUtils.millis();
    }

    public void spawnCadeau(Array<Rectangle> presents) {
        presents.add(new Cadeau().getRec());
        lastCadeauTime = TimeUtils.millis();
    }

    public void spawnMissiles(Array<Rectangle> missiles, float shipx, float shipy) {
        PlayScreen.sound.play();
        missiles.add(new Missile(shipx, shipy).getRec());
        lastShotTime = TimeUtils.millis();

    }

    public void moveStars(Array<Rectangle> stars) {
        if (TimeUtils.millis() - lastStarTime > 100) spawnStar(stars);
        Iterator<Rectangle> counterStar = stars.iterator(); // on cree un compteur specifique pour parcourir la liste de rectangle
        while (counterStar.hasNext()) {
            Rectangle star = counterStar.next();
            star.y -= Star.velocity * 1 / 30;
            if (star.y < 0) counterStar.remove();
        }
    }

    public void moveEnemies(Array<RectanglePerso> enemies, Player p, Array<Rectangle> lifes) {
        if (TimeUtils.millis() - lastEnemyTime > 1000) spawnEnemies(enemies);
        Iterator<RectanglePerso> counterEnemy = enemies.iterator(); // on cree un compteur specifique pour parcourir la liste de rectangle
        while (counterEnemy.hasNext()) {
            Rectangle enemy = counterEnemy.next();
            if (PlayScreen.enemyType == 1) {
                enemy.y -= EnemyEasy.velocity * 1 / 30;
            } else {
                if (PlayScreen.enemyType == 2) {
                    enemy.y -= EnemyMedium.velocity * 1 / 30;
                } else enemy.y -= EnemyHard.velocity * 1 / 30;
            }
            ;
            if (enemy.y < 0) {
                counterEnemy.remove();
                p.setLife(p.getLife() - 1);
                lifes.pop();
            }
        }
    }

    public void moveCadeau(Array<Rectangle> presents, Player p, Array<Rectangle> lifes) {
        if (TimeUtils.millis() - lastCadeauTime > 100000) spawnCadeau(presents);
        Iterator<Rectangle> counterCadeau = presents.iterator();
        while (counterCadeau.hasNext()) {
            Rectangle present = counterCadeau.next();
            present.y -= Cadeau.velocity * 1 / 30;
            if (present.y < 0) {
                counterCadeau.remove();
                //quand le cadeau sort de l'écran aucune vie n'est ajoutée
            }
        }
    }

    public void moveMissile(Array<Rectangle> missiles, float shipx, float shipy) {
        if (TimeUtils.millis() - lastShotTime > 450)
            spawnMissiles(missiles, shipx, shipy);

        Iterator<Rectangle> counterMissile = missiles.iterator(); // on cree un compteur specifique pour parcourir la liste de rectangle
        while (counterMissile.hasNext()) {
            Rectangle missile = counterMissile.next();
            missile.y += Missile.velocity * 1 / 30;
            if (missile.y + missile.height > 800) counterMissile.remove();
        }
    }

    public void updateLastTime() {
        lastEnemyTime = TimeUtils.millis();
        lastShotTime = TimeUtils.millis();
        lastStarTime = TimeUtils.millis();
    }

}
