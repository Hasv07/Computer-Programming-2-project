
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameOver extends Application {
    @Override
    public void start(Stage primaryStage)  {

        StackPane p2= new StackPane();
        Text txt3 =new Text();
        txt3.setFont(new Font(60));
        txt3.setText("Game Over");
        p2.getChildren().add(txt3);
        Scene scene=new Scene(p2);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ProfessorBall");
        primaryStage.show();
    }
}
