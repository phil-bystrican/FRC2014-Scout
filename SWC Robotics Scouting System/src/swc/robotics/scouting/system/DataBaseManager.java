
package swc.robotics.scouting.system;

import com.almworks.sqlite4java.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Project Name: SWC Robotics Scouting System 
 * File Name:	 DataBaseManager
 * Programmer:	 Phil Bystrican <Phil@PBApps.ca>
 * Teacher:	 Mr. K 
 * Date:         Mar 7, 2014 
 * Description:  This class provides all db access functionality. It allows the 
 *               reading and writing of the data storage classes to and from an 
 *               SQL DB.
 *
 */
public class DataBaseManager {

    //takes no parameters, opens and returns a database connection
    private static SQLiteConnection openDB() {
        //load the database directory
        File fl_database = new File("RoboticsDB.sql");
        try {
            //create the db file if only only if it doesnt exist
            fl_database.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        //check if the file exists
        if (!fl_database.exists())
        {
            //something went wrong with db creation
            //let the user know the db couldnt be created
            JOptionPane.showConfirmDialog(null, "The database could not be created, "
                    + "make sure you have permission to write to disk and try "
                    + "again. The program will now quit.", "Fatal Error", JOptionPane.DEFAULT_OPTION);
            
            //quit the program due to fatal error
            System.exit(1);
            
        }
        //check if the file can be written to
        if (!fl_database.canWrite())
        {
            //something went wrong with db writing
            //let the user know the db couldnt be read
            JOptionPane.showConfirmDialog(null, "The database could not be written to, "
                    + "make sure you have permission to write to disk and try "
                    + "again. The program will now quit.", "Fatal Error", JOptionPane.DEFAULT_OPTION);
            
            //quit the program due to fatal error
            System.exit(1);
        }
        //check if the file can be read
        if (!fl_database.canRead())
        {
            //something went wrong with db reading
            //let the user know the db couldnt be read
            JOptionPane.showConfirmDialog(null, "The database could not be read, "
                    + "make sure you have permission to access the files on disk and try "
                    + "again. The program will now quit.", "Fatal Error", JOptionPane.DEFAULT_OPTION);
            
            //quit the program due to fatal error
            System.exit(1);
        }
        
        
        
        //create a connection to the database
        SQLiteConnection sqlc_database = new SQLiteConnection(fl_database);
        
        try {
            //open the db connection
            sqlc_database.open(true);
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
        //return the opened database
        return sqlc_database;
    }
    
    /*takes the sql exception as a parameter, lets the user know a fatal error 
    occured, quits the program. returns nothing*/
    private static void unrecoverableErrorOccured(SQLiteException ex)
    {
        //log the exception to console
        Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        
        System.out.println("issue:" + ex.getMessage());
        
        //something went wrong with loading the db
        //let the user know something went wrong
        JOptionPane.showConfirmDialog(null, "An unexpected error occured. "
                + "The program will now quit.", "Fatal Error", JOptionPane.DEFAULT_OPTION);
        
        

        //quit the program due to fatal error
        System.exit(1);
    }
    
    //takes no parameters, creates the DB tables and indicies, returns nothing 
    public static void createDB() {
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            /*create the team table (if it doesnt exist) with fields: team number(int), 
            * team name (str), robot type(int), robot strengths(str), robot weaknesses(str),
            * notes(str) and the match numbers the team played in (array as TEXT)*/
            sqlc_database.exec("CREATE TABLE IF NOT EXISTS Teams(teamNumber INTEGER, name TEXT, "
                    + "type INTEGER, strengths TEXT, weaknesses TEXT, notes TEXT);");
            //create a unique index with the team number (if it doesnt exist) for the team table
            sqlc_database.exec("CREATE UNIQUE INDEX IF NOT EXISTS TeamNumber ON Teams (teamNumber);");
            
            /*create the game table (if it doesnt exist)*/
            sqlc_database.exec("CREATE TABLE IF NOT EXISTS GameMetaData(matchNumber INTEGER, "
                    + "redT1_number INTEGER,  redT2_number INTEGER,  redT3_number INTEGER, "
                    + "blueT1_number INTEGER, blueT2_number INTEGER, blueT3_number INTEGER, "
                    + "numberOfRedCycles INTEGER, numberOfBlueCycles INTEGER, matchOutcome INTEGER);");
            
            //create a unique index with the match number (if it doesnt exist) for the game table
            sqlc_database.exec("CREATE UNIQUE INDEX IF NOT EXISTS MatchNumber_MetaData ON GameMetaData (matchNumber);");
            
            //create the autonomous table (if it doesnt exist) to store the autonomous data fields
            sqlc_database.exec("CREATE TABLE IF NOT EXISTS GameAutonomous(matchNumber INTEGER, "
                    + "teamNumber INTEGER, mobility INTEGER, lowGoal INTEGER, highGoal INTEGER, hotGoal INTEGER);");
            
            //create a unique index with the match number and team number (if it doesnt exist) for the autonomous table
            sqlc_database.exec("CREATE UNIQUE INDEX IF NOT EXISTS  MatchTeamNumber_Autonomous ON GameAutonomous(matchNumber, teamNumber);");
            
            //create the match cycles table (if it doesnt exist) to store the match cycle data fields
            sqlc_database.exec("CREATE TABLE IF NOT EXISTS GameCycles(matchNumber INTEGER, "
                     //zone & scoring fields (booleans)
                    + "teamNumber INTEGER, cycleNumber INTEGER, blueZone INTEGER, whiteZone INTEGER, redZone INTEGER, "
                    + "truss INTEGER, catch INTEGER, lowGoal INTEGER, highGoal INTEGER);");

            //create a unique index with the match number, team numberm and cycle number (if it doesnt exist) for the game cycles table
            sqlc_database.exec("CREATE UNIQUE INDEX IF NOT EXISTS  MatchTeamNumber_GameCycles ON GameCycles(matchNumber, teamNumber, cycleNumber);");
            
            //create the fouls table (if it doesnt exist) to store the fouls data fields
            sqlc_database.exec("CREATE TABLE IF NOT EXISTS GameFouls(matchNumber INTEGER, "
                    + "teamNumber INTEGER, fouls INTEGER, technicalFouls INTEGER);");
            
            //create a unique index with the match number and team number (if it doesnt exist) for the fouls table
            sqlc_database.exec("CREATE UNIQUE INDEX IF NOT EXISTS  MatchTeamNumber_GameFouls ON GameFouls(matchNumber, teamNumber);");
            
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
    }
/*---------------------------------Team Related Data Base Access---------------------------------*/
    //takes a team object as a parameter and adds it to the db, returns nothing
    public static void addTeam(FRCTeam team) {
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //instert the team data into the db
            sqlc_database.exec("REPLACE INTO Teams VALUES(" + team.int_teamNumber + ",'" 
                    + team.str_teamName + "'," + team.int_robotType + ",'" + team.str_strengths 
                    + "','" + team.str_weaknesses + "','" + team.str_notes + "');");
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
    }

    //takes an team number as a parameter , loads the team from the db, returns the loaded team
    public static FRCTeam loadTeam(int int_teamNumber) {
        //create a blank team object to load the team into
        FRCTeam frct_team = new FRCTeam();

        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //retrieve the row from the db that matches the inputed team number
            SQLiteStatement st = sqlc_database.prepare("SELECT * FROM Teams WHERE "
                    + "teamNumber=" + int_teamNumber + ";");
            try {
                //loop while there is data to be read as a result of the statement
                while (st.step()) {
                    //loop through the columns in the data
                    for (int i = 0; i < st.columnCount(); i++) {
                        //check if the column is an integer
                        if (st.columnType(i) == SQLiteConstants.SQLITE_INTEGER) {
                            //use a switch to check the column name
                            switch (st.getColumnName(i)) {
                                case "teamNumber":
                                    //set the team's number to that column's data
                                    frct_team.int_teamNumber = st.columnInt(i);
                                    break;
                                case "type":
                                    //set the robot type to that column's data
                                    frct_team.int_robotType = st.columnInt(i);
                                    break;
                            }
                        }
                        //check if the column is a string
                        else if (st.columnType(i) == SQLiteConstants.SQLITE_TEXT) {
                            //use a switch to check the column name
                            switch (st.getColumnName(i)) {
                                case "name":
                                    //set the team's name to that column's data
                                    frct_team.str_teamName = st.columnString(i);
                                    break;
                                case "strengths":
                                    //set the team's strenghts to that column's data
                                    frct_team.str_strengths = st.columnString(i);
                                    break;
                                case "weaknesses":
                                    //set the team's weaknesses to that column's data
                                    frct_team.str_weaknesses = st.columnString(i);
                                    break;
                                case "notes":
                                    //set the team's note to that column's data
                                    frct_team.str_notes = st.columnString(i);
                                    break;
                            }
                        }
                    }
                }
            } finally {
                //clear up memory used by the statement
                st.dispose();
            }
            
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
        //return the loaded team
        return frct_team;
    }

    //takes a team number as a parameter and removes it from the db, returns nothing
    public static void removeTeam(int int_teamNumber) {
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //delete the team with the inputed team number from the db
            sqlc_database.exec("DELETE FROM Teams WHERE teamNumber = " + int_teamNumber + ";");
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
    }
    
    /*---------------------------------Game Related Data Base Access---------------------------------*/
    //takes a match object as a parameter and adds it to the db, returns nothing
    public static void addMatch(Match mch_match)  {
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //instert the game data into the db
            sqlc_database.exec("REPLACE INTO GameMetaData VALUES(" + mch_match.int_gameNumber + "," 
                    + mch_match.int_teamNumbers[Constants.int_RED_TEAM_1] + "," + mch_match.int_teamNumbers[Constants.int_RED_TEAM_2] + "," 
                    + mch_match.int_teamNumbers[Constants.int_RED_TEAM_3] + "," + mch_match.int_teamNumbers[Constants.int_BLUE_TEAM_1] + "," 
                    + mch_match.int_teamNumbers[Constants.int_BLUE_TEAM_2] + "," + mch_match.int_teamNumbers[Constants.int_BLUE_TEAM_3] + "," 
                    + mch_match.int_numberOfRedCycles + "," + mch_match.int_numberOfBlueCycles + "," + mch_match.int_matchOutCome + ");");
            
            
            
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
        
        //loop through the number of teams
        for (int i = 0; i < Constants.int_NUMBER_OF_TEAMS; i++)
        {
            //add the autonomous data to the match object
            DataBaseManager.addAutonomous(mch_match.mtch_autonomous[i]);
            //add the foul data to the match object
            DataBaseManager.addFoul(mch_match.mtch_fouls[i]);
            
            if (i<3) //red alliance
            {
                //loop through the red cycles
                for (int j = 0; j < mch_match.int_numberOfRedCycles-1; j++)
                {
                    //add the cycle to the match object
                    DataBaseManager.addCycle(mch_match.mtch_cycles[j][i]);
                }
            }
            else // blue alliance
            {
                //loop through the blue cycles
                for (int j = 0; j < mch_match.int_numberOfBlueCycles-1; j++)
                {
                    //add the cycle to the match object
                    DataBaseManager.addCycle(mch_match.mtch_cycles[j][i]);
                }
            }
        }
    }
    //takes a match object as a parameter and adds its meta data (team numbers, match number) to the db, returns nothing
    public static void addMatchMeta(Match mch_match)  {
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //instert the game data into the db
            sqlc_database.exec("REPLACE INTO GameMetaData VALUES(" + mch_match.int_gameNumber + "," 
                    + mch_match.int_teamNumbers[Constants.int_RED_TEAM_1] + "," + mch_match.int_teamNumbers[Constants.int_RED_TEAM_2] + "," 
                    + mch_match.int_teamNumbers[Constants.int_RED_TEAM_3] + "," + mch_match.int_teamNumbers[Constants.int_BLUE_TEAM_1] + "," 
                    + mch_match.int_teamNumbers[Constants.int_BLUE_TEAM_2] + "," + mch_match.int_teamNumbers[Constants.int_BLUE_TEAM_3] + "," 
                    + mch_match.int_numberOfRedCycles + "," + mch_match.int_numberOfBlueCycles + "," + mch_match.int_matchOutCome + ");");
            
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
    }
    
    //takes no parameters, loads all the match numbers from the db and returns them as an int array
    public static int[] loadMatchNumbers()
    {
        //create an array list to store the unknown number of matches
        ArrayList <Integer> aryLst_matchNumbers = new ArrayList<>();

        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //retrieve the row from the db that matches the inputed match number
            SQLiteStatement st = sqlc_database.prepare("SELECT matchNumber FROM GameMetaData;");
            try {
                //loop while there is data to be read as a result of the statement
                while (st.step()) {
                    //loop through the columns in the data
                    for (int i = 0; i < st.columnCount(); i++) {
                        //check if the column is an integer
                        if (st.columnType(i) == SQLiteConstants.SQLITE_INTEGER) {
                            //use a switch to check the column name
                            switch (st.getColumnName(i)) {
                                case "matchNumber":
                                    //add the match number to the array list
                                    aryLst_matchNumbers.add(Integer.valueOf(st.columnInt(i)));
                                    break;
                            }
                        }
                    }
                }
            } finally {
                //clear up memory used by the statement
                st.dispose();
            }
            
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }  
        
        //create a primative array with a size of the array list
        int [] int_matches = new int[aryLst_matchNumbers.size()];
        //loop through the matches
        for (int i = 0; i < aryLst_matchNumbers.size(); i++)
        {
            //assign the match a position in the primative array
            int_matches[i] = aryLst_matchNumbers.get(i).intValue();
        }
            
        //convert the array to integer objects (can be used like primatives) and return it
        return int_matches; 
    }
    
    //takes an match number as a parameter, loads the match from the db, returns the loaded match
    public static Match loadMatch(int int_matchNumber)
    {
        //create a blank match object to load the team into
        Match mch_match = new Match();
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //retrieve the row from the db that matches the inputed match number
            SQLiteStatement st = sqlc_database.prepare("SELECT * FROM GameMetaData WHERE matchNumber=" + int_matchNumber + ";");
            try {
                //loop while there is data to be read as a result of the statement
                while (st.step()) {
                    //loop through the columns in the data
                    for (int i = 0; i < st.columnCount(); i++) {
                        //check if the column is an integer
                        if (st.columnType(i) == SQLiteConstants.SQLITE_INTEGER) {
                            //use a switch to check the column name
                            switch (st.getColumnName(i)) {
                                case "matchNumber":
                                    //set the match number to that column's data
                                    mch_match.int_gameNumber = st.columnInt(i);
                                    break;
                                case "redT1_number":
                                    //set the team's number to that column's data
                                    mch_match.int_teamNumbers[Constants.int_RED_TEAM_1] = st.columnInt(i);
                                    break;
                                case "redT2_number":
                                    //set the team's number to that column's data
                                    mch_match.int_teamNumbers[Constants.int_RED_TEAM_2] = st.columnInt(i);
                                    break;
                                case "redT3_number":
                                    //set the team's number to that column's data
                                    mch_match.int_teamNumbers[Constants.int_RED_TEAM_3] = st.columnInt(i);
                                    break;
                                case "blueT1_number":
                                    //set the team's number to that column's data
                                    mch_match.int_teamNumbers[Constants.int_BLUE_TEAM_1] = st.columnInt(i);
                                    break;
                                case "blueT2_number":
                                    //set the team's number to that column's data
                                    mch_match.int_teamNumbers[Constants.int_BLUE_TEAM_2] = st.columnInt(i);
                                    break;
                                case "blueT3_number":
                                    //set the team's number to that column's data
                                    mch_match.int_teamNumbers[Constants.int_BLUE_TEAM_3] = st.columnInt(i);
                                    break;
                                case "numberOfRedCycles":
                                    //set the number of cycles to that column's data
                                    mch_match.int_numberOfRedCycles = st.columnInt(i);
                                    break;
                                case "numberOfBlueCycles":
                                    //set the number of cycles to that column's data
                                    mch_match.int_numberOfBlueCycles = st.columnInt(i);
                                    break;
                                case "matchOutcome":
                                    //set the match outcome to that column's data
                                    mch_match.int_matchOutCome = st.columnInt(i);
                                    break;
                            }
                        }
                    }
                }
            } finally {
                //clear up memory used by the statement
                st.dispose();
            }
            
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }

        //loop through the number of teams
        for (int i = 0; i < Constants.int_NUMBER_OF_TEAMS; i++)
        {
            //load the autonomous cycle from the db
            mch_match.mtch_autonomous[i] = DataBaseManager.loadAutonomous(mch_match.int_gameNumber, mch_match.int_teamNumbers[i]);
            //load the fouls from the db
            mch_match.mtch_fouls[i] = DataBaseManager.loadFoul(mch_match.int_gameNumber, mch_match.int_teamNumbers[i]);

            if (i<3) //red alliance
            {
                //loop through the red cycles
                for (int j = 0; j < mch_match.int_numberOfRedCycles-1; j++)
                {
                    //load the red cycles from the db
                    mch_match.mtch_cycles[j][i] =  DataBaseManager.loadCycle(mch_match.int_gameNumber, mch_match.int_teamNumbers[i], j);
                }
            }
            else //blue alliance
            {
                //loop through the blue cycles
                for (int j = 0; j < mch_match.int_numberOfBlueCycles-1; j++)
                {
                    //load the blue cycles from the db
                    mch_match.mtch_cycles[j][i] =  DataBaseManager.loadCycle(mch_match.int_gameNumber, mch_match.int_teamNumbers[i], j);
                }
            }
        }
        
        //return the loaded team
        return mch_match;
    }
    //takes a match as a parameter and removes it from the db, returns nothing
    public static void removeMatch(int int_matchNumber)
    {
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //delete the match with the inputed number from the meta data db
            sqlc_database.exec("DELETE FROM GameMetaData WHERE matchNumber = " + int_matchNumber + ";");
            //delete the match with the inputed number from the autonomous db
            sqlc_database.exec("DELETE FROM GameAutonomous WHERE matchNumber = " + int_matchNumber + ";");
            //delete the match with the inputed number from the game cyles db
            sqlc_database.exec("DELETE FROM GameCycles WHERE matchNumber = " + int_matchNumber + ";");
            //delete the match with the inputed number from the fouls db
            sqlc_database.exec("DELETE FROM GameFouls WHERE matchNumber = " + int_matchNumber + ";");
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
    }
    
