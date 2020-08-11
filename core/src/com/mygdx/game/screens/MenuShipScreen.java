package com.mygdx.game.screens;

/**
 * Created by chlo on 24/05/2017.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.MyGame;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Player;



public class MenuShipScreen implements Screen {

    private Sprite boutonShip1Sprite;
    private Sprite boutonShip1CliqueSprite;
    private Sprite boutonShip2Sprite;
    private Sprite boutonShip2CliqueSprite;
    private Sprite arrierePlanSprite;
    private Sprite boutonRetourSprite;
    private BitmapFont font;
    private SpriteBatch batch;

    public Player player;


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
    public static int skin;

    Music music;

    MyGame game;
    public MenuShipScreen(MyGame game){
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

        // Charger Texture dans Sprite
        boutonShip1Sprite =new Sprite(new Texture(Gdx.files.internal("boutonplay.png"))) ;
        boutonShip1CliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutonplayclique.png"))) ;
        boutonShip2Sprite =new Sprite(new Texture(Gdx.files.internal("boutonplay.png"))) ;
        boutonShip2CliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutonplayclique.png"))) ;
        arrierePlanSprite = new Sprite(new Texture(Gdx.files.internal("arriereplan.png")));
        boutonRetourSprite = new Sprite(new Texture(Gdx.files.internal("retour.png")));


        music=Gdx.audio.newMusic(Gdx.files.internal("musicmenu.mp3"));
        music.play();
        music.setLooping(true);


        boutonShip1Sprite.setSize(xUnite(148), yUnite(32));
        boutonShip1CliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonShip2Sprite.setSize(xUnite(148), yUnite(32));
        boutonShip2CliqueSprite.setSize(xUnite(148), yUnite(32));
        arrierePlanSprite.setSize(largeur_ecran, hauteur_ecran);
        boutonRetourSprite.setSize(xUnite(64), yUnite(64));

        // La police pour le texte
        font = new BitmapFont();
        font.setColor(Color.DARK_GRAY);
        font.getData().setScale(xUnite(1), yUnite(1)); // définir la taille du texte selon l'écran


        xposBouton1 = xUnite(156); // Position de l'image pour le vaisseau 1
        yposBouton1 = yUnite(130);

        xposBouton2 = xUnite(156); // Position de l'image du vaisseau 2
        yposBouton2 = yUnite(90);

        xposBoutonRetour = xUnite(0);  // Position du bouton 'Retour'
        yposBoutonRetour = yUnite(260);
        boutonRetourSprite.setPosition(xposBoutonRetour, yposBoutonRetour);

    }

    public void manipulerMenuShip()
    {
        Gdx.input.setInputProcessor(new InputProcessor() {

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
            public boolean touchUp(int x, int y, int pointer, int bouton) {
                if(x>xUnite(156) && x < xUnite(304) && y<yUnite(192) && y> yUnite(160))
                {
                    // le bouton 1
                    page=0;
                    skin =0;


                }
                if(x>xUnite(156) && x < xUnite(304) && y<yUnite(232) && y>yUnite(200))
                {
                    // le bouton 2
                    page=0;
                    skin =1;
                }

                if(x>xUnite(0) && x<xUnite(64) && y<yUnite(64) && y>yUnite(0))
                {
                    // le bouton retour a été cliqué
                    page=2;
                }

                cliqueBouton1 = false;
                cliqueBouton2 = false;

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
    public void dessinerMenuShip()
    {

        batch.begin();

        // arrierePlan
        arrierePlanSprite.draw(batch);


        if(!cliqueBouton1)
        {
            boutonShip1Sprite.setPosition(xposBouton1, yposBouton1);// fixer la position
            boutonShip1Sprite.draw(batch);                          // puis le dessiner
        }else
        {
            boutonShip1CliqueSprite.setPosition(xposBouton1, yposBouton1);
            boutonShip1CliqueSprite.draw(batch);
            player.shipImage = new Texture(Gdx.files.internal("s.png"));


        }

        if(!cliqueBouton2)
        {
            boutonShip2Sprite.setPosition(xposBouton2, yposBouton2);// fixer la position
            boutonShip2Sprite.draw(batch);                          // puis le dessiner
        }else
        {
            boutonShip2CliqueSprite.setPosition(xposBouton2, yposBouton2);
            boutonShip2CliqueSprite.draw(batch);
            player.shipImage = new Texture(Gdx.files.internal("s.png"));

        }

        batch.end();

    }

    public void dessinerPageShip(int page)
    {
        batch.begin();

        if(page == 0) { // si on est au menu principal
            music.stop();
            game.menuscreen.create();
            game.setScreen(game.menuscreen);
        }

        if(page == 2) {  // si on est au meu des options
            music.stop();
            game.menuoptionscreen.create();
            game.setScreen(game.menuoptionscreen);
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

        manipulerMenuShip();  // gestion des input

        switch(page)  // dans quelle page je me situe ?
        {
            case 5:              // Contenu de la page menu pour les vaisseaux
                dessinerMenuShip();

                break;
            case 0:             // Contenu du menu principal
                dessinerPageShip(0);
                break;

            case 2:             // Contenu du menu optios
                dessinerPageShip(2);
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



