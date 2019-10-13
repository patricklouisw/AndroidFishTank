package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class Seaweed extends Items {

    /**
     * This is seaweed's colour
     */
    final Paint paintText = new Paint();


    /**
     * The number of weed segments.
     */
    final int l;

    /**
     * Indicates whether the bottom segment is leaning right.
     */
    boolean leanRight;

    /**
     * Constructs a new seaweed item at the specified cursor
     * location (x,y),l segments tall.
     *
     * @param x the x-coordinate of the seaweed.
     * @param y the y-coordinate of the seaweed.
     * @param l the number of segments this seaweed is tall.
     */
    public Seaweed(int y, int x, int l) {
        super(y, x);
        this.l = l;
        paintText.setTextSize(36);
        paintText.setColor(Color.GREEN);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        leanRight = true;
    }

    /**
     * Draws this fish tank item.  Looks lovely waving in the current, doesn't
     * it?
     *
     * @param canvas the graphics context in which to draw this item.
     */
    public void draw(Canvas canvas) {

        // Which way does the first segment lean?
        boolean lR = leanRight;

        for (int i = 0; i < l; i++) {
            if ((i % 2 == 0) && lR) {
                // Draw a "/" seaweed segment: even numbered and leaning to the right.
                canvas.drawText("/", x * FishTankView.charWidth, (-i + y) * FishTankView.charHeight, paintText);

            } else if (i % 2 == 0 && !lR) {
                // Draw a "\\" seaweed segment: even numbered and leaning to the left.
                canvas.drawText("\\", x * FishTankView.charWidth, (-i + y) * FishTankView.charHeight, paintText);

            } else if (lR) {
                // Draw a "/" seaweed segment: odd numbered and leaning to the right.
                canvas.drawText("\\", x * FishTankView.charWidth, (-i + y) * FishTankView.charHeight, paintText);

            } else{
                // Draw the string for the last kind of leaning of the segment at location  my_curr_row,(-i+my_curr_col)
                canvas.drawText("/", x * FishTankView.charWidth, (-i + y) * FishTankView.charHeight, paintText);
            }
        }
    }

    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    public void moveItem() {
        leanRight = !leanRight;
    }

}