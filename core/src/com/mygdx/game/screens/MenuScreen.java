package com.mygdx.game.screens;


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


public class MenuScreen implements Screen{

    private Sprite boutonPlaySprite;
    private Sprite boutonPlayCliqueSprite;
    private Sprite boutonOptionSprite;
    private Sprite boutonOptionCliqueSprite;
    private Sprite boutonCreditSprite;
    private Sprite boutonCreditCliqueSprite;
    private Sprite arrierePlanSprite;
    private Sprite boutonRetourSprite;
    private Sprite boutonDifficultySprite;
    private Sprite boutonDifficultyCliqueSprite;
    private Sprite boutonShipSprite;
    private Sprite boutonShipCliqueSprite;
    private Sprite boutonPlanetSprite;
    private Sprite boutonPlanetCliqueSprite;
    private Sprite boutonStellarSprite;
    private Sprite boutonStellarCliqueSprite;
    private Sprite boutonGallacticSprite;
    private Sprite boutonGallacticCliqueSprite;


    private Sprite arrierePlanOptions;
    private Sprite arrierePlanCredits;
    private Sprite arrierePlanDifficulty;
    private Sprite arrierePlanShip;
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

    BitmapFont yourBitmapCredit;


    public int page;

    Music music;

    MyGame game;
    public MenuScreen(MyGame game){
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
        boutonPlaySprite =new Sprite(new Texture(Gdx.files.internal("boutonplay.png"))) ;
        boutonPlayCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutonplayclique.png"))) ;
        boutonCreditSprite =new Sprite(new Texture(Gdx.files.internal("boutoncredit.png"))) ;
        boutonCreditCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutoncreditclique.png"))) ;
        boutonOptionSprite =new Sprite(new Texture(Gdx.files.internal("boutonoption.png"))) ;
        boutonOptionCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutonoptionclique.png"))) ;
        arrierePlanSprite = new Sprite(new Texture(Gdx.files.internal("arriereplan.png")));
        boutonRetourSprite = new Sprite(new Texture(Gdx.files.internal("retour.png")));
        boutonDifficultySprite = new Sprite(new Texture(Gdx.files.internal("boutondifficulty.png"))) ;
        boutonDifficultyCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutondifficultyclique.png"))) ;
        boutonShipSprite = new Sprite(new Texture(Gdx.files.internal("boutonship.png"))) ;
        boutonShipCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutonshipclique.png"))) ;
        boutonPlanetSprite = new Sprite(new Texture(Gdx.files.internal("boutonplanet.png"))) ;
        boutonPlanetCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutonplanetclique.png"))) ;
        boutonStellarSprite = new Sprite(new Texture(Gdx.files.internal("boutonstellar.png"))) ;
        boutonStellarCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutonstellar.png"))) ;
        boutonGallacticSprite = new Sprite(new Texture(Gdx.files.internal("boutongallactic.png"))) ;
        boutonGallacticCliqueSprite = new Sprite(new Texture(Gdx.files.internal("boutongallacticclique.png"))) ;
        arrierePlanOptions= new Sprite(new Texture(Gdx.files.internal("options.png")));
        arrierePlanDifficulty= new Sprite(new Texture(Gdx.files.internal("difficulty.png")));
        arrierePlanShip= new Sprite(new Texture(Gdx.files.internal("ship.png")));
        arrierePlanCredits= new Sprite(new Texture(Gdx.files.internal("credits.png")));


        music=Gdx.audio.newMusic(Gdx.files.internal("musicmenu.mp3"));
        music.play();
        music.setLooping(true);


        boutonPlaySprite.setSize(xUnite(148), yUnite(32));
        boutonPlayCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonOptionSprite.setSize(xUnite(148), yUnite(32));
        boutonOptionCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonCreditSprite.setSize(xUnite(148), yUnite(32));
        boutonCreditCliqueSprite.setSize(xUnite(148), yUnite(32));
        arrierePlanSprite.setSize(largeur_ecran, hauteur_ecran);
        boutonRetourSprite.setSize(xUnite(64), yUnite(64));
        boutonDifficultySprite.setSize(xUnite(148), yUnite(32));
        boutonDifficultyCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonShipSprite.setSize(xUnite(148), yUnite(32));
        boutonShipCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonPlanetSprite.setSize(xUnite(148), yUnite(32));
        boutonPlanetCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonStellarSprite.setSize(xUnite(148), yUnite(32));
        boutonStellarCliqueSprite.setSize(xUnite(148), yUnite(32));
        boutonGallacticSprite.setSize(xUnite(148), yUnite(32));
        boutonGallacticCliqueSprite.setSize(xUnite(148), yUnite(32));

        arrierePlanOptions.setSize(largeur_ecran, hauteur_ecran);
        arrierePlanDifficulty.setSize(largeur_ecran, hauteur_ecran);
        arrierePlanShip.setSize(largeur_ecran, hauteur_ecran);
        arrierePlanCredits.setSize(largeur_ecran, hauteur_ecran);

        yourBitmapCredit = new BitmapFont();




        // La police pour le texte
        font = new BitmapFont();
        yourBitmapCredit = new BitmapFont();
        font.setColor(Color.DARK_GRAY);
        font.getData().setScale(xUnite(1), yUnite(1)); // définir la taille du texte selon l'écran


        xposBouton1 = xUnite(156); // Position du bouton 'StartGame'
        yposBouton1 = yUnite(130);

        xposBouton2 = xUnite(156); // Position du bouton 'Options'
        yposBouton2 = yUnite(90);

        xposBouton3 = xUnite(156); // Position du bouton 'Bonus'
        yposBouton3 = yUnite(50);

        xposBoutonRetour = xUnite(0);  // Position du bouton 'Retour'
        yposBoutonRetour = yUnite(260);
        boutonRetourSprite.setPosition(xposBoutonRetour, yposBoutonRetour);

    }

