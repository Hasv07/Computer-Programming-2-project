import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Ball extends Rectangle
{
    double x = (Math.random() * 480 )+10;
    double y = 10;
     boolean flag=false;

    double move = 3500;
   public Timeline time;

    public Ball()
    {
        setFill(new ImagePattern(new Image("images/Game2/zy6lng2invu01.png")));
        setX(x);
        setY(y);
        setWidth(30);
        setHeight(30);

         time = new Timeline(new KeyFrame(Duration.millis(move/45)
               , e->{
                    setY(getY()+10);
                }));
        time.setCycleCount(-1);
        time.play();


    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public void stop(){

    time.stop();
    setX(600);

    }

}