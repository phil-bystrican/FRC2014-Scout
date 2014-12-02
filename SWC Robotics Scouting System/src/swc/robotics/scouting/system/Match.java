/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swc.robotics.scouting.system;

/**
 * Project Name: SWC Robotics Scouting System 
 * File Name:	 Match 
 * Programmer:	 Phil Bystrican <Phil@PBApps.ca>
 * Teacher:	 Mr. K 
 * Date:         Mar 11, 2014 
 * Description:  Match object that handles all the data for each tam participating in a match.
 *
 */
public class Match {
    //integer for team number
    int int_gameNumber;
    //integer for number of red scoring cycles
    int int_numberOfRedCycles = 1;
    //integer for number of blue scoring cycles
    int int_numberOfBlueCycles = 1;
    //integer for the outcome of the match
    int int_matchOutCome = Constants.int_TIE;
    //constant integer for x position (in an array)
    private final int int_X = 0;
    //constant integer for y position (in an array)
    private final int int_Y = 1;
    //array of integers to hold all the team numbers for teams in the match
    int[] int_teamNumbers = new int[Constants.int_NUMBER_OF_TEAMS];
    //array of autonomous objects to store the autonomous data for each team
    MatchAutonomous[] mtch_autonomous = new MatchAutonomous[Constants.int_NUMBER_OF_TEAMS];
    //array of foul objects to store the foul data for each team
    MatchFouls[] mtch_fouls = new MatchFouls[Constants.int_NUMBER_OF_TEAMS];
    //allow support for upto 50 cycles
    MatchCycle[][] mtch_cycles = new MatchCycle[50][Constants.int_NUMBER_OF_TEAMS];

    //takes team number as a parameter, calculates the team's points, for the cycle returns the points as an integer
    public int getPointsForTeamInPosition(int int_teamPosition) {
        //create an int to store the points scored
        int int_points = 0;

        //loop through the cycles in the match
        for (int i = 0; i < mtch_cycles.length; i++) {
            //if the match cycle doesnt exist (can occur as the array is predefined)
            if (mtch_cycles[i][int_teamPosition] == null) {
                //break the loop
                break;
            }
            //add the points from the cycle to the running total
            int_points += mtch_cycles[i][int_teamPosition].countPoints();
        }
        
        //return the calculated points
        return int_points;
    }
    
    //takes team number as a parameter, calculates the team's autonomous points, for the atch, returns the points as an integer
    public int getAutonomousPointsForTeamInPosition(int int_teamPosition) {
        //create an int to store the points scored
        int int_points = 0;
        
        //add the autonomous points to the total points
        int_points += mtch_autonomous[int_teamPosition].countPoints();

        //return the calculated points
        return int_points;
    }
    
    /*takes team position (1-6) as a parameter, calculates the team's alliance's 
    foul points for the match, returns the points as an integer*/
    public int getFoulPointsForAllianceForTeamInPosition(int int_teamPosition)
    {
        //create an int to store the points scored
        int int_points = 0;
        
        //if the team is a red team
        if (int_teamPosition < 3)
        {
            //get the points for fouls called against the blue team (which would contribute to the red score)
            int_points += mtch_fouls[Constants.int_BLUE_TEAM_1].countPoints();
            int_points += mtch_fouls[Constants.int_BLUE_TEAM_2].countPoints();
            int_points += mtch_fouls[Constants.int_BLUE_TEAM_3].countPoints();    
        }
        else //blue team
        {
            //get the points for fouls called against the red team (which would contribute to the blue score)
            int_points += mtch_fouls[Constants.int_RED_TEAM_1].countPoints();
            int_points += mtch_fouls[Constants.int_RED_TEAM_2].countPoints();
            int_points += mtch_fouls[Constants.int_RED_TEAM_3].countPoints();
        }
        //return the calculated points
        return int_points;
    }
    
    /*takes team position (1-6) as a parameter, calculates the team's 
    foul points for the match, returns the points as an integer*/
    public int getFoulPointsForTeamInPosition(int int_teamPosition)
    {
        //get the points for fouls called against the team
        return  mtch_fouls[int_teamPosition].countPoints();
    }
    
