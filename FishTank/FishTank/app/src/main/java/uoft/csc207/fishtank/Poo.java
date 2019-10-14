package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

class Poo extends Items {

    private String appearance;

    private final Paint paintText = new Paint();

    /**
     * Constructs a new poo at the specified cursor location (x, y).
     */
    Poo(int y, int x) {
        super(y, x);
        // Get a nice-looking grey for the bubble
        paintText.setTextSize(30);
        paintText.setColor(Color.rgb(187, 138, 0));
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        // start off with . as the appearance
        appearance = "<POO>";
    }

    void draw(Canvas canvas) {
        canvas.drawText(appearance, this.getX() * FishTankView.charWidth, this.getY() * FishTankView.charHeight, paintText);
    }

    void moveItem() {
        int x = this.getX();
        int y = this.getY();

        if (y != FishTankManager.getGridHeight()-6) {
            this.setY(++y);
        } else if (y == FishTankManager.getGridHeight()-6) {
            FishTankManager.addingBottomPoop(this);
        }
    }

}
