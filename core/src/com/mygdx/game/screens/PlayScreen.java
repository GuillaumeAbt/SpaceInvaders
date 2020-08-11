package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGame;
import com.mygdx.game.objects.Cadeau;
import com.mygdx.game.objects.EnemyEasy;
import com.mygdx.game.objects.EnemyHard;
import com.mygdx.game.objects.EnemyMedium;
import com.mygdx.game.objects.Missile;
import com.mygdx.game.objects.Player;
import com.mygdx.game.objects.Star;
import com.mygdx.game.utils.Motion;
import com.mygdx.game.utils.RectanglePerso;
import com.badlogic.gdx.Preferences;
import com.mygdx.game.utils.Collision;

import sun.rmi.runtime.Log;


public class PlayScreen implements Screen {

    MyGame game;
    private Sprite arrierePlan;
    private Texture pauseImage;
    private Texture pause;
    private Texture heartimage;
    private Texture boutonresume;
    private Texture boutonresumeclique;
    private Texture boutonmenu;
    private Texture boutonmenuclique;

    private SpriteBatch batch;
    private OrthographicCamera camera;

    private String yourScoreName;
    public int score = 0;
    BitmapFont yourBitmapFontName;

    private Array<RectanglePerso> enemies;
    private Array<Rectangle> missiles;
    private Array<Rectangle> stars;
    private Array<Rectangle> presents;
    private Array<Rectangle> lifes;

    private Collision collision;
    private Motion motion;

    private Player p;
    Music music;
    public static Sound sound;

    boolean paused = false;
    public static int enemyType = 2;
    public static int skin = 1;
    
    public static int state;
    Preferences prefs = Gdx.app.getPreferences("pref highscore");

    // pas oublier le son
    public PlayScreen(MyGame game) {
        this.game = game;
    }

    public void create() {

        /* Initialisation des textures */
        Star.starImage = new Texture(Gdx.files.internal("star.png"));
        EnemyEasy.enemyImage = new Texture(Gdx.files.internal("eE.png"));
        EnemyHard.enemyImage = new Texture(Gdx.files.internal("eH.png"));
        EnemyMedium.enemyImage = new Texture(Gdx.files.internal("eM.png"));
        Missile.missileImage = new Texture(Gdx.files.internal("m.png"));
        arrierePlan= new Sprite(new Texture(Gdx.files.internal("fond.png")));
        if (skin == 1){
            Player.shipImage = new Texture(Gdx.files.internal("s.png"));

        }
        else if (skin == 2){
            Player.shipImage = new Texture(Gdx.files.internal("s2.png"));
        }
        else{
            Player.shipImage = new Texture(Gdx.files.internal("s.png"));
        }
        Cadeau.presentImage = new Texture(Gdx.files.internal("presentImage.png"));

        pause = new Texture(Gdx.files.internal("pause.png"));
        pauseImage = new Texture(Gdx.files.internal("pauseImage.png"));
        boutonresume = new Texture(Gdx.files.internal("boutonresume.png"));
        boutonresumeclique = new Texture(Gdx.files.internal("boutonresumeclique.png"));
        boutonmenu = new Texture(Gdx.files.internal("boutonmenu.png"));
        boutonmenuclique = new Texture(Gdx.files.internal("boutonmenuclique.png"));
        heartimage = new Texture(Gdx.files.internal("coeur.png"));
        /* Fin initialisation des textures */

        sound = Gdx.audio.newSound(Gdx.files.internal("shot.mp3"));
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.play();
        music.setVolume(0.5f);
        music.setLooping(true);


        /* Initialisation des indispensables */
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);
        arrierePlan.setSize(480,800);

        batch = new SpriteBatch();
        /* Fin des indispensables */

        /*Initialisation du score */
        yourScoreName = "Score:0";
        yourBitmapFontName = new BitmapFont();
        /* Fin du score */

        collision = new Collision();
        motion = new Motion();
        p = new Player();


        /* Initialisation des listes de rectangles d'objets de jeu */
        enemies = new Array<RectanglePerso>();
        missiles = new Array<Rectangle>();
        stars = new Array<Rectangle>();
        lifes = new Array<Rectangle>();
        presents = new Array<Rectangle>();
        /*Fin des des listes rectangles */

