package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * A bubble.
 */
public class Bubble extends Items {

    /**
     * How this bubble appears on the screen.
     */
    private String appearance;

    final Paint paintText = new Paint();

    /**
     * Constructs a new bubble at the specified cursor location (x, y).
     */
    public Bubble(int x, int y) {
        super(x, y);
        // Get a nice-looking grey for the bubble
        paintText.setTextSize(36);
        paintText.setColor(Color.LTGRAY);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        // start off with . as the appearance
        appearance = ".";
    }

    /**
     * Draws this fish tank item.
     *
     * @param canvas the graphics context in which to draw this item.
     */
    public void draw(Canvas canvas) {
        canvas.drawText(appearance, y * FishTankView.charWidth, x * FishTankView.charHeight, paintText);

    }

    public void moveItem() {
        y--; //move up
        double d = Math.random();

        if (d < 0.3) {
            // float right
            x++;
        } else if (d > 0.6) {
            // float left
            x--;
        }

        // Figure out whether to grow, if at all.
        d = Math.random();
        // Occasionally change a . to a o or a o to a O
        if (d < 0.05) {
            // If the appearance is a ., change it to an o
            if (appearance.equals(".")) appearance = "o";
                // If the appearance is an o, change it to a O
            else if (appearance.equals("o")) appearance = "O";
        }

    }

}
