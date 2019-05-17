import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;


public class BigMain extends Application {
    Timeline Start;
    static boolean flag;
    static main1 e;
    static GamePane g;
    static Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        ImageView img =new ImageView(new Image("images/giphy[3].gif"));
        ImageView img1=new ImageView(new Image("images/6d5201130c4a347f6e12a4ebbe812671f.png"));

        ImageView img2 =new ImageView(new Image("images/6d5201130c4a347f6e12a4ebbe81267f2.png"));
        ImageView img3=new ImageView(new Image("images/6d5201130c4a347f6e12a4ebbe81267f.png"));


        img1.setX(50);
        img2.setX(50);
        img3.setX(50);
        img1.setY(10);
        img2.setY(150);
        img3.setY(300);
        img1.setFitWidth(400);
        img2.setFitWidth(400);
        img3.setFitWidth(400);
        img1.setFitHeight(400);
        img2.setFitHeight(400);
        img3.setFitHeight(400);
        img1.setOnMousePressed(e->
        {
         main Pong=new main();
         Pong.start(primaryStage);
               
        });

       img2.setOnMousePressed(e2->{
   testmain2 ZombieAttack=new testmain2();
   ZombieAttack.start(primaryStage);
       });
       img3.setOnMousePressed(e->{
           ProfessorBall prof=new ProfessorBall();
           prof.start(primaryStage);
               }
               );
        Pane p=new Pane();
        p.getChildren().addAll(img,img1,img2,img3);
        Scene scene=new Scene(p);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Temple Games");
        primaryStage.show();

    }
}
