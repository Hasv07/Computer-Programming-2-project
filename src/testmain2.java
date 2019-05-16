
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;


public class testmain2 extends Application{
    static main1 e;
    static GamePane g;
    static Scene scene;
    @Override
    public void start(Stage primaryStage)
    {  StackPane f=new StackPane();
        Rectangle r=new Rectangle(500,500);
        r.setFill(Color.BLACK);
         g=new GamePane();
         e=new main1();


        f.getChildren().addAll(r,g);
         scene = new Scene(f, 500, 500);

        URL url = getClass().getResource("audio/Zombie-Game.mp3");

        AudioClip note=new AudioClip(url.toString());
        note.setVolume(100);
        note.setCycleCount(-1);
        note.play();
        primaryStage.setScene(scene);
        primaryStage.show();
        g.requestFocus();

    }

    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    public static void switchScene() {
         e.updatetoscene();
        scene.setRoot(e);

        e.show();
    }
    static Integer getScore() {
        return g.score;
    }


}