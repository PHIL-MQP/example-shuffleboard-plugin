package edu.wpi.first.shuffleboard;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

import java.util.List;
import java.util.Map;

@Description(
        group = "edu.wpi.first.shuffleboard",
        name = "Example Plugin",
        version = "0.0.0",
        summary = "This is an example plugin for testing"
)
public class ExamplePlugin extends Plugin {

    // Gets the data types defined by this plugin
    @Override
    public List<DataType> getDataTypes() {
        return ImmutableList.of(PhilType.Instance);
    }

    // Gets the components defined by this plugin
    @Override
    public List<ComponentType> getComponents() {
        return ImmutableList.of(
                WidgetType.forAnnotatedWidget(PhilWidget.class)
        );
    }

    // Gets the default components to use for each data type
    @Override
    public Map<DataType, ComponentType> getDefaultComponents() {
        return ImmutableMap.<DataType, ComponentType>builder()
                .put(PhilType.Instance, WidgetType.forAnnotatedWidget(PhilWidget.class))
                .build();
    }
}
