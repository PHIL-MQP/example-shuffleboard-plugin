package edu.wpi.first.shuffleboard;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.fxmisc.easybind.EasyBind;

@Description(name = "Phil", dataTypes = Phil.class)
@ParametrizedController("PhilWidget.fxml")
public final class PhilWidget extends SimpleAnnotatedWidget<Phil> {

    @FXML
    private Pane root;
    @FXML
    private TextField xLabel;
    @FXML
    private TextField yLabel;
    @FXML
    private TextField yawLabel;

    private Property<Phil> poseProperty = new SimpleObjectProperty<Phil>();
    private Rectangle robot;
    private double metersToPixels = 200;

    @FXML
    private void initialize() {
        xLabel.textProperty().bind(
                EasyBind.monadic(dataOrDefault)
                        .map(Phil::getX)
                        .map(Number::toString)
                        .orElse("0.0"));
        yLabel.textProperty().bind(
                EasyBind.monadic(dataOrDefault)
                        .map(Phil::getY)
                        .map(Number::toString)
                        .orElse("0.0"));
        yawLabel.textProperty().bind(
                EasyBind.monadic(dataOrDefault)
                        .map(Phil::getYaw)
                        .map(Number::toString)
                        .orElse("0.0"));

        robot = new Rectangle(10, 20);
        robot.setFill(Color.GREEN);
        root.getChildren().add(robot);

        poseProperty.bind(dataProperty().orElse(new Phil(0, 0, 0)));
        poseProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            final double robot_x_m = newValue.getX();
            final double robot_y_m = newValue.getY();
            final double robot_yaw_rad = newValue.getYaw();
            robot.setTranslateX(robot_x_m * metersToPixels);
            robot.setTranslateY(robot_y_m * metersToPixels);
            robot.setRotate(Math.toDegrees(robot_yaw_rad));
        });
    }

    @Override
    public Pane getView() {
        return root;
    }
}