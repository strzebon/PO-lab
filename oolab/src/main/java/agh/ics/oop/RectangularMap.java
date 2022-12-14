package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    private final int width;
    private final  int height;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width-1,height-1);
        this.animals = new HashMap<>();
        this.visualizer = new MapVisualizer(this);
    }

    @Override
    public Vector2d checkLowerLeft() {
        return this.lowerLeft;
    }

    @Override
    public Vector2d checkUpperRight() {
        return this.upperRight;
    }
}
