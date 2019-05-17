

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ButtonStyle extends Button {


    public ButtonStyle(String text)
    {
        getStylesheets().add("Style.css");
        setText(text);
        setButtonFont();
        setPrefWidth(150);
        setPrefHeight(50);
        getStyleClass().add("record-sales");
        initializeBtnListeners();

    }

    private void setButtonFont()
    {

            setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, 23));

    }


    private void initializeBtnListeners()
    {

        setOnMouseEntered(e -> {


        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(null);
            }
        });


    }
}
