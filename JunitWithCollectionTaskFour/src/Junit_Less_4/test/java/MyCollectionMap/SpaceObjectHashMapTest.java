package MyCollectionMap;

import MyClasses.Discoverer;
import MyClasses.SpaceObject.SpaceObject;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class SpaceObjectHashMapTest {
    private SpaceObjectHashMap map;

    @Before
    public void setUp() throws Exception {
        map = new SpaceObjectHashMap();
    }

    @Test
    public void whenPut100ElementsThenSizeBecome100() {
        for (int i = 0; i < 100; i++) {
            Discoverer discoverer =
                    new Discoverer(i, "Name" + i,
                                      "LastName" + i);
            SpaceObject spaceObject =
                    new SpaceObject("asteroid" + i,
                                   "ShipDestroyer" + i, i + 100);
            map.put(discoverer, spaceObject);
        }
        assertEquals(100, map.size());
    }

    @Test
    public void whenPut100ElementsWith10DifferentKeysThenSize10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            Discoverer discoverer =
                    new Discoverer(index, "Name" + index,
                                          "LastName" + index);
            SpaceObject spaceObject =
                    new SpaceObject("planet",
                                                     "Kenair" + index, index * 1000);
            map.put(discoverer, spaceObject);
        }
        assertEquals(10, map.size());
    }

    @Test
    public void removeReturnTrueOnlyOnce() {
        for (int i = 0; i < 10; i++) {
            Discoverer discoverer =
                    new Discoverer(i, "Name" + i,
                                      "LastName" + i);
            SpaceObject spaceObject =
                    new SpaceObject("star",
                                   "Alpha Talinta" + i, i * 10_000);
            map.put(discoverer, spaceObject);
        }
        assertEquals(10, map.size());

        Discoverer elementForDeleting =
                new Discoverer(5, "Name5",
                                                "LastName5");
        assertTrue(map.remove(elementForDeleting));
        assertEquals(9, map.size());
        assertFalse(map.remove(elementForDeleting));
    }

    @Test
    public void countOfKeysMustBeEqualsToCountOfValues() {
        for (int i = 0; i < 100; i++) {
            Discoverer discoverer =
                    new Discoverer(i, "Name" + i,
                                      "LastName" + i);
            SpaceObject spaceObject =
                    new SpaceObject("komet",
                                   "Ipsius" + i, i);
            map.put(discoverer, spaceObject);
        }
        assertEquals(100, map.size());
        assertEquals(100, map.keySet().size());
        assertEquals(100, map.values().size());
    }

    @Test
    public void methodGetMustReturnRightValue() {
        for (int i = 0; i < 100; i++) {
            Discoverer discoverer =
                    new Discoverer(i, "Name" + i,
                                                       "LastName" + i);
            SpaceObject spaceObject =
                    new SpaceObject("black hole",
                                    "Tolsa" + i, i * 1_000_000);
            map.put(discoverer, spaceObject);
        }
        Discoverer keyForFind =
                new Discoverer(50, "Name50", "LastName50");
        SpaceObject findValue = map.get(keyForFind);
        String expectedSpaceObjectName = "Tolsa50";
        assertEquals(expectedSpaceObjectName, findValue.getNameOfSpaceObject());
    }
}