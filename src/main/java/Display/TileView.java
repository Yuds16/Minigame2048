package Display;

import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;

public class TileView {
    private int value;
    private Color color;
    private int xIndex;
    private int yIndex;
    private double xPos;
    private double yPos;
    private double width;
    private double height;

    private Box box;
    private Label label;

    public TileView(int value, int xIndex, int yIndex, double width, double height) {
        this.value = value;
        this.xIndex = xIndex;
        this.yIndex = yIndex;
        this.xPos = width * 1.5 + xIndex * width;
        this.yPos = height * 1.5 + yIndex * height;
        this.width = width;
        this.height = height;

        this.box = makeBox();
        this.label = makeLabel();
    }

    public boolean add(Pane pane) {
        if (pane.getChildren().contains(this.box) &&
                pane.getChildren().contains(this.label)) {
            return false;
        } else {
            pane.getChildren().add(this.box);
            pane.getChildren().add(this.label);
            return true;
        }
    }

    public boolean remove(Pane pane) {
        if (pane.getChildren().remove(this.box) &&
        pane.getChildren().remove(this.label)) {
            return true;
        }
        return false;
    }

    private Box makeBox() {
        Box box = new Box();
        box.setLayoutX(this.xPos);
        box.setLayoutY(this.yPos);
        box.setWidth(this.width);
        box.setHeight(this.height);
        return box;
    }

    private Label makeLabel() {
        Label label = new Label();
        label.setText("" + this.value);
        label.setStyle("-fx-border-color: black;");
        label.setLayoutX(this.xPos);
        label.setLayoutY(this.yPos);
        label.setPrefWidth(this.width);
        label.setPrefHeight(this.height);
        return label;
    }
}
