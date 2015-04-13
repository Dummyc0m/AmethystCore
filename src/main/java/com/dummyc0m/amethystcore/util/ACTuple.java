package com.dummyc0m.amethystcore.util;

/**
 * Created by Dummyc0m on 3/3/15.
 */
public class ACTuple<X, Y> {
    public final X x;
    public final Y y;

    public ACTuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ACTuple tuple = (ACTuple) o;

        if (x != null ? !x.equals(tuple.x) : tuple.x != null) return false;
        if (y != null ? !y.equals(tuple.y) : tuple.y != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}
