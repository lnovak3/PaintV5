/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import javafx.geometry.Point2D;



/**
 *
 * @author Logan
 */
public class MyShapes {
    //used for stack for undo button, all shapes extend this class
    public MyShapes() {
        
    }
    
    public boolean containsPoint(Point2D point){
        return false;
    }
}
