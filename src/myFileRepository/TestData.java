package myFileRepository;

import java.io.Serializable;

public class TestData implements Serializable {
    String testString;
    int testInt;

    public TestData(String testString, int testInt) {
        this.testString = testString;
        this.testInt = testInt;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "testString='" + testString + '\'' +
                ", testInt=" + testInt +
                '}';
    }
}