    /*----------------------------------------Autonomous----------------------------------------*/
    //takes an autonomous object as a parameter and adds it to the db, returns nothing
    public static void addAutonomous(MatchAutonomous mchatn_autonomous)
    {
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            
            int int_mobility = boolToInt(mchatn_autonomous.bool_mobility);
            int int_lowGoal = boolToInt(mchatn_autonomous.bool_lowGoal);
            int int_highGoal = boolToInt(mchatn_autonomous.bool_highGoal);
            int int_hotGoal = boolToInt(mchatn_autonomous.bool_hotGoal);
            
            //instert the autonomous data into the db
            sqlc_database.exec("REPLACE INTO GameAutonomous VALUES(" + mchatn_autonomous.int_matchNumber + "," 
                    + mchatn_autonomous.int_teamNumber + "," + int_mobility + "," + int_lowGoal 
                    + "," + int_highGoal + "," + int_hotGoal + ");");
            
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
    }
    
    //takes the match number and team number as parameters , loads the autonomous cycle from the db, returns the loaded autonomous cycle
    public static MatchAutonomous loadAutonomous(int int_matchNumber, int int_teamNumber)
    {
        //create an autonomous match objet with the inputed match and team numbers
        MatchAutonomous mchatn_autonomous = new MatchAutonomous(int_matchNumber, int_teamNumber);   
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //retrieve the row from the db that matches the inputed match and team numbers
            SQLiteStatement st = sqlc_database.prepare("SELECT * FROM GameAutonomous WHERE matchNumber=" 
                    + int_matchNumber + " AND teamNumber=" + int_teamNumber + ";");
            try {
                //loop while there is data to be read as a result of the statement
                while (st.step()) {
                    //loop through the columns in the data
                    for (int i = 0; i < st.columnCount(); i++) {
                        //check if the column is an integer
                        if (st.columnType(i) == SQLiteConstants.SQLITE_INTEGER) {
                            //use a switch to check the column name
                            switch (st.getColumnName(i)) {
                                case "mobility":
                                    //set the mobility value to that column's data
                                    mchatn_autonomous.bool_mobility = intToBool(st.columnInt(i));
                                    break;
                                case "lowGoal":
                                    //set the low goal value to that column's data
                                    mchatn_autonomous.bool_lowGoal = intToBool(st.columnInt(i));
                                    break;
                                case "highGoal":
                                    //set the high goal value to that column's data
                                    mchatn_autonomous.bool_highGoal = intToBool(st.columnInt(i));
                                    break;
                                case "hotGoal":
                                    //set the hot goal value to that column's data
                                    mchatn_autonomous.bool_hotGoal = intToBool(st.columnInt(i));
                                    break;
                            }
                        }
                    }
                }
            } finally {
                //clear up memory used by the statement
                st.dispose();
            }
            
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
        //return the loaded autonomous match
        return mchatn_autonomous;
    }
    
