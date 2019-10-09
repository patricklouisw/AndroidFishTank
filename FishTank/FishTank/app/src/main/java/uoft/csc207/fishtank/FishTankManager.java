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
        fishTankItems.addAll(newItems);
    }

    public void createTankItems() {
        fishTankItems.add(new Fish(18, 28));
        fishTankItems.add(new Fish(22, 10));
        fishTankItems.add(new Fish(14, 17));
        fishTankItems.add(new Fish(28, 15));
        fishTankItems.add(new Fish(18, 43));
        fishTankItems.add(new Fish(5, 16));
        fishTankItems.add(new Fish(12, 16));
        fishTankItems.add(new Fish(22, 16));
        fishTankItems.add(new Fish(18, 23));
        fishTankItems.add(new Fish(12, 6));
        fishTankItems.add(new HungryFish(20, 10));

//        fishTankItems.add(new Seaweed(5, 5, 33));
//        fishTankItems.add(new Seaweed(5, 4, 24));
//        fishTankItems.add(new Seaweed(5, 6, 42));
//
//        fishTankItems.add(new Seaweed(10, 10, 42));
//        fishTankItems.add(new Seaweed(9, 10, 42));
//        fishTankItems.add(new Seaweed(11, 10, 42));
        fishTankItems.add(new Seaweed(4, 33, 9));
        fishTankItems.add(new Seaweed(13, 24, 6));
        fishTankItems.add(new Seaweed(15, 42, 12));
        fishTankItems.add(new Seaweed(20, 13, 5));
    }
}
