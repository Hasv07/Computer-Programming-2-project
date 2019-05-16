

import javafx.animation.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;

public class GamePane extends Pane implements Updatable{
    Object[] ob;
    boolean flag=false;
    ArrayList<Ball> b=new ArrayList<>();
    Timeline animation,anim,anim2;
    Text lbl=new Text("+ 5");
    Text txt=new Text("Score : 0");
    int score=0;
      Rectangle rect=new Rectangle(100,20);
    ParallelTransition floatingScoreTransition;
    public GamePane() {

        lbl.setFont(Font.font(28));
        lbl.setStrokeWidth(5);
        lbl.setStroke(Color.WHITE);

        txt.setY(20);
        txt.setFont(Font.font(28));
        txt.setStrokeWidth(2);
        txt.setStroke(Color.WHITE);

        rect.setY(35);
        rect.setFill(Color.RED);


        FadeTransition lblfader = new FadeTransition(Duration.millis(1000));
        lblfader.setToValue(0);
        lblfader.setFromValue(1);
        TranslateTransition lblmover;
        lblmover = new TranslateTransition(Duration.millis(1000));
        lblmover.setByY(-65);
        floatingScoreTransition = new ParallelTransition(lbl, lblfader, lblmover);


        Tank t=new Tank();
        Timeline t2= new Timeline(new KeyFrame(Duration.seconds(1.5), e->{
            Ball b1=new Ball();

            getChildren().add(b1);
            b.add(b1);

        }));


        getChildren().addAll(t,txt,rect);

        t2.setCycleCount(-1);
        t2.play();



        setOnKeyPressed(e->
        { if(e.getCode()==KeyCode.RIGHT)
            t.setX(t.getX()+5);
            if(e.getCode()==KeyCode.LEFT)
                t.setX(t.getX()-5);
            if(e.getCode()==KeyCode.SPACE)
            {
                anim.play();

                Fire f=new Fire((int)t.getX(),(int) t.getY());
                getChildren().add(f);

                ob=getChildren().toArray();

            }});
        requestFocus();
        anim=new Timeline(new KeyFrame(Duration.millis(1),e->{



        for (Object node:ob) {
            if(node instanceof  Fire) {
                if(!(b.isEmpty()))
                {
                    animation=new Timeline(new KeyFrame(Duration.millis(1),e1->{
                        for (Ball enemy:b)
                        {
                            if (((Fire)node).intersects(enemy.getBoundsInParent()))
                            {
                                System.out.println("collision");
                                lbl.setX(enemy.getX());


                                lblmover.setFromY(enemy.getY());
                                System.out.println(enemy.getY());
                                getChildren().remove(node);
                                getChildren().remove(enemy);
                                ((Fire)node).stop();
                                enemy.stop();

                                if(flag==false) {
                                    getChildren().add(lbl);
                                    score+=5;

                                    flag = true;
                                }



                                    floatingScoreTransition.play();
                                floatingScoreTransition.setOnFinished(e6->{getChildren().remove(lbl);
                                    flag=false;});
                                txt.setText("Score : "+score);
                            }
                        }


                    }

                    ));
                    animation.setCycleCount(1);
                    animation.play();





                    }

                }



            }




        }));
        anim.setCycleCount(-1);
        anim2=new Timeline(new KeyFrame(Duration.millis(1),e->{
            for (Ball enemy:b) {
                if (enemy.getY() > 500) {
                    getChildren().remove(enemy);
                    if(enemy.isFlag()==false) {
                        rect.setWidth(rect.getWidth() - 5);
                        enemy.setFlag(true);
                    }
                    if(rect.getWidth()==0)
                    {
                        testmain2.switchScene();
                        anim2.stop();
                        anim.stop();
                        animation.stop();
                    }
                }

            }

        }));
        anim2.setCycleCount(-1);
        anim2.play();



    }

    @Override
    public void updatetoscene() {

    }


}