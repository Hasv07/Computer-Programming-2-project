
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


class main1 extends VBox implements Updatable{
    Text txt=new Text("You Died") ;
    Text txt2=new Text();
    FadeTransition fadeTransition;

    public main1() {
        updatetoscene();
        setPadding(new Insets(100,100,100,100));
        txt.setStrokeWidth(2);
        txt.setStroke(Color.RED);


        try {

            final Font f = Font.loadFont(new FileInputStream(new File("Resources/Font/Horror.otf")), 100);
            txt.setFont(f);
            txt2.setFont(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        getChildren().add(txt);
        setSpacing(80);
        txt2.setStrokeWidth(2);
        txt2.setStroke(Color.WHITE);
        getChildren().add(txt2);



        setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        setMouseTransparent(true);
        setOpacity(0);
        fadeTransition = new FadeTransition(Duration.millis(1500), this);

        fadeTransition.setToValue(1);
        fadeTransition.setOnFinished(e -> setMouseTransparent(false));

    }

    @Override
    public void updatetoscene() {
        txt2.setText("Score : "+testmain2.getScore().toString());
    }
    public void show() {
        fadeTransition.play();
    }
}
public class EndGame extends Application
{
    @Override
    public void start(Stage primaryStage)  {
        main1 e=new main1();
        Scene scene=new Scene(e,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();



    }

}
