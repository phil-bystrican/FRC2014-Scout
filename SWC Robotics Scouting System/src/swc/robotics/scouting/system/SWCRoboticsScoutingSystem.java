package swc.robotics.scouting.system;

/**
 * Project Name: SWC Robotics Scouting System
 * File Name:	 SWCRoboticsScoutingSystem
 * Programmer:	 Phil Bystrican <Phil@PBApps.ca>
 * Teacher:	 Mr. K
 * Date:         Feb 24, 2014
 * Description:  The starting point of the application, 
 *               set the looks and feel and opens the main menu.
 **/

public class SWCRoboticsScoutingSystem 
{
    /**
     * @param args the command line arguments
     */
    //main run method
    public static void main(String[] args) 
    {
        
        // Set nimbus look/feel
        try {
            //loop through the jave looks and feels
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                //if the look and feel name is Nimbus
                if ("Nimbus".equals(info.getName())) {
                    //set the nimbus look and feel
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            //nimbus was not found, log the error
            java.util.logging.Logger.getLogger(SWCRoboticsScoutingSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //initialize the main menu
        MainMenu jfrm_mainMenu = new MainMenu();
        //make the window now resizable
        jfrm_mainMenu.setResizable(false);
        //show the main frame
        jfrm_mainMenu.setVisible(true);
    }
}
