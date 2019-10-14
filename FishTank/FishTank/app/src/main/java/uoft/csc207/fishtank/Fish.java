package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

/**
 * A fish.
 */
class Fish extends Items {

    private static Map<Character, Character> SYMBOLS = new HashMap<>();

    private String appearance;

    private boolean goingRight = true;

    private final Paint paintText = new Paint();

    String getAppearance() {
        return appearance;
    }

    void setAppearance(String s) {
        appearance = s;
    }

    Fish(int y, int x) {
        super(y, x);
        appearance = "><>";
        paintText.setTextSize(36);
        paintText.setColor(Color.CYAN);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        addReversedSymbols();
    }

    private void blowBubble() {
        int x = this.getX();
        int y = this.getY();
        Bubble b = new Bubble(y, x);
        FishTankManager.addingBubbles(b);
    }

    private void poop() {
        int x = this.getX();
        int y = this.getY();
        Poo p = new Poo(y, x);
        FishTankManager.addingPoop(p);
    }

    private static void addReversedSymbols(){
        SYMBOLS.put('>', '<');
        SYMBOLS.put('<', '>');
    }

    private String reverseAppearance() {
        StringBuilder reverse = new StringBuilder();
        for (int i = appearance.length() - 1; i >= 0; i--) {
            reverse.append(SYMBOLS.getOrDefault(appearance.charAt(i), appearance.charAt(i)));
        }
        appearance = reverse.toString();
        return appearance;
    }

    private void turnAround() {
        goingRight = !goingRight;
        appearance = reverseAppearance();
    }

    void draw(Canvas canvas) {
        canvas.drawText(appearance, this.getX() * FishTankView.charWidth, this.getY() * FishTankView.charHeight, paintText);
    }

    void moveItem() {
        int x = this.getX();
        int y = this.getY();
        int width = FishTankManager.getGridWidth();

        if (this instanceof HungryFish){
            width -= 7;
        } else {
            width -= 1;
        }

        // Move one spot to the right or left in the direction I'm going. If I bump into a wall,
        // turn around.
        if (getX() == 0) {
            this.setX(++x);
            turnAround();
        } else if (getX() == width) {
            this.setX(--x);
            turnAround();
        }else {
            if (goingRight) {
                this.setX(++x);
            } else {
                this.setX(--x);
            }

            // Figure out whether I turn around.
            double d = Math.random();
            if (d < 0.1) {
                turnAround();
            }
        }

        // Figure out whether to move up or down, or neither.
        if (getY() == 0) {
            this.setY(++y);
        } else if (getY() == FishTankManager.getGridHeight() - 7) {
            this.setY(--y);
        } else{
            double d = Math.random();
            if (d < 0.1) {
                this.setY(++y);
            } else if (d < 0.2) {
                this.setY(--y);
            }
        }

        // Figure out whether I blow a bubble.
        double d = Math.random();
        if (d < 0.1) {
            blowBubble();
        }

        // Figure out whether I poop.
        d = Math.random();
        if (d < 0.003) {
            poop();
        }
    }

}
