package uoft.csc207.fishtank;

import android.graphics.Canvas;

abstract class Items {

    // X-coordinate of the item
    private int x;

    // Y-coordinate of the item
    private int y;

    /**
     * Constructs aan item in the fish tank/
     *
     * @param row the x-coordinate of this item.
     * @param col the y-coordinate of this item.
     */

    Items(int col, int row) {
        this.x = row;
        this.y = col;
    }

    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    abstract void moveItem();

    /**
     * Draws this fish tank item.
     *
     * @param canvas the graphics context in which to draw this item.
     */
    abstract void draw(Canvas canvas);

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
