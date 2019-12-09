package Display;

import Minigame2048.Minigame2048;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;
import javafx.util.Duration;

public class GameDisplay {
    private double width;
    private double height;

    private Pane pane;
    private Scene scene;
    private Minigame2048 minigame;
    private Text[][] board;

    private double tileWidth;
    private double tileHeight;

    public GameDisplay(Minigame2048 minigame, double width, double height) {
        this.minigame = minigame;
        this.width = width;
        this.height = height;
        this.pane = new Pane();
        this.board = new Text[this.minigame.getSize()][this.minigame.getSize()];

        this.scene = new Scene(this.pane, this.width, this.height);

        KeyboardInput keyboardInput = new KeyboardInput(this.minigame);
        this.scene.setOnKeyPressed(keyboardInput::handlePressed);
        this.scene.setOnKeyReleased(keyboardInput::handleReleased);

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
        for (Text[] i : this.board) {
            this.pane.getChildren().removeAll(i);
        }
        boardUpdate();
        for (Text[] i : this.board) {
            this.pane.getChildren().addAll(i);
        }
    }

    private void boardUpdate() {
        for (int i = 0; i < this.minigame.getSize(); i++) {
            for (int j = 0; j < this.minigame.getSize(); j++) {
                if (this.minigame.getTile(i, j) == 0) {
                    this.board[i][j] = new Text("");
                } else {
                    this.board[i][j] = new Text("" + this.minigame.getTile(i, j));
                }
                this.board[i][j].setTextAlignment(TextAlignment.CENTER);
                this.board[i][j].setFont(new Font(20));
                this.board[i][j].setSelectionFill(Paint.valueOf("RED"));
                this.board[i][j].setX(j * this.tileWidth + this.tileWidth * 1.5);
                this.board[i][j].setY(i * this.tileHeight + this.tileHeight * 1.5);
                this.board[i][j].prefWidth(this.tileWidth);
                this.board[i][j].prefHeight(this.tileHeight);
            }
        }
    }

    public Scene getScene() {
        return  this.scene;
    }

    public Minigame2048 getMinigame() {
        return this.minigame;
    }
}
