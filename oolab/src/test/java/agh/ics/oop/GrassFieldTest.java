package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    @Test
    void test(){
        IWorldMap map = new GrassField(1);
        Vector2d grassPosition = null;
        Vector2d currPosition;
        int counter = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                currPosition = new Vector2d(i, j);
                if(map.objectAt(currPosition) instanceof Grass){
                    counter++;
                    grassPosition = currPosition;
                }
            }
        }
        assertEquals(counter, 1);
        assertTrue(map.isOccupied(grassPosition));
        assertTrue(map.canMoveTo(grassPosition));
        Animal animal1 = new Animal(map, new Vector2d(0,0));
        Animal animal2 = new Animal(map, new Vector2d(1,1));
        assertTrue(map.place(animal1));
        assertTrue(map.place(animal2));
        assertFalse(map.place(animal1));
        assertEquals(map.objectAt(new Vector2d(0,0)), animal1);
        assertEquals(map.objectAt(new Vector2d(1,1)), animal2);
        assertTrue(map.isOccupied(new Vector2d(1,1)));
        assertFalse((map.isOccupied(new Vector2d(0,1))));
        assertTrue(map.canMoveTo(new Vector2d(1,0)));
        assertFalse(map.canMoveTo(new Vector2d(1,1)));
        assertTrue(map.canMoveTo(new Vector2d(-1,-1)));
    }
}