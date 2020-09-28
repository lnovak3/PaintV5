/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 *
 * @author Logan
 */
public class FreeDraw extends MyShapes {
    
    //date of FreeDraw
    private GraphicsContext graphicsContext;
    private ColorPicker colorPicker;
    private Color color;

    private double startX, startY, endX, endY;
    
    //to hold all x and y values to draw
    private ArrayList<Double> xValues = new ArrayList<>();
    private ArrayList<Double> yValues = new ArrayList<>();

    public FreeDraw() {
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }
    
    //originally got value from colorPicker to set color, but returned null for
    //it. changed to set a specific color
    public void setColor(ColorPicker colorPicker) {
        this.colorPicker = colorPicker;
        color = colorPicker.getValue();
    }
    
    //get the starting point of the line drawn
    public void setStartPoint(double startX, double startY) {
        this.startX = startX;
        this.startY = startY;
    }
    
    //get the ending point of the line drawn
    public void setEndPoint(double endX, double endY) {
        this.endX = endX;
        this.endY = endY;
    }
    
    //add a point to the line 
    public void addPoint(double x, double y) {
        xValues.add(x);
        yValues.add(y);
    }

    //next 4 methods to get X and Y points
    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getEndX() {
        return endX;
    }

    public double getEndY() {
        return endY;
    }

    
    //returns a list of all the X points
    public double[] getAllXValues() {
        double[] xVals = new double[xValues.size()];

        for (int i = 0; i < xValues.size(); i++) {
            xVals[i] = xValues.get(i);
        }

        return xVals;
    }

    //returns a list of all the Y points
    public double[] getAllYValues() {
        double[] yVals = new double[yValues.size()];

        for (int i = 0; i < yValues.size(); i++) {
            yVals[i] = yValues.get(i);
        }

        return yVals;
    }

    public ColorPicker getColor() {
        return colorPicker;
    }

    //draws line on canvas
    public void draw() {
        graphicsContext.setStroke(color);
        graphicsContext.beginPath();
        graphicsContext.lineTo(getStartX(), getStartY());

        for (int i = 0; i < xValues.size(); i++) {
            graphicsContext.lineTo(xValues.get(i), yValues.get(i));
            graphicsContext.stroke();
        }

        graphicsContext.lineTo(getEndX(), getEndY());
        graphicsContext.stroke();

        graphicsContext.closePath();
    }
    
    @Override
    public boolean containsPoint(Point2D point){
        for(int i = 0; i < xValues.size(); i++){
            if(xValues.get(i) == point.getX() && yValues.get(i) == point.getY()){
                return true;
            }
        }

        return false;
    }
}
