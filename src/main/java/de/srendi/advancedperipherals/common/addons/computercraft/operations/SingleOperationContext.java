package de.srendi.advancedperipherals.common.addons.computercraft.operations;

import java.io.Serializable;

public class SingleOperationContext implements Serializable {
    private int count;
    private final int distance;

    public SingleOperationContext(int count, int distance) {
        this.count = count;
        this.distance = distance;
    }

    public int getCount() {
        return count;
    }

    public int getDistance() {
        return distance;
    }

    public SingleOperationContext extraCount(int extra) {
        this.count += extra;
        return new SingleOperationContext(extra, distance);
    }
}
