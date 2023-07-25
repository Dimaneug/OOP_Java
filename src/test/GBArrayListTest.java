package test;

import main.GBArrayList;
import main.GBList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GBArrayListTest {
    @Test
    void addTest() {
        GBList<Double> dbList = new GBArrayList<>();
        dbList.add(2.3);
        Assertions.assertEquals(2.3, dbList.get(0));
    }

    @Test
    void addNegativeTest() {
        GBList<Double> dbList = new GBArrayList<>();
        dbList.add(2.3);
        Assertions.assertNotEquals(2.2, dbList.get(0));
    }
}
