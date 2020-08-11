package com.mygdx.game.screens;

/*/**
 * Created by chlo on 24/05/2017.

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



public class MenuOptionScreen implements Screen {

    private Sprite boutonDifficultySprite;
    private Sprite boutonDifficultyCliqueSprite;
    private Sprite boutonShipSprite;
    private Sprite boutonShipCliqueSprite;
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

    public int page;

    Music music;
    MyGame game;

    public MenuOptionScreen(MyGame game) {
        this.game = game;
    }


    // Fonction qui maintien le rapport entre les positions Y
    // vis-à-vis de la taille de l'écran
    private float xUnite(float x)
    {
        return x*largeur_ecran/480f;
    }

    // Fonction qui maintien le rapport entre les positions Y
    // vis-à-vis de la taille de l'écran
    private float yUnite(float y)
    {
        return y*hauteur_ecran/320;
    }


    public void create() {

        // Obtenir la taille de l'écran actuelle
        largeur_ecran = Gdx.graphics.getWidth();
        hauteur_ecran = Gdx.graphics.getHeight();

       batch = new SpriteBatch();

        boutonRetourSprite = new Sprite(new Texture(Gdx.files.internal("retour.png")));
        boutonDifficultySprite =new Sprite(new Texture(Gdx.files.internal("boutonplay.png"))) ;
        boutonDifficultyCliqueSprite=new Sprite(new Texture(Gdx.files.internal("boutonplay.png"))) ;
        boutonShipSprite =new Sprite(new Texture(Gdx.files.internal("boutonplay.png"))) ;
        boutonShipCliqueSprite =new Sprite(new Texture(Gdx.files.internal("boutonplay.png")));

        music=Gdx.audio.newMusic(Gdx.files.internal("musicmenu.mp3"));
        music.play();
        music.setLooping(true);

        boutonDifficultySprite.setSize(xUnite(148), yUnite(32));
        boutonDifficultyCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonShipSprite.setSize(xUnite(148), yUnite(32));
        boutonShipCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonRetourSprite.setSize(xUnite(64), yUnite(64));

        // La police pour le texte
        font = new BitmapFont();
        font.setColor(Color.DARK_GRAY);
        font.getData().setScale(xUnite(1), yUnite(1)); // définir la taille du texte selon l'écran


        xposBouton1 = xUnite(156); // Position du bouton 'Difficulty'
        yposBouton1 = yUnite(130);

        xposBouton2 = xUnite(156); // Position du bouton 'Ship'
        yposBouton2 = yUnite(90);

        xposBoutonRetour = xUnite(0);  // Position du bouton 'Retour'
        yposBoutonRetour = yUnite(260);
        boutonRetourSprite.setPosition(xposBoutonRetour, yposBoutonRetour);
    }
    public void manipulerMenuOption()
    {
        Gdx.input.setInputProcessor(new InputProcessor() {

            @Override
            public boolean touchUp(int x, int y, int pointer, int bouton) {
                if(x>xUnite(156) && x < xUnite(304) && y<yUnite(192) && y> yUnite(160))
                {
                    // le bouton 1 difficulty a été cliqué
                    page=4;
                }
                if(x>xUnite(156) && x < xUnite(304) && y<yUnite(232) && y>yUnite(200))
                {
                    // le bouton 2 Ship a été cliqué
                    page=5;
                }


                if(x>xUnite(0) && x<xUnite(64) && y<yUnite(64) && y>yUnite(0))
                {
                    // le bouton retour a été cliqué
                    page=0;
                }

                cliqueBouton1 = false;
                cliqueBouton2 = false;


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


    public void dessinerMenuOption(int x)   // dessiner le menu
    {

        batch.begin();

        // arrierePlan
        arrierePlanSprite.draw(batch);

        // bouton 1
        if(!cliqueBouton1)
        {
            boutonDifficultySprite.setPosition(xposBouton1, yposBouton1);// fixer la position
            boutonDifficultySprite.draw(batch);                          // puis le dessiner
        }else
        {
            boutonDifficultyCliqueSprite.setPosition(xposBouton1, yposBouton1);
            boutonDifficultyCliqueSprite.draw(batch);
        }

        // bouton 2
        if(!cliqueBouton2)
        {
            boutonShipSprite.setPosition(xposBouton2, yposBouton2);// fixer la position
            boutonShipSprite.draw(batch);                          // puis le dessiner
        }else
        {
            boutonShipCliqueSprite.setPosition(xposBouton2, yposBouton2);
            boutonShipCliqueSprite.draw(batch);
        }
        batch.end();

    }

    public void dessinerPageOption(int page) {
        batch.begin();

        if(page == 4) { // si on est à la page Difficulty
            music.stop();
            game.menudifficultyscreen.create();
            game.setScreen(game.menudifficultyscreen);

        if (page == 5) { // si on est à la page Ship
            music.stop();
            game.menushipscreen.create();
            game.setScreen(game.menushipscreen);
        }

        if(page == 0) {  // si on est à la page Menu Principal
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

        manipulerMenuOption();

        switch(page)  // dans quelle page je me situe ?
        {
            case 3:              // Contenu de la page menu options
                dessinerMenuOption(3);

                break;
            case 0:             // Contenu de la page du menu principal
                dessinerPageOption(0);
                break;

            case 4:             // Contenu de la page Difficulty
                dessinerPageOption(4);
                break;
            case 5:             // Contenu de la page Ship
                dessinerPageOption(5);
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


}/*
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



public class MenuOptionScreen implements Screen {

    private Sprite boutonDifficultySprite;
    private Sprite boutonDifficultyCliqueSprite;
    private Sprite boutonShipSprite;
    private Sprite boutonShipCliqueSprite;
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

    public int page;

    Music music;
    MyGame game;

    public MenuOptionScreen(MyGame game) {
        this.game = game;
    }


    // Fonction qui maintien le rapport entre les positions Y
    // vis-à-vis de la taille de l'écran
    private float xUnite(float x)
    {
        return x*largeur_ecran/480f;
    }

    // Fonction qui maintien le rapport entre les positions Y
    // vis-à-vis de la taille de l'écran
    private float yUnite(float y)
    {
        return y*hauteur_ecran/320;
    }


    public void create() {

        // Obtenir la taille de l'écran actuelle
        largeur_ecran = Gdx.graphics.getWidth();
        hauteur_ecran = Gdx.graphics.getHeight();

        batch = new SpriteBatch();

        arrierePlanSprite = new Sprite(new Texture(Gdx.files.internal("arriereplan.png")));
        boutonRetourSprite = new Sprite(new Texture(Gdx.files.internal("retour.png")));
        boutonDifficultySprite = new Sprite(new Texture(Gdx.files.internal("boutonplay.png"))) ;
        boutonDifficultyCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutonplay.png"))) ;
        boutonShipSprite = new Sprite(new Texture(Gdx.files.internal("boutonplay.png"))) ;
        boutonShipCliqueSprite =new Sprite(new Texture(Gdx.files.internal("boutonplay.png")));

        music=Gdx.audio.newMusic(Gdx.files.internal("musicmenu.mp3"));
        music.play();
        music.setLooping(true);

        boutonDifficultySprite.setSize(xUnite(148), yUnite(32));
        boutonDifficultyCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonShipSprite.setSize(xUnite(148), yUnite(32));
        boutonShipCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonRetourSprite.setSize(xUnite(64), yUnite(64));

        // La police pour le texte
        font = new BitmapFont();
        font.setColor(Color.DARK_GRAY);
        font.getData().setScale(xUnite(1), yUnite(1)); // définir la taille du texte selon l'écran


        xposBouton1 = xUnite(156); // Position du bouton 'Difficulty'
        yposBouton1 = yUnite(130);

        xposBouton2 = xUnite(156); // Position du bouton 'Ship'
        yposBouton2 = yUnite(90);

        xposBoutonRetour = xUnite(0);  // Position du bouton 'Retour'
        yposBoutonRetour = yUnite(260);
        boutonRetourSprite.setPosition(xposBoutonRetour, yposBoutonRetour);
    }
    private void manipulerMenuOption()
    {
        Gdx.input.setInputProcessor(new InputProcessor() {

            @Override
            public boolean touchUp(int x, int y, int pointer, int bouton) {
                if(x>xUnite(156) && x < xUnite(304) && y<yUnite(192) && y> yUnite(160))
                {
                    // le bouton 1 difficulty a été cliqué
                    page=4;
                }
                if(x>xUnite(156) && x < xUnite(304) && y<yUnite(232) && y>yUnite(200))
                {
                    // le bouton 2 Ship a été cliqué
                    page=5;
                }
                if(x>xUnite(0) && x<xUnite(64) && y<yUnite(64) && y>yUnite(0))
                {
                    // le bouton retour a été cliqué
                    page=0;
                }

                cliqueBouton1 = false;
                cliqueBouton2 = false;

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

    public void dessinerMenuOption()   // dessiner le menu
    {

        batch.begin();

        // arrierePlan
        arrierePlanSprite.draw(batch);

        // bouton 1
        if(!cliqueBouton1)
        {
            boutonDifficultySprite.setPosition(xposBouton1, yposBouton1);// fixer la position
            boutonDifficultySprite.draw(batch);                          // puis le dessiner
        }else
        {
            boutonDifficultyCliqueSprite.setPosition(xposBouton1, yposBouton1);
            boutonDifficultyCliqueSprite.draw(batch);
        }

        // bouton 2
        if(!cliqueBouton2)
        {
            boutonShipSprite.setPosition(xposBouton2, yposBouton2);// fixer la position
            boutonShipSprite.draw(batch);                          // puis le dessiner
        }else
        {
            boutonShipCliqueSprite.setPosition(xposBouton2, yposBouton2);
            boutonShipCliqueSprite.draw(batch);
        }

        //game.setScreen(game.menuoptionscreen);

        batch.end();

    }

    public void dessinerPageOption(int page) {
        batch.begin();

        if(page == 4) { // si on est à la page Difficulty
            music.stop();
            game.menudifficultyscreen.create();
            game.setScreen(game.menudifficultyscreen);
        }
        if (page == 5) { // si on est à la page Ship
            music.stop();
            game.menushipscreen.create();
            game.setScreen(game.menushipscreen);
        }

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

        manipulerMenuOption();
        page = 2;

        switch(page)  // dans quelle page je me situe ?
        {
            case 2:              // Contenu de la page menu options
                dessinerMenuOption();

                break;
            case 0:             // Contenu de la page du menu principal
                dessinerPageOption(0);
                break;

            case 4:             // Contenu de la page Difficulty
                dessinerPageOption(4);
                break;
            case 5:             // Contenu de la page Ship
                dessinerPageOption(5);
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




