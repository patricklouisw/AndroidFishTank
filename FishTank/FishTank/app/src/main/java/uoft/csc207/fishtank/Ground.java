package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

class Ground extends Items{

    private String appearance;

    private final Paint paintText = new Paint();

    private final int l;

    Ground(int y, int x, int l) {
        super(y,1);
        appearance = "=";

        paintText.setTextSize(36);
        paintText.setColor(Color.YELLOW);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);

        this.l = l;
    }

    void draw(Canvas canvas) {
        for (int i = 0; i < l; i++) {
            canvas.drawText(appearance, (this.getX() + i) * FishTankView.charWidth, this.getY() * FishTankView.charHeight, paintText);
        }
    }

    void moveItem(){}

}