    //takes a team number and match number as a parameters and removes the matching autonomous data from the db, returns nothing
    public static void removeAutonomous(int int_matchNumber, int int_teamNumber)
    {
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //delete the match with the inputed number from the autonomous db
            sqlc_database.exec("DELETE FROM GameAutonomous WHERE matchNumber = " + int_matchNumber 
                    + " AND teamNumber=" + int_teamNumber + ";");
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
    }
    
    /*----------------------------------------Fouls----------------------------------------*/
    //takes a foul object as a parameter and adds it to the db, returns nothing
    public static void addFoul(MatchFouls mchfls_fouls)
    {
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            
            //instert the autonomous data into the db
            sqlc_database.exec("REPLACE INTO GameFouls VALUES(" + mchfls_fouls.int_matchNumber + "," 
                    + mchfls_fouls.int_teamNumber + "," + mchfls_fouls.int_fouls + "," + mchfls_fouls.int_technicalFouls + ");");
            
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
    }
    //takes the match number and team number as parameters, loads the corresponding fouls from the db, returns the loaded fouls
    public static MatchFouls loadFoul(int int_matchNumber, int int_teamNumber)
    {
        //create an autonomous match objet with the inputed match and team numbers
        MatchFouls mchfls_fouls = new MatchFouls(int_matchNumber, int_teamNumber);   
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //retrieve the row from the db that matches the inputed match and team numbers
            SQLiteStatement st = sqlc_database.prepare("SELECT * FROM GameFouls WHERE matchNumber=" 
                    + int_matchNumber + " AND teamNumber=" + int_teamNumber + ";");
            try {
                //loop while there is data to be read as a result of the statement
                while (st.step()) {
                    //loop through the columns in the data
                    for (int i = 0; i < st.columnCount(); i++) {
                        //check if the column is an integer
                        if (st.columnType(i) == SQLiteConstants.SQLITE_INTEGER) {
                            //use a switch to check the column name
                            switch (st.getColumnName(i)) {
                                case "fouls":
                                    //set the fouls value to that column's data
                                    mchfls_fouls.int_fouls = st.columnInt(i);
                                    break;
                                case "technicalFouls":
                                    //set the technical fouls value to that column's data
                                    mchfls_fouls.int_technicalFouls = st.columnInt(i);
                                    break;
                            }
                        }
                    }
                }
            } finally {
                //clear up memory used by the statement
                st.dispose();
            }
            
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
        //return the loaded autonomous match
        return mchfls_fouls;
    }
    
