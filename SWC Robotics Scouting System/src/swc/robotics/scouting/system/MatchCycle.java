package swc.robotics.scouting.system;

/**
 * Project Name: SWC Robotics Scouting System
 * File Name:	 MatchCycle
 * Programmer:	 Phil Bystrican <Phil@PBApps.ca>
 * Teacher:	 Mr. K
 * Date:         Mar 12, 2014
 * Description:  A basic object used to store data for a single cycle for a single team's match.
 **/

public class MatchCycle implements Cloneable
{
    //define variables to hold the cycle number, team number and match number
    int int_cycleNumber, int_teamNumber, int_matchNumber;
    //define booleans to store the states of the zones, truss, catch and goals 
    boolean bool_redZone, bool_whiteZone, bool_blueZone, bool_truss, bool_catch, bool_highGoal, bool_lowGoal;
    
    //constructor requiring match, team, and cycle numbers (used to reduce variable assigments in other classes)
    public MatchCycle (int _int_matchNumber, int _int_teamNumber, int _int_cycleNumber)
    {
        //set the team number
        this.int_teamNumber = _int_teamNumber;
        //set the match number
        this.int_matchNumber = _int_matchNumber;
        //set the cycle number
        this.int_cycleNumber = _int_cycleNumber;
    }
    
    //basic constructor
    public MatchCycle () {}
    
    //takes no parameters, calculates the team's points for the cycle (not assists), returns the cycle points
    public int countPoints()
    {
        //create an int to store the points scored
        int int_points = 0;
        //if a truss was scored add the truss value to the total
        if (bool_truss) int_points += Constants.int_TRUSS_POINTS;
        //if a catch occured, add the catch value to the total
        if (bool_catch) int_points += Constants.int_CATCH_POINTS;
        //if a high goal was scored add the high goal value to the total
        if (bool_highGoal) int_points += Constants.int_HIGH_GOAL_POINTS;
        //if a low goal was scored add the low goal value to the total
        if (bool_lowGoal) int_points += Constants.int_LOW_GOAL_POINTS;
        
        //return the calculated points
        return int_points;
    }
    
    //takes no parameters, adds the cycle to the DB
    public void addToDB()
    {
        //add/replace the team in the database
        DataBaseManager.addCycle(this);
    }
    
    //takes no parameters, removes the cycle from the DB
    public void removeFromDB()
    {
        //remove the team from the database
        DataBaseManager.removeCycle(int_matchNumber, int_teamNumber, int_cycleNumber);
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return the clone
        return super.clone();
    }
}
