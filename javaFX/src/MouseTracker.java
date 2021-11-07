import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MouseTracker extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Mouse Tracker");
        stage.setHeight(700);
        stage.setWidth(700);
        Button clearButton = new Button("Clear");
        Canvas drawingBoard = new Canvas(stage.getWidth() - 30, stage.getHeight() - 100);
        GraphicsContext gc;
        VBox root = new VBox(10, clearButton, drawingBoard);
        root.setPadding(new Insets(10));

        gc = drawingBoard.getGraphicsContext2D();
        gc.setLineWidth(4);
        gc.setStroke(Color.BLACK);

        clearButton.setOnMouseClicked(mouseEvent -> gc.clearRect(0, 0, drawingBoard.getWidth(), drawingBoard.getHeight()));
        drawingBoard.setOnMouseDragged(mouseEvent -> {
            gc.beginPath();
            gc.lineTo(mouseEvent.getX(), mouseEvent.getY());
            gc.stroke();
        });
        drawingBoard.setOnMouseReleased(mouseEvent -> gc.closePath());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

