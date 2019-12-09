package Display;

import Minigame2048.Minigame2048;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.*;

public class TileDisplay {
    private double width;
    private double height;

    private ArrayList<TileView> tiles;
    private Pane pane;
    private Scene scene;
    private Minigame2048 minigame;

    private double tileWidth;
    private double tileHeight;

    public TileDisplay(Minigame2048 minigame, double width, double height) {
        this.minigame = minigame;
        this.width = width;
        this.height = height;

        this.pane = new Pane();
        this.scene = new Scene(this.pane, this.width, this.height);

        KeyboardInput keyboardInput = new KeyboardInput(this.minigame);
        this.scene.setOnKeyPressed(keyboardInput::handlePressed);
        this.scene.setOnKeyReleased(keyboardInput::handleReleased);

        this.tiles = new ArrayList<>();
        this.tileWidth = this.width/(this.minigame.getSize() + 2);
        this.tileHeight = this.height/(this.minigame.getSize() + 2);
    }

    public void run() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10),
                t -> this.draw()));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void draw() {
        for (TileView i : this.tiles) {
            i.remove(this.pane);
        }
        update();
        for (TileView i : this.tiles) {
            i.add(this.pane);
        }
    }

    public Scene getScene() {
        return this.scene;
    }

    private void update() {
        for (int i = 0; i < this.minigame.getSize(); i++) {
            for (int j = 0; j < this.minigame.getSize(); j++) {
                if (this.minigame.getTile(i, j) != 0) {
                    TileView tile = new TileView(this.minigame.getTile(i, j), j, i, this.tileWidth, this.tileHeight);
                    this.tiles.add(tile);
                }
            }
        }
    }
}
