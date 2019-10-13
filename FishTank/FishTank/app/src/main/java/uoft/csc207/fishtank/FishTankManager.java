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

    public static List<Poo> bottomPoop;
    
    /**
     * The width of myLittleFishes.
     */
    private static int gridWidth;

    /**
     * The height of myLittleFishes.
     */
    private static int gridHeight;


    /**
     * Return the width of a row of locations.
     *
     * @return the width of a column of locations.
     */
    public static int getGridWidth() {
        return gridWidth;
    }

    /**
     * Return the height of a column of locations.
     *
     * @return the height of a column of locations.
     */
    public static int getGridHeight() {
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
        bottomPoop = new ArrayList<>();
    }

    public static void removeItem(Items b) {
        if (fishTankItems.contains(b)){
            fishTankItems.remove(b);
        }
    }

//    public static boolean isEmpty(int x, int y) {
//        for(Items item : fishTankItems) {
//            int x_item = item.getX();
//            int y_item = item.getY();
//            if (x == x_item && y == y_item){
//                return false;
//            }
//        }
//        return true;
//    }

//    public static void removeItem(Items item) {
//        fishTankItems.remove(item);
//    }

    public void draw(Canvas canvas) {
        for(Items item : fishTankItems) {
            item.draw(canvas);
        }
    }

    public void cleanFishTankItems() {
        fishTankItems.addAll(newItems);
        newItems.clear();

        for(Items item : fishTankItems) {
            if (item instanceof Bubble ) {
                if (item.getY() == 0) {
                    removeItem(item);
                }
            } else if (item instanceof Crab && bottomPoop.size() != 0) {
                for (Poo p : bottomPoop) {
                    if (p.getX() == item.getX()) {
                        bottomPoop.remove(p);
                        removeItem(p);
                    }
                }
            }
        }
    }

    public void update() {
        for(Items item : fishTankItems) {
            if (item instanceof Poo && (item.getY() == FishTankManager.getGridHeight()-6)) {
                bottomPoop.add((Poo) item);
                continue;
            }else {
                item.moveItem();
            }
        }
        cleanFishTankItems();
    }

    public void createTankItems() {
        fishTankItems.add(new Ground(FishTankManager.getGridHeight()-5, 0 ,FishTankManager.getGridWidth() - 1));
//        fishTankItems.add(new Fish(18, 28));
//        fishTankItems.add(new Fish(22, 10));
//        fishTankItems.add(new Fish(14, 17));
//        fishTankItems.add(new Fish(28, 15));
        fishTankItems.add(new Fish(36, 35));
        fishTankItems.add(new Fish(5, 16));
        fishTankItems.add(new Fish(12, 16));
        fishTankItems.add(new Fish(18, 16));
        fishTankItems.add(new Fish(18, 23));
        fishTankItems.add(new Fish(12, 6));
        fishTankItems.add(new Crab(FishTankManager.getGridHeight()-6, 0));
        fishTankItems.add(new HungryFish(20, 10));

        fishTankItems.add(new Seaweed(33, 4, 9));
        fishTankItems.add(new Seaweed(24, 13, 6));
        fishTankItems.add(new Seaweed(42, 15, 12));
        fishTankItems.add(new Seaweed(13, 20, 5));

    }


}
