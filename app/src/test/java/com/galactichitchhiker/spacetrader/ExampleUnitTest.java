package com.galactichitchhiker.spacetrader;

import com.galactichitchhiker.spacetrader.models.Ship;

import org.junit.Before;
import org.junit.Test;

import static com.galactichitchhiker.spacetrader.models.ShipType.GNAT;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private static int failures = 0;
    private static int successes = 0;
    private static final int TIMEOUT = 200;

    private Ship ship;


    @Before
    public void setup() {
        ship = new Ship(GNAT);
        //fuel capacity should be 14 now
    }

    @Test(timeout = TIMEOUT)
    public void testSubtractFuel() {
        //whitebox tech: should test: sub < 0, sub >= 0, fuel - sub < 0, fuel - sub >= 0
        //sub < 0
        ship.subtractFuel(-1);
        assertEquals("returned map has incorrect values",
                14.0, ship.getFuel(), 0.0000000001);
        //double's precision problems

        //sub >= 0, fuel - sub >= 0
        ship.subtractFuel(0);
        assertEquals("returned map has incorrect values",
                14.0, ship.getFuel(), 0.0000000001);
        ship.subtractFuel(1);
        assertEquals("returned map has incorrect values",
                13.0, ship.getFuel(), 0.0000000001);

        //sub >= 0, fuel - sub < 0
        ship.subtractFuel(14);
        assertEquals("returned map has incorrect values",
                0.0, ship.getFuel(), 0.0000000001);
    }


    @Test(timeout = TIMEOUT)
    public void testAddFuel() {

        assertEquals("Ship does not have initially full tank", ship.getFuel(), ship.getFuelCapacity(), 0.0000000001);


        ship.subtractFuel(10);

        ship.addFuel(-10);

        assertEquals("Add fuel does not handle negative value", ship.getFuel(), ship.getFuelCapacity() - 10, 0.0000000001);


        ship.addFuel(5);

        assertEquals("Does not add fuel correctly", ship.getFuel(), ship.getFuelCapacity() - 5, 0.0000000001);


        ship.addFuel(100);

        assertEquals("Does not overflow when adding fuel correctly", ship.getFuel(), ship.getFuelCapacity(), 0.0000000001);

    }

    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }








}