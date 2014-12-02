package swc.robotics.scouting.system;

/**
 * Project Name: SWC Robotics Scouting System
 * File Name:	 MatchFouls
 * Programmer:	 Phil Bystrican <Phil@PBApps.ca>
 * Teacher:	 Mr. K
 * Date:         Mar 12, 2014
 * Description:  A basic object used to store data for one team's fouls incurred in a match.
 **/

public class MatchFouls implements Cloneable
{
    //int for the team number
    int int_teamNumber;
    //int for the match number
    int int_matchNumber;
    
    //int for the number of technical fouls
    int int_technicalFouls;
    //int for the number of regular fouls
    int int_fouls;
    
    //basic constructor
    public MatchFouls () {} 
    
    //constructor requiring match and team numbers (used to reduce variable assigments in other classes)
    public MatchFouls (int _int_matchNumber, int _int_teamNumber)
    {
        //set the team number
        this.int_teamNumber = _int_teamNumber;
        //set the match number
        this.int_matchNumber = _int_matchNumber;
    }
    
    //takes no parameters, calculates the team's foul points, returns the foul points
    public int countPoints()
    {
        //create an int to store the points scored
        int int_points = 0;
        //if a foul was incured add the foul value to the total
        int_points += int_fouls * Constants.int_FOUL_POINTS;
        //if a tech foul was incured add the tech foul value to the total
        int_points += int_technicalFouls * Constants.int_TECHNICAL_FOUL_POINTS;
        
        //return the calculated points
        return int_points;
    }
    
    //takes no parameters, adds the match's foul portion to the DB
    public void addToDb()
    {
        //save the autonomous part of the match to the db
        DataBaseManager.addFoul(this);
    }
    
    //takes no parameters, removes the match's foul portion from the DB
    public void removeFromDb()
    {
        //remove the fouls part of the match from the db
        DataBaseManager.removeFoul(int_matchNumber, int_teamNumber);
    }
    
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return the object clone
        return super.clone();
    }
}