        /* remplissage de la liste des vies*/
        initHeart(lifes);
        // initStars(stars);

    }

    public void initHeart(Array<Rectangle> lifes) {
        for (int i = 0; i < p.getLife(); i++) {
            Rectangle recVie = new Rectangle();
            recVie.x = i * 54;
            recVie.y = 800 - 54;
            lifes.add(recVie);
        }
    }

    public void initStars(Array<Rectangle> stars) { // debut d'initialisation des etoiles, pour eviter l'effet moche de l'initialisation...
        for (int i = 0; i <= 80; i++) {

            motion.spawnStar(stars, 10 * i);
            batch.begin();
            batch.draw(Star.starImage, stars.peek().x, 10 * i);
            batch.end();

        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


        if (p.getLife() <= 0) { // si on meurt
            if (score > prefs.getInteger("highscore", 0)) { //0 est la valeur par défaut si le highscore est vide
                prefs.putInteger("highscore", score);
                prefs.flush();
            }
            p.setLife(3);
            initHeart(lifes);
            score = 0;
            music.stop();
            game.stopscreen.create();
            game.stopscreen.page = 0;
            game.setScreen(game.stopscreen);

        } else if (paused) { // menu pause
            batch.begin();
            batch.draw(pause, 130, 700);
            batch.draw(boutonmenu, 150, 400, 200, 100);
            batch.draw(boutonresume, 150, 550, 200, 100);

            music.pause();
          /*  if((Gdx.input.getX()>=150 && Gdx.input.getX()<=380)&& (Gdx.input.getY()>=550 && Gdx.input.getY()<=650)){  action bouton qui fonctionne pas
                music.play();
                paused=false;
                motion.updateLastTime();
            }else if((Gdx.input.getX()>=150 && Gdx.input.getX()<=380)&& (Gdx.input.getY()>=400 && Gdx.input.getY()<=500)){
                paused=false;
                game.menuscreen.create();
                game.setScreen(game.menuscreen);
            } */

            if (Gdx.input.isTouched()) { // en attendant...
                music.play();
                paused = false;
                motion.updateLastTime();
            }
            batch.end();
        } else {
            Gdx.gl.glClearColor(0, 0, 0.15f, 1); // couleur bleu rvb
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            camera.update();
            batch.setProjectionMatrix(camera.combined); // on sait pas c'est quoi
            batch.begin();
            arrierePlan.draw(batch);
            batch.draw(pauseImage, 480 - 60, 800 - 54); // il reste à creer un evenement des qu'on le touche pour mettre en pause le jeu

            for (Rectangle star : stars) {

                batch.draw(Star.starImage, star.x, star.y); // on dessine une etoile avec son x et son y

            }
            for (Rectangle enemy : enemies) {
                if (enemyType == 1) {
                    batch.draw(EnemyEasy.enemyImage, enemy.x, enemy.y);
                } // on dessine une etoile avec son x et son y selon la difficulté
                else {
                    if (enemyType == 2) {
                        batch.draw(EnemyMedium.enemyImage, enemy.x, enemy.y);
                    } else batch.draw(EnemyHard.enemyImage, enemy.x, enemy.y);
                }
            }
            for (Rectangle cadeau : presents) {
                batch.draw(Cadeau.presentImage, cadeau.x, cadeau.y, 60, 60); // on dessine un bonus cadeau avec son x et son y
            }

            for (Rectangle missile : missiles) {
                batch.draw(Missile.missileImage, missile.x + p.getWidth() / 2, missile.y - 15); // on dessine une etoile avec son x et son y
            }
            for (Rectangle recVie : lifes) {
                batch.draw(heartimage, recVie.x, recVie.y);
            }
            motion.moveStars(stars);
            motion.moveEnemies(enemies, p, lifes);
            motion.moveMissile(missiles, p.getX(), p.getY()); // On fait bouger les missiles à partir de la position du vaisseau
            motion.moveCadeau(presents, p, lifes);
            sound.play(2.0f);

            batch.draw(Player.shipImage, p.getX(), p.getY()); // On affiche le vaisseau

        /* On capte l'event toucher et on bouge le vaisseau */
            if (Gdx.input.isTouched()) {
                Vector3 touchPos = new Vector3();
                touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                camera.unproject(touchPos);

                if (Math.abs(p.getX() - touchPos.x) <= 85) { // condition pour pas teleporter le vaisseau

                    p.setX(touchPos.x - 85 / 2);
                }
                if (Math.abs(p.getY() - touchPos.y) <= 62) {
                    p.setY(touchPos.y - 62 / 2);
                }
                if (touchPos.x > 440 && touchPos.y > 740) { // menu pause
                    paused = true;
                }

            }
        /* Fin event toucher */
            score += collision.collisionEMP(enemies, missiles, p, lifes); // collision Ennemie/missile/player
            collision.collisionCP(presents, p, lifes); //collision cadeau


            // fonction pause

            /* Affichage du score */
            yourBitmapFontName.setColor(1.0f, 1.0f, 1.0f, 1.0f);        //la couleur (blanc)
            yourBitmapFontName.getData().setScale((float) 2.5);                    //la taille
            yourBitmapFontName.setFixedWidthGlyphs(yourScoreName);        //pour la mettre horizontale
            yourBitmapFontName.draw(batch, "Score:" + score, 180, 800 - 15);    //affichage
            batch.end();
            /* Fin affichage du score */

        /* conditions aux limites*/
            if (p.getX() < 0) p.setX(0);
            if (p.getX() > 480 - 62) p.setX(480 - 62);
            if (p.getY() < 0) p.setY(0);
            if (p.getY() > 800 - 85) p.setY(800 - 85);
        /*Fin conditions aux limites */

        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        Star.starImage.dispose();
        Player.shipImage.dispose();
        Missile.missileImage.dispose();
        EnemyEasy.enemyImage.dispose();
        EnemyHard.enemyImage.dispose();
        EnemyMedium.enemyImage.dispose();
        Cadeau.presentImage.dispose();
        music.dispose();
        sound.dispose();
        batch.dispose();
    }
}
