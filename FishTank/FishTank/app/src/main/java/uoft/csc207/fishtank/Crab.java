package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * A
 */
public class Crab extends Items {

    /**
     * How this fish appears on the screen.
     */
    String appearance;

    /**
     * Indicates whether this fish is moving right.
     */
    boolean goingRight;

    final Paint paintText = new Paint();

    /**
     * Constructs a new fish.
     */
    public Crab(int y, int x) {
        super(y, x);
        appearance = ">@(i~i)@< ";
        paintText.setTextSize(36);
        paintText.setColor(Color.RED);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        goingRight = true;
    }

    /**
     * Turns this crab around, causing it to reverse direction.
     */
    public void turnAround() {
        goingRight = !goingRight;
    }

    /**
     * Draws this fish tank item.
     *
     * @param canvas the canvas on which to draw this item.
     */
    public void draw(Canvas canvas) {
        canvas.drawText(appearance, x * FishTankView.charWidth, y * FishTankView.charHeight, paintText);
    }

    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    public void moveItem() {

        // Move one spot to the right or left in the direction I'm going. If I bump into a wall,
        // turn around.
        if (getX() == 0) {
            x++;
            turnAround();
        } else if (getX() == FishTankManager.getGridWidth() - 1) {
            x--;
            turnAround();
        }else {
            if (goingRight) {
                x++;
            } else {
                x--;
            }
        }

        removePoop();
    }

    public void removePoop() {
        if (FishTankManager.bottomPoop.size() != 0) {
            for (Poo p : FishTankManager.bottomPoop) {
                int poop_x = p.getX();
                if (poop_x == x) {
                    FishTankManager.removePoop.add(p);
                }
            }
        }
    }

}
