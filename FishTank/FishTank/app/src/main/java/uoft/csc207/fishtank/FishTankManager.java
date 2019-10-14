package uoft.csc207.fishtank;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

class FishTankManager {

    /**
     * All the locations where the items can be.
     */
    private static List<Items> fishTankItems;

    /**
     * Any additional items that will be added into the tank can be store in the variables below
     */
    private static List<Bubble> addBubbles;

    private static ArrayList<Bubble> removeBubbles;

    private static List<Poo> bottomPoop;

    private static List<Poo> removePoop;

    private static List<Poo> addPoop;

    static void addingBubbles(Bubble b) {
        addBubbles.add(b);
    }

    static void addingRemoveBubbles(Bubble b) {
        removeBubbles.add(b);
    }

    static void addingBottomPoop(Poo p) {
        bottomPoop.add(p);
    }

    static void addingRemovePoop(Poo p) {
        removePoop.add(p);
    }

    static void addingPoop(Poo p) {
        addPoop.add(p);
    }

    static List<Poo> getBottomPoop(){
        return bottomPoop;
    }

    static void removeBottomPoop(List<Poo> p){
        bottomPoop.removeAll(p);
    }

    /**
     * The width of the Tank.
     */
    private static int gridWidth;

    /**
     * The height of the Tank.
     */
    private static int gridHeight;

    static int getGridWidth() {
        return gridWidth;
    }

    static int getGridHeight() {
        return gridHeight;
    }

    /**
     * The fish tank manager on a screen with height rows and width columns.
     */
    FishTankManager(int height, int width) {
        gridHeight = height;
        gridWidth = width;
        fishTankItems = new ArrayList<>();
        addBubbles = new ArrayList<>();
        removeBubbles = new ArrayList<>();
        bottomPoop = new ArrayList<>();
        removePoop = new ArrayList<>();
        addPoop = new ArrayList<> ();
    }

    void draw(Canvas canvas) {
        for(Items item : fishTankItems) {
            item.draw(canvas);
        }
    }

    void update() {
        for(Items item : fishTankItems) {
                item.moveItem();
        }
        fishTankItems.addAll(addPoop);
        addPoop.clear();
        fishTankItems.addAll(addBubbles);
        addBubbles.clear();
        fishTankItems.removeAll(removeBubbles);
        removeBubbles.clear();
        fishTankItems.removeAll(removePoop);
        removePoop.clear();
    }

    void createTankItems() {
        fishTankItems.add(new Ground(FishTankManager.getGridHeight()-5, 0 ,FishTankManager.getGridWidth() - 1));
        fishTankItems.add(new Fish(18, 28));
        fishTankItems.add(new Fish(22, 10));
        fishTankItems.add(new Fish(14, 17));
        fishTankItems.add(new Fish(28, 15));
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
