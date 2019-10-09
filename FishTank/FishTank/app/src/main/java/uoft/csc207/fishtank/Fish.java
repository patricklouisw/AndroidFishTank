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
    public Fish(int x, int y) {
        super(x, y);
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
        Bubble b = new Bubble(x, y);
//        System.out.println(x + " " + y);
        FishTankManager.newItems.add(b);
    }


    /**
     * Build and initialize this fish's forward and backward
     * appearances.
     */
    public String reverseAppearance() {
        StringBuilder reverse = new StringBuilder();
        for (int i = appearance.length() - 1; i >= 0; i--) {
            switch (appearance.charAt(i)) {
                case ')':
                    reverse.append('(');
                    break;
                case '(':
                    reverse.append(')');
                    break;
                case '>':
                    reverse.append('<');
                    break;
                case '<':
                    reverse.append('>');
                    break;
                case '}':
                    reverse.append('{');
                    break;
                case '{':
                    reverse.append('}');
                    break;
                case '[':
                    reverse.append(']');
                    break;
                case ']':
                    reverse.append('[');
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
        canvas.drawText(appearance, y * FishTankView.charWidth, x * FishTankView.charHeight, paintText);
    }

    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    public void moveItem() {

        // Move one spot to the right or left in the direction I'm going. If I bump into a wall,
        // turn around.
        if (goingRight) {
            y += 1;
        } else {
            y -= 1;
        }

        // Figure out whether I blow a bubble.
        double d = Math.random();
        if (d < 0.1) {
            blowBubble();
        }

        // Figure out whether I turn around.
        d = Math.random();
        if (d < 0.1) {
            turnAround();
        }

        // Figure out whether to move up or down, or neither.
        d = Math.random();
        if (d < 0.1) {
            x += 1;
        } else if (d < 0.2) {
            x -= 1;
        }
    }
}
