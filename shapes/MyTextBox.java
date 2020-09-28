/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Logan
 */
public class MyTextBox extends MyShapes {
    
    //data of MyTextBox
    private GraphicsContext graphicsContext;
    private double positionX;
    private double positionY;
    private boolean onCanvas; //used to place back on canvas
    private String text;

    public void MyTextBox() {
        onCanvas = false;
    }

    //following 5 methods to set data of MyTextBox
    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public void setPositionX(double x) {
        positionX = x;
    }

    public void setPositionY(double y) {
        positionY = y;
    }

    public void setOnCanvas(boolean bool) {
        onCanvas = bool;
    }

    public void setText(String text) {
        this.text = text;
    }

    //following 5 methods to get necessary data from MyTextBox
    public double getPositionY() {
        return positionY;
    }

    public double getPositionX() {
        return positionX;
    }

    public boolean getOnCanvas() {
        return onCanvas;
    }

    public String getText() {
        return text;
    }

    //to put the text box on the canvas
    public void draw() {
        //if this is the first time drawing it, do the following
        if (!onCanvas) {
            //layout for popup and what is being put inside it
            GridPane gridPane = new GridPane();
            Label insertText = new Label("Insert Text: ");
            TextField insertTextField = new TextField("Type Here");
            Button insert = new Button("Insert");
            gridPane.add(insertText, 0, 0);
            gridPane.add(insertTextField, 1, 0);
            gridPane.add(insert, 1, 1);

            //pop up for placing text in canvas
            Alert alert = new Alert(Alert.AlertType.INFORMATION); //setting type of alert it is
            alert.setTitle("Insert Text");
            alert.getDialogPane().setContent(gridPane); //putting gridPane into alert

            insert.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setText(insertTextField.getText()); //set the text of the object
                    setOnCanvas(true); //has been placed on canvas
                    graphicsContext.setLineWidth(1.0); //how thick drawing is of text
                    graphicsContext.strokeText(getText(), positionX, positionY); //putting text on canvas
                    alert.close(); //close popup
                }
            });
            alert.showAndWait();
        } else { //if this is an old object already placed on canvas (for undo button)
            graphicsContext.setLineWidth(1.0);
            graphicsContext.strokeText(text, positionX, positionY);
        }

    }

}
