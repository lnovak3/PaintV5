/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Logan
 */
public class MySquare extends MyShapes{
    //data of square
    private GraphicsContext graphicsContext;
    private ColorPicker colorPicker;
    private ColorPicker colorPickerFill;
    private Color colorStroke;
    private Color colorFill;

    private double startX, startY, endX, endY;

    private Rectangle square = new Rectangle();

    public MySquare(){ }

    //get necessary info from canvas
    public void setGraphicsContext(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;
    }

    public void setColor(ColorPicker colorPicker){
        this.colorPicker = colorPicker;
        colorStroke = colorPicker.getValue();
    }

    public void setFill(ColorPicker colorPicker){
        colorPickerFill = colorPicker;
        colorFill = colorPickerFill.getValue();
    }

    //following 2 methods set start and end point for square
    public void setStartPoint(double startX, double startY){
        this.startX = startX;
        this.startY = startY;

        square.setX(startX);
        square.setY(startY);
    }

    public void setEndPoint(double endX, double endY){
        this.endX = endX;
        this.endY = endY;
    }

    //following 3 methods set up the squares width and height
    public void setWidth(){
        square.setWidth(Math.abs((endX - startX)));
    }

    public void setHeight(){
        square.setHeight(Math.abs((endY - startY)));
    }

    public void check() {
        if (getX() > endX) {
            square.setX(endX);
        }
        if (getY() > endY) {
            square.setY(endY);
        }
    }

    //following 6 methods are getters for data of square
    public double getX(){
        return square.getX();
    }

    public double getY(){
        return square.getY();
    }

    public double getWidth(){
        return square.getWidth();
    }

    public double getHeight() {
        return square.getHeight();
    }

    public ColorPicker getColor(){
        return colorPicker;
    }

    public ColorPicker getFill(){
        return colorPickerFill;
    }

    //put square on canvas
    public void draw(){
        graphicsContext.setStroke(colorStroke);
        graphicsContext.setFill(colorFill);

        graphicsContext.fillRect(getX(), getY(), getWidth(), getWidth());
        graphicsContext.strokeRect(getX(), getY(), getWidth(), getWidth());
    }
    
    @Override
    public boolean containsPoint(Point2D point){
        return square.contains(point);
    }
}
