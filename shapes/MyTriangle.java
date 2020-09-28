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
import javafx.scene.shape.Polygon;

/**
 *
 * @author Logan
 */
public class MyTriangle extends MyShapes {

    //data for triangle
    private GraphicsContext graphicsContext;
    private ColorPicker colorPicker;
    private ColorPicker colorPickerFill;
    private Color colorStroke;
    private Color colorFill;
    private Double startX, startY, endX, endY, midX, midY;
    private double[] xPoints;
    private double[] yPoints;
    private Polygon triangle;

    public MyTriangle() {
        xPoints = new double[3]; //triangle has 3 points
        yPoints = new double[3];
    }

    //following 9 methods to get data
    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public ColorPicker getColorPicker() {
        return colorPicker;
    }

    public ColorPicker getColorPickerFill() {
        return colorPickerFill;
    }

    public Double getStartX() {
        return startX;
    }

    public Double getStartY() {
        return startY;
    }

    public Double getEndX() {
        return endX;
    }

    public Double getEndY() {
        return endY;
    }

    public Double getMidx() {
        return midX;
    }

    public Double getMidY() {
        return midY;
    }

    //following 9 methods to set data
    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public void setColorPicker(ColorPicker colorPicker) {
        this.colorPicker = colorPicker;
        colorStroke = colorPicker.getValue();
    }

    public void setColorPickerFill(ColorPicker colorPickerFill) {
        this.colorPickerFill = colorPickerFill;
        colorFill = colorPickerFill.getValue();
    }

    public void setStartX(Double startX) {
        this.startX = startX;
    }

    public void setStartY(Double startY) {
        this.startY = startY;
    }

    public void setEndX(Double endX) {
        this.endX = endX;
    }

    public void setEndY(Double endY) {
        this.endY = endY;
    }

    public void setMidX(Double midx) {
        this.midX = midx;
    }

    public void setMidY(Double midY) {
        this.midY = midY;
    }

    //put triangle on canvas
    public void draw(double width, double height) {
        //getting midpoints to connect the lines
        if (startX > endX) {
            midX = endX + (Math.abs(startX - endX));
            midY = endY;
        } else {
            midX = endX - (Math.abs(startX - endX));
            midY = endY;
        }
        
        //put x/y points into an array for putting triangle on canvas
        xPoints[0] = startX;
        xPoints[1] = endX;
        xPoints[2] = midX;

        yPoints[0] = startY;
        yPoints[1] = endY;
        yPoints[2] = midY;
        //setting color and fill of triangle
        graphicsContext.setStroke(colorStroke);
        graphicsContext.setFill(colorFill);
        
        //putting triangle on canvas
        graphicsContext.strokePolygon(xPoints, yPoints, 3);
        graphicsContext.fillPolygon(xPoints, yPoints, 3);
        
        triangle = new Polygon(new double[]{
        startX, startY,
        endX, endY,
        midX, midY});

    }
    
    @Override
    public boolean containsPoint(Point2D point){
        return triangle.contains(point);
    }

}
