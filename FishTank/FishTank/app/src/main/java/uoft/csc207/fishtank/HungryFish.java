package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class HungryFish extends Fish {

    /**
     * How this fish appears on the screen.
     */
    String appearance;

    /**
     * Constructs a new hungry fish.
     */
    public HungryFish(int x, int y) {
        super(x, y);
        appearance = "><MEHUNGRY>";
        paintText.setTextSize(36);
        paintText.setColor(Color.CYAN);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        goingRight = true;
    }

}
