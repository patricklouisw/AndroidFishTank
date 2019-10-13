package uoft.csc207.fishtank;

import android.graphics.Canvas;

public abstract class Items {

    // X-coordinate of the item
    int x;

    // Y-coordinate of the item
    int y;

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

    abstract void moveItem();

    abstract void draw(Canvas canvas);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
