import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

class MainPane extends Pane {
    Rectangle pane;
    ImageView SinglePlayer,multiplayer;
    static int index;
    static boolean flag=false;

    public MainPane() {
        pane=new Rectangle();
        pane.widthProperty().bind(widthProperty());
        pane.heightProperty().bind(heightProperty());
        pane.setFill(new ImagePattern(new Image("images/Background/game.isoftbetPong.backgroundimage.jpg")));
        SinglePlayer =new ImageView(new Image("images/players mode/Single Player.png"));
        SinglePlayer.setFitWidth(100);
        SinglePlayer.setFitHeight(100);
        SinglePlayer.xProperty().bind(widthProperty().multiply(0.2));
        SinglePlayer.yProperty().bind(heightProperty().multiply(0.7));
        multiplayer =new ImageView(new Image("images/players mode/multiplayers.png"));
        multiplayer.setFitWidth(100);
        multiplayer.setFitHeight(100);
        multiplayer.xProperty().bind(widthProperty().multiply(0.7));
        multiplayer.yProperty().bind(heightProperty().multiply(0.7));
        SinglePlayer.setOnMouseEntered(e->{
            SinglePlayer.setImage(new Image("images/players mode/1-Player.png"));
        });
        SinglePlayer.setOnMouseExited(e->{
            SinglePlayer.setImage(new Image("images/players mode/Single Player.png"));
        });

        multiplayer.setOnMouseEntered(e->{
            multiplayer.setImage(new Image("images/players mode/2-Player.png"));
        });
        multiplayer.setOnMouseExited(e->{
            multiplayer.setImage(new Image("images/players mode/multiplayers.png"));
        });
        SinglePlayer.setOnMousePressed(e->{
            flag=true;
            index=0;
        });
        multiplayer.setOnMousePressed(e->{
            flag=true;

            index=1;
        });


        getChildren().addAll(pane, SinglePlayer,multiplayer);



    }
}




public class Testmain extends Application {
    @Override
    public void start(Stage primaryStage)   {

        MainPane menu=new MainPane();
        Scene scene=new Scene(menu,900,700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pong");

        primaryStage.show();

    }
}
