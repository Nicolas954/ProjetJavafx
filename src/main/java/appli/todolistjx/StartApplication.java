package appli.todolistjx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class StartApplication extends Application {
    private static Stage stg;


    @Override
    public void start(Stage mainStage) throws IOException {
        stg = mainStage;
        mainStage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 540);
        mainStage.setTitle("Hello!");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void changeScene(String[] fxml) throws IOException {
    Parent pane=FXMLLoader.load(StartApplication.class.getResource(Arrays.toString(fxml)));
    stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}