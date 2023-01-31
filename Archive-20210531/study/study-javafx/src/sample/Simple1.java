package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Simple1  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            //BorderPane root = new BorderPane();
            Parent root = FXMLLoader.load(getClass().getResource("MySecene.fxml"));
            Scene scene = new Scene(root,400,400);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            primaryStage.setTitle("My Application");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
