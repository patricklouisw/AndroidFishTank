package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

class HungryFish extends Fish {

    private Paint paintText = new Paint();

    HungryFish(int y, int x) {
        super(y, x);
        this.setAppearance("><MEHUNGRY>");
        paintText.setTextSize(36);
        paintText.setColor(Color.CYAN);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
    }

    void draw(Canvas canvas) {
        canvas.drawText(this.getAppearance(), this.getX() * FishTankView.charWidth, this.getY() * FishTankView.charHeight, paintText);
    }

}
