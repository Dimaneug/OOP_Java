package myFileRepository;

import java.io.Serializable;
import java.util.Objects;

public class TestID implements IDable<TestID>, Serializable {
    int val;

    public TestID() {
        val = 0;
    }

    public TestID(int val) {
        this.val = val;
    }

    @Override
    public TestID increase() {
        return new TestID(this.val + 1);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestID testID = (TestID) o;
        return val == testID.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
