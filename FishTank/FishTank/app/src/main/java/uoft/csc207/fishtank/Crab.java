package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.util.ArrayList;
import java.util.List;

class Crab extends Items {


    private String appearance;

    private boolean goingRight;

    private final Paint paintText = new Paint();

    Crab(int y, int x) {
        super(y, x);
        appearance = ">@(i~i)@< ";
        paintText.setTextSize(36);
        paintText.setColor(Color.RED);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        goingRight = true;
    }

    private void turnAround() {
        goingRight = !goingRight;
    }

    void draw(Canvas canvas) {
        canvas.drawText(appearance, this.getX() * FishTankView.charWidth, this.getY() * FishTankView.charHeight, paintText);
    }

    void moveItem() {
        int x = this.getX();

        // Move one spot to the right or left in the direction I'm going. If I bump into a wall,
        // turn around.
        if (x == 0) {
            this.setX(++x);
            turnAround();
            removePoop();
        } else if (x == FishTankManager.getGridWidth() - 5) {
            this.setX(--x);
            removeSidePoop();
            turnAround();
        } else {
            if (goingRight) {
                this.setX(++x);
            } else {
                this.setX(--x);
            }
            removePoop();
        }

    }

    private void removePoop() {
        List<Poo> erasedPoops = new ArrayList<>();
        List<Poo> bottomPoop = FishTankManager.getBottomPoop();
        if (bottomPoop.size() != 0) {
            for (Poo p : bottomPoop) {
                if (p.getX() == this.getX()) {
                    FishTankManager.addingRemovePoop(p);
                    erasedPoops.add(p);
                }
            }
        }
        FishTankManager.removeBottomPoop(erasedPoops);
    }

    /**
     * Remove all the poop at the right side of the boundary
     */
    private void removeSidePoop() {
        List<Poo> erasedPoops = new ArrayList<>();
        List<Poo> bottomPoop = FishTankManager.getBottomPoop();
        if (bottomPoop.size() != 0) {
            for (Poo p : bottomPoop) {
                if (p.getX() >= this.getX()) {
                    FishTankManager.addingRemovePoop(p);
                    erasedPoops.add(p);
                }
            }
        }
        FishTankManager.removeBottomPoop(erasedPoops);
    }

}
