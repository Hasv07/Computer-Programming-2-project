

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


import javafx.scene.control.ComboBox;

class circle  {
    int dx=1,dy=1;
    double x,y,radius,width,Height;
    Timeline animation;
    static Integer score1=0,score2=0;



    circle (Rectangle r1, Rectangle r2, Circle c1, double width,double height){
        this.width=width;
        this.Height=height;
        x=c1.getCenterX();
        y=c1.getCenterY();
        radius=c1.getRadius();
        animation=new Timeline(new KeyFrame( Duration.millis(50),e->

        {

            moveball(r1,r2,c1);
            animation.setRate(animation.getRate()+3);
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();




    }

    public void moveball (Rectangle r1, Rectangle r2,Circle c1){
        if (x < radius )
        {
            score2++;
            x=250;
            y=250;

        }
        if(x > width - radius) {
            score1++;
            x=250;
            y=250;

        }

        if (y < radius || y > Height - radius) {
            dy *= -1;

        }



        if(c1.intersects(r1.getBoundsInParent()))
        {
            dx *= -1;

        }
        if(c1.intersects(r2.getBoundsInParent()))
        {
            dx *= -1;

        }
        x += dx;
        y += dy;

        c1.setCenterX(x);
        c1.setCenterY(y);
    }
}

class Tabs extends Pane {

    KeyManager key=new KeyManager();
    Rectangle r1 = new Rectangle(400,230,10,40);
    Rectangle r2 = new Rectangle(90, 230, 10, 40);
    Circle c1 = new Circle(250, 250, 7);
    Text txt1=new Text(150,100,"");
    Text txt2=new Text(350,100,"");
    Timeline animation;


    public Tabs(){





        r1.setFill(Color.BLUE);
        r2.setFill(Color.RED);

        this.getChildren().addAll(r1,r2,c1,txt1,txt2);

        this.setOnKeyPressed(
                (KeyEvent event) -> {
                    if (event.getCode() == KeyCode.UP)
                        key.setkeystate(KeyCode.UP,true);
                    else if (event.getCode() == KeyCode.DOWN)
                        key.setkeystate(KeyCode.DOWN,true);


                    if (event.getCode() == KeyCode.W)
                        key.setkeystate(KeyCode.W,true);


                    else if (event.getCode() == KeyCode.S)
                        key.setkeystate(KeyCode.S,true);


                });
        this.setOnKeyReleased(
                (KeyEvent event) -> {
                    if (event.getCode() == KeyCode.UP)
                        key.setkeystate(KeyCode.UP,false);
                    else if (event.getCode() == KeyCode.DOWN)
                        key.setkeystate(KeyCode.DOWN,false);


                    if (event.getCode() == KeyCode.W)
                        key.setkeystate(KeyCode.W,false);


                    else if (event.getCode() == KeyCode.S)
                        key.setkeystate(KeyCode.S,false);


                });



        animation=new Timeline(new KeyFrame( Duration.millis(35),e->

        {
            if (key.getkeystate(KeyCode.UP))
                r1.setY(r1.getY() <= 0 ? r1.getY() : r1.getY() - 5);

            else if (key.getkeystate(KeyCode.DOWN))
                r1.setY(r1.getY() >= 500 - 40 ? r1.getY() : r1.getY() + 5);
            if (key.getkeystate(KeyCode.W))
                r2.setY(r2.getY() <= 0 ? r2.getY() : r2.getY() - 5);
            else if (key.getkeystate(KeyCode.S))
                r2.setY(r2.getY() >= 500 - 40 ? r2.getY() : r2.getY() + 5);
            txt1.setText(circle.score1.toString());
            txt2.setText(circle.score2.toString());
        }));
        animation.setCycleCount(-1);
        animation.play();

        circle s1 = new circle(r1, r2, c1,500,500);






    }
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