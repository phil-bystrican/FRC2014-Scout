/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package swc.robotics.scouting.system;

/**
 * Project Name: SWC Robotics Scouting System
 * File Name:	 FRCTeam
 * Programmer:	 Phil Bystrican <Phil@PBApps.ca>
 * Teacher:	 Mr. K
 * Date:         Mar 8, 2014
 * Description:  A basic team object used to store general data for each team.
 **/

public class FRCTeam 
{
    //integer for team number
    int int_teamNumber;
    //string for team name
    String str_teamName;
    /*integer for robot type 1 = scoring, 2 = passing, 4 = goalie.
     * numbers can be added ex. 3 = scoring/passing, 5 = scoring goalie, 
     * 6 = passing goalie, 7 = all
     */
    int int_robotType;
    //string for team strengths
    String str_strengths;
    //string for team weaknesses
    String str_weaknesses;
    //string for general notes
    String str_notes;
    
    /*constructor used for reconstruction from the DB, requiring team number, name, robot type,
      robot strenghts, robot weaknesses, and general notes*/
    public FRCTeam (int int_number, String str_name, int int_type, String str_stren, String str_weak, String str_note)
    {
        //set the team number to the passed parameter
        this.int_teamNumber = int_number;
        //set the team name to the passed parameter
        this.str_teamName = str_name;
        //set the robot type to the passed parameter
        this.int_robotType = int_type;
        //set the robot strengths to the passed parameter
        this.str_strengths = str_stren;
        //set the weaknesses to the passed parameter
        this.str_weaknesses = str_weak;
        //set the notes to the passed parameter
        this.str_notes = str_note;
    }
    
    //basic constructor, take no parameters
    public FRCTeam ()
    {
    }
    
    //takes no parameters, removes the team from the DB
    public void removeFromDB()
    {
        //remove the team from the database
        DataBaseManager.removeTeam(this.int_teamNumber);
    }
    
    //takes no parameters, adds the team to the DB
    public void addToDB()
    {
        //add/replace the team in the database
        DataBaseManager.addTeam(this);
    }
}