    public void manipulerMenu()
    {
        Gdx.input.setInputProcessor(new InputProcessor() {

            @Override
            public boolean touchUp(int x, int y, int pointer, int bouton) {
                if (page == 0) {
                    if (x > xUnite(156) && x < xUnite(304) && y < yUnite(192) && y > yUnite(160)) {
                        // le bouton 1 (startGame) a été cliqué
                        page = 1;
                    }
                    else if (x > xUnite(156) && x < xUnite(304) && y < yUnite(232) && y > yUnite(200)) {
                        // le bouton 2 (Options) a été cliqué

                        page = 2;
                    }

                    else if (x > xUnite(156) && x < xUnite(304) && y < yUnite(272) && y > yUnite(240)) {
                        // le bouton 3 (Crédits) a été cliqué
                        page = 3;
                    }
                    else if (x > xUnite(0) && x < xUnite(64) && y < yUnite(64) && y > yUnite(0)) {
                        // le bouton retour a été cliqué
                        page = 0;
                    }

                    cliqueBouton1 = false;
                    cliqueBouton2 = false;
                    cliqueBouton3 = false;
                }
                else if (page == 2){
                    if (x > xUnite(156) && x < xUnite(304) && y < yUnite(192) && y > yUnite(160)) {
                        // le bouton 1 (Difficulty) a été cliqué
                        page = 4;
                    }
                    else if (x > xUnite(156) && x < xUnite(304) && y < yUnite(232) && y > yUnite(200)) {
                        // le bouton 2 (Ship) a été cliqué
                        page = 5;
                    }
                    else if (x > xUnite(0) && x < xUnite(64) && y < yUnite(64) && y > yUnite(0)) {
                        // le bouton retour a été cliqué
                        page = 0;
                    }



                    cliqueBouton1 = false;
                    cliqueBouton2 = false;
                }
                else if (page==3){
                     if (x > xUnite(0) && x < xUnite(64) && y < yUnite(64) && y > yUnite(0)) {
                        // le bouton retour a été cliqué
                        page = 0;
                    }
                }
                else if (page == 4) {
                    if (x > xUnite(156) && x < xUnite(304) && y < yUnite(192) && y > yUnite(160)) {
                        // le bouton 1 (Planet) a été cliqué
                        PlayScreen.enemyType = 1;
                        page = 2;
                    } else if (x > xUnite(156) && x < xUnite(304) && y < yUnite(232) && y > yUnite(200)) {
                        // le bouton 2 (Stellar) a été cliqué
                        PlayScreen.enemyType = 2;
                        page = 2;
                    } else if (x > xUnite(156) && x < xUnite(304) && y < yUnite(272) && y > yUnite(240)) {
                        // le bouton 3 (Gallactic) a été cliqué
                        PlayScreen.enemyType = 3;
                        page = 2;
                    } else if (x > xUnite(0) && x < xUnite(64) && y < yUnite(64) && y > yUnite(0)) {
                        // le bouton retour a été cliqué
                        page = 2;
                    }

                    cliqueBouton1 = false;
                    cliqueBouton2 = false;
                    cliqueBouton3 = false;
                }

                    else if (page == 5) {
                    if (x > xUnite(156) && x < xUnite(304) && y < yUnite(192) && y > yUnite(160)) {
                        // le premier vaisseau a été cliqué
                        PlayScreen.skin = 1;
                        page = 2;
                    } else if (x > xUnite(156) && x < xUnite(304) && y < yUnite(232) && y > yUnite(200)) {
                        // le deuxieme vaisseau a été cliqué
                        PlayScreen.skin = 2;
                                page = 2;
                    }
                     else if (x > xUnite(0) && x < xUnite(64) && y < yUnite(64) && y > yUnite(0)) {
                    // le bouton retour a été cliqué
                    page = 2;
                    }

                    cliqueBouton1 = false;
                    cliqueBouton2 = false;
                }

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
    public void dessinerMenu()   // dessiner le menu
    {

        batch.begin();  // obligatoire pour commencer un dessin sur le SpriteBatch

        // arrierePlan
        arrierePlanSprite.draw(batch);

        // bouton 1
        if(!cliqueBouton1)
        {
            boutonPlaySprite.setPosition(xposBouton1, yposBouton1);// fixer la position
            boutonPlaySprite.draw(batch);                          // puis le dessiner
        }else
        {
            boutonPlayCliqueSprite.setPosition(xposBouton1, yposBouton1);
            boutonPlayCliqueSprite.draw(batch);
        }

        // bouton 2
        if(!cliqueBouton2)
        {
            boutonOptionSprite.setPosition(xposBouton2, yposBouton2);// fixer la position
            boutonOptionSprite.draw(batch);                          // puis le dessiner
        }else
        {
            boutonOptionCliqueSprite.setPosition(xposBouton2, yposBouton2);
            boutonOptionCliqueSprite.draw(batch);
        }

        // bouton 3
        if(!cliqueBouton3)
        {
            boutonCreditSprite.setPosition(xposBouton3, yposBouton3); // fixer la position
            boutonCreditSprite.draw(batch);                           // puis le dessiner
        }else
        {
            boutonCreditCliqueSprite.setPosition(xposBouton3, yposBouton3);
            boutonCreditCliqueSprite.draw(batch);
        }

        batch.end();  // obligatoire pour finir le dessin sur un SpriteBatch

    }

    public void dessinerPage(int page)
    {
        batch.begin();

        if(page == 1) { // si on est à la page Game
            music.stop();
            game.playscreen.create();
            game.setScreen(game.playscreen);
        }
        else if(page == 2) { // si on est à la page Options
            music.stop();
            arrierePlanOptions.draw(batch);
            boutonRetourSprite.draw(batch);
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

        }

        else if(page == 3) {  // si on est à la page Crédits
            arrierePlanCredits.draw(batch);
            boutonRetourSprite.draw(batch);
            yourBitmapCredit.setColor(1.0f, 1.0f, 1.0f, 1.0f);        //la couleur (blanc)
            yourBitmapCredit.getData().setScale((float) 3);                    //la taille
            yourBitmapCredit.draw(batch, "Crée par Guillaume Abautret, Jordan Chemouhoum,\n\nChloé Brochet et Clement Jubault \n\n\n\nMerci aussi à Daniel Ranc de nous avoir suivis \ndurant ce projet:", 100, yUnite(230));    //affichage

        }


        else if(page == 4) {  // si on est à la page Difficulty
            font.draw(batch, "Difficulty", xUnite(220), yUnite(320)); // dessiner le titre de la page 4


            arrierePlanDifficulty.draw(batch);

            boutonRetourSprite.draw(batch);
                // bouton 1
                if(!cliqueBouton1)
                {
                    boutonPlanetSprite.setPosition(xposBouton1, yposBouton1);// fixer la position
                    boutonPlanetSprite.draw(batch);                          // puis le dessiner
                    boutonRetourSprite.draw(batch);
                }else
                {
                    boutonPlanetCliqueSprite.setPosition(xposBouton1, yposBouton1);
                    boutonPlanetCliqueSprite.draw(batch);
                    boutonRetourSprite.draw(batch);
                }

                // bouton 2
                if(!cliqueBouton2)
                {
                    boutonStellarSprite.setPosition(xposBouton2, yposBouton2);// fixer la position
                    boutonStellarSprite.draw(batch);// puis le dessiner
                    boutonRetourSprite.draw(batch);
                }else
                {
                    boutonStellarCliqueSprite.setPosition(xposBouton2, yposBouton2);
                    boutonStellarCliqueSprite.draw(batch);
                    boutonRetourSprite.draw(batch);
                }

                // bouton 3
                if(!cliqueBouton3)
                {
                    boutonGallacticSprite.setPosition(xposBouton3, yposBouton3);// fixer la position
                    boutonGallacticSprite.draw(batch);                          // puis le dessiner
                    boutonRetourSprite.draw(batch);
                }else
                {
                    boutonGallacticCliqueSprite.setPosition(xposBouton3, yposBouton3);
                    boutonGallacticCliqueSprite.draw(batch);
                    boutonRetourSprite.draw(batch);
                }
            }

        else if(page == 5) {  // si on est à la page Ship
            font.draw(batch, "Ship", xUnite(220), yUnite(320)); // dessiner le titre de la page 5

            arrierePlanShip.draw(batch);

            boutonRetourSprite.draw(batch);
            // bouton 1
            if(!cliqueBouton1)
            {
                boutonShipSprite.setPosition(xposBouton1, yposBouton1);// fixer la position
                boutonShipSprite.draw(batch);                          // puis le dessiner
                boutonRetourSprite.draw(batch);
            }else
            {
                boutonShipCliqueSprite.setPosition(xposBouton1, yposBouton1);
                boutonShipCliqueSprite.draw(batch);
                boutonRetourSprite.draw(batch);
            }

            // bouton 2
            if(!cliqueBouton2)
            {
                boutonShipSprite.setPosition(xposBouton2, yposBouton2);// fixer la position
                boutonShipSprite.draw(batch);                          // puis le dessiner
                boutonRetourSprite.draw(batch);
            }else
            {
                boutonShipCliqueSprite.setPosition(xposBouton2, yposBouton2);
                boutonShipCliqueSprite.draw(batch);
                boutonRetourSprite.draw(batch);

            }
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

        manipulerMenu();  // gestion des input

        switch(page)  // dans quelle page je me situe ?
        {
            case 0:              // Contenu de la page menu
                dessinerMenu();
                break;

            default:             // Contenu de la page Game
                dessinerPage(page);
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
