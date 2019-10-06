package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class Seaweed {

    /**
     * This seaweed's current row.
     */
    private int my_curr_row;
    /**
     * This seaweed's current column.
     */
    private int my_curr_col;

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
     * @param l the number of segments this seaweed is tall.
     */
    public Seaweed(int l) {
        this.l = l;
        paintText.setTextSize(36);
        paintText.setColor(Color.GREEN);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
    }

    /**
     * Draws this fish tank item.  Looks lovely waving in the current, doesn't
     * it?
     *
     * @param canvas the graphics context in which to draw this item.
     */
    void draw(Canvas canvas) {

        // Which way does the first segment lean?
        boolean lR = leanRight;

        for (int i = 0; i < l; i++) {
            if ((i % 2 == 0) && lR)
                // Draw a "/" seaweed segment: even numbered and leaning to the right.
                drawString(canvas, "/", -i + my_curr_row, (my_curr_col));
            else if (i % 2 == 0) {
                // Draw a "\\" seaweed segment: even numbered and leaning to the left.
                drawString(canvas, "\\", -i + my_curr_row, (my_curr_col));
            }
            else if (lR) {
                // Draw a "/" seaweed segment: odd numbered and leaning to the right.
                drawString(canvas, "\\", -i + my_curr_row, (my_curr_col));
            } else{
                // Draw the string for the last kind of leaning of the segment at location  my_curr_row,(-i+my_curr_col)
                drawString(canvas, "/", -i + my_curr_row, (my_curr_col));
                }
        }
    }

    /**
     * Draws the given string in the given graphics context at
     * at the given cursor location.
     *
     * @param canvas where to draw the string.
     * @param s      the string to draw.
     * @param x      the x-coordinate of the string's cursor location.
     * @param y      the y-coordinate of the string's cursor location.
     */
    private void drawString(Canvas canvas, String s, int x, int y) {
        canvas.drawText(s, y * FishTankView.charWidth, x * FishTankView.charHeight, paintText);
    }

    /**
     * Set this item's location.
     *
     * @param a the first coordinate.
     * @param b the second coordinate.
     */
    void setLocation(int a, int b) {
        this.my_curr_row = a;
        this.my_curr_col = b;
    }

    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    void wave() {
        leanRight = !leanRight;
    }

}