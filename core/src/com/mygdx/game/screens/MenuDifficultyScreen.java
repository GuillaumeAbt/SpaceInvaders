package com.mygdx.game.screens;

/**
 * Created by chlo on 24/05/2017.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.MyGame;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.PlayScreen;

public class MenuDifficultyScreen implements Screen {
    private Sprite boutonPlanetSprite;
    private Sprite boutonPlanetCliqueSprite;
    private Sprite boutonStellarSprite;
    private Sprite boutonStellarCliqueSprite;
    private Sprite boutonGallacticSprite;
    private Sprite boutonGallacticCliqueSprite;
    private Sprite arrierePlanSprite;
    private Sprite boutonRetourSprite;
    private BitmapFont font;
    private SpriteBatch batch;

    private float largeur_ecran;
    private float hauteur_ecran;

    private float xposBouton1;
    private float xposBouton2;
    private float xposBouton3;
    private float xposBoutonRetour;

    private float yposBouton1;
    private float yposBouton2;
    private float yposBouton3;
    private float yposBoutonRetour;

    private boolean cliqueBouton1;
    private boolean cliqueBouton2;
    private boolean cliqueBouton3;

    public int page;

    Music music;
    MyGame game;

    public MenuDifficultyScreen(MyGame game) {
        this.game = game;
    }


    // Fonction qui maintien le rapport entre les positions Y
    // vis-à-vis de la taille de l'écran
    private float xUnite(float x) {
        return x * largeur_ecran / 480f;
    }

    // Fonction qui maintien le rapport entre les positions Y
    // vis-à-vis de la taille de l'écran
    private float yUnite(float y) {
        return y * hauteur_ecran / 320;
    }


    public void create() {

        // Obtenir la taille de l'écran actuelle
        largeur_ecran = Gdx.graphics.getWidth();
        hauteur_ecran = Gdx.graphics.getHeight();

        batch = new SpriteBatch();

        boutonRetourSprite = new Sprite(new Texture(Gdx.files.internal("retour.png")));
        boutonPlanetSprite = new Sprite(new Texture(Gdx.files.internal("boutonplanet.png")));
        boutonPlanetCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutonplanetClique.png")));
        boutonStellarSprite = new Sprite(new Texture(Gdx.files.internal("boutonstellar.png")));
        boutonStellarCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutonstellarClique.png")));
        boutonGallacticSprite = new Sprite(new Texture(Gdx.files.internal("boutongallactic.png")));
        boutonGallacticCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutongallacticClique.png")));

        music = Gdx.audio.newMusic(Gdx.files.internal("musicmenu.mp3"));
        music.play();
        music.setLooping(true);

        boutonPlanetSprite.setSize(xUnite(148), yUnite(32));
        boutonPlanetCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonStellarSprite.setSize(xUnite(148), yUnite(32));
        boutonStellarCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonGallacticCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonGallacticCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonRetourSprite.setSize(xUnite(64), yUnite(64));

        // La police pour le texte
        font = new BitmapFont();
        font.setColor(Color.DARK_GRAY);
        font.getData().setScale(xUnite(1), yUnite(1)); // définir la taille du texte selon l'écran


        xposBouton1 = xUnite(156); // Position du bouton 'Planet'
        yposBouton1 = yUnite(130);

        xposBouton2 = xUnite(156); // Position du bouton 'Stellar'
        yposBouton2 = yUnite(90);

        xposBouton3 = xUnite(156); // Position du bouton 'Gallactic'
        yposBouton3 = yUnite(50);

        xposBoutonRetour = xUnite(0);  // Position du bouton 'Retour'
        yposBoutonRetour = yUnite(260);
        boutonRetourSprite.setPosition(xposBoutonRetour, yposBoutonRetour);
    }

    public void manipulerMenuDifficulty()
    {
        Gdx.input.setInputProcessor(new InputProcessor() {

            @Override
            public boolean touchUp(int x, int y, int pointer, int bouton) {
                if (x > xUnite(156) && x < xUnite(304) && y < yUnite(192) && y > yUnite(160)) {
                    // le bouton 1 Planet a été cliqué

                    PlayScreen.enemyType = 1;
                }
                if (x > xUnite(156) && x < xUnite(304) && y < yUnite(232) && y > yUnite(200)) {
                    // le bouton 2 Stellar a été cliqué
                    PlayScreen.enemyType = 2;
                }

                if (x > xUnite(156) && x < xUnite(304) && y < yUnite(272) && y > yUnite(240)) {
                    // le bouton 3 Gallactic a été cliqué
                    PlayScreen.enemyType = 3;
                    if (x > xUnite(0) && x < xUnite(64) && y < yUnite(64) && y > yUnite(0)) {
                        // le bouton retour a été cliqué
                        page = 0;
                    }
                }

                cliqueBouton1 = false;
                cliqueBouton2 = false;
                cliqueBouton3 = false;

                return false;
            }

            @Override
            public boolean touchDown(int x, int y, int pointer, int bouton) {

                if(x>xUnite(156) && x < xUnite(304) && y<yUnite(192) && y> yUnite(160))
                {
                    cliqueBouton1=true;
                }
                if(x>xUnite(156) && x < xUnite(304) && y<yUnite(232) && y>yUnite(200))
                {
                    cliqueBouton2=true;
                }
                if(x>xUnite(156) && x < xUnite(304) && y<yUnite(272) && y>yUnite(240))
                {
                    cliqueBouton3=true;
                }
                return false;
            }

            @Override
            public boolean touchDragged(int arg0, int arg1, int arg2) {
                return false;
            }

            @Override
            public boolean scrolled(int arg0) {
                return false;
            }

            @Override
            public boolean mouseMoved(int arg0, int arg1) {
                return false;
            }

            @Override
            public boolean keyUp(int arg0) {
                return false;
            }

            @Override
            public boolean keyTyped(char arg0) {
                return false;
            }

            @Override
            public boolean keyDown(int arg0) {
                return false;
            }
        });
    }




    public void dessinerMenuDifficulty()   // dessiner le menu
    {

        batch.begin();

        // arrierePlan
        arrierePlanSprite.draw(batch);

        // bouton 1
        if (!cliqueBouton1) {
            boutonPlanetSprite.setPosition(xposBouton1, yposBouton1);// fixer la position
            boutonPlanetSprite.draw(batch);                          // puis le dessiner
        } else {
            boutonPlanetCliqueSprite.setPosition(xposBouton1, yposBouton1);
            boutonPlanetCliqueSprite.draw(batch);
        }

        // bouton 2
        if (!cliqueBouton2) {
            boutonStellarSprite.setPosition(xposBouton2, yposBouton2);// fixer la position
            boutonStellarSprite.draw(batch);                          // puis le dessiner
        } else {
            boutonStellarCliqueSprite.setPosition(xposBouton2, yposBouton2);
            boutonStellarCliqueSprite.draw(batch);
        }
        // bouton 3
        if (!cliqueBouton3) {
            boutonGallacticSprite.setPosition(xposBouton3, yposBouton3);// fixer la position
            boutonGallacticSprite.draw(batch);                          // puis le dessiner
        } else {
            boutonGallacticCliqueSprite.setPosition(xposBouton3, yposBouton3);
            boutonGallacticCliqueSprite.draw(batch);
        }
        batch.end();

    }

    public void dessinerPageDifficulty(int page) {
        batch.begin();

        if (page == 0) {  // si on est à la page Menu Principal
            music.stop();
            game.menuscreen.create();
            game.setScreen(game.menuscreen);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        font.dispose();
        batch.dispose();
    }

    @Override
    public void pause() {

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 1, 1, 1);

        manipulerMenuDifficulty();

        switch (page)  // dans quelle page je me situe ?
        {
            case 4:              // Contenu de la page menu options
                dessinerMenuDifficulty();

                break;
            case 0:             // Contenu de la page du menu principal
                dessinerPageDifficulty(0);
                break;
        }

    }


    @Override
    public void resize(int arg0, int arg1) {
    }

    @Override
    public void resume() {


    }

    @Override
    public void hide() {

    }


}


