package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class Ground extends Items{

    String appearance;

    final Paint paintText = new Paint();

    final int l;

    public Ground(int y, int x, int l) {
        super(y,1);
        appearance = "=";

        paintText.setTextSize(36);
        paintText.setColor(Color.YELLOW);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);

        this.l = l;
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i < l; i++) {
            canvas.drawText(appearance, (x + i) * FishTankView.charWidth, y * FishTankView.charHeight, paintText);
        }
    }

    public void moveItem(){}

}
