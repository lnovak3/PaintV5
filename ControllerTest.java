/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Logan
 */
public class ControllerTest {
    
    public ControllerTest() {
    }

    //test to see if the default mode is no tool when starting application
    @Test
    public void testDefaultMode() {
        System.out.print("Mode: ");
        Controller instance = new Controller();
        String actual = instance.getMode();
        String expected = "No Tool";
        assertEquals(actual, expected);
        System.out.print("No tool");
        System.out.println();
    }

    //test to see if edited defaults to false when starting application
    @Test
    public void testIsEdited() {
        System.out.print("isEdited: ");
        Controller instance = new Controller();
        Boolean expected = false;
        Boolean actual = instance.saved;
        assertEquals(actual, expected);
        System.out.print("False");
        System.out.println();
    }

    //test to see if anything is in the undo stack when starting application
    @Test
    public void testUndoStack() {
        System.out.print("testUndoStack: ");
        Controller instance = new Controller();
        Boolean expected = true;
        Boolean actual = instance.undoStack.isEmpty();
        assertEquals(actual, expected);
        System.out.print("Empty");
        System.out.println();
    }
    
}
