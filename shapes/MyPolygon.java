/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 *
 * @author Logan
 */
public class MyPolygon extends MyShapes{
    //data for polygon
    private GraphicsContext graphicsContext;
    private ColorPicker colorPicker;
    private ColorPicker colorPickerFill;
    private Color colorStroke;
    private Color colorFill;
    private ArrayList<Double> xPoints = new ArrayList<Double>();
    private ArrayList<Double> yPoints = new ArrayList<Double>();
    
    public MyPolygon() {
        
    }

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
    
    public void addPoint(double x, double y){
        xPoints.add(x);
        yPoints.add(y);
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public ColorPicker getColorPicker() {
        return colorPicker;
    }

    public ColorPicker getColorPickerFill() {
        return colorPickerFill;
    }

    public ArrayList<Double> getxPoints() {
        return xPoints;
    }

    public ArrayList<Double> getyPoints() {
        return yPoints;
    }
    
    public void draw(){
        graphicsContext.setStroke(colorStroke);
        graphicsContext.setFill(colorFill);

        double[] polyX = new double[xPoints.size()];
        double[] polyY = new double[yPoints.size()];

        for(int i = 0; i < xPoints.size(); i++){
            polyX[i] = xPoints.get(i);
            polyY[i] = yPoints.get(i);
        }

        graphicsContext.strokePolygon(polyX, polyY, polyX.length);
        graphicsContext.fillPolygon(polyX, polyY, polyX.length);
    }
    
    
}
