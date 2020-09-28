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
public class MyRectangle extends MyShapes {

    //data for rectangle
    private GraphicsContext graphicsContext;
    private ColorPicker colorPicker;
    private ColorPicker colorPickerFill;
    private Color colorStroke;
    private Color colorFill;
    public double startX, startY, endX, endY, width, height;

    private Rectangle rectangle = new Rectangle();

    public MyRectangle() {
    }

    //following 3 methods to get info from canvas
    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public void setColor(ColorPicker colorPicker) {
        this.colorPicker = colorPicker;
        colorStroke = colorPicker.getValue();
    }

    public void setFill(ColorPicker colorPicker) {
        this.colorPickerFill = colorPicker;
        colorFill = colorPickerFill.getValue();
    }

    //following 2 methods setting points of rectangle
    public void setStartPoint(double startX, double startY) {
        this.startX = startX;
        this.startY = startY;

        rectangle.setX(startX);
        rectangle.setY(startY);
    }

    public void setEndPoint(double endX, double endY) {
        this.endX = endX;
        this.endY = endY;
    }

    //setting width and height of rectangle
    public void setWidth() {
        this.width = Math.abs((endX - startX));

        rectangle.setWidth(Math.abs((endX - startX)));
    }

    public void setHeight() {
        this.height = Math.abs((endY - startY));

        rectangle.setHeight(Math.abs((endY - startY)));
    }

    public void check() {
        if (getX() > endX) {
            rectangle.setX(endX);
        }
        if (getY() > endY) {
            rectangle.setY(endY);
        }
    }

    //following 6 methods to get any necessary attributes of rectangle
    public double getX() {
        return rectangle.getX();
    }

    public double getY() {
        return rectangle.getY();
    }

    public double getWidth() {
        return rectangle.getWidth();
    }

    public double getHeight() {
        return rectangle.getHeight();
    }

    public ColorPicker getColor() {
        return colorPicker;
    }

    public ColorPicker getFill() {
        return colorPickerFill;
    }

    //put rectangle on canvas
    public void draw() {
        graphicsContext.setStroke(colorStroke);
        graphicsContext.setFill(colorFill);

        graphicsContext.fillRect(getX(), getY(), getWidth(), getHeight());
        graphicsContext.strokeRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public boolean containsPoint(Point2D point) {
        return rectangle.contains(point);
    }
}
