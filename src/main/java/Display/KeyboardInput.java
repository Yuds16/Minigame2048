package Display;

import java.util.HashSet;
import java.util.Set;

import Minigame2048.Minigame2048;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardInput {

    private Set<KeyCode> pressedKeys = new HashSet<>();
    private Minigame2048 minigame;

    public KeyboardInput(Minigame2048 minigame) {
        this.minigame = minigame;
    }

    /**
     * Listens for and handles Key press events.
     *
     * @param keyEvent the Key being pressed.
     */
    void handlePressed(KeyEvent keyEvent) {
        if (pressedKeys.contains(keyEvent.getCode())) {
            return;
        }
        pressedKeys.add(keyEvent.getCode());

        if (keyEvent.getCode().equals(KeyCode.UP)) {
            this.minigame.moveUp();
        } else if (keyEvent.getCode().equals(KeyCode.DOWN)) {
            this.minigame.moveDown();
        } else if (keyEvent.getCode().equals(KeyCode.LEFT)) {
            this.minigame.moveLeft();
        } else if (keyEvent.getCode().equals(KeyCode.RIGHT)) {
            this.minigame.moveRight();
        } else {
            return;
        }
    }

    /**
     * Listens for and handles Key release events.
     *
     * @param keyEvent the key being released.
     */
    void handleReleased(KeyEvent keyEvent) {
        pressedKeys.remove(keyEvent.getCode());
    }
}