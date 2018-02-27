package edu.wpi.first.shuffleboard;

import edu.wpi.first.shuffleboard.api.data.ComplexData;
import edu.wpi.first.shuffleboard.api.util.Maps;

import java.util.Map;

public final class Phil extends ComplexData<Phil> {

    private final double x;
    private final double y;
    private final double yaw;

    public Phil(double x, double y, double yaw) {
        this.x = x;
        this.y = y;
        this.yaw = yaw;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getYaw() {
        return yaw;
    }

    @Override
    public Map<String, Object> asMap() {
        return Maps.<String, Object>builder()
                .put("x", x)
                .put("y", y)
                .put("yaw", yaw)
                .build();
    }

    @Override
    public String toString() {
        return this.x + "," + this.y;
    }

    @Override
    public int hashCode() {
        // modified from java.awt.geom.Point2D
        long bits = java.lang.Double.doubleToLongBits(getX());
        bits ^= java.lang.Double.doubleToLongBits(getY());
        bits ^= java.lang.Double.doubleToLongBits(getYaw());
        return (((int) bits) ^ ((int) (bits >> 32)));
    }
}
