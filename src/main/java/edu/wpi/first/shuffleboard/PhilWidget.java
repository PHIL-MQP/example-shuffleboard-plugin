package edu.wpi.first.shuffleboard;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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
    }

    @Override
    public Pane getView() {
        return root;
    }
}