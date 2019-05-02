

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.scene.control.ComboBox;

class circle  {
    int dx=1,dy=1;
    double x,y,radius,width,Height;
    double destination=0;
   static Timeline animation;
    static Integer score1=0,score2=0;
    Timeline SinglePlayeranimation;



    circle (Rectangle r1, Rectangle r2, Circle c1, double width,double height){
        this.width=width;
        this.Height=height;
        x=c1.getCenterX();
        y=c1.getCenterY();
        radius=c1.getRadius();
        animation=new Timeline(new KeyFrame( Duration.millis(50),e->

        {

            moveball(r1,r2,c1);
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        SinglePlayeranimation=new Timeline(new KeyFrame(Duration.millis(4),e->
        {
            if(destination!=0)
            {

                if(r2.getY()!=destination)
                r2.setY(r2.getY()>destination? r2.getY()-1:r2.getY()<destination? r2.getY()+1:r2.getY());
            else {
                    System.out.println("pause");
                    SinglePlayeranimation.pause();
                    destination = 0;
                }

            }
            else
            {
                if(dy==1)
                    r2.setY(r2.getY()>500-40?r2.getY():r2.getY()+1);
                else
                    r2.setY(r2.getY()<0?r2.getY():r2.getY()-1);




            }
        }));
        SinglePlayeranimation.setCycleCount(-1);




    }
    private void Ai( )
    {
        destination= (dy==1)?x-100+y:-1*(x-100)+y;
        destination=destination>500-40?500-40:destination;
        destination=destination<0?0:destination;
    }


    public void moveball (Rectangle r1, Rectangle r2,Circle c1){
        if (x < radius )
        {
            score2++;
            x=250;
            y=250;
           Ai();


            SinglePlayeranimation.play();


        }
        if(x > width - radius) {
            score1++;
            x=250;
            y=250;
            Ai();


            SinglePlayeranimation.play();


        }

        if (y < radius || y > Height - radius) {
            dy *= -1;
//            destination= !((x-100+y)>(500-40))&&(dy==1)?x-100+y:0;
//           destination= !((-1*(x-100)+y)<0)&&(dy==-1)?-1*(x-100)+y:0;

            Ai();



            SinglePlayeranimation.play();
            System.out.println(destination);

        }



        if(c1.intersects(r1.getBoundsInParent()))
        {
            dx *= -1;
//            destination= !((x-100+y)>(500-40))&&(dy==1)?x-100+y:0;
//            destination= !((-1*(x-100)+y)<0)&&(dy==-1)?-1*(x-100)+y:0;


            Ai();


            System.out.println(destination);

            SinglePlayeranimation.play();


            URL url = getClass().getResource("audio/POOL-Pool_Shot-709343898.mp3");

            AudioClip note=new AudioClip(url.toString());
            note.setVolume(100);
            note.setCycleCount(1);

            note.play();

        }
        if(c1.intersects(r2.getBoundsInParent()))
        {

            dx *= -1;

            URL url = this.getClass().getResource("audio/POOL-Pool_Shot-709343898.mp3");

            AudioClip note=new AudioClip(url.toString());
            note.setVolume(100);
            note.setCycleCount(1);

            note.play();
            SinglePlayeranimation.play();


        }
        x += dx;
        y += dy;

        c1.setCenterX(x);
        c1.setCenterY(y);
    }
}

class Tabs extends Pane {


    Timeline anim;

    Rectangle r1 = new Rectangle(400,230,10,40);
    Rectangle r2 = new Rectangle(90, 230, 10, 40);
    Circle c1 = new Circle(250, 250, 7);
    Text txt1=new Text(150,100,"");
    Text txt2=new Text(350,100,"");
    Timeline animation;


    public Tabs(){
        setWidth(200);
        setHeight(200);




        r1.setFill(Color.BLUE);
        r2.setFill(Color.RED);

        this.getChildren().addAll(r1,r2,c1,txt1,txt2);
        this.setOnKeyPressed(
                (KeyEvent event) -> {
                    if (event.getCode() == KeyCode.UP)
                        r1.setY(r1.getY() <= 0 ? r1.getY() : r1.getY() - 5);

                    else if (event.getCode() == KeyCode.DOWN)
                        r1.setY(r1.getY() >= 500 - 40 ? r1.getY() : r1.getY() + 5);
                    if (event.getCode() == KeyCode.W)
                        r2.setY(r2.getY() <= 0 ? r2.getY() : r2.getY() - 5);
                    else if (event.getCode() == KeyCode.S)
                        r2.setY(r2.getY() >= 500 - 40 ? r2.getY() : r2.getY() + 5);
                });


     /*   final List<KeyCode> acceptedCodes = Arrays.asList(KeyCode.S, KeyCode.W, KeyCode.UP, KeyCode.DOWN);
        final Set<KeyCode> codes = new HashSet<>();
        setOnKeyReleased(e -> codes.clear());
        setOnKeyPressed(e -> {
            if (acceptedCodes.contains(e.getCode())) {
                codes.add(e.getCode());
                if (codes.contains(KeyCode.W)) {
                    r2.setY(r1.getY()<0 ?   r2.getY(): r2.getY()-5);

                } else if (codes.contains(KeyCode.S)) {
                    r2.setY(r1.getY()> 500-40 ?   r2.getY(): r2.getY()+5);

                }

                if (codes.contains(KeyCode.UP)) {
                    r1.setY(r2.getY()<0 ?   r1.getY(): r1.getY()-5);

                } else if (codes.contains(KeyCode.DOWN)) {
                    r1.setY(r2.getY()> 500-40 ?   r1.getY(): r1.getY()+5);
                }
            }
        });*/
        animation=new Timeline(new KeyFrame( Duration.millis(50),e->

        {
            txt1.setText(circle.score1.toString());
            txt2.setText(circle.score2.toString());
        }));
        animation.setCycleCount(-1);
        animation.play();

        circle s1 = new circle(r1, r2, c1,500,500);

        anim=new Timeline(new KeyFrame(Duration.millis(50),e->{

            increaseSpeed();
        }));
        anim.setCycleCount(Timeline.INDEFINITE);
        anim.play();


    }
    public  void increaseSpeed()
    {
        circle.animation.setRate(circle.animation.getRate()>5?circle.animation.getRate():circle.animation.getRate()+0.05);


    };
}
public class main extends Application {
    @Override
    public void start(Stage primaryStage)  {

        Tabs tab =new Tabs();

        Rectangle r= new Rectangle(800,800,Color.WHITE);
        b cb=new b();


        Pane p=new Pane(r,tab,cb);
        Scene scene=new Scene(p,500,500);
        tab.requestFocus();

        cb.setOnAction(e->{
            tab.requestFocus();

            if(cb.getValue()=="white")

            {

                tab.c1.setFill(Color.BLACK);
                tab.txt1.setFill(Color.BLACK);
                tab.txt2.setFill(Color.BLACK);

                r.setFill(Color.WHITE);}
            else if(cb.getValue()=="black")
            {
                r.setFill(Color.BLACK);
                tab.c1.setFill(Color.WHITE);
                tab.txt1.setFill(Color.WHITE);
                tab.txt2.setFill(Color.WHITE);  }

            else
            {
                tab.c1.setFill(Color.WHITE);

                r.setFill(Color.BLUE);
                tab.r1.setFill(Color.YELLOW);}
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("pong");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
class b extends ComboBox{

    b(){
        setValue("white");

        setLayoutX(15);
        setLayoutY(10);
        getItems().addAll("white","black","blue");

    }
}