    /*takes team position (1-6) as a parameter, calculates the team's alliance's 
    assist points for the match, returns the points as an integer*/
    public int getAssistPointsForAllianceForTeamInPosition(int int_teamPosition) {
        //create an int to store the points scored
        int int_points = 0;
        //define the low bound for the loop based on whether the team is red or blue alliance (refer to constants)  
        int int_lowerBound = (int_teamPosition < 3) ? 0 : Constants.int_NUMBER_OF_TEAMS / 2;
        //define the upper bound for the loop based on whether the team is on the red or blue alliance
        int int_upperBound = (int_teamPosition < 3) ? Constants.int_NUMBER_OF_TEAMS / 2 : Constants.int_NUMBER_OF_TEAMS;

        //loop through the match cycles
        for (int i = 0; i < mtch_cycles.length; i++) {
            //if the match cycle doesnt exist (can occur as the array is predefined)
            if (mtch_cycles[i][int_lowerBound] == null) {
                //break the loop
                break;
            }
            //define an array of booleans to store the states of the field zones
            boolean bool_zone[][] = new boolean[3][3];
            //integer for the number of passes in this cycle
            int int_numberOfPasses = 0;
            //if a goal has been scored in the cycle
            boolean bool_goalScored = false;

            //loop through the first dimension the the zone array
            for (int j = 0; j < bool_zone.length; j++) {
                //check if a goal has bee scored
                if (mtch_cycles[i][j + int_lowerBound].bool_highGoal || mtch_cycles[i][j + int_lowerBound].bool_lowGoal) {
                    //a goal has been scored
                    bool_goalScored = true;
                }
                //set the state of the first column in the row
                bool_zone[j][0] = (mtch_cycles[i][j + int_lowerBound].bool_blueZone);
                //increase the number of passes if the value for the zone is true
                int_numberOfPasses += bool_zone[j][0] ? 1 : 0;
                //set the state of the first column in the row
                bool_zone[j][1] = (mtch_cycles[i][j + int_lowerBound].bool_whiteZone);
                //increase the number of passes if the value for the zone is true
                int_numberOfPasses += bool_zone[j][1] ? 1 : 0;
                //set the state of the first column in the row
                bool_zone[j][2] = (mtch_cycles[i][j + int_lowerBound].bool_redZone);
                //increase the number of passes if the value for the zone is true
                int_numberOfPasses += bool_zone[j][2] ? 1 : 0;
            }
            //if no goals were scored then no assists are awarded
            if (!bool_goalScored) {
                //skip this iteration
                continue;
            }
            //switch on the number of assists scored in the cycle
            switch (this.findAssists(bool_zone, int_numberOfPasses))
            {
                //one assist
                case 1 :
                    //add the assist points to the score
                    int_points += Constants.int_ONE_ASSIST_POINTS;
                    break;
                //two assist    
                case 2 :
                    //add the assist points to the score
                    int_points += Constants.int_TWO_ASSIST_POINTS;
                    break;
                //three assist    
                case 3 :
                    //add the assist points to the score
                    int_points += Constants.int_THREE_ASSIST_POINTS;
                    break;
                //error  
                default :
                    break;
            }
        }

        //return the calculated points
        return int_points;
    }
    
