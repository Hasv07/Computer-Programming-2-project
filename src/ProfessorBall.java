
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import javafx.scene.layout.*;

import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.scene.text.Text;

import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;


public class ProfessorBall extends Application {
    Timeline main1;
    Image img=new Image("cursor/wind-rose.png");
    Character[] Characters={Character.Boy,Character.Robot,Character.Zombie,Character.Cat,Character.Dino};



    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage)  {
        {
            menupane main=new menupane();

            Ballpane ball=new Ballpane();
            Text txt1=new Text();
            txt1.setFont(new Font(30));
            txt1.setText("Score :");

            Text txt2=new Text();
            txt2.setFont(new Font(30));
            txt1.setY(60);
            txt1.setX(1600);
            txt1.setStrokeWidth(2);
            txt1.setStroke(Color.BISQUE);

            txt2.setY(60);
            txt2.setX(1700);
            txt2.setStrokeWidth(2);
            txt2.setStroke(Color.BISQUE);

//            ImageView img2 =new ImageView(new Image("images/icons8-undo-filled-100.png"));




            ImageView img1 =new ImageView(new Image("gif/cooltext324580070154732.gif"));
            img1.setY(0);
            img1.setX(550);

            Pane H=new Pane();
            H.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY)));

            H.getChildren().addAll(img1,txt1,txt2);


            BorderPane p=new BorderPane();
            p.setTop(H);
            p.setCenter(ball);
            StackPane p2= new StackPane();
            Text txt3 =new Text();
            txt3.setFont(new Font(60));
            p2.getChildren().add(txt3);



            Scene scene = new Scene(main);
            primaryStage.setMinWidth(800);
            primaryStage.setMinHeight(800);

            Timeline animation = new Timeline(new KeyFrame(Duration.millis(50), e1 -> {

                ball.increaseSpeed();
                txt2.setText(Ballpane.counter.toString());

            }

            ));


            Timeline animation2=new Timeline(new KeyFrame(Duration.millis(50), e2->{

                if (ball.cond) {

                    txt3.setText("Game Over" + "\n" + " Score:" + Ballpane.counter);


                    scene.setRoot(p2);


                    scene.setCursor(new ImageCursor(img));






                }}));
            main1 = new Timeline(new KeyFrame(Duration.millis(1), e -> {


                if (main.flag) {
                    main1.stop();
                    scene.setRoot(p);

                    scene.setCursor(Cursor.NONE);


                    animation.setCycleCount(Timeline.INDEFINITE);
                    animation.play();


                    animation2.setCycleCount(Timeline.INDEFINITE);
                    animation2.play();


                } else {

                        scene.setCursor(new ImageCursor(img));


                }
            }));

            main1.setCycleCount(-1);
            main1.play();











            ball.requestFocus();

            scene.setOnKeyPressed(e -> {
                if(!(ball.j>=Characters[menupane.charindex].dead)) {
                    if (e.getCode() == KeyCode.RIGHT) ball.MoveRight();
                    else if (e.getCode() == KeyCode.LEFT) ball.MoveLeft();
                }


            });



            URL url = this.getClass().getResource("/audio/Black_Clover_-_Opening_7_HDGrabvidtoMp3.mp3");

            AudioClip note=new AudioClip(url.toString());
            note.setVolume(100);
            note.setCycleCount(-1);

            note.play();



    primaryStage.setScene(scene);
    primaryStage.setFullScreen(true);

    primaryStage.setTitle("ProfessorBall");
    primaryStage.show();


        }

    }
}
