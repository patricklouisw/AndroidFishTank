package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

class Bubble extends Items {

    private String appearance;

    private final Paint paintText = new Paint();

    /**
     * Constructs a new bubble at the specified cursor location (x, y).
     */
    Bubble(int y, int x) {
        super(y, x);
        // Get a nice-looking grey for the bubble
        paintText.setTextSize(36);
        paintText.setColor(Color.LTGRAY);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        // start off with . as the appearance
        appearance = ".";
    }

    void draw(Canvas canvas) {
        canvas.drawText(appearance, this.getX() * FishTankView.charWidth, this.getY() * FishTankView.charHeight, paintText);
    }

    void moveItem() {
        int x = this.getX();
        int y = this.getY();

        this.setY(--y);

        double d = Math.random();

        if (d < 0.3) {
            // float right
            this.setX(++x);
        } else if (d < 0.6) {
            // float left
            this.setX(--x);
        }

        if (y == 0) {
            FishTankManager.addingRemoveBubbles(this);
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
