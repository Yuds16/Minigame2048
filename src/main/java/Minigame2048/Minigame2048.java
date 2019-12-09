package Minigame2048;

import java.util.Random;

public class Minigame2048 {
    private int size;
    private int[][] board;
    private Random random;

    public Minigame2048() {
        this.size = 4;
        this.board = new int[this.size][this.size];
        initialize();
    }

    public Minigame2048(int size) {
        this.size = size;
        this.board = new int[this.size][this.size];
        initialize();
    }

    public void initialize() {
        this.random = new Random();
        spawn();
        spawn();
    }

    public boolean moveUp() {
        boolean moved = false;
        boolean merged = false;
        moved = pushUp();
        merged = mergeUp();
        pushUp();
        if (moved || merged) {
            spawn();
            return true;
        }
        return false;
    }

    public boolean moveDown() {
        boolean moved = false;
        boolean merged = false;
        moved = pushDown();
        merged = mergeDown();
        pushDown();
        if (moved || merged) {
            spawn();
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        boolean moved = false;
        boolean merged = false;
        moved = pushLeft();
        merged = mergeLeft();
        pushLeft();
        if (moved || merged) {
            spawn();
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        boolean moved = false;
        boolean merged = false;
        moved = pushRight();
        merged = mergeRight();
        pushRight();
        if (moved || merged) {
            spawn();
            return true;
        }
        return false;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public int getSize() {
        return this.size;
    }

    public int getTile(int row, int col) {
        return this.board[row][col];
    }

    public int getMax() {
        int max = 0;
        for (int[] i : this.board) {
            for (int j : i) {
                if (j > max) {
                    max = j;
                }
            }
        }
        return max;
    }

    private boolean pushUp() {
        boolean moved = false;
        for (int counter = 0; counter < this.size; counter++) {
            for (int i = this.size - 1; i > 0; i--) {
                for (int j = 0; j < this.size; j++) {
                    if (this.board[i][j] != 0 && this.board[i - 1][j] == 0) {
                        this.board[i - 1][j] = this.board[i][j];
                        this.board[i][j] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private boolean pushDown() {
        boolean moved = false;
        for (int counter = 0; counter < this.size; counter++) {
            for (int i = 0; i < this.size - 1; i++) {
                for (int j = 0; j < this.size; j++) {
                    if (this.board[i][j] != 0 && this.board[i + 1][j] == 0) {
                        this.board[i + 1][j] = this.board[i][j];
                        this.board[i][j] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private boolean pushLeft() {
        boolean moved = false;
        for (int counter = 0; counter < this.size; counter++) {
            for (int j = this.size - 1; j > 0; j--) {
                for (int i = 0; i < this.size; i++) {
                    if (this.board[i][j] != 0 && this.board[i][j - 1] == 0) {
                        this.board[i][j - 1] = this.board[i][j];
                        this.board[i][j] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private boolean pushRight() {
        boolean moved = false;
        for (int counter = 0; counter < this.size; counter++) {
            for (int j = 0; j < this.size - 1; j++) {
                for (int i = 0; i < this.size; i++) {
                    if (this.board[i][j] != 0 && this.board[i][j + 1] == 0) {
                        this.board[i][j + 1] = this.board[i][j];
                        this.board[i][j] = 0;
                        moved = true;
                    }
                }
            }
        }
        return moved;
    }

    private boolean mergeUp() {
        boolean merged = false;
        for (int i = 0; i < this.size - 1; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.board[i][j] == this.board[i + 1][j] && this.board[i][j] != 0) {
                    this.board[i][j] *= 2;
                    this.board[i + 1][j] = 0;
                    merged = true;
                }
            }
        }
        return merged;
    }

    private boolean mergeDown() {
        boolean merged = false;
        for (int i = this.size - 1; i > 0; i--) {
            for (int j = 0; j < this.size; j++) {
                if (this.board[i][j] == this.board[i - 1][j] && this.board[i][j] != 0) {
                    this.board[i][j] *= 2;
                    this.board[i - 1][j] = 0;
                    merged = true;
                }
            }
        }
        return merged;
    }

    private boolean mergeLeft() {
        boolean merged = false;
        for (int j = 0; j < this.size - 1; j++) {
            for (int i = 0; i < this.size; i++) {
                if (this.board[i][j] == this.board[i][j + 1] && this.board[i][j] != 0) {
                    this.board[i][j] *= 2;
                    this.board[i][j + 1] = 0;
                    merged = true;
                }
            }
        }
        return merged;
    }

    private boolean mergeRight() {
        boolean merged = false;
        for (int j = this.size - 1; j > 0; j--) {
            for (int i = 0; i < this.size; i++) {
                if (this.board[i][j] == this.board[i][j - 1] && this.board[i][j] != 0) {
                    this.board[i][j] *= 2;
                    this.board[i][j - 1] = 0;
                    merged = true;
                }
            }
        }
        return merged;
    }

    private void spawn() {
        while (true) {
            int row = this.random.nextInt(this.size);
            int col = this.random.nextInt(this.size);
            int chance = this.random.nextInt(10);
            if (this.board[row][col] == 0 && chance <= 7) {
                this.board[row][col] = 2;
                break;
            } else if (this.board[row][col] == 0 && chance > 7) {
                this.board[row][col] = 4;
                break;
            }
        }
    }
}