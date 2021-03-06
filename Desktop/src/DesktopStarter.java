import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import utils.Game;

public class DesktopStarter {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Pluvia";
        cfg.useGL20 = true;
        boolean BIG = true;
        if(BIG) {
            cfg.width = 1280;
            cfg.height = 768;
        } else {
            cfg.width = 800;
            cfg.height = 480;
        }
        new LwjglApplication(new Game(), cfg);
    }
}