package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import utils.*;

public class Menuscreen extends MyScreen {
    Button startButton;
    Button exitButton;

    public Menuscreen(final Pluvia pluvia) {
        super(pluvia);
        startButton = new Button(70, 180, Assets.menu_play);
        exitButton = new Button(620, 280, Assets.menu_exit);
        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked (InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pluvia.getScreenManager().changeTo("LevelScreen");
            }
        });
        stage.addActor(startButton);
        stage.addActor(exitButton);
        stage.addListener(new InputListener(){
            @Override
            public boolean keyTyped (InputEvent event, char character) {
                if(event.getKeyCode() == com.badlogic.gdx.Input.Keys.BACK) {
                    Gdx.app.exit();
                }
                return false;
            }
        });
        stage.setViewport(Game.VIRTUAL_WIDTH, Game.VIRTUAL_HEIGHT, true);
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(Assets.menu_bg, 0, 0);
        batch.end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) { }

    @Override
    public void show() { }

    @Override
    public void hide() { }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void dispose() { }

    @Override
    public void init() {
        Gdx.input.setInputProcessor(stage);
    }
}
