package AI;

import Minigame2048.Minigame2048;

public class Player {

    private Minigame2048 minigame;
    private int maxScore;

    public Player(Minigame2048 minigame) {
        this.minigame = minigame;
        this.maxScore = this.minigame.getMax();
    }

    public void run() {

    }

    private boolean moveUp() {
        return this.minigame.moveUp();
    }

    private boolean moveDown() {
        return this.minigame.moveDown();
    }

    private boolean moveLeft() {
        return this.minigame.moveLeft();
    }

    private boolean moveRight() {
        return this.minigame.moveRight();
    }
}
