package swc.robotics.scouting.system;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * Project Name: SWC Robotics Scouting System
 * File Name:	 BaseJFrame
 * Programmer:	 Phil Bystrican <Phil@PBApps.ca>
 * Teacher:	 Mr. K
 * Date:         Mar 7, 2014
 * Description:  The class serves as a base for all jFrames used in the project.
 *               It implements basic navigation features such as push, pop, and pop to root.
 **/

public class BaseJFrame extends javax.swing.JFrame {
    //varable to store the parent of this frame

    BaseJFrame parent;

    /*Takes a BaseJFrame object as a parameter. Disables resizing of the jframe's, makes it
     visible, sets the main menu as its parent and hides the main menu. Returns nothing*/
    public void pushFrame(BaseJFrame jfrm_frame, BaseJFrame jfrm_sender) {
        //make the window non resizable
        jfrm_frame.setResizable(false);
        //show the new jframe
        jfrm_frame.setVisible(true);
        //set the parent
        jfrm_frame.parent = this;
        //center the jframe
        jfrm_frame.setLocationRelativeTo(null);

        //hide the main menu
        this.setVisible(false);
    }

    //Take no paramters. Pop's the top frame off the stack. Returns nothing.
    public void popFrame() {
        //check if the frame that is being returned to is the sort data frame
        if (parent.getClass().getSimpleName().equals("SortData"))
        {
            //update the table
            ((SortData) parent).updateTable();
        }

        //show the parent
        parent.setVisible(true);
        //hide this jframe
        this.setVisible(false);

        //let the system know it should perform garbage collection
        System.gc();

        //dispose of this jframe
        this.dispose();
    }

    //Take no paramters. Pop's the view to the main menu (root). Returns nothing.
    public void popToRoot() {
        //hide this jframe
        this.setVisible(false);
        //create an array list to store the jframes that need to be disposed of
        ArrayList arylst_viewsToDispose = new ArrayList();

        //while the parent has a grandparent
        while (true) {
            //hide this jframe
            parent.setVisible(false);

            //if the parent view had no grandparent then it is the root
            if (parent.parent == null) {
                //break the loop as the root was reached
                break;
            }
            //add the jframe to a list of frames to dispose
            arylst_viewsToDispose.add(parent);

            //make the grandparent the new parent
            parent = parent.parent;
        }
        //cast the array list to an array
        Object jframesToDispose[] = arylst_viewsToDispose.toArray();
        //loop through the array of jframes to dispose
        for (int i = 0; i < jframesToDispose.length; i++) {
            //dispose of the jframe
            ((JFrame) jframesToDispose[i]).dispose();
        }

        //show the parent
        parent.setVisible(true);

        //let the system know it should perform garbage collection
        System.gc();

        //dispose of this jframe
        this.dispose();
    }
}