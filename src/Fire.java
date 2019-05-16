import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Fire extends Circle {
//    int r= (int)(Math.random()*156);
//    int b=(int)(Math.random()*156);
//    int g=(int)(Math.random()*156);
    Timeline time;
    public Fire(int x, int y) {
        setRadius(10);
        setCenterX(x+15);
        setCenterY(y-25);
        setFill(Color.BLUEVIOLET);

         time = new Timeline(new KeyFrame(Duration.millis(2000/40)
                , e->{
            setCenterY(getCenterY()-10);
        }));
        time.setCycleCount(-1);
        time.play();



    }
    public void stop(){

        time.stop();
        setCenterY(600);


    }

}