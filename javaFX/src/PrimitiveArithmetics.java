import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PrimitiveArithmetics extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Primitive Arithmetics");
        stage.setWidth(500);
        stage.setHeight(150);

        GridPane gridPane = new GridPane();
        Button button = new Button("Compute");

        Label exceptionLabel = new Label(),
                minusLabel = new Label(),
                plusLabel = new Label();

        TextField textField1 = new TextField(),
                textField2 = new TextField();

        gridPane.add(textField1, 0, 0);
        gridPane.add(textField2, 0, 1);
        gridPane.add(button, 1, 0);
        gridPane.add(exceptionLabel, 1, 1);
        gridPane.add(plusLabel, 2, 0);
        gridPane.add(minusLabel, 2, 1);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Scene pane = new Scene(gridPane);
        stage.setScene(pane);

        button.setOnAction(actionEvent -> {
            StringBuilder num1_text = new StringBuilder(textField1.getText());
            StringBuilder num2_text = new StringBuilder(textField2.getText());

            try {
                int num1 = Integer.parseInt(num1_text.toString());
                int num2 = Integer.parseInt(num2_text.toString());
                plusLabel.setText(num1 + " + " + num2 + " = " + (num1 + num2));
                minusLabel.setText(num1 + " - " + num2 + " = " + (num1 - num2));
                exceptionLabel.setText("");

            } catch (NumberFormatException e) {
                exceptionLabel.setText("Illegal Argument(s)!");
                plusLabel.setText("");
                minusLabel.setText("");
            }
        });
        stage.show();
    }
}
