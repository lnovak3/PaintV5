/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import javafx.scene.canvas.Canvas;

/**
 *
 * @author Logan
 */
public class ResizableCanvas extends Canvas {

    boolean saved; //to check if the canvas has been edited recently

    //instaniates object
    public ResizableCanvas() {
        saved = true;
    }

    //allows canvas to be resizable
    @Override
    public boolean isResizable() {
        return true;
    }

    //what to do when update button is clicked
    public void resizeCanvas(double width, double height) {
        super.setWidth(width);
        super.setHeight(height);
        
    }

    //to check if the canvas has been saved since the last edit
    public boolean getCanvasSaved() {
        return saved;
    }

    //to set the canvas when it has been saved or edited
    public void setCanvasSaved(boolean saved) {
        this.saved = saved;
    }
}
