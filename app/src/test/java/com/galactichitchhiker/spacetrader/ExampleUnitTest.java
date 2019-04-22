package com.galactichitchhiker.spacetrader;

import com.galactichitchhiker.spacetrader.models.Ship;

import com.galactichitchhiker.spacetrader.models.TradeGoods;
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

    @Test(timeout = TIMEOUT)
    public void testAddCargoOf() {

        assertEquals("Cargo doesn't begin empty", 0, ship.getUsedCargoSpace());
        int prevCargoSpace = ship.getUsedCargoSpace();

        // All cargo types can be added correctly
        for (TradeGoods good: TradeGoods.values()) {
            ship.addCargoOf(good, 1);
            assertEquals("Cargo type" + good.name() + "is added incorrectly", 1, ship.getCargoAmountOf(good));
            assertEquals("Cargo space is inaccurate", prevCargoSpace + 1, ship.getUsedCargoSpace());
            prevCargoSpace = ship.getUsedCargoSpace();
        }

        int oldCargoVal = ship.getCargoAmountOf(TradeGoods.WATER);
        ship.addCargoOf(TradeGoods.WATER, -1);
        assertEquals("Can't add negative cargo", oldCargoVal, ship.getCargoAmountOf(TradeGoods.WATER));
        assertEquals("Cargo space is inaccurate after negative add", prevCargoSpace, ship.getUsedCargoSpace());
        prevCargoSpace = ship.getUsedCargoSpace();

        ship.addCargoOf(TradeGoods.WATER, ship.getMaxCargoSpace() + 1);
        assertEquals("Can't exceed max cargo space", oldCargoVal, ship.getCargoAmountOf(TradeGoods.WATER));
        assertEquals("Cargo space is inaccurate after exceeding max space", prevCargoSpace, ship.getUsedCargoSpace());

    }

    @Test(timeout = TIMEOUT)
    public void testRemoveCargoOf() {
        for (TradeGoods good : TradeGoods.values()) {
            ship.addCargoOf(good, 1);
        }
        ship.removeCargoOf(null, 0);
        for (TradeGoods good : TradeGoods.values()) {
            assertEquals("Cargo amount changed when TradeGood g is null", 1, ship.getCargoAmountOf(good));
        }
        assertEquals("Used cargo space is inaccurate when TradeGood g is null", ship.getUsedCargoSpace(), TradeGoods.values().length);


        ship.removeCargoOf(TradeGoods.FOOD, 1);
        for (TradeGoods good : TradeGoods.values()) {
            if (!good.equals(TradeGoods.FOOD)) {
                assertEquals("Cargo amount changed for the wrong TradeGood", 1, ship.getCargoAmountOf(good));
            } else {
                assertEquals("Removed the incorrect amount of cargo", 0, ship.getCargoAmountOf(good));
                assertEquals("Cargo amount of good changed incorrectly", 0, ship.getCargoAmountOf(good));
            }
        }
        assertEquals("Used cargo space is inaccurate after change", ship.getUsedCargoSpace(), TradeGoods.values().length - 1);


        ship.removeCargoOf(TradeGoods.FIREARMS, -1);
        for (TradeGoods good : TradeGoods.values()) {
            if (!good.equals(TradeGoods.FOOD)) {
                assertEquals("Cargo amount changed when num is negative", 1, ship.getCargoAmountOf(good));
            }
        }
        assertEquals("Used cargo space is inaccurate when num is negative", ship.getUsedCargoSpace(), TradeGoods.values().length - 1);


        ship.removeCargoOf(TradeGoods.FURS, 3);
        assertEquals("Should not remove cargo when num is greater than amount of cargo stored", 1, ship.getCargoAmountOf(TradeGoods.FURS));
        assertEquals("Used cargo space is inaccurate after change", ship.getUsedCargoSpace(), TradeGoods.values().length - 1);


        int usedCargoSpace = TradeGoods.values().length;
        ship.addCargoOf(TradeGoods.FOOD, 1);
        for (TradeGoods good : TradeGoods.values()) {
            ship.removeCargoOf(good, 1);
            assertEquals("Cargo amount of good changed incorrectly", 0, ship.getCargoAmountOf(good));
            usedCargoSpace--;
            assertEquals("Used cargo space is inaccurate after change", usedCargoSpace, ship.getUsedCargoSpace());

        }

    }

    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }








}