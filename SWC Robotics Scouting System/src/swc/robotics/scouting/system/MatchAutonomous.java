package swc.robotics.scouting.system;

/**
 * Project Name: SWC Robotics Scouting System
 * File Name:	 MatchAutonomous
 * Programmer:	 Phil Bystrican <Phil@PBApps.ca>
 * Teacher:	 Mr. K
 * Date:         Mar 11, 2014
 * Description:  A basic object used to store data for one team's autonomous portion of a match.
 **/

public class MatchAutonomous implements Cloneable
{
    //int for the team's number
    int int_teamNumber;
    //int for the match's number
    int int_matchNumber;
    //boolean for the robot's mobility status
    boolean bool_mobility = false;
    //boolean for the robot's low goal status
    boolean bool_lowGoal = false;
    //boolean for the robot's high goal status
    boolean bool_highGoal = false;
    //boolean for state of the hot goal
    boolean bool_hotGoal = false;
    
    //basic constructor
    public MatchAutonomous () {} 
    
    //constructor requiring match and team numbers (used to reduce variable assigments in other classes)
    public MatchAutonomous (int _int_matchNumber, int _int_teamNumber)
    {
        //set the team number
        this.int_teamNumber = _int_teamNumber;
        //set the match number
        this.int_matchNumber = _int_matchNumber;
    }
    
    //takes no parameters, calculates the team's autonomus points, returns the autonomous points
    public int countPoints()
    {
        //create an int to store the points scored
        int int_points = 0;
        
        //if the mobility bonus is due add the bonus points
        int_points += bool_mobility ? Constants.int_AUTONOMOUS_BONUS_POINTS : 0;
        //if a low goal has been scored add the bonus points and the low goal points
        int_points += bool_lowGoal ? Constants.int_LOW_GOAL_POINTS + Constants.int_AUTONOMOUS_BONUS_POINTS : 0;
        //if a high goal has been scored add the bonus points and the high goal points
        int_points += bool_highGoal ? Constants.int_HIGH_GOAL_POINTS + Constants.int_AUTONOMOUS_BONUS_POINTS : 0;
        //if the hot goal is selected and a goal has been scored add the bonus points
        int_points += (bool_hotGoal && (bool_lowGoal || bool_highGoal)) ? Constants.int_AUTONOMOUS_BONUS_POINTS : 0;
        
        //return the calculated points
        return int_points;
    }
    
    //takes no parameters, adds the match's autonomous portion to the DB
    public void addToDb()
    {
        //save the autonomous part of the match to the db
        DataBaseManager.addAutonomous(this);
    }
    
    //takes no parameters, removes the match's autonomous portion from the DB
    public void removeFromDb()
    {
        //remove the autonomous part of the match from the db
        DataBaseManager.removeAutonomous(int_matchNumber, int_teamNumber);
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return the object clone
        return super.clone();
    }
}
