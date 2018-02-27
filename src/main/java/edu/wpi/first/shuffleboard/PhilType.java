package edu.wpi.first.shuffleboard;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import edu.wpi.first.shuffleboard.api.util.Maps;

import java.util.Map;
import java.util.function.Function;

public final class PhilType extends ComplexDataType<Phil> {

    public static final PhilType Instance = new PhilType();

    private PhilType() {
        // The name provided here, "Phil" must exactly match the .type entry in the phil_table
        super("Phil", Phil.class);
    }

    @Override
    public Function<Map<String, Object>, Phil> fromMap() {
        return map -> {
            double x = (double) map.getOrDefault("x", -1.0);
            double y = (double) map.getOrDefault("y", -1.0);
            double yaw = (double) map.getOrDefault("yaw", -1.0);
            return new Phil(x, y, yaw);
        };
    }

    @Override
    public Phil getDefaultValue() {
        return new Phil(0, 0, 0);
    }
}