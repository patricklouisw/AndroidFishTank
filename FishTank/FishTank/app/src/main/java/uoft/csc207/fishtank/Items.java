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
     * @param x the x-coordinate of this item.
     * @param y the y-coordinate of this item.
     */

    Items(int x, int y) {
        this.x = x;
        this.y = y;
    }

    abstract void moveItem();

    abstract void draw(Canvas canvas);

}