    /*takes the boolean zone array number of passes as parameters, calculates and returns the max number of assists
    assist points for the match, returns the points as an integer*/
    private int findAssists(boolean[][] bool_zone, int int_numberOfPasses) {
        //create an int to store the number of assists scored
        int int_maxAssists = 0;
        //array used to hold the previous positions of starting points in the zone array
        int[] int_previousStartingPositions = new int[18];
        //loop through the previous starting points
        for (int i = 0; i < int_previousStartingPositions.length; i++) {
            //set the points to -1 (instead of the default 0)
            int_previousStartingPositions[i] = -1;
        }
        
        //loop through the passes
        for (int i = 0; i < int_numberOfPasses; i++) {
            //create an array of booleans for the locations where assists have been assinged
            boolean bool_assistAssigned[][] = new boolean[3][3];
            //set the initial assist position [x,y] to (-1,-1)
            int[] int_initialAssistPosition = {-1, -1};
            //set an integer [x,y] for the current/starting position
            int[] int_currentPosition = {0, 0};
            //integer for the number of assists in the cycle 
            int int_numberOfAssists = 0;
            
            //loop while the y position is less than 3
            while (int_currentPosition[int_Y] < 3) {
                //if the position has had the ball travel through it it will be true
                if (bool_zone[int_currentPosition[int_X]][int_currentPosition[int_Y]]) {
                    //boolean to determine whether the starting point is one that has been used before
                    boolean bool_startingPointisNew = true;
                    //loop through past starting points
                    for (int j = 0; j < int_previousStartingPositions.length; j++) {
                        //if a previous starting position is equal to the current position
                        if (int_previousStartingPositions[j] == int_currentPosition[int_X]
                                && int_previousStartingPositions[j + 1] == int_currentPosition[int_Y]) {
                            //the starting point was used before
                            bool_startingPointisNew = false;
                            break;
                        }
                    }
                    //check if the starting point is not new
                    if (!bool_startingPointisNew) {
                        //increase the current position
                        int_currentPosition = increaseCurrentPosition(int_currentPosition);
                        //continue to the next iteration
                        continue;
                    }
                    //set the initial position x (where to start the next assist from) to the current position
                    int_initialAssistPosition[int_X] = int_currentPosition[int_X];
                    //set the initial position y (where to start the next assist from) to the current position
                    int_initialAssistPosition[int_Y] = int_currentPosition[int_Y];

                    //loop through past starting points
                    for (int j = 0; j < int_previousStartingPositions.length; j++) {
                        //check if the starting point is (-1,-1) (default)
                        if (int_previousStartingPositions[j] == -1
                                && int_previousStartingPositions[j + 1] == -1) {
                            //add the assist position to the array of previous starting positions
                            int_previousStartingPositions[j] = int_initialAssistPosition[int_X];
                            int_previousStartingPositions[j + 1] = int_initialAssistPosition[int_Y];
                            break;
                        }
                    }
                    //update the array of assigned assists
                    this.updateAssignedAssits(bool_assistAssigned, int_currentPosition);

                    //the initial position has been found, award an assist
                    int_numberOfAssists++;

                    //break the loop
                    break;
                }
                //increase the current position
                int_currentPosition = increaseCurrentPosition(int_currentPosition);
            }

            //reset the current position
            int_currentPosition = new int[]{0, 0};
            //boolean for whether an assist has been detected in a row
            boolean bool_assistDetectedInRow = false;
            //boolean for whether a far pass should be checked for
            boolean bool_checkForFarPass = false;

            //loop while the y coordinate is less than 3
            while (int_currentPosition[int_Y] < 3) {
                //check if the posisiton is the first in a row and an assist has been detected
                if (int_currentPosition[int_X] == 0 && bool_assistDetectedInRow == true) {
                    //set it so no assist has been detected as it is a new row
                    bool_assistDetectedInRow = false;
                    //do not check for a far pass (yet)
                    bool_checkForFarPass = false;
                }
                //caclculate the difference between the intial assist x position and the current x posisiton
                int int_xDelta = Math.abs(int_initialAssistPosition[int_X] - int_currentPosition[int_X]);
                //caclculate the difference between the intial assist y position and the current y posisiton
                int int_yDelta = Math.abs(int_initialAssistPosition[int_Y] - int_currentPosition[int_Y]);
                
                //check if the zone is set to true at the current position and an assist has not been assined to that posisiton
                if (bool_zone[int_currentPosition[int_X]][int_currentPosition[int_Y]] 
                        && !bool_assistAssigned[int_currentPosition[int_X]][int_currentPosition[int_Y]]) 
                {
                    //check if both the x and y deltas are 1
                    if (int_xDelta == 1 && int_yDelta == 1) 
                    {                        
                        //set the initial position x (where to start the next assist from) to the current position
                        int_initialAssistPosition[int_X] = int_currentPosition[int_X];
                        //set the initial position y (where to start the next assist from) to the current position
                        int_initialAssistPosition[int_Y] = int_currentPosition[int_Y];

                        //update the bool array of assigned assists
                        this.updateAssignedAssits(bool_assistAssigned, int_currentPosition);
                        //an assist has been detected in the row
                        bool_assistDetectedInRow = true;
                        //a far pass does not need to be detected
                        bool_checkForFarPass = false;
                        //increase the number of assists
                        int_numberOfAssists++;

                        //set the x position to -1 (the incrementor at the bottom will increase it to 0)
                        int_currentPosition[int_X] = -1;
                        //increase the y position
                        int_currentPosition[int_Y]++;


                    } else if (bool_checkForFarPass) { //check for a long pass
                        //if at least one delta is greater than 2 a long pass occured
                        if ((int_xDelta == 2 && int_yDelta == 2) || (int_xDelta == 1 && int_yDelta == 2) || (int_xDelta == 2 && int_yDelta == 1)) {
                            //set the initial position x (where to start the next assist from) to the current position
                            int_initialAssistPosition[int_X] = int_currentPosition[int_X];
                            //set the initial position y (where to start the next assist from) to the current position
                            int_initialAssistPosition[int_Y] = int_currentPosition[int_Y];

                            //update the bool array of assigned assists
                            this.updateAssignedAssits(bool_assistAssigned, int_currentPosition);

                            //an assist has been detected in the row
                            bool_assistDetectedInRow = true;
                            //a far pass does not need to be detected
                            bool_checkForFarPass = false;
                            //increase the number of assists
                            int_numberOfAssists++;

                            //set the x position to -1 (the incrementor at the bottom will increase it to 0)
                            int_currentPosition[int_X] = -1;
                            //increase the y position
                            int_currentPosition[int_Y]++;
                        }
                    }
                }
                //check if the current position is at the end of the row and no assit has been detected and the long pass hasnt been checked
                if (int_currentPosition[int_X] >= 2 && !bool_assistDetectedInRow && !bool_checkForFarPass) {
                    //check for the long pass
                    bool_checkForFarPass = true;
                    //reset the x cordinate
                    int_currentPosition[int_X] = 0;
                } else {
                    //increase the current position
                    int_currentPosition = increaseCurrentPosition(int_currentPosition);
                    //if the position has been reset to the beginning of the row
                    if (int_currentPosition[int_X] == 0) {
                        //reset the assist detected
                        bool_assistDetectedInRow = false;
                        //reset the check for pass
                        bool_checkForFarPass = false;
                    }
                }
            }
            //if the number of assists is greater than the max assists, set the max assists to the number of assists
            int_maxAssists = (int_maxAssists < int_numberOfAssists) ? int_numberOfAssists : int_maxAssists;
            //if the maximum number of assists have already been found
            if (int_maxAssists == 3) {
                //return the maximum number of assists found
                return int_maxAssists;
            }
        }
        //return the maximum number of assists found
        return int_maxAssists;
    }
    
