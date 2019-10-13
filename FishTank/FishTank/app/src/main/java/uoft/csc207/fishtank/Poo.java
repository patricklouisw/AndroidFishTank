package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * A Poo
 */
public class Poo extends Items {

    /**
     * How this bubble appears on the screen.
     */
    private String appearance;

    final Paint paintText = new Paint();

    /**
     * Constructs a new bubble at the specified cursor location (x, y).
     */
    public Poo(int y, int x) {
        super(y, x);
        // Get a nice-looking grey for the bubble
        paintText.setTextSize(30);
        paintText.setColor(Color.rgb(187, 138, 0));
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        // start off with . as the appearance
        appearance = "<POO>";
    }

    /**
     * Draws this fish tank item.
     *
     * @param canvas the graphics context in which to draw this item.
     */
    public void draw(Canvas canvas) {
        canvas.drawText(appearance, x * FishTankView.charWidth, y * FishTankView.charHeight, paintText);
    }

    public void moveItem() {
        y++; //move down
    }

}
