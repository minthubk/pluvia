package view;

import controllers.GamescreenController;
import utils.Input;
import utils.MyScreen;
import utils.Pluvia;
import utils.WorldRenderer;

import static controllers.GamescreenController.gameStateDef.playing;


public class Gamescreen extends MyScreen {
    WorldRenderer worldRenderer;
    GamescreenController gsController;
    public final Input input;

    public Gamescreen(Pluvia pluvia) {
        super(pluvia);
        gsController = new GamescreenController(pluvia, this);
        worldRenderer = new WorldRenderer(batch, gsController);
        input = new Input();
    }

    public void render() {
        worldRenderer.render();
        gsController.update();
        if(input.LEFT) {
            gsController.getPlayer().moveLeft();
        }
        if(input.RIGHT) {
            gsController.getPlayer().moveRight();
        }
        if(input.SPACE) {
            gsController.getPlayer().shot();
        }
        if(gsController.getGameState() != playing) {
            stage.draw();
        }
    }

    public void init(){
        gsController.setGameState(playing);
    }
    @Override
    public void resume() { }

    @Override
    public void resize(int width, int height) { }

    @Override
    public void show() { }

    @Override
    public void hide() { }

    @Override
    public void pause() { }

    @Override
    public void dispose() { }
}