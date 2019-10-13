package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class HungryFish extends Fish {

//    /**
//     * How this fish appears on the screen.
//     */
//    String appearance;

    /**
     * Defines colour pattern for this hungry fish.
     */
    private Paint paintText = new Paint();

    /**
     * Constructs a new hungry fish.
     */
    public HungryFish(int y, int x) {
        super(y, x);
        appearance = "><MEHUNGRY>";
        paintText.setTextSize(36);
        paintText.setColor(Color.CYAN);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        goingRight = true;
    }

    /**
     * Draws appearance of this hungry fish in the given graphics context at the given cursor
     * location.
     *
     * @param canvas the graphics context in which to draw the string.
     */
    public void draw(Canvas canvas) {
        canvas.drawText(appearance, x * FishTankView.charWidth, y * FishTankView.charHeight, paintText);
    }

}
