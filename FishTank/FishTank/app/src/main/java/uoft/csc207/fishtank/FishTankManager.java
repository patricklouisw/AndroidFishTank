package uoft.csc207.fishtank;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

public class FishTankManager {

    /**
     * All the locations where the items can be.
     */
    public static List<Items> fishTankItems;

    /**
     * All the locations where the items can be.
     */
    public static List<Items> newItems;
    
    /**
     * The width of myLittleFishes.
     */
    private final int gridWidth;

    /**
     * The height of myLittleFishes.
     */
    private final int gridHeight;


    /**
     * Return the width of a row of locations.
     *
     * @return the width of a column of locations.
     */
    public int getGridWidth() {
        return gridWidth;
    }

    /**
     * Return the height of a column of locations.
     *
     * @return the height of a column of locations.
     */
    public int getGridHeight() {
        return gridHeight;
    }

    /**
     * The fish tank manager on a screen with height rows and width columns.
     */
    public FishTankManager(int height, int width) {
        gridHeight = height;
        gridWidth = width;
        fishTankItems = new ArrayList<>();
        newItems = new ArrayList<>();
    }

    public void draw(Canvas canvas) {
        for(Items item : fishTankItems) {
            item.draw(canvas);
        }
    }

    public void update() {
        for(Items item : fishTankItems) {
            item.moveItem();
        }

        if (newItems.size() != 0)
            fishTankItems.addAll(newItems);
    }

    public void createTankItems() {
        fishTankItems.add(new Fish(28, 18));
        fishTankItems.add(new Fish(10, 22));
        fishTankItems.add(new Fish(17, 14));
        fishTankItems.add(new Fish(15, 28));
        fishTankItems.add(new Fish(35, 36));
        fishTankItems.add(new Fish(16, 5));
        fishTankItems.add(new Fish(16, 12));
        fishTankItems.add(new Fish(16, 18));
        fishTankItems.add(new Fish(23, 18));
        fishTankItems.add(new Fish(6, 12));
        fishTankItems.add(new HungryFish(10, 20));
        fishTankItems.add(new Seaweed(4, 9, 33));
        fishTankItems.add(new Seaweed(13, 6, 24));
        fishTankItems.add(new Seaweed(15, 12, 42));
        fishTankItems.add(new Seaweed(20, 5, 13));
    }
}
