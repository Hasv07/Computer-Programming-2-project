

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;




class Ballpane extends Pane {
    Timeline deadanimation;
    static int i=0,j=0;
    boolean cond=false;
    static Integer counter = 0;
    final static double redius = 50;
    double x = redius, y = redius, dy = 1, dx = 1,q=600,w=600,dq=1.5,dw=1;
    Circle circle = new Circle(x, y, redius);
    Circle circle2 = new Circle(q, w, redius);

    Timeline animation,animation2,animation3;
    ImageView person=new ImageView();
    Rectangle pane;

    Image image1=new Image("images/62999356-seamless-game-background-flat-style-2d-game-application.jpg");
/*
    ImageView image2=new ImageView(image1);
*/

/*

    Image [] image={new Image("images/Walk (1).png") ,new Image("images/Walk (2).png"),
              new Image("images/Walk (3).png"),new Image("images/Walk (4).png"),
              new Image("images/Walk (5).png"),new Image("images/Walk (6).png"),
              new Image("images/Walk (7).png"),new Image("images/Walk (8).png"),
              new Image("images/Walk (9).png"),new Image("images/Walk (10).png"),
              new Image("images/Walk (11).png"),new Image("images/Walk (12).png"),
              new Image("images/Walk (13).png"),new Image("images/Walk (14).png"),
              new Image("images/Walk (15).png")
   ,new Image("images/Dead (1).png") ,new Image("images/Dead (2).png"),
              new Image("images/Dead (3).png"),new Image("images/Dead (4).png"),

              new Image("images/Dead (5).png"),new Image("images/Dead (6).png"),
            new Image("images/Dead (7).png"),new Image("images/Dead (8).png"),
            new Image("images/Dead (9).png"),new Image("images/Dead (10).png"),
            new Image("images/Dead (11).png"),new Image("images/Dead (12).png"),
            new Image("images/Dead (13).png"),new Image("images/Dead (14).png"),
            new Image("images/Dead (15).png")};
*/
Character[] Characters={Character.Boy,Character.Robot,Character.Zombie,Character.Cat,Character.Dino};
Type[] Types={Type.Idle,Type.walk,Type.dead};
    Image [] walkimage;
    Image [] deadimage;
    int counter2=0;



    public Ballpane() {





        pane=new Rectangle(300,300);
        pane.widthProperty().bind(widthProperty());
        pane.heightProperty().bind(heightProperty().add(100));
        pane.setFill(new ImagePattern(image1));
        circle.setFill(new ImagePattern(new Image("images/ball.png")));

        circle2.setFill(new ImagePattern(new Image("images/ball.png")));





        person.layoutYProperty().bind(heightProperty().subtract(100));
        person.setLayoutX(0);
        person.setFitHeight(100);
        person.setFitWidth(100);






        getChildren().addAll(pane,circle,circle2,person);
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveball()));
        animation2 = new Timeline(new KeyFrame(Duration.millis(1000), e -> counter++));

         animation3=new Timeline(new KeyFrame(Duration.millis(50), e->{

            if (cond||!(menupane.flag)) {



                animation.stop();
                animation2.stop();

            }
            else if(menupane.flag&&counter2==0) {
                counter2=1;
                walkimage=new Image[Characters[menupane.charindex].walk];
                deadimage=new Image[Characters[menupane.charindex].dead];
                person.setImage(new Image("images/" + Characters[menupane.charindex].getName() + " " + Types[1].getName() + "/Walk (1).png"));
                for (int i=0;i<walkimage.length;i++) {
                    walkimage[i]=new Image("images/"+Characters[menupane.charindex].getName()+" "+Types[1].getName()+"/Walk ("+(i+1)+").png");

                }

                for (int i=0;i<deadimage.length;i++) {
                    deadimage[i]=new Image("images/"+Characters[menupane.charindex].getName()+" "+Types[2].getName()+"/Dead ("+(i+1)+").png");

                }

                animation.play();
                animation2.play();
            }

        }));

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        animation2.setCycleCount(Timeline.INDEFINITE);
        animation2.play();
        animation3.setCycleCount(Timeline.INDEFINITE);
        animation3.play();
    }

    public void play() {
        animation.play();



    }


    public void pause() {
        animation.pause();

    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.05);


    }

    public void decreaseSpeed() {
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }

    public void MoveRight() {

        person.setX(person.getX() < getWidth() - 70 ? person.getX() + 10 : person.getX());


        person.setScaleY(1);

        person.setRotate(360);

        i++;

        if(i>=Characters[menupane.charindex].walk)
        {
            i=0;

        }
        System.out.println("images/"+Characters[menupane.charindex].getName()+" "+Types[1].getName()+"/Walk ("+(i+1)+").png");

        person.setImage(walkimage[i]);








    }

    public void MoveLeft() {
        person.setX(person.getX() > 0 ? person.getX() - 10 : 0);




        person.setScaleY(-1);
        person.setRotate(180);



        i++;

        if(i>=Characters[menupane.charindex].walk)
        {
            i=0;

        }
        System.out.println(Characters[menupane.charindex].walk);

        person.setImage(walkimage[i]);



    }

    protected boolean moveball() {

        if (x < redius || x > getWidth() - redius) {
            dx *= -1;


        }

        if (y < redius || y > getHeight() - redius) {
            dy *= -1;

        }
        if (q < redius || q > getWidth() - redius) {
            dq *= -1;
        }

        if (w < redius || w > getHeight() - redius) {
            dw *= -1;

        }


        x += dx;
        y += dy;
        q += dq;
        w += dw;
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle2.setCenterX(q);
        circle2.setCenterY(w);



  /*if(counter>0) {

            Shape shape = Shape.intersect(person, circle);

            Shape shape2 = Shape.intersect(person, circle2);


            boolean intersects = shape.getBoundsInLocal().getWidth() != -1;
            boolean intersects2 = shape2.getBoundsInLocal().getWidth() != -1;

            if (intersects||intersects2) {
                System.out.println("Collision" + counter);
                return true;

            }
        }*/

        if(counter>0 && !cond) {


            if(circle.intersects(person.getBoundsInParent()))
            {



                deadanimation=new Timeline(new KeyFrame(Duration.millis(50),e->{
                    if(j<=Characters[menupane.charindex].dead )
                    {
                        person.setImage(deadimage[i]);


                    }
                    j++;
                    if(j==30) {
                        cond = true;

                        deadanimation.stop();
                    }





                }
                ));
                deadanimation.play();
                System.out.println("Collision" + counter);


                if(cond)
                {

                    return true;
                }
            }
            if(circle2.intersects(person.getBoundsInParent()))
            {



                 deadanimation=new Timeline(new KeyFrame(Duration.millis(50),e->{

                     if(j<=Characters[menupane.charindex].dead )
                     {
                         person.setImage(deadimage[i]);


                     }
                     j++;
                     if(j==30) {
                         cond = true;

                         deadanimation.stop();
                     }




                 }
                ));
                deadanimation.play();
                System.out.println("Collision" + counter);

                if(cond)
                {
                    return true;
                }
            }
        }

        return false;

    }
}

