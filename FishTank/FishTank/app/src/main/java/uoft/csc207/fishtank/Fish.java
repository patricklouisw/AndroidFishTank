package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * A fish.
 */
public class Fish extends Items {

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
    public Fish(int y, int x) {
        super(y, x);
        appearance = "><>";
        paintText.setTextSize(36);
        paintText.setColor(Color.CYAN);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        goingRight = true;
    }


    /**
     * Causes this fish to blow a bubble.
     */
    public void blowBubble() {
        Bubble b = new Bubble(y, x);
//        System.out.println(x + " " + y);
        FishTankManager.addBubbles.add(b);
    }

    public void poop() {
        Poo p = new Poo(y, x);
        FishTankManager.fishTankItems.add(p);
    }


    /**
     * Build and initialize this fish's forward and backward
     * appearances.
     */
    public String reverseAppearance() {
        StringBuilder reverse = new StringBuilder();
        for (int i = appearance.length() - 1; i >= 0; i--) {
            switch (appearance.charAt(i)) {
                case '>':
                    reverse.append('<');
                    break;
                case '<':
                    reverse.append('>');
                    break;
                default:
                    reverse.append(appearance.charAt(i));
                    break;
            }
        }
        appearance = reverse.toString();
        return appearance;
    }

    /**
     * Turns this fish around, causing it to reverse direction.
     */
    public void turnAround() {
        goingRight = !goingRight;
        appearance = reverseAppearance();
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

            // Figure out whether I turn around.
            double d = Math.random();
            if (d < 0.1) {
                turnAround();
            }
        }

        // Figure out whether to move up or down, or neither.
        if (getY() == 0) {
            y++;
        } else if (getY() == FishTankManager.getGridHeight() - 5) {
            y--;
        } else{
            double d = Math.random();
            if (d < 0.1) {
                y++;
            } else if (d < 0.2) {
                y--;
            }
        }

        // Figure out whether I blow a bubble.
        double d = Math.random();
        if (d < 0.1) {
            blowBubble();
        }

        // Figure out whether I poop.
        d = Math.random();
        if (d < 0.005) {
            poop();
        }
    }

}