    //takes a team number and match number as a parameters and removes the matching foul data from the db, returns nothing
    public static void removeFoul(int int_matchNumber, int int_teamNumber)
    {
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //delete the match with the inputed number from the autonomous db
            sqlc_database.exec("DELETE FROM GameFouls WHERE matchNumber = " + int_matchNumber 
                    + " AND teamNumber=" + int_teamNumber + ";");
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
    }    
    
    
    
    /*----------------------------------------Cycle----------------------------------------*/
    //takes a cycle object as a parameter and adds it to the db, returns nothing
    public static void addCycle(MatchCycle cycle)
    {
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //get the int value of the blue zone boolean for db storage
            int int_blueZone = boolToInt(cycle.bool_blueZone);
            //get the int value of the red zone boolean for db storage
            int int_redZone = boolToInt(cycle.bool_redZone);
            //get the int value of the white zone boolean for db storage
            int int_whiteZone = boolToInt(cycle.bool_whiteZone);
            //get the int value of the catch boolean for db storage
            int int_catch = boolToInt(cycle.bool_catch);
            //get the int value of the truss boolean for db storage
            int int_truss = boolToInt(cycle.bool_truss);
            //get the int value of the high goal boolean for db storage
            int int_highGoal = boolToInt(cycle.bool_highGoal);
            //get the int value of the low goal boolean for db storage
            int int_lowGoal = boolToInt(cycle.bool_lowGoal);
            
            //instert the cycle data into the db
            sqlc_database.exec("REPLACE INTO GameCycles VALUES(" + cycle.int_matchNumber + "," 
                    + cycle.int_teamNumber + "," + cycle.int_cycleNumber + "," + int_blueZone 
                    + "," + int_whiteZone + "," + int_redZone + "," + int_truss 
                    + "," + int_catch  + "," + int_lowGoal + "," + int_highGoal + ");");
            
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
    }
    
