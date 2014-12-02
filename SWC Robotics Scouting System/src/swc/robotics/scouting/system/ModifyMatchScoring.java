/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package swc.robotics.scouting.system;

/**
 * Project Name: SWC Robotics Scouting System
 * File Name:	 ModifyMatchScoring
 * Programmer:	 Phil Bystrican <Phil@PBApps.ca>
 * Teacher:	 Mr. K
 * Date:         Mar 27, 2014
 * Description:  
 **/

public class ModifyMatchScoring extends MatchScoring
{
    
    /** Creates new form MatchScoring */
    public ModifyMatchScoring(int int_gameNumber) {


        //load the match data from the db
        this.loadTeamDataFromDB(int_gameNumber);
    }

}
