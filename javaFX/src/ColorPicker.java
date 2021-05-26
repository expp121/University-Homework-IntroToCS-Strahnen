import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ColorPicker extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Color Picker");
        stage.setWidth(400);
        stage.setHeight(200);
        String[] colors = {"Red: ", "Green: ", "Blue: "};
        Label[] labels = new Label[3];
        Slider[] sliders = new Slider[3];

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new Label(colors[i]);
            sliders[i] = new Slider(0, 255, 0);
            sliders[i].setShowTickLabels(true);
        }

        HBox root = new HBox(10,
                new VBox(
                        new HBox(20, labels[0], sliders[0]),
                        new HBox(20, labels[1], sliders[1]),
                        new HBox(20, labels[2], sliders[2])
                ),
                new Rectangle(100, 100, Color.RED)
        );
        root.setPadding(new Insets(10));

        for (int i = 0; i < sliders.length; i++) {
            int finalI = i;
            sliders[i].valueProperty().addListener((observableValue, number, t1) -> {
                labels[finalI].setText(colors[finalI] + (int) sliders[finalI].getValue());

                ((Rectangle) (root.getChildren().get(1))).setFill(Paint.valueOf("rgb(" + (int) sliders[0].getValue() + ","
                        + (int) sliders[1].getValue() + ","
                        + (int) sliders[2].getValue() + ')'
                ));
            });
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
