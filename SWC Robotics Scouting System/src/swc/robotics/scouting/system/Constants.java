package swc.robotics.scouting.system;

/**
 * Project Name: SWC Robotics Scouting System
 * File Name:	 Constants
 * Programmer:	 Phil Bystrican <Phil@PBApps.ca>
 * Teacher:	 Mr. K
 * Date:         Mar 8, 2014
 * Description:  All program wide constants are stored in this class and accessed statically
 **/

public class Constants 
{
    //int value (identifier) for a red alliance win
    static final int int_RED_WIN= 1;
    //int value (identifier) for a blue alliance win
    static final int int_BLUE_WIN = 2;
    //int value (identifier) for a tie
    static final int int_TIE = 3;
    
    
    //int value for a scoring type robot
    static final int int_SCORING = 1;
    //int value for a pasing type robot
    static final int int_PASSING = 2;
    //int value for a goalie type robot
    static final int int_GOALIE = 4;
    
    //int value for 1st team on red alliance
    static final int int_RED_TEAM_1 = 0;
    //int value for 2nd team on red alliance
    static final int int_RED_TEAM_2 = 1;
    //int value for 3rd team on red alliance
    static final int int_RED_TEAM_3 = 2;
    
    //int value for 1st team on blue alliance
    static final int int_BLUE_TEAM_1 = 3;
    //int value for 2nd team on blue alliance
    static final int int_BLUE_TEAM_2 = 4;
    //int value for 3rd team on blue alliance
    static final int int_BLUE_TEAM_3 = 5;
    
    
    
    //int value for 3rd team on blue alliance
    static final int int_NUMBER_OF_TEAMS = 6;
    
    //int for autonomous bonus points
    static final int int_AUTONOMOUS_BONUS_POINTS = 5;
    //int for foul points
    static final int int_FOUL_POINTS = 20;
    //int for technical foul points
    static final int int_TECHNICAL_FOUL_POINTS = 50;
    //int for catch points
    static final int int_CATCH_POINTS = 10;
    //int for truss points
    static final int int_TRUSS_POINTS = 10;
    //int for low goal points
    static final int int_LOW_GOAL_POINTS = 1;
    //int for high goal points
    static final int int_HIGH_GOAL_POINTS = 10;
    //int for points for a one assist goal 
    static final int int_ONE_ASSIST_POINTS = 0;
    //int for points for a two assist goal 
    static final int int_TWO_ASSIST_POINTS = 10;
    //int for points for a three assist goal 
    static final int int_THREE_ASSIST_POINTS = 30;
}
