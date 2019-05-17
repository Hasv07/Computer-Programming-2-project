import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;



class menupane extends Pane {
    int index,idleIndex;
    Rectangle pane;
    static boolean flag=false;
    static ButtonStyle bt1=new ButtonStyle("Start");
     Image arrow=new Image("images/Arrow/icons8-chevron-right-100.png");
     Character[] Characters={Character.Boy,Character.Robot,Character.Zombie,Character.Cat,Character.Dino};
     Type[] Types={Type.Idle,Type.walk,Type.dead};
    ImageView character;
    ImageView arrowView, arrowView2;
   static   int charindex;
    public menupane() {


         character=new ImageView(new Image("images/"+Characters[0].getName()+" "+Types[0].getName()+"/Idle (1).png"));

         arrowView=new ImageView(arrow);
         arrowView2=new ImageView(arrow);
        arrowView.setOnMousePressed(e-> {

       arrowview_arrowpressed();

        });
        arrowView2.setOnMousePressed(e->{
            arrowview2_arrowpressed();
        });
        arrowView.setOnMouseReleased(e->{
            arrowView.setImage(arrow);
        });
        arrowView2.setOnMouseReleased(e->{
            arrowView2.setImage(arrow);
        });
         bt1.setLayoutY(860);
         bt1.setLayoutX(850);
        character.fitHeightProperty().bind(heightProperty().multiply(0.3));
        character.fitWidthProperty().bind(widthProperty().multiply(0.22));



        pane=new Rectangle();
        pane.widthProperty().bind(widthProperty());
        pane.heightProperty().bind(heightProperty());
         bt1.layoutXProperty().bind(pane.widthProperty().multiply(0.46));
        bt1.layoutYProperty().bind((pane.heightProperty().multiply(0.786)));

        arrowView.layoutXProperty().bind(pane.widthProperty().multiply(0.7));
        arrowView.layoutYProperty().bind((pane.heightProperty().multiply(0.5)));
        arrowView2.layoutXProperty().bind(pane.widthProperty().multiply(0.23));
        arrowView2.layoutYProperty().bind((pane.heightProperty().multiply(0.5)));
        character.layoutXProperty().bind(pane.widthProperty().multiply(0.45));
        character.layoutYProperty().bind((pane.heightProperty().multiply(0.39)));
        arrowView2.setScaleX(-1);
        getChildren().addAll(pane,bt1,arrowView,arrowView2,character);

        Timeline animation=new Timeline(new KeyFrame(Duration.millis(75),e->
        {

            if (idleIndex >= Characters[charindex].Idle) {
            idleIndex = 0;
        }
                character.setImage(new Image("images/"+Characters[charindex].getName()+" "+Types[0].getName()+"/Idle ("+(idleIndex+1)+").png"));
            idleIndex++;


                if(index<9) {

                    pane.setFill(new ImagePattern(new Image("images/background2/y2mate.com - studiopolis_background_animation_dZLR5MuBeuk_1080p 00" + (index + 1) + ".jpg")));
                    index++;
                    if (index >= 499) {
                        index = 0;
                    }
                }
                else if(index<99)
                {
                    pane.setFill(new ImagePattern(new Image("images/background2/y2mate.com - studiopolis_background_animation_dZLR5MuBeuk_1080p 0" + (index + 1) + ".jpg")));
                    index++;
                    if (index >= 499) {
                        index = 0;
                    }
                }
                else
            {
                pane.setFill(new ImagePattern(new Image("images/background2/y2mate.com - studiopolis_background_animation_dZLR5MuBeuk_1080p " + (index + 1) + ".jpg")));
                index++;
                if (index >= 499) {
                    index = 0;
                }
            }



        }));

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        bt1.setOnMouseClicked(e->
        {
            System.out.println("clicked");
            animation.stop();
            flag=true;

        });
    }
    public void arrowview_arrowpressed()
    {
        charindex++;
        arrowView.setImage(new Image("images/Arrow/icons-chevron-right-100.png"));

        if (charindex < Characters.length)
            character.setImage(new Image("images/" + Characters[charindex].getName() + " " + Types[0].getName() + "/Idle (1).png"));

        else{
            charindex = 0;
            character.setImage(new Image("images/" + Characters[charindex].getName() + " " + Types[0].getName() + "/Idle (1).png"));
        }
    }
    public void arrowview2_arrowpressed()
    {
        charindex--;
        arrowView2.setImage(new Image("images/Arrow/icons-chevron-right-100.png"));
        if(charindex<0)
        {
            charindex= Characters.length-1;
        }

        if (charindex < Characters.length)
            character.setImage(new Image("images/" + Characters[charindex].getName() + " " + Types[0].getName() + "/Idle (1).png"));

        else{
            charindex = 0;
            character.setImage(new Image("images/" + Characters[charindex].getName() + " " + Types[0].getName() + "/Idle (1).png"));
        }
    }

}