    /*takes the match number, team number, and cycle number as parameters , 
     * loads the cycle from the db, returns the loaded cycle*/
    public static MatchCycle loadCycle(int int_matchNumber, int int_teamNumber, int int_cycleNumber)
    {
        //create a cycle objet with the inputed match and team numbers
        MatchCycle cycle = new MatchCycle(int_matchNumber, int_teamNumber, int_cycleNumber);   
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //retrieve the row from the db that matches the inputed match, team number, and cycle numbers
            SQLiteStatement st = sqlc_database.prepare("SELECT * FROM GameCycles WHERE matchNumber=" 
                    + int_matchNumber + " AND teamNumber=" + int_teamNumber + " AND cycleNumber=" + int_cycleNumber + ";");
            try {
                //loop while there is data to be read as a result of the statement
                while (st.step()) {
                    //loop through the columns in the data
                    for (int i = 0; i < st.columnCount(); i++) {
                        //check if the column is an integer
                        if (st.columnType(i) == SQLiteConstants.SQLITE_INTEGER) {
                            //use a switch to check the column name
                            switch (st.getColumnName(i)) {
                                case "blueZone":
                                    //set the blue zone value to that column's data
                                    cycle.bool_blueZone = intToBool(st.columnInt(i));
                                    break;
                                case "whiteZone":
                                    //set the white zone value to that column's data
                                    cycle.bool_whiteZone = intToBool(st.columnInt(i));
                                    break;
                                case "redZone":
                                    //set the red zone value to that column's data
                                    cycle.bool_redZone = intToBool(st.columnInt(i));
                                    break;
                                case "truss":
                                    //set the truss value to that column's data
                                    cycle.bool_truss = intToBool(st.columnInt(i));
                                    break;
                                case "catch":
                                    //set the catch value to that column's data
                                    cycle.bool_catch = intToBool(st.columnInt(i));
                                    break;
                                case "lowGoal":
                                    //set the low goal value to that column's data
                                    cycle.bool_lowGoal = intToBool(st.columnInt(i));
                                    break;
                                case "highGoal":
                                    //set the high goal value to that column's data
                                    cycle.bool_highGoal = intToBool(st.columnInt(i));
                                    break;
                            }
                        }
                    }
                }
            } finally {
                //clear up memory used by the statement
                st.dispose();
            }
            
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
        //return the loaded cycle
        return cycle;
    }
    
    //takes a team number, match number, and cycle number as a parameters and removes the matching cycle data from the db, returns nothing
    public static void removeCycle(int int_matchNumber, int int_teamNumber, int int_cycleNumber)
    {
        try {
            //open the db connection
            SQLiteConnection sqlc_database = openDB();
            //delete the cycle with the inputed number from the autonomous db
            sqlc_database.exec("DELETE FROM GameCycles WHERE matchNumber=" 
                    + int_matchNumber +  " AND cycleNumber=" + int_cycleNumber + ";");
            //close the db connection
            sqlc_database.dispose();
        } catch (SQLiteException ex) {
            //a fatal error occured
            unrecoverableErrorOccured(ex);
        }
    }
    
    
    //takes a boolean as a parameter and returns it as an integer
    public static int boolToInt(boolean bool_boolean)
    {
        //return 1 if true and 0 if false
        return (bool_boolean) ? 1 : 0;
    }
    //takes an integer as a parameter and returns it as a boolean
    public static boolean intToBool(int int_boolean)
    {
        //return true if the value is greater than 0
        return (int_boolean > 0) ? true : false;
    }
}           