package com.mygdx.game.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Preferences;
import com.mygdx.game.MyGame;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class StopScreen implements Screen {

    private Sprite boutonPlaySprite;
    private Sprite boutonPlayCliqueSprite;
    private Sprite boutonMenuSprite;
    private Sprite boutonMenuCliqueSprite;
    private Sprite arrierePlanSprite;
    private Sprite boutonRetourSprite;
    private BitmapFont font;
    private SpriteBatch batch;
    BitmapFont yourBitmapFontName;

    private float largeur_ecran;
    private float hauteur_ecran;

    private float xposBouton1;
    private float xposBouton2;
    private float xposBoutonRetour;

    private float yposBouton1;
    private float yposBouton2;
    private float yposBoutonRetour;

    private boolean cliqueBouton1;
    private boolean cliqueBouton2;

    public int page;
    private Preferences prefs;

    MyGame game;

    public StopScreen(MyGame game) {
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

        // Charger Texture dans Sprite
        boutonPlaySprite = new Sprite(new Texture(Gdx.files.internal("boutonreplay.png")));
        boutonPlayCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutonreplayclique.png")));
        boutonMenuSprite = new Sprite(new Texture(Gdx.files.internal("boutonmenu.png")));
        boutonMenuCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutonmenuclique.png")));
        arrierePlanSprite = new Sprite(new Texture(Gdx.files.internal("gameover.png")));
        boutonRetourSprite = new Sprite(new Texture(Gdx.files.internal("retour.png")));

        boutonPlaySprite.setSize(xUnite(148), yUnite(32));
        boutonPlaySprite.setSize(xUnite(148), yUnite(32));
        boutonPlayCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonMenuSprite.setSize(xUnite(148), yUnite(32));
        boutonMenuCliqueSprite.setSize(xUnite(148), yUnite(32));
        arrierePlanSprite.setSize(largeur_ecran, hauteur_ecran);
        boutonRetourSprite.setSize(xUnite(64), yUnite(64));

        // La police pour le texte
        font = new BitmapFont();
        font.setColor(Color.DARK_GRAY);
        font.getData().setScale(xUnite(1), yUnite(1)); // définir la taille du texte selon l'écran


        xposBouton1 = xUnite(156); // Position du bouton 'StartGame'
        yposBouton1 = yUnite(130);

        xposBouton2 = xUnite(156); // Position du bouton 'StartGame'
        yposBouton2 = yUnite(90);

        xposBoutonRetour = xUnite(0);  // Position du bouton 'Retour'
        yposBoutonRetour = yUnite(260);
        boutonRetourSprite.setPosition(xposBoutonRetour, yposBoutonRetour);

        //Initialisation du highscore */

        yourBitmapFontName = new BitmapFont();
        prefs = Gdx.app.getPreferences("pref highscore");
        //Fin du score

    }

    public void manipulerMenu() {
        Gdx.input.setInputProcessor(new InputProcessor() {

            @Override
            public boolean touchUp(int x, int y, int pointer, int bouton) {
                if (x > xUnite(156) && x < xUnite(304) && y < yUnite(192) && y > yUnite(160)) {
                    // le bouton 1 (startGame) a été cliqué
                    page = 1;
                }
                if (x > xUnite(156) && x < xUnite(304) && y < yUnite(232) && y > yUnite(200)) {
                   page=2;
                }
                cliqueBouton1 = false;
                cliqueBouton2= false;

                return false;
            }

            @Override
            public boolean touchDown(int x, int y, int pointer, int bouton) {

                if (x > xUnite(156) && x < xUnite(304) && y < yUnite(192) && y > yUnite(160)) {
                    cliqueBouton1 = true;
                }
                if (x > xUnite(156) && x < xUnite(304) && y < yUnite(232) && y > yUnite(200)) {
                    cliqueBouton2=true;
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

    public void dessinerMenu()   // dessiner le menu
    {

        batch.begin();  // obligatoire pour commencer un dessin sur le SpriteBatch

        // arrierePlan
        arrierePlanSprite.draw(batch);

        // bouton 1
        if (!cliqueBouton1) {
            boutonPlaySprite.setPosition(xposBouton1, yposBouton1);// fixer la position
            boutonPlaySprite.draw(batch);                          // puis le dessiner
        } else {
            boutonPlayCliqueSprite.setPosition(xposBouton1, yposBouton1);
            boutonPlayCliqueSprite.draw(batch);
        }
        if (!cliqueBouton2) {
            boutonMenuSprite.setPosition(xposBouton2, yposBouton2);// fixer la position
            boutonMenuSprite.draw(batch);                          // puis le dessiner
        } else {
            boutonMenuCliqueSprite.setPosition(xposBouton2, yposBouton2);
            boutonMenuCliqueSprite.draw(batch);
        }
        batch.end();  // obligatoire pour finir le dessin sur un SpriteBatch

    }

    public void dessinerPage(int page) {
        batch.begin();

        if (page == 1)  // si on est à la page Game
        {  game.playscreen.create();
            game.setScreen(game.playscreen);
        }
        if(page == 2) {
            dispose();
            page=0;
           game.menuscreen.create();
           game.setScreen(game.menuscreen); }

        batch.end();
    }

    @Override
    public void dispose() {
        font.dispose();
        yourBitmapFontName.dispose();
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

        manipulerMenu();  // gestion des input

        switch (page)  // dans quelle page je me situe ?
        {
            case 0:              // Contenu de la page menu
                dessinerMenu();

                break;
            case 1:             // Contenu de la page Game
                dessinerPage(1);
                break;
            case 2:
                dessinerPage(2);
                break;

        }
        batch.begin();
        yourBitmapFontName.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        yourBitmapFontName.getData().setScale((float) 5);
        yourBitmapFontName.draw(batch, "Highscore:" + prefs.getInteger("highscore", 0), xUnite(140), yUnite(195));
        batch.end();

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
