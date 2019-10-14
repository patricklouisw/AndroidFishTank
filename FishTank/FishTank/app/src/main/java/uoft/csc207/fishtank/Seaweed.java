package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

class Seaweed extends Items {

    /**
     * This is seaweed's colour
     */
    private final Paint paintText = new Paint();


    /**
     * The number of weed segments.
     */
    private final int l;

    /**
     * Indicates whether the bottom segment is leaning right.
     */
    private boolean leanRight;

    /**
     * Constructs a new seaweed item at the specified cursor
     * location (x,y),l segments tall.
     *
     * @param x the x-coordinate of the seaweed.
     * @param y the y-coordinate of the seaweed.
     * @param l the number of segments this seaweed is tall.
     */
    Seaweed(int y, int x, int l) {
        super(y, x);
        this.l = l;
        paintText.setTextSize(36);
        paintText.setColor(Color.GREEN);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        leanRight = true;
    }


    void draw(Canvas canvas) {

        // Which way does the first segment lean?
        boolean lR = leanRight;

        for (int i = 0; i < l; i++) {
            if (((i % 2 == 0) && lR) || ((i % 2 == 1) && !lR)) {
                // Draw a "/" seaweed segment: even numbered and leaning to the right.
                canvas.drawText("/", this.getX() * FishTankView.charWidth, (-i + this.getY()) * FishTankView.charHeight, paintText);

            } else {
                // Draw a "\\" seaweed segment: even numbered and leaning to the left.
                canvas.drawText("\\", this.getX() * FishTankView.charWidth, (-i + this.getY()) * FishTankView.charHeight, paintText);
            }
        }
    }

    void moveItem() {
        leanRight = !leanRight;
    }

}