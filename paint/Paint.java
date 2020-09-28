package paint;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Paint extends Application {
    
    private static Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        setPrimaryStage(stage);
        
        //setting the scene based off of the FXML file paint.fmxl and showing
        //it when the file is opened
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("paint.fxml")));
        stage.setScene(scene);
        stage.setTitle("Paint");
        
        stage.show();
    }
    
    //following two methods used in order to grant access to the current stage in the Controller
    private void setPrimaryStage(Stage stage) {
        Paint.primaryStage = stage;
        primaryStage.setTitle("Paint");
    }
    
    public static Stage getPrimaryStage(){
        return Paint.primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
