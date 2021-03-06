package utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

public class Assets {
    public static Texture shot;
    public static Texture ball_smaller;
    public static Texture ball_small;
    public static Texture ball_middle;
    public static Texture ball_big;
    // ---- GUI ----
    public static Texture gs_bar;
    public static Texture moon;
    public static Texture arrow_left;
    public static Texture arrow_right;
    public static Texture arrow_up;
    public static Texture menu_bg;
    public static Texture menu_play;
    public static Texture menu_exit;
    public static Texture test;
    public static Texture pauseState;
    public static Texture winState;
    public static Texture gameoverState;
    public static Texture readyState;
    public static Texture readyBlink;
    public static Texture transparent;
    public static Texture resumeButton;
    public static Texture exitGameButton;
    public static Texture restartButton;
    public static Texture nextLevelButton;
    public static Texture lifeFilled;
    public static Texture lifeEmpty;
    public static Texture starEmpty;
    public static Texture starFilled;
    public static Texture levelDisabled;
    public static Texture levelscreen_bg;
    public static Texture logo;
    // ---- Levels ----
    public static Texture levelIcon;
    static List<Texture> levelBackgrounds = new ArrayList<Texture>();
    public static Animation walkLeftAnimation;
    public static Animation walkRightAnimation;
    public static Animation ballPoppingAnimation;
    public static TextureRegion playerIdleLeft;
    public static TextureRegion playerIdleRight;

    public static void loadObjects(){
        shot = new Texture(Gdx.files.internal("objects/shot2.png"));
        ball_smaller = new Texture(Gdx.files.internal("objects/ball.png"));
        ball_small = new Texture(Gdx.files.internal("objects/ball.png"));
        ball_middle = new Texture(Gdx.files.internal("objects/ball.png"));
        ball_big = new Texture(Gdx.files.internal("objects/ball.png"));
        TextureRegion[] walkLeftFrames = new TextureRegion[5];
        for (int i = 0; i < 5; i++) {
            walkLeftFrames[i] = new TextureRegion(new Texture(Gdx.files.internal("animationExample/bob_0"+i+".png")));
        }
        walkLeftAnimation = new Animation(0.06f, walkLeftFrames);

        TextureRegion[] walkRightFrames = new TextureRegion[5];

        for (int i = 0; i < 5; i++) {
            walkRightFrames[i] = new TextureRegion(walkLeftFrames[i]);
            walkRightFrames[i].flip(true, false);
        }
        walkRightAnimation = new Animation(0.06f, walkRightFrames);
        playerIdleLeft = new TextureRegion(walkLeftFrames[0]);
        playerIdleRight = new TextureRegion(walkRightFrames[0]);

        TextureRegion[] ballPoppingFrames = new TextureRegion[3];
        for (int i = 0; i < 3; i++) {
            ballPoppingFrames[i] = new TextureRegion(new Texture(Gdx.files.internal("poppingAnimation/pop_0"+i+".png")));
        }
        ballPoppingAnimation = new Animation(0.03f, ballPoppingFrames);
    }

    public static void loadGuiElements(){
        gs_bar = new Texture(Gdx.files.internal("gui/gs_bar.png"));
        moon = new Texture(Gdx.files.internal("gui/moon.png"));
        arrow_left = new Texture(Gdx.files.internal("gui/arrow_left.png"));
        arrow_right = new Texture(Gdx.files.internal("gui/arrow_right.png"));
        arrow_up = new Texture(Gdx.files.internal("gui/arrow_up.png"));
        menu_bg = new Texture(Gdx.files.internal("gui/menu_bg1.png"));
        menu_play = new Texture(Gdx.files.internal("gui/play_button.png"));
        menu_exit = new Texture(Gdx.files.internal("gui/exit_button.png"));
        test = new Texture(Gdx.files.internal("gui/test.png"));
        pauseState = new Texture(Gdx.files.internal("gui/pauseState.png"));
        winState = new Texture(Gdx.files.internal("gui/winState.png"));
        gameoverState = new Texture(Gdx.files.internal("gui/gameoverState.png"));
        transparent = new Texture(Gdx.files.internal("gui/transparent.png"));
        resumeButton = new Texture(Gdx.files.internal("gui/resumeButton.png"));
        restartButton = new Texture(Gdx.files.internal("gui/restartButton.png"));
        exitGameButton = new Texture(Gdx.files.internal("gui/exitGameButton.png"));
        nextLevelButton = new Texture(Gdx.files.internal("gui/nextLevelButton.png"));
        levelIcon = new Texture(Gdx.files.internal("gui/levelIcon.png"));
        readyState = new Texture(Gdx.files.internal("gui/readyState.png"));
        readyBlink = new Texture(Gdx.files.internal("gui/readyBlink.png"));
        lifeFilled = new Texture(Gdx.files.internal("gui/life_full.png"));
        lifeEmpty = new Texture(Gdx.files.internal("gui/life_empty.png"));
        starEmpty = new Texture(Gdx.files.internal("gui/star_empty.png"));
        starFilled = new Texture(Gdx.files.internal("gui/star_full.png"));
        levelDisabled = new Texture(Gdx.files.internal("gui/levelDisabled.png"));
        levelscreen_bg = new Texture(Gdx.files.internal("gui/levelscreen_bg.png"));
        levelBackgrounds.add(new Texture(Gdx.files.internal("gui/level0.png")));
        levelBackgrounds.add(new Texture(Gdx.files.internal("gui/level1.png")));
        levelBackgrounds.add(new Texture(Gdx.files.internal("gui/level2.png")));
        levelBackgrounds.add(new Texture(Gdx.files.internal("gui/level3.png")));
        levelBackgrounds.add(new Texture(Gdx.files.internal("gui/level4.png")));
        logo = new Texture(Gdx.files.internal("gui/logo.png"));
    }
}