import Display.GameDisplay;
import Display.TileDisplay;
import Minigame2048.Minigame2048;
import javafx.application.Application;
import javafx.stage.*;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Minigame2048 minigame = new Minigame2048();
//        runTile(stage, minigame);
        runText(stage, minigame);
    }

    private void runTile(Stage stage, Minigame2048 minigame) {
        TileDisplay tileDisplay = new TileDisplay(minigame, 800, 800);
        tileDisplay.run();


        stage.setTitle("Minigame2048");
        stage.setScene(tileDisplay.getScene());
        stage.show();
    }

    private void runText(Stage stage, Minigame2048 minigame) {
        GameDisplay gameDisplay = new GameDisplay(minigame, 800, 800);
        gameDisplay.run();

        stage.setTitle("Minigame2048");
        stage.setScene(gameDisplay.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}