    //takes the current position [x][y] as a parameter, increases it and returns the new position
    private int[] increaseCurrentPosition(int int_currentPosition[]) {
        //increase the x position
        int_currentPosition[int_X]++;
        //check if the x position is greater than 3
        if (int_currentPosition[int_X] >= 3) {
            //set the x position to 0
            int_currentPosition[int_X] = 0;
            //increase the y position
            int_currentPosition[int_Y]++;
        }
        
        //return the updated position
        return int_currentPosition;
    }
    
    /*takes a 2d boolean array of assigned assist locations and the position of the current assist,
    updates the array according to the current assist position and returns the updated array*/
    private boolean[][] updateAssignedAssits(boolean[][] bool_assistAssigned, int[] int_currentPosition) {
        //set the assist assigned to the column to be true
        bool_assistAssigned[int_currentPosition[int_X]][0] = true;
        bool_assistAssigned[int_currentPosition[int_X]][1] = true;
        bool_assistAssigned[int_currentPosition[int_X]][2] = true;

        //set the assist assigned to the row to be true
        bool_assistAssigned[0][int_currentPosition[int_Y]] = true;
        bool_assistAssigned[1][int_currentPosition[int_Y]] = true;
        bool_assistAssigned[2][int_currentPosition[int_Y]] = true;

        //return the updated array
        return bool_assistAssigned;
    }

    //takes no parameters, adds the match to the DB
    public void removeFromDB() {
        //remove the team from the database
        DataBaseManager.removeMatch(this.int_gameNumber);
    }

    //takes no parameters, adds the match's metadata (team numbers, match number) to the DB
    public void addMetaToDB() {
        //add/replace the team in the database
        DataBaseManager.addMatchMeta(this);
    }

    //takes no parameters, removes the match from the DB
    public void addToDB() {
        //add/replace the team in the database
        DataBaseManager.addMatch(this);
    }
}
