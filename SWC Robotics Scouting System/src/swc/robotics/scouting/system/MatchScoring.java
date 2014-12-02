/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package swc.robotics.scouting.system;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;

/**
 * Project Name: SWC Robotics Scouting System
 * File Name:	 MatchScoring
 * Programmer:	 Phil Bystrican <Phil@PBApps.ca>
 * Teacher:	 Mr. K
 * Date:         Mar 7, 2014
 * Description:  JFrame used to collect all scoring data for the match
 **/
public class MatchScoring extends BaseJFrame {

    //create a match object to store all match data
    public Match mtch_currentMatch;
    //create an array for all red zone buttons (one for each team)
    private JToggleButton tglBtn_redZoneButtons[] = new JToggleButton[Constants.int_NUMBER_OF_TEAMS];
    //create an array for all white zone buttons (one for each team)
    private JToggleButton tglBtn_whiteZoneButtons[] = new JToggleButton[Constants.int_NUMBER_OF_TEAMS];
    //create an array for all blue zone buttons (one for each team)
    private JToggleButton tglBtn_blueZoneButtons[] = new JToggleButton[Constants.int_NUMBER_OF_TEAMS];
    
    //create an array for all truss check boxes (one for each team)
    private JCheckBox chkbx_truss[] = new JCheckBox[Constants.int_NUMBER_OF_TEAMS];
    //create an array for all catch check boxes (one for each team)
    private JCheckBox chkbx_catch[] = new JCheckBox[Constants.int_NUMBER_OF_TEAMS];
    //create an array for all high goal check boxes (one for each team)
    private JCheckBox chkbx_highGoal[] = new JCheckBox[Constants.int_NUMBER_OF_TEAMS];
    //create an array for all low goal check boxes (one for each team)
    private JCheckBox chkbx_lowGoal[] = new JCheckBox[Constants.int_NUMBER_OF_TEAMS];
   
    //create an array for all foul spinners (one for each team)
    private JSpinner spnr_fouls[] = new JSpinner[Constants.int_NUMBER_OF_TEAMS];
    //create an array for all technical foul spinners (one for each team)
    private JSpinner spnr_technicalFouls[] = new JSpinner[Constants.int_NUMBER_OF_TEAMS];
    
    //create an array for all autonomous mobility check boxes (one for each team)
    private JCheckBox chkbx_AutonMobility[] = new JCheckBox[Constants.int_NUMBER_OF_TEAMS];
    //create an array for all autonomous high goal check boxes (one for each team)
    private JCheckBox chkbx_AutonHighGoal[] = new JCheckBox[Constants.int_NUMBER_OF_TEAMS];
    //create an array for all autonomous low goal check boxes (one for each team)
    private JCheckBox chkbx_AutonLowGoal[] = new JCheckBox[Constants.int_NUMBER_OF_TEAMS];
    //create an array for all autonomous hot goal check boxes (one for each team)
    private JCheckBox chkbx_AutonHotGoal[] = new JCheckBox[Constants.int_NUMBER_OF_TEAMS]; 
    
    //array of matches to remove from the database
    private ArrayList arylst_cyclesToRemove = new ArrayList();
    
    //integer for last calculated blue alliance score
    private int int_lastCalculatedBlueScore = 0;
    //integer for last calculated red alliance score
    private int int_lastCalculatedRedScore = 0;
    
    //basic constructor onyl used in subclasses
    public MatchScoring()
    {
        //init the underlying components
        initComponents();
        
        //assign the gui components to arrays for easier access 
        this.assignComponentsToArrays();
    }
    
    /** Constructs a new MatchScoring and loads the data from  */
    public MatchScoring(int int_gameNumber) {
        //init the underlying components
        initComponents();
        
        //assign the gui components to arrays for easier access 
        this.assignComponentsToArrays();
        
        //load the match data from the db
        this.loadTeamDataFromDB(int_gameNumber);
    }
    
    /*takes no parameters, checks if the match number is 0 (meaning it doesnt exist in the db) 
    and pops the frame if the match is non existant. Returns nothing */
    public void becameVisible()
    {
        if (this.mtch_currentMatch.int_gameNumber == 0)
        {
            //let the user know no entry exists
            JOptionPane.showConfirmDialog(null, "No Entry Exists for that match.", "Return to Menu", JOptionPane.DEFAULT_OPTION);
            
            //go back to the previous frame
            this.back(null);
        }
    }
    
    //takes the game number as a parameter and loads the match data from the db
    public void loadTeamDataFromDB(int int_gameNumber)
    {
        //load the match from the db (may seem redudnant but allows for reuse as editor class)
        mtch_currentMatch = DataBaseManager.loadMatch(int_gameNumber);
        
        //decrease the number of blue cycles by one if more than 1 cycle exists 
        mtch_currentMatch.int_numberOfBlueCycles -= (mtch_currentMatch.int_numberOfBlueCycles > 1) ? 1 : 0;
        //decrease the number of red cycles by one if more than 1 cycle exists
        mtch_currentMatch.int_numberOfRedCycles -= (mtch_currentMatch.int_numberOfRedCycles > 1) ? 1 : 0;
        
        //restore the last blue cycle to the gui
        this.restoreBlueCycle(this.lastBlueCycle());
        //restore the last red cycle to the gui
        this.restoreRedCycle(this.lastRedCycle());

        
        //load the autonomous data from the db to the gui
        this.restoreAutonomous();
        //load the foul data from the db to the gui
        this.restoreFouls();
        
        //setup basic gui elements (set team number text)
        this.refreshBasicElements();
        
        //update the on screen scores for the blue alliance
        this.updateBlueScores();
        //update the on screen scores for the reds alliance
        this.updateRedScores();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chkbx_redTeam3AutonHighGoal1 = new javax.swing.JCheckBox();
        chkbx_redTeam3AutonLowGoal1 = new javax.swing.JCheckBox();
        chkbx_redTeam3HotGoal1 = new javax.swing.JCheckBox();
        chkbx_redTeam3Mobility1 = new javax.swing.JCheckBox();
        lbl_redAlliance2 = new javax.swing.JLabel();
        chkbx_redTeam2Mobility1 = new javax.swing.JCheckBox();
        chkbx_redTeam2HotGoal1 = new javax.swing.JCheckBox();
        chkbx_redTeam2AutonLowGoal1 = new javax.swing.JCheckBox();
        chkbx_redTeam2AutonHighGoal1 = new javax.swing.JCheckBox();
        chkbx_redTeam1AutonHighGoal1 = new javax.swing.JCheckBox();
        chkbx_redTeam1AutonLowGoal1 = new javax.swing.JCheckBox();
        chkbx_redTeam1HotGoal1 = new javax.swing.JCheckBox();
        chkbx_redTeam1Mobility1 = new javax.swing.JCheckBox();
        chkbx_redTeam3AutonHighGoal2 = new javax.swing.JCheckBox();
        chkbx_redTeam3AutonLowGoal2 = new javax.swing.JCheckBox();
        chkbx_redTeam3HotGoal2 = new javax.swing.JCheckBox();
        chkbx_redTeam3Mobility2 = new javax.swing.JCheckBox();
        lbl_redAlliance3 = new javax.swing.JLabel();
        chkbx_redTeam2Mobility2 = new javax.swing.JCheckBox();
        chkbx_redTeam2HotGoal2 = new javax.swing.JCheckBox();
        chkbx_redTeam2AutonLowGoal2 = new javax.swing.JCheckBox();
        chkbx_redTeam2AutonHighGoal2 = new javax.swing.JCheckBox();
        chkbx_redTeam1AutonHighGoal2 = new javax.swing.JCheckBox();
        chkbx_redTeam1AutonLowGoal2 = new javax.swing.JCheckBox();
        chkbx_redTeam1HotGoal2 = new javax.swing.JCheckBox();
        chkbx_redTeam1Mobility2 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_redAlliance = new javax.swing.JLabel();
        lbl_redTeam1 = new javax.swing.JLabel();
        lbl_redTeam2 = new javax.swing.JLabel();
        lbl_redTeam3 = new javax.swing.JLabel();
        tglBtn_redTeam3BlueZone = new javax.swing.JToggleButton();
        tglBtn_redTeam2BlueZone = new javax.swing.JToggleButton();
        tglBtn_redTeam1BlueZone = new javax.swing.JToggleButton();
        tglBtn_redTeam1WhiteZone = new javax.swing.JToggleButton();
        tglBtn_redTeam1RedZone = new javax.swing.JToggleButton();
        tglBtn_redTeam2RedZone = new javax.swing.JToggleButton();
        tglBtn_redTeam2WhiteZone = new javax.swing.JToggleButton();
        tglBtn_redTeam3WhiteZone = new javax.swing.JToggleButton();
        tglBtn_redTeam3RedZone = new javax.swing.JToggleButton();
        chkbx_redTeam1Truss = new javax.swing.JCheckBox();
        chkbx_redTeam1Catch = new javax.swing.JCheckBox();
        chkbx_redTeam1LowGoal = new javax.swing.JCheckBox();
        chkbx_redTeam1HighGoal = new javax.swing.JCheckBox();
        btn_endRedCycle = new javax.swing.JButton();
        chkbx_redTeam2HighGoal = new javax.swing.JCheckBox();
        chkbx_redTeam2LowGoal = new javax.swing.JCheckBox();
        chkbx_redTeam2Catch = new javax.swing.JCheckBox();
        chkbx_redTeam2Truss = new javax.swing.JCheckBox();
        chkbx_redTeam3Truss = new javax.swing.JCheckBox();
        chkbx_redTeam3Catch = new javax.swing.JCheckBox();
        chkbx_redTeam3LowGoal = new javax.swing.JCheckBox();
        chkbx_redTeam3HighGoal = new javax.swing.JCheckBox();
        spnr_redTeam1Fouls = new javax.swing.JSpinner();
        spnr_redTeam1TechFouls = new javax.swing.JSpinner();
        lbl_techFoul = new javax.swing.JLabel();
        lbl_foul = new javax.swing.JLabel();
        spnr_redTeam2TechFouls = new javax.swing.JSpinner();
        lbl_techFoul1 = new javax.swing.JLabel();
        lbl_foul1 = new javax.swing.JLabel();
        spnr_redTeam2Fouls = new javax.swing.JSpinner();
        lbl_techFoul2 = new javax.swing.JLabel();
        lbl_foul2 = new javax.swing.JLabel();
        spnr_redTeam3Fouls = new javax.swing.JSpinner();
        spnr_redTeam3TechFouls = new javax.swing.JSpinner();
        lbl_redAlliance1 = new javax.swing.JLabel();
        chkbx_redTeam1AutonHighGoal = new javax.swing.JCheckBox();
        chkbx_redTeam1AutonLowGoal = new javax.swing.JCheckBox();
        chkbx_redTeam1HotGoal = new javax.swing.JCheckBox();
        chkbx_redTeam1Mobility = new javax.swing.JCheckBox();
        chkbx_redTeam2AutonHighGoal = new javax.swing.JCheckBox();
        chkbx_redTeam2AutonLowGoal = new javax.swing.JCheckBox();
        chkbx_redTeam2HotGoal = new javax.swing.JCheckBox();
        chkbx_redTeam2Mobility = new javax.swing.JCheckBox();
        chkbx_redTeam3AutonHighGoal = new javax.swing.JCheckBox();
        chkbx_redTeam3AutonLowGoal = new javax.swing.JCheckBox();
        chkbx_redTeam3HotGoal = new javax.swing.JCheckBox();
        chkbx_redTeam3Mobility = new javax.swing.JCheckBox();
        lbl_redCycleNumber = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_redT1Points = new javax.swing.JLabel();
        lbl_redT2Points = new javax.swing.JLabel();
        lbl_redT3Points = new javax.swing.JLabel();
        lbl_redAssistPoints = new javax.swing.JLabel();
        lbl_redTotalPoints = new javax.swing.JLabel();
        lbl_redFoulPoints = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_redT3AutonomousPoints = new javax.swing.JLabel();
        lbl_redT2AutonomousPoints = new javax.swing.JLabel();
        lbl_redT1AutonomousPoints = new javax.swing.JLabel();
        btn_deleteRedCycle = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lbl_blueAlliance = new javax.swing.JLabel();
        lbl_blueTeam1 = new javax.swing.JLabel();
        lbl_blueTeam2 = new javax.swing.JLabel();
        lbl_blueTeam3 = new javax.swing.JLabel();
        tglBtn_blueTeam3BlueZone = new javax.swing.JToggleButton();
        tglBtn_blueTeam2BlueZone = new javax.swing.JToggleButton();
        tglBtn_blueTeam1BlueZone = new javax.swing.JToggleButton();
        tglBtn_blueTeam1WhiteZone = new javax.swing.JToggleButton();
        tglBtn_blueTeam1RedZone = new javax.swing.JToggleButton();
        tglBtn_blueTeam2RedZone = new javax.swing.JToggleButton();
        tglBtn_blueTeam2WhiteZone = new javax.swing.JToggleButton();
        tglBtn_blueTeam3WhiteZone = new javax.swing.JToggleButton();
        tglBtn_blueTeam3RedZone = new javax.swing.JToggleButton();
        chkbx_blueTeam1Truss = new javax.swing.JCheckBox();
        chkbx_blueTeam1Catch = new javax.swing.JCheckBox();
        chkbx_blueTeam1LowGoal = new javax.swing.JCheckBox();
        chkbx_blueTeam1HighGoal = new javax.swing.JCheckBox();
        btn_endBlueCycle = new javax.swing.JButton();
        chkbx_blueTeam2HighGoal = new javax.swing.JCheckBox();
        chkbx_blueTeam2LowGoal = new javax.swing.JCheckBox();
        chkbx_blueTeam2Catch = new javax.swing.JCheckBox();
        chkbx_blueTeam2Truss = new javax.swing.JCheckBox();
        chkbx_blueTeam3Truss = new javax.swing.JCheckBox();
        chkbx_blueTeam3Catch = new javax.swing.JCheckBox();
        chkbx_blueTeam3LowGoal = new javax.swing.JCheckBox();
        chkbx_blueTeam3HighGoal = new javax.swing.JCheckBox();
        lbl_techFoul5 = new javax.swing.JLabel();
        lbl_foul5 = new javax.swing.JLabel();
        spnr_blueTeam3TechFouls = new javax.swing.JSpinner();
        lbl_foul3 = new javax.swing.JLabel();
        lbl_techFoul3 = new javax.swing.JLabel();
        spnr_blueTeam3Fouls = new javax.swing.JSpinner();
        spnr_blueTeam1TechFouls = new javax.swing.JSpinner();
        spnr_blueTeam1Fouls = new javax.swing.JSpinner();
        spnr_blueTeam2Fouls = new javax.swing.JSpinner();
        spnr_blueTeam2TechFouls = new javax.swing.JSpinner();
        lbl_techFoul4 = new javax.swing.JLabel();
        lbl_foul4 = new javax.swing.JLabel();
        lbl_redAlliance4 = new javax.swing.JLabel();
        chkbx_blueTeam1Mobility = new javax.swing.JCheckBox();
        chkbx_blueTeam1HotGoal = new javax.swing.JCheckBox();
        chkbx_blueTeam1AutonLowGoal = new javax.swing.JCheckBox();
        chkbx_blueTeam1AutonHighGoal = new javax.swing.JCheckBox();
        chkbx_blueTeam2Mobility = new javax.swing.JCheckBox();
        chkbx_blueTeam2HotGoal = new javax.swing.JCheckBox();
        chkbx_blueTeam2AutonHighGoal = new javax.swing.JCheckBox();
        chkbx_blueTeam2AutonLowGoal = new javax.swing.JCheckBox();
        chkbx_blueTeam3Mobility = new javax.swing.JCheckBox();
        chkbx_blueTeam3HotGoal = new javax.swing.JCheckBox();
        chkbx_blueTeam3AutonHighGoal = new javax.swing.JCheckBox();
        chkbx_blueTeam3AutonLowGoal = new javax.swing.JCheckBox();
        lbl_blueCycleNumber = new javax.swing.JLabel();
        lbl_blueT1Points = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_blueT3Points = new javax.swing.JLabel();
        lbl_blueT2Points = new javax.swing.JLabel();
        lbl_blueAssistPoints = new javax.swing.JLabel();
        lbl_blueTotalPoints = new javax.swing.JLabel();
        lbl_blueFoulPoints = new javax.swing.JLabel();
        lbl_blueT3AutonomousPoints = new javax.swing.JLabel();
        lbl_blueT2AutonomousPoints = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_blueT1AutonomousPoints = new javax.swing.JLabel();
        btn_deleteBlueCycle = new javax.swing.JButton();
        btn_mainMenu = new javax.swing.JButton();
        btn_finishScoring = new javax.swing.JButton();
        btn_deleteMatch = new javax.swing.JButton();

        chkbx_redTeam3AutonHighGoal1.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3AutonHighGoal1.setText("High Goal");

        chkbx_redTeam3AutonLowGoal1.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3AutonLowGoal1.setText("Low Goal");

        chkbx_redTeam3HotGoal1.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3HotGoal1.setText("Hot Goal");

        chkbx_redTeam3Mobility1.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3Mobility1.setText("Mobility");

        lbl_redAlliance2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_redAlliance2.setForeground(new java.awt.Color(255, 204, 204));
        lbl_redAlliance2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redAlliance2.setText("Autonomous");

        chkbx_redTeam2Mobility1.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2Mobility1.setText("Mobility");

        chkbx_redTeam2HotGoal1.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2HotGoal1.setText("Hot Goal");

        chkbx_redTeam2AutonLowGoal1.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2AutonLowGoal1.setText("Low Goal");

        chkbx_redTeam2AutonHighGoal1.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2AutonHighGoal1.setText("High Goal");

        chkbx_redTeam1AutonHighGoal1.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1AutonHighGoal1.setText("High Goal");

        chkbx_redTeam1AutonLowGoal1.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1AutonLowGoal1.setText("Low Goal");

        chkbx_redTeam1HotGoal1.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1HotGoal1.setText("Hot Goal");

        chkbx_redTeam1Mobility1.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1Mobility1.setText("Mobility");

        chkbx_redTeam3AutonHighGoal2.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3AutonHighGoal2.setText("High Goal");

        chkbx_redTeam3AutonLowGoal2.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3AutonLowGoal2.setText("Low Goal");

        chkbx_redTeam3HotGoal2.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3HotGoal2.setText("Hot Goal");

        chkbx_redTeam3Mobility2.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3Mobility2.setText("Mobility");

        lbl_redAlliance3.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_redAlliance3.setForeground(new java.awt.Color(255, 204, 204));
        lbl_redAlliance3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redAlliance3.setText("Autonomous");

        chkbx_redTeam2Mobility2.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2Mobility2.setText("Mobility");

        chkbx_redTeam2HotGoal2.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2HotGoal2.setText("Hot Goal");

        chkbx_redTeam2AutonLowGoal2.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2AutonLowGoal2.setText("Low Goal");

        chkbx_redTeam2AutonHighGoal2.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2AutonHighGoal2.setText("High Goal");

        chkbx_redTeam1AutonHighGoal2.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1AutonHighGoal2.setText("High Goal");

        chkbx_redTeam1AutonLowGoal2.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1AutonLowGoal2.setText("Low Goal");

        chkbx_redTeam1HotGoal2.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1HotGoal2.setText("Hot Goal");

        chkbx_redTeam1Mobility2.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1Mobility2.setText("Mobility");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        lbl_title.setBackground(new java.awt.Color(255, 255, 255));
        lbl_title.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("Match #### Scoring");

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(153, 0, 0));

        lbl_redAlliance.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_redAlliance.setForeground(new java.awt.Color(255, 204, 204));
        lbl_redAlliance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redAlliance.setText("Red Alliance");

        lbl_redTeam1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_redTeam1.setForeground(new java.awt.Color(255, 204, 204));
        lbl_redTeam1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redTeam1.setText("Team ####");

        lbl_redTeam2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_redTeam2.setForeground(new java.awt.Color(255, 204, 204));
        lbl_redTeam2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redTeam2.setText("Team ####");

        lbl_redTeam3.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_redTeam3.setForeground(new java.awt.Color(255, 204, 204));
        lbl_redTeam3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redTeam3.setText("Team ####");

        tglBtn_redTeam3BlueZone.setBackground(new java.awt.Color(0, 51, 255));
        tglBtn_redTeam3BlueZone.setForeground(new java.awt.Color(255, 255, 255));
        tglBtn_redTeam3BlueZone.setMnemonic('1');
        tglBtn_redTeam3BlueZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_redTeam3BlueZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_redTeam2BlueZone.setBackground(new java.awt.Color(0, 51, 255));
        tglBtn_redTeam2BlueZone.setForeground(new java.awt.Color(255, 255, 255));
        tglBtn_redTeam2BlueZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_redTeam2BlueZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_redTeam1BlueZone.setBackground(new java.awt.Color(0, 51, 255));
        tglBtn_redTeam1BlueZone.setForeground(new java.awt.Color(255, 255, 255));
        tglBtn_redTeam1BlueZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_redTeam1BlueZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_redTeam1WhiteZone.setBackground(new java.awt.Color(255, 255, 255));
        tglBtn_redTeam1WhiteZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_redTeam1WhiteZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_redTeam1RedZone.setBackground(new java.awt.Color(255, 0, 51));
        tglBtn_redTeam1RedZone.setForeground(new java.awt.Color(255, 255, 255));
        tglBtn_redTeam1RedZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_redTeam1RedZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_redTeam2RedZone.setBackground(new java.awt.Color(255, 0, 51));
        tglBtn_redTeam2RedZone.setForeground(new java.awt.Color(255, 255, 255));
        tglBtn_redTeam2RedZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_redTeam2RedZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_redTeam2WhiteZone.setBackground(new java.awt.Color(255, 255, 255));
        tglBtn_redTeam2WhiteZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_redTeam2WhiteZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_redTeam3WhiteZone.setBackground(new java.awt.Color(255, 255, 255));
        tglBtn_redTeam3WhiteZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_redTeam3WhiteZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_redTeam3RedZone.setBackground(new java.awt.Color(255, 0, 51));
        tglBtn_redTeam3RedZone.setForeground(new java.awt.Color(255, 255, 255));
        tglBtn_redTeam3RedZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_redTeam3RedZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        chkbx_redTeam1Truss.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1Truss.setText("Truss");
        chkbx_redTeam1Truss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redTrussActionPerformed(evt);
            }
        });

        chkbx_redTeam1Catch.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1Catch.setText("Catch");
        chkbx_redTeam1Catch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redCatchActionPerformed(evt);
            }
        });

        chkbx_redTeam1LowGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1LowGoal.setText("Low Goal");
        chkbx_redTeam1LowGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redLowGoalActionPerformed(evt);
            }
        });

        chkbx_redTeam1HighGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1HighGoal.setText("High Goal");
        chkbx_redTeam1HighGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redHighGoalActionPerformed(evt);
            }
        });

        btn_endRedCycle.setBackground(new java.awt.Color(255, 255, 255));
        btn_endRedCycle.setForeground(new java.awt.Color(153, 0, 0));
        btn_endRedCycle.setText("Save and End Red Cycle");
        btn_endRedCycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_endRedCycleActionPerformed(evt);
            }
        });

        chkbx_redTeam2HighGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2HighGoal.setText("High Goal");
        chkbx_redTeam2HighGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redHighGoalActionPerformed(evt);
            }
        });

        chkbx_redTeam2LowGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2LowGoal.setText("Low Goal");
        chkbx_redTeam2LowGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redLowGoalActionPerformed(evt);
            }
        });

        chkbx_redTeam2Catch.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2Catch.setText("Catch");
        chkbx_redTeam2Catch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redCatchActionPerformed(evt);
            }
        });

        chkbx_redTeam2Truss.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2Truss.setText("Truss");
        chkbx_redTeam2Truss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redTrussActionPerformed(evt);
            }
        });

        chkbx_redTeam3Truss.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3Truss.setText("Truss");
        chkbx_redTeam3Truss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redTrussActionPerformed(evt);
            }
        });

        chkbx_redTeam3Catch.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3Catch.setText("Catch");
        chkbx_redTeam3Catch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redCatchActionPerformed(evt);
            }
        });

        chkbx_redTeam3LowGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3LowGoal.setText("Low Goal");
        chkbx_redTeam3LowGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redLowGoalActionPerformed(evt);
            }
        });

        chkbx_redTeam3HighGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3HighGoal.setText("High Goal");
        chkbx_redTeam3HighGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redHighGoalActionPerformed(evt);
            }
        });

        spnr_redTeam1Fouls.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnr_redTeam1Fouls.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                foulsChanged(evt);
            }
        });

        spnr_redTeam1TechFouls.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnr_redTeam1TechFouls.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                foulsChanged(evt);
            }
        });

        lbl_techFoul.setForeground(new java.awt.Color(255, 204, 204));
        lbl_techFoul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_techFoul.setText("Tech. Foul");

        lbl_foul.setForeground(new java.awt.Color(255, 204, 204));
        lbl_foul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_foul.setText("Foul");

        spnr_redTeam2TechFouls.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnr_redTeam2TechFouls.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                foulsChanged(evt);
            }
        });

        lbl_techFoul1.setForeground(new java.awt.Color(255, 204, 204));
        lbl_techFoul1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_techFoul1.setText("Tech. Foul");

        lbl_foul1.setForeground(new java.awt.Color(255, 204, 204));
        lbl_foul1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_foul1.setText("Foul");

        spnr_redTeam2Fouls.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnr_redTeam2Fouls.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                foulsChanged(evt);
            }
        });

        lbl_techFoul2.setForeground(new java.awt.Color(255, 204, 204));
        lbl_techFoul2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_techFoul2.setText("Tech. Foul");

        lbl_foul2.setForeground(new java.awt.Color(255, 204, 204));
        lbl_foul2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_foul2.setText("Foul");

        spnr_redTeam3Fouls.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnr_redTeam3Fouls.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                foulsChanged(evt);
            }
        });

        spnr_redTeam3TechFouls.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnr_redTeam3TechFouls.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                foulsChanged(evt);
            }
        });

        lbl_redAlliance1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_redAlliance1.setForeground(new java.awt.Color(255, 204, 204));
        lbl_redAlliance1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redAlliance1.setText("Autonomous");

        chkbx_redTeam1AutonHighGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1AutonHighGoal.setText("High Goal");
        chkbx_redTeam1AutonHighGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_redTeam1AutonLowGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1AutonLowGoal.setText("Low Goal");
        chkbx_redTeam1AutonLowGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_redTeam1HotGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1HotGoal.setText("Hot Goal");
        chkbx_redTeam1HotGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_redTeam1Mobility.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam1Mobility.setText("Mobility");
        chkbx_redTeam1Mobility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_redTeam2AutonHighGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2AutonHighGoal.setText("High Goal");
        chkbx_redTeam2AutonHighGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_redTeam2AutonLowGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2AutonLowGoal.setText("Low Goal");
        chkbx_redTeam2AutonLowGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_redTeam2HotGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2HotGoal.setText("Hot Goal");
        chkbx_redTeam2HotGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_redTeam2Mobility.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam2Mobility.setText("Mobility");
        chkbx_redTeam2Mobility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_redTeam3AutonHighGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3AutonHighGoal.setText("High Goal");
        chkbx_redTeam3AutonHighGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_redTeam3AutonLowGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3AutonLowGoal.setText("Low Goal");
        chkbx_redTeam3AutonLowGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_redTeam3HotGoal.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3HotGoal.setText("Hot Goal");
        chkbx_redTeam3HotGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_redTeam3Mobility.setForeground(new java.awt.Color(255, 204, 204));
        chkbx_redTeam3Mobility.setText("Mobility");
        chkbx_redTeam3Mobility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        lbl_redCycleNumber.setForeground(new java.awt.Color(255, 255, 255));
        lbl_redCycleNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redCycleNumber.setText("Cycle # ");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Individual Points");

        lbl_redT1Points.setForeground(new java.awt.Color(255, 255, 255));
        lbl_redT1Points.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redT1Points.setText("0");

        lbl_redT2Points.setForeground(new java.awt.Color(255, 255, 255));
        lbl_redT2Points.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redT2Points.setText("0");

        lbl_redT3Points.setForeground(new java.awt.Color(255, 255, 255));
        lbl_redT3Points.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redT3Points.setText("0");

        lbl_redAssistPoints.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_redAssistPoints.setForeground(new java.awt.Color(255, 255, 255));
        lbl_redAssistPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redAssistPoints.setText("Assist Points: 0");

        lbl_redTotalPoints.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_redTotalPoints.setForeground(new java.awt.Color(255, 255, 255));
        lbl_redTotalPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redTotalPoints.setText("Total Points: 0");

        lbl_redFoulPoints.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_redFoulPoints.setForeground(new java.awt.Color(255, 255, 255));
        lbl_redFoulPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redFoulPoints.setText("Foul Points: 0");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Autonomous Points");

        lbl_redT3AutonomousPoints.setForeground(new java.awt.Color(255, 255, 255));
        lbl_redT3AutonomousPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redT3AutonomousPoints.setText("0");

        lbl_redT2AutonomousPoints.setForeground(new java.awt.Color(255, 255, 255));
        lbl_redT2AutonomousPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redT2AutonomousPoints.setText("0");

        lbl_redT1AutonomousPoints.setForeground(new java.awt.Color(255, 255, 255));
        lbl_redT1AutonomousPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redT1AutonomousPoints.setText("0");

        btn_deleteRedCycle.setBackground(new java.awt.Color(255, 255, 255));
        btn_deleteRedCycle.setForeground(new java.awt.Color(153, 0, 0));
        btn_deleteRedCycle.setText("Delete Red Cycle");
        btn_deleteRedCycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteRedCycleActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lbl_redAlliance1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(spnr_redTeam1Fouls, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .add(lbl_foul, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(lbl_techFoul, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(spnr_redTeam1TechFouls))
                        .add(15, 15, 15)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(spnr_redTeam2Fouls, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .add(lbl_foul1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(lbl_techFoul1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(spnr_redTeam2TechFouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(15, 15, 15)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(spnr_redTeam3Fouls, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .add(lbl_foul2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(lbl_techFoul2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(spnr_redTeam3TechFouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(chkbx_redTeam1Truss, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(chkbx_redTeam1Catch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(chkbx_redTeam1LowGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(chkbx_redTeam1HighGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, chkbx_redTeam2LowGoal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, chkbx_redTeam2Catch, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, chkbx_redTeam2HighGoal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .add(chkbx_redTeam2Truss, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(lbl_redCycleNumber, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(chkbx_redTeam3Truss, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(chkbx_redTeam3LowGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(chkbx_redTeam3HighGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(chkbx_redTeam3Catch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jPanel4Layout.createSequentialGroup()
                .add(lbl_redTotalPoints, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(1, 1, 1))
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(tglBtn_redTeam1WhiteZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(tglBtn_redTeam1RedZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(tglBtn_redTeam2WhiteZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(tglBtn_redTeam3WhiteZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(tglBtn_redTeam2RedZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(tglBtn_redTeam3RedZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, lbl_redFoulPoints, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, lbl_redAssistPoints, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(1, 1, 1))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(chkbx_redTeam1Mobility, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(chkbx_redTeam1HotGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(chkbx_redTeam1AutonLowGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(chkbx_redTeam1AutonHighGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(chkbx_redTeam2Mobility, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(chkbx_redTeam2HotGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(chkbx_redTeam2AutonLowGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(chkbx_redTeam2AutonHighGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(chkbx_redTeam3Mobility, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(chkbx_redTeam3HotGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(chkbx_redTeam3AutonLowGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(chkbx_redTeam3AutonHighGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(lbl_redT1AutonomousPoints, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(lbl_redT2AutonomousPoints, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(lbl_redT3AutonomousPoints, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(btn_endRedCycle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 450, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btn_deleteRedCycle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 447, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(lbl_redT1Points, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(lbl_redT2Points, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(lbl_redT3Points, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 0, Short.MAX_VALUE))))
            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, lbl_redAlliance, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(tglBtn_redTeam1BlueZone, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(tglBtn_redTeam2BlueZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(tglBtn_redTeam3BlueZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(jPanel4Layout.createSequentialGroup()
                            .add(lbl_redTeam1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(lbl_redTeam2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(lbl_redTeam3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(96, 96, 96)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tglBtn_redTeam1WhiteZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tglBtn_redTeam2WhiteZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tglBtn_redTeam3WhiteZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 0, 0)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tglBtn_redTeam3RedZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tglBtn_redTeam2RedZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tglBtn_redTeam1RedZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 0, 0)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(chkbx_redTeam2LowGoal)
                                    .add(chkbx_redTeam3LowGoal))
                                .add(jPanel4Layout.createSequentialGroup()
                                    .add(chkbx_redTeam1Truss)
                                    .add(0, 0, 0)
                                    .add(chkbx_redTeam1Catch)
                                    .add(0, 0, 0)
                                    .add(chkbx_redTeam1LowGoal)))
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(chkbx_redTeam2Truss)
                                    .add(chkbx_redTeam3Truss))
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(chkbx_redTeam2Catch)
                                    .add(chkbx_redTeam3Catch))))
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(chkbx_redTeam1HighGoal)
                            .add(chkbx_redTeam2HighGoal)))
                    .add(chkbx_redTeam3HighGoal))
                .add(0, 0, 0)
                .add(lbl_redCycleNumber)
                .add(1, 1, 1)
                .add(btn_endRedCycle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(btn_deleteRedCycle)
                .add(0, 0, 0)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(jPanel4Layout.createSequentialGroup()
                            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(lbl_techFoul)
                                .add(lbl_foul))
                            .add(0, 0, 0)
                            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(spnr_redTeam1TechFouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(spnr_redTeam1Fouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(jPanel4Layout.createSequentialGroup()
                            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(lbl_techFoul1)
                                .add(lbl_foul1))
                            .add(0, 0, 0)
                            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(spnr_redTeam2TechFouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(spnr_redTeam2Fouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lbl_techFoul2)
                            .add(lbl_foul2))
                        .add(0, 0, 0)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(spnr_redTeam3TechFouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(spnr_redTeam3Fouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(0, 0, 0)
                .add(lbl_redAlliance1)
                .add(0, 0, 0)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(chkbx_redTeam1Mobility)
                        .add(0, 0, 0)
                        .add(chkbx_redTeam1HotGoal)
                        .add(0, 0, 0)
                        .add(chkbx_redTeam1AutonLowGoal)
                        .add(0, 0, 0)
                        .add(chkbx_redTeam1AutonHighGoal))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(chkbx_redTeam2Mobility)
                        .add(0, 0, 0)
                        .add(chkbx_redTeam2HotGoal)
                        .add(0, 0, 0)
                        .add(chkbx_redTeam2AutonLowGoal)
                        .add(0, 0, 0)
                        .add(chkbx_redTeam2AutonHighGoal))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(chkbx_redTeam3Mobility)
                        .add(0, 0, 0)
                        .add(chkbx_redTeam3HotGoal)
                        .add(0, 0, 0)
                        .add(chkbx_redTeam3AutonLowGoal)
                        .add(0, 0, 0)
                        .add(chkbx_redTeam3AutonHighGoal)))
                .add(0, 0, 0)
                .add(jLabel2)
                .add(3, 3, 3)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbl_redT1AutonomousPoints)
                    .add(lbl_redT2AutonomousPoints)
                    .add(lbl_redT3AutonomousPoints))
                .add(0, 0, 0)
                .add(jLabel1)
                .add(3, 3, 3)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbl_redT1Points)
                    .add(lbl_redT2Points)
                    .add(lbl_redT3Points))
                .add(2, 2, 2)
                .add(lbl_redAssistPoints)
                .add(2, 2, 2)
                .add(lbl_redFoulPoints)
                .add(2, 2, 2)
                .add(lbl_redTotalPoints)
                .add(0, 0, 0))
            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .add(lbl_redAlliance)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(lbl_redTeam1)
                        .add(lbl_redTeam2)
                        .add(lbl_redTeam3))
                    .add(0, 0, 0)
                    .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(tglBtn_redTeam1BlueZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(tglBtn_redTeam2BlueZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(tglBtn_redTeam3BlueZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(570, Short.MAX_VALUE)))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 153));

        lbl_blueAlliance.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_blueAlliance.setForeground(new java.awt.Color(204, 204, 255));
        lbl_blueAlliance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueAlliance.setText("Blue Alliance");

        lbl_blueTeam1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_blueTeam1.setForeground(new java.awt.Color(204, 204, 255));
        lbl_blueTeam1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueTeam1.setText("Team ####");

        lbl_blueTeam2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_blueTeam2.setForeground(new java.awt.Color(204, 204, 255));
        lbl_blueTeam2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueTeam2.setText("Team ####");

        lbl_blueTeam3.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_blueTeam3.setForeground(new java.awt.Color(204, 204, 255));
        lbl_blueTeam3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueTeam3.setText("Team ####");

        tglBtn_blueTeam3BlueZone.setBackground(new java.awt.Color(0, 51, 255));
        tglBtn_blueTeam3BlueZone.setForeground(new java.awt.Color(255, 255, 255));
        tglBtn_blueTeam3BlueZone.setMnemonic('1');
        tglBtn_blueTeam3BlueZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_blueTeam3BlueZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_blueTeam2BlueZone.setBackground(new java.awt.Color(0, 51, 255));
        tglBtn_blueTeam2BlueZone.setForeground(new java.awt.Color(255, 255, 255));
        tglBtn_blueTeam2BlueZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_blueTeam2BlueZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_blueTeam1BlueZone.setBackground(new java.awt.Color(0, 51, 255));
        tglBtn_blueTeam1BlueZone.setForeground(new java.awt.Color(255, 255, 255));
        tglBtn_blueTeam1BlueZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_blueTeam1BlueZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_blueTeam1WhiteZone.setBackground(new java.awt.Color(255, 255, 255));
        tglBtn_blueTeam1WhiteZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_blueTeam1WhiteZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_blueTeam1RedZone.setBackground(new java.awt.Color(255, 0, 51));
        tglBtn_blueTeam1RedZone.setForeground(new java.awt.Color(255, 255, 255));
        tglBtn_blueTeam1RedZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_blueTeam1RedZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_blueTeam2RedZone.setBackground(new java.awt.Color(255, 0, 51));
        tglBtn_blueTeam2RedZone.setForeground(new java.awt.Color(255, 255, 255));
        tglBtn_blueTeam2RedZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_blueTeam2RedZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_blueTeam2WhiteZone.setBackground(new java.awt.Color(255, 255, 255));
        tglBtn_blueTeam2WhiteZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_blueTeam2WhiteZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_blueTeam3WhiteZone.setBackground(new java.awt.Color(255, 255, 255));
        tglBtn_blueTeam3WhiteZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_blueTeam3WhiteZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        tglBtn_blueTeam3RedZone.setBackground(new java.awt.Color(255, 0, 51));
        tglBtn_blueTeam3RedZone.setForeground(new java.awt.Color(255, 255, 255));
        tglBtn_blueTeam3RedZone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tglBtn_blueTeam3RedZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        chkbx_blueTeam1Truss.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam1Truss.setText("Truss");
        chkbx_blueTeam1Truss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueTrussActionPerformed(evt);
            }
        });

        chkbx_blueTeam1Catch.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam1Catch.setText("Catch");
        chkbx_blueTeam1Catch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueCatchActionPerformed(evt);
            }
        });

        chkbx_blueTeam1LowGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam1LowGoal.setText("Low Goal");
        chkbx_blueTeam1LowGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueLowGoalActionPerformed(evt);
            }
        });

        chkbx_blueTeam1HighGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam1HighGoal.setText("High Goal");
        chkbx_blueTeam1HighGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueHighGoalActionPerformed(evt);
            }
        });

        btn_endBlueCycle.setBackground(new java.awt.Color(255, 255, 255));
        btn_endBlueCycle.setForeground(new java.awt.Color(0, 0, 153));
        btn_endBlueCycle.setText("Save and End Blue Cycle");
        btn_endBlueCycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_endBlueCycleActionPerformed(evt);
            }
        });

        chkbx_blueTeam2HighGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam2HighGoal.setText("High Goal");
        chkbx_blueTeam2HighGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueHighGoalActionPerformed(evt);
            }
        });

        chkbx_blueTeam2LowGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam2LowGoal.setText("Low Goal");
        chkbx_blueTeam2LowGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueLowGoalActionPerformed(evt);
            }
        });

        chkbx_blueTeam2Catch.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam2Catch.setText("Catch");
        chkbx_blueTeam2Catch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueCatchActionPerformed(evt);
            }
        });

        chkbx_blueTeam2Truss.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam2Truss.setText("Truss");
        chkbx_blueTeam2Truss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueTrussActionPerformed(evt);
            }
        });

        chkbx_blueTeam3Truss.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam3Truss.setText("Truss");
        chkbx_blueTeam3Truss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueTrussActionPerformed(evt);
            }
        });

        chkbx_blueTeam3Catch.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam3Catch.setText("Catch");
        chkbx_blueTeam3Catch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueCatchActionPerformed(evt);
            }
        });

        chkbx_blueTeam3LowGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam3LowGoal.setText("Low Goal");
        chkbx_blueTeam3LowGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueLowGoalActionPerformed(evt);
            }
        });

        chkbx_blueTeam3HighGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam3HighGoal.setText("High Goal");
        chkbx_blueTeam3HighGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueHighGoalActionPerformed(evt);
            }
        });

        lbl_techFoul5.setForeground(new java.awt.Color(204, 204, 255));
        lbl_techFoul5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_techFoul5.setText("Tech. Foul");

        lbl_foul5.setForeground(new java.awt.Color(204, 204, 255));
        lbl_foul5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_foul5.setText("Foul");

        spnr_blueTeam3TechFouls.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnr_blueTeam3TechFouls.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                foulsChanged(evt);
            }
        });

        lbl_foul3.setForeground(new java.awt.Color(204, 204, 255));
        lbl_foul3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_foul3.setText("Foul");

        lbl_techFoul3.setForeground(new java.awt.Color(204, 204, 255));
        lbl_techFoul3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_techFoul3.setText("Tech. Foul");

        spnr_blueTeam3Fouls.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnr_blueTeam3Fouls.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                foulsChanged(evt);
            }
        });

        spnr_blueTeam1TechFouls.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnr_blueTeam1TechFouls.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                foulsChanged(evt);
            }
        });

        spnr_blueTeam1Fouls.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnr_blueTeam1Fouls.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                foulsChanged(evt);
            }
        });

        spnr_blueTeam2Fouls.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnr_blueTeam2Fouls.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                foulsChanged(evt);
            }
        });

        spnr_blueTeam2TechFouls.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnr_blueTeam2TechFouls.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                foulsChanged(evt);
            }
        });

        lbl_techFoul4.setForeground(new java.awt.Color(204, 204, 255));
        lbl_techFoul4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_techFoul4.setText("Tech. Foul");

        lbl_foul4.setForeground(new java.awt.Color(204, 204, 255));
        lbl_foul4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_foul4.setText("Foul");

        lbl_redAlliance4.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_redAlliance4.setForeground(new java.awt.Color(204, 204, 255));
        lbl_redAlliance4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_redAlliance4.setText("Autonomous");

        chkbx_blueTeam1Mobility.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam1Mobility.setText("Mobility");
        chkbx_blueTeam1Mobility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_blueTeam1HotGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam1HotGoal.setText("Hot Goal");
        chkbx_blueTeam1HotGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_blueTeam1AutonLowGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam1AutonLowGoal.setText("Low Goal");
        chkbx_blueTeam1AutonLowGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_blueTeam1AutonHighGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam1AutonHighGoal.setText("High Goal");
        chkbx_blueTeam1AutonHighGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_blueTeam2Mobility.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam2Mobility.setText("Mobility");
        chkbx_blueTeam2Mobility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_blueTeam2HotGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam2HotGoal.setText("Hot Goal");
        chkbx_blueTeam2HotGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_blueTeam2AutonHighGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam2AutonHighGoal.setText("High Goal");
        chkbx_blueTeam2AutonHighGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_blueTeam2AutonLowGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam2AutonLowGoal.setText("Low Goal");
        chkbx_blueTeam2AutonLowGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_blueTeam3Mobility.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam3Mobility.setText("Mobility");
        chkbx_blueTeam3Mobility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_blueTeam3HotGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam3HotGoal.setText("Hot Goal");
        chkbx_blueTeam3HotGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_blueTeam3AutonHighGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam3AutonHighGoal.setText("High Goal");
        chkbx_blueTeam3AutonHighGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        chkbx_blueTeam3AutonLowGoal.setForeground(new java.awt.Color(204, 204, 255));
        chkbx_blueTeam3AutonLowGoal.setText("Low Goal");
        chkbx_blueTeam3AutonLowGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonomousBoxChecked(evt);
            }
        });

        lbl_blueCycleNumber.setForeground(new java.awt.Color(255, 255, 255));
        lbl_blueCycleNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueCycleNumber.setText("Cycle # ");

        lbl_blueT1Points.setForeground(new java.awt.Color(255, 255, 255));
        lbl_blueT1Points.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueT1Points.setText("0");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Individual Points");

        lbl_blueT3Points.setForeground(new java.awt.Color(255, 255, 255));
        lbl_blueT3Points.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueT3Points.setText("0");

        lbl_blueT2Points.setForeground(new java.awt.Color(255, 255, 255));
        lbl_blueT2Points.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueT2Points.setText("0");

        lbl_blueAssistPoints.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_blueAssistPoints.setForeground(new java.awt.Color(255, 255, 255));
        lbl_blueAssistPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueAssistPoints.setText("Assist Points: 0");

        lbl_blueTotalPoints.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_blueTotalPoints.setForeground(new java.awt.Color(255, 255, 255));
        lbl_blueTotalPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueTotalPoints.setText("Total Points: 0");

        lbl_blueFoulPoints.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_blueFoulPoints.setForeground(new java.awt.Color(255, 255, 255));
        lbl_blueFoulPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueFoulPoints.setText("Foul Points: 0");

        lbl_blueT3AutonomousPoints.setForeground(new java.awt.Color(255, 255, 255));
        lbl_blueT3AutonomousPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueT3AutonomousPoints.setText("0");

        lbl_blueT2AutonomousPoints.setForeground(new java.awt.Color(255, 255, 255));
        lbl_blueT2AutonomousPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueT2AutonomousPoints.setText("0");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Autonomous Points");

        lbl_blueT1AutonomousPoints.setForeground(new java.awt.Color(255, 255, 255));
        lbl_blueT1AutonomousPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_blueT1AutonomousPoints.setText("0");

        btn_deleteBlueCycle.setBackground(new java.awt.Color(255, 255, 255));
        btn_deleteBlueCycle.setForeground(new java.awt.Color(0, 0, 153));
        btn_deleteBlueCycle.setText("Delete Blue Cycle");
        btn_deleteBlueCycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteBlueCycleActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lbl_redAlliance4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(chkbx_blueTeam1Mobility, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chkbx_blueTeam1HotGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chkbx_blueTeam1AutonLowGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chkbx_blueTeam1AutonHighGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(chkbx_blueTeam2Mobility, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chkbx_blueTeam2HotGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chkbx_blueTeam2AutonLowGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chkbx_blueTeam2AutonHighGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(chkbx_blueTeam3Mobility, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chkbx_blueTeam3HotGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chkbx_blueTeam3AutonLowGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chkbx_blueTeam3AutonHighGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(lbl_blueT1AutonomousPoints, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lbl_blueT2AutonomousPoints, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(3, 3, 3)
                        .add(lbl_blueT3AutonomousPoints, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(lbl_blueT1Points, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lbl_blueT2Points, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(3, 3, 3)
                        .add(lbl_blueT3Points, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(lbl_blueTotalPoints, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(lbl_blueAssistPoints, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(lbl_blueFoulPoints, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, btn_deleteBlueCycle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, btn_endBlueCycle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel5Layout.createSequentialGroup()
                                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(spnr_blueTeam1Fouls)
                                            .add(lbl_foul5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(lbl_techFoul5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(spnr_blueTeam1TechFouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(15, 15, 15)
                                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(spnr_blueTeam2Fouls)
                                            .add(lbl_foul4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(lbl_techFoul4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(spnr_blueTeam2TechFouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(15, 15, 15)
                                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(spnr_blueTeam3Fouls)
                                            .add(lbl_foul3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(lbl_techFoul3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(spnr_blueTeam3TechFouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                    .add(jPanel5Layout.createSequentialGroup()
                                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(chkbx_blueTeam1Truss, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(chkbx_blueTeam1Catch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(chkbx_blueTeam1LowGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(chkbx_blueTeam1HighGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(tglBtn_blueTeam1WhiteZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                                .add(chkbx_blueTeam2LowGoal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(chkbx_blueTeam2Catch, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(chkbx_blueTeam2HighGoal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, lbl_blueCycleNumber, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .add(chkbx_blueTeam2Truss, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(tglBtn_blueTeam2WhiteZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(chkbx_blueTeam3Truss, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(chkbx_blueTeam3Catch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(chkbx_blueTeam3HighGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(chkbx_blueTeam3LowGoal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(tglBtn_blueTeam3WhiteZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                            .add(jPanel5Layout.createSequentialGroup()
                                .add(tglBtn_blueTeam1RedZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(tglBtn_blueTeam2RedZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(tglBtn_blueTeam3RedZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 0, Short.MAX_VALUE))))
            .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, lbl_blueAlliance, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel5Layout.createSequentialGroup()
                                .add(tglBtn_blueTeam1BlueZone, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(tglBtn_blueTeam2BlueZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(tglBtn_blueTeam3BlueZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(jPanel5Layout.createSequentialGroup()
                            .add(lbl_blueTeam1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(lbl_blueTeam2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(lbl_blueTeam3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(12, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(95, 95, 95)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tglBtn_blueTeam3WhiteZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tglBtn_blueTeam2WhiteZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tglBtn_blueTeam1WhiteZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 0, 0)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tglBtn_blueTeam1RedZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tglBtn_blueTeam2RedZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tglBtn_blueTeam3RedZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 0, 0)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(chkbx_blueTeam2LowGoal)
                                    .add(chkbx_blueTeam3LowGoal))
                                .add(jPanel5Layout.createSequentialGroup()
                                    .add(chkbx_blueTeam1Truss)
                                    .add(0, 0, 0)
                                    .add(chkbx_blueTeam1Catch)
                                    .add(0, 0, 0)
                                    .add(chkbx_blueTeam1LowGoal)))
                            .add(jPanel5Layout.createSequentialGroup()
                                .add(chkbx_blueTeam2Truss)
                                .add(0, 0, 0)
                                .add(chkbx_blueTeam2Catch)))
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(chkbx_blueTeam1HighGoal)
                            .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(chkbx_blueTeam2HighGoal)
                                .add(chkbx_blueTeam3HighGoal))))
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(chkbx_blueTeam3Truss)
                        .add(0, 0, 0)
                        .add(chkbx_blueTeam3Catch)))
                .add(0, 0, 0)
                .add(lbl_blueCycleNumber)
                .add(2, 2, 2)
                .add(btn_endBlueCycle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(btn_deleteBlueCycle)
                .add(0, 0, 0)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(jPanel5Layout.createSequentialGroup()
                            .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(lbl_techFoul5)
                                .add(lbl_foul5))
                            .add(0, 0, 0)
                            .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(spnr_blueTeam1TechFouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(spnr_blueTeam1Fouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(jPanel5Layout.createSequentialGroup()
                            .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(lbl_techFoul4)
                                .add(lbl_foul4))
                            .add(0, 0, 0)
                            .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(spnr_blueTeam2TechFouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(spnr_blueTeam2Fouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lbl_techFoul3)
                            .add(lbl_foul3))
                        .add(0, 0, 0)
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(spnr_blueTeam3TechFouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(spnr_blueTeam3Fouls, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(0, 0, 0)
                .add(lbl_redAlliance4)
                .add(0, 0, 0)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(chkbx_blueTeam1Mobility)
                        .add(0, 0, 0)
                        .add(chkbx_blueTeam1HotGoal)
                        .add(0, 0, 0)
                        .add(chkbx_blueTeam1AutonLowGoal)
                        .add(0, 0, 0)
                        .add(chkbx_blueTeam1AutonHighGoal))
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(chkbx_blueTeam2Mobility)
                        .add(0, 0, 0)
                        .add(chkbx_blueTeam2HotGoal)
                        .add(0, 0, 0)
                        .add(chkbx_blueTeam2AutonLowGoal)
                        .add(0, 0, 0)
                        .add(chkbx_blueTeam2AutonHighGoal))
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(chkbx_blueTeam3Mobility)
                        .add(0, 0, 0)
                        .add(chkbx_blueTeam3HotGoal)
                        .add(0, 0, 0)
                        .add(chkbx_blueTeam3AutonLowGoal)
                        .add(0, 0, 0)
                        .add(chkbx_blueTeam3AutonHighGoal)))
                .add(0, 0, 0)
                .add(jLabel4)
                .add(3, 3, 3)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbl_blueT1AutonomousPoints)
                    .add(lbl_blueT2AutonomousPoints)
                    .add(lbl_blueT3AutonomousPoints))
                .add(0, 0, 0)
                .add(jLabel3)
                .add(3, 3, 3)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbl_blueT1Points)
                    .add(lbl_blueT2Points)
                    .add(lbl_blueT3Points))
                .add(2, 2, 2)
                .add(lbl_blueAssistPoints)
                .add(2, 2, 2)
                .add(lbl_blueFoulPoints)
                .add(2, 2, 2)
                .add(lbl_blueTotalPoints)
                .add(0, 0, 0))
            .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .add(lbl_blueAlliance)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(lbl_blueTeam1)
                        .add(lbl_blueTeam2)
                        .add(lbl_blueTeam3))
                    .add(0, 0, 0)
                    .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(tglBtn_blueTeam1BlueZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(tglBtn_blueTeam2BlueZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(tglBtn_blueTeam3BlueZone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(570, Short.MAX_VALUE)))
        );

        btn_mainMenu.setText("Main Menu");
        btn_mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mainMenuback(evt);
            }
        });

        btn_finishScoring.setBackground(new java.awt.Color(255, 255, 255));
        btn_finishScoring.setText("Save and Finish Scoring Match");
        btn_finishScoring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finishScoringActionPerformed(evt);
            }
        });

        btn_deleteMatch.setBackground(new java.awt.Color(255, 255, 255));
        btn_deleteMatch.setForeground(new java.awt.Color(153, 0, 0));
        btn_deleteMatch.setText("Delete Match");
        btn_deleteMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteMatchActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(btn_back)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(lbl_title, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 720, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btn_mainMenu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3Layout.createSequentialGroup()
                        .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 462, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, 0)
                        .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(0, 0, Short.MAX_VALUE))
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(btn_finishScoring, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 911, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btn_deleteMatch, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lbl_title)
                    .add(btn_mainMenu)
                    .add(btn_back))
                .add(0, 0, 0)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(0, 0, 0)
                .add(btn_finishScoring, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(btn_deleteMatch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //takes the event as a parameter, pops the frame, returns nothing
    private void back(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back
        //call the super class' back function 
        super.popFrame();
    }//GEN-LAST:event_back
    //takes the event as a parameter, pops to the root frame, returns nothing
    private void btn_mainMenuback(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mainMenuback
        //call the super class' to pop the view to the root
        super.popToRoot();
    }//GEN-LAST:event_btn_mainMenuback

    /*takes the event as a parameter, changes the text of a toggle button accoring 
     * to its state ("X" - True, "" - False), returns nothing*/
    private void toggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleActionPerformed
        //get a reference to the toggle button that called this funtion
        JToggleButton jtglbtn_sender = ((JToggleButton)evt.getSource());
        
        //check if the toggle button is depressed
        if (jtglbtn_sender.isSelected())
        {
            //place an x in the toggle button for user experience purposes
            jtglbtn_sender.setText("X");
        }
        else
        {
            //clear the previous text from the toggle button
            jtglbtn_sender.setText("");
        }
    }//GEN-LAST:event_toggleActionPerformed
    
    /*takes the event as a parameter. Adds the red cycle to the match object, updates
     *the on screen red score. Displays an error if the cycle is empty. returns nothing*/
    private void btn_endRedCycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_endRedCycleActionPerformed
        if (!checkRedCycleisEmpty()) 
        { 
            //add the red cycle to the match object
            this.addRedCycleToMatch();
            //refresh the cycle number on screen
            refreshBasicElements();
            //clear the cycle related fields
            this.clearRedCycle();
            //update the on screen scores for the red alliance
            this.updateRedScores();
        }
        else
        {
            //let the user know the cycle is empty
            JOptionPane.showConfirmDialog(null, "The cycle is empty.", "Error", 
                    JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btn_endRedCycleActionPerformed
     
    //take no parameters, determines which team is winning/won the match, returns nothing
    private void updateMatchStatus()
    {
        //if the scores are the same
        if (this.int_lastCalculatedRedScore == this.int_lastCalculatedBlueScore)
        {
            //set the match as a tie
            mtch_currentMatch.int_matchOutCome = Constants.int_TIE;
        }
        else
        {
            //if the red alliance has the largest score set the match as a red win other wise set it as a blue win
            mtch_currentMatch.int_matchOutCome = (this.int_lastCalculatedRedScore > this.int_lastCalculatedBlueScore) 
                ? Constants.int_RED_WIN : Constants.int_BLUE_WIN;
        }
    }
    
    /*takes the event as a parameter. Saves the match to the db and pops the frame to root. returns nothing*/
    private void btn_finishScoringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finishScoringActionPerformed
        //if the red cycle isn't empty add it to the match object
        if (!checkRedCycleisEmpty()) { this.addRedCycleToMatch(); }
        //if the blue cycle isn't empty add it to the match object
        if (!checkBlueCycleisEmpty()) { this.addBlueCycleToMatch(); }
        
        //loop through the cycles to remove
        for (int i = 0; i < this.arylst_cyclesToRemove.size(); i++)
        {
            //remove the match cycles from the db
            ((MatchCycle)this.arylst_cyclesToRemove.get(i)).removeFromDB();
        }
            
        //add the autonomous data to the match object
        this.addAutonomousToMatch();
        //add the fouls to the match object
        this.addFoulsToMatch();
        
        //update the on screen scores for the blue alliance
        this.updateBlueScores();
        //update the on screen scores for the reds alliance
        this.updateRedScores();
        
        //add the match to the database
        mtch_currentMatch.addToDB();
        
        //pop the frame to the root
        super.popToRoot();
    }//GEN-LAST:event_btn_finishScoringActionPerformed

    /*takes the event as a parameter. Ensures only one box is the row is checked. returns nothing*/
    private void redTrussActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redTrussActionPerformed
        //ensure only one box per row is selected and deselect boxes that are non-compliant
        this.uncheckOneRowOfOtherBoxes(chkbx_truss, evt, true);
    }//GEN-LAST:event_redTrussActionPerformed
    /*takes the event as a parameter. Ensures only one box is the row is checked. returns nothing*/ 
    private void redCatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redCatchActionPerformed
        //ensure only one box per row is selected and deselect boxes that are non-compliant
        this.uncheckOneRowOfOtherBoxes(chkbx_catch, evt, true);
    }//GEN-LAST:event_redCatchActionPerformed
    /*takes the event as a parameter. Ensures only one goal box is checked. returns nothing*/
    private void redLowGoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redLowGoalActionPerformed
        //ensure only one goalis selected and deselect boxes that are non-compliant
        this.uncheckTwoRowsOfOtherBoxes(chkbx_lowGoal, chkbx_highGoal, evt, true);
    }//GEN-LAST:event_redLowGoalActionPerformed
    /*takes the event as a parameter. Ensures only one goal box is checked. returns nothing*/
    private void redHighGoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redHighGoalActionPerformed
        //ensure only one goal is selected and deselect boxes that are non-compliant
        this.uncheckTwoRowsOfOtherBoxes(chkbx_highGoal, chkbx_lowGoal, evt, true);
    }//GEN-LAST:event_redHighGoalActionPerformed
    
    /*takes the event as a parameter. Ensures only one autonomous goal is checked per team. returns nothing*/
    private void autonomousBoxChecked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autonomousBoxChecked
        //loop through all the high goal check boxes
        for (int i = 0; i < chkbx_AutonHighGoal.length; i ++)
        {
            //check if both the high and low goals are selected
            if (this.chkbx_AutonHighGoal[i].isSelected() && 
                    this.chkbx_AutonLowGoal[i].isSelected())
            {
                //get the source object
                JCheckBox chkbx_sender = (JCheckBox) evt.getSource();
                
                //check to make sure the check box is a low or high autonomous goal box
                if (this.chkbx_AutonHighGoal[i].equals(chkbx_sender) || 
                        this.chkbx_AutonLowGoal[i].equals(chkbx_sender))
                {
                    //deselect the check box 
                    chkbx_sender.setSelected(false);
                }
                //let the user know why the check box was deselected
                JOptionPane.showConfirmDialog(null, "Only one goal may be be "
                        + "selected per team.", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        }
        //add the autonomous data to the match (overwrites current data)
        this.addAutonomousToMatch();
        //update the on screen scores for the blue alliance
        this.updateBlueScores();
        //update the on screen scores for the reds alliance
        this.updateRedScores();
    }//GEN-LAST:event_autonomousBoxChecked

    /*takes the event as a parameter. Updates scores and fouls in the DB. returns nothing*/
    private void foulsChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_foulsChanged
        //add the foul data to the match (overwrites current data)
        addFoulsToMatch();
        //update the on screen scores for the blue alliance
        this.updateBlueScores();
        //update the on screen scores for the reds alliance
        this.updateRedScores();
    }//GEN-LAST:event_foulsChanged
    /*takes the event as a parameter. Ensures only one goal box is checked. returns nothing*/
    private void blueHighGoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueHighGoalActionPerformed
        //ensure only one box per the 2 goal rows is selected and deselect boxes that are non-compliant
        this.uncheckTwoRowsOfOtherBoxes(chkbx_highGoal, chkbx_lowGoal, evt, false);
    }//GEN-LAST:event_blueHighGoalActionPerformed
    /*takes the event as a parameter. Ensures only one goal box is checked. returns nothing*/
    private void blueLowGoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueLowGoalActionPerformed
       //ensure only one box per the 2 goal rows is selected and deselect boxes that are non-compliant
        this.uncheckTwoRowsOfOtherBoxes(chkbx_lowGoal, chkbx_highGoal, evt, false);
    }//GEN-LAST:event_blueLowGoalActionPerformed
    /*takes the event as a parameter. Ensures only one box is the row is checked. returns nothing*/ 
    private void blueCatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueCatchActionPerformed
        //ensure only one box per the 2 goal rows is selected and deselect boxes that are non-compliant
        this.uncheckOneRowOfOtherBoxes(chkbx_catch, evt, false);
    }//GEN-LAST:event_blueCatchActionPerformed
    /*takes the event as a parameter. Ensures only one box is the row is checked. returns nothing*/ 
    private void blueTrussActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueTrussActionPerformed
        //ensure only one box per the 2 goal rows is selected and deselect boxes that are non-compliant
        this.uncheckOneRowOfOtherBoxes(chkbx_truss, evt, false);
    }//GEN-LAST:event_blueTrussActionPerformed
    /*takes the event as a parameter. Ends the blue cycle and updates the scores. returns nothing*/ 
    private void btn_endBlueCycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_endBlueCycleActionPerformed
        if (!checkBlueCycleisEmpty())
        {
            //add the blue cycle to the match object
            this.addBlueCycleToMatch();
            //refresh the cycle number on screen
            refreshBasicElements();
            //clear the cycle related fields
            this.clearBlueCycle();
            //update the on screen scores for the blue alliance
            this.updateBlueScores();
        }
        else
        {
            //let the user know the cycle is empty
            JOptionPane.showConfirmDialog(null, "The cycle is empty.", "Error",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btn_endBlueCycleActionPerformed
    /*takes the event as a parameter. Deletes the red cycle, loads the previous 
     * cycle and updates the scores. returns nothing*/ 
    private void btn_deleteRedCycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteRedCycleActionPerformed
        //ask the user to confirm the deletion of the cycle and get the number of the clicked button
        int int_delete = JOptionPane.showConfirmDialog(null, "Do you really want to delete all data for " 
                + "this cycle? This will be finalized upon saving the match!", "Delete Cycle", JOptionPane.YES_NO_OPTION);

        //if the delete button was selected
        if (int_delete == JOptionPane.YES_OPTION)
        {
            //calculate the cycle number which is 1 less than the number of cycles
            int int_cycleNumber = this.mtch_currentMatch.int_numberOfRedCycles-1;

            //loop through the blue teams
            for (int i = 0; i < Constants.int_NUMBER_OF_TEAMS/2; i++)
            {
                // check if the cycle already has been set to null
                if (mtch_currentMatch.mtch_cycles[int_cycleNumber][i] != null)
                {
                    try 
                    {
                        //add a clone of the object to the array of cycles to remove so the ob
                        this.arylst_cyclesToRemove.add(mtch_currentMatch.mtch_cycles[int_cycleNumber][i].clone());
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(MatchScoring.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //make the cycle null
                    mtch_currentMatch.mtch_cycles[int_cycleNumber][i] = null;
                }
            }

            //clear the cycle
            this.clearRedCycle();

            //if this isnt the first cycle int he match
            if (int_cycleNumber > 0)
            {
                //decrease the number of blue cycles
                this.mtch_currentMatch.int_numberOfRedCycles--;
                //restore the previous blue cycle
                this.restoreRedCycle(this.lastRedCycle());
            }

            //refresh the cycle number on screen
            refreshBasicElements();

            //update the on screen scores for the blue alliance
            this.updateRedScores();
        }
    }//GEN-LAST:event_btn_deleteRedCycleActionPerformed
    /*takes the event as a parameter. Deletes the blue cycle, loads the previous 
     * cycle and updates the scores. returns nothing*/ 
    private void btn_deleteBlueCycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteBlueCycleActionPerformed
        //ask the user to confirm the deletion of the cycle and get the number of the clicked button
        int int_delete = JOptionPane.showConfirmDialog(null, "Do you really want to delete all data for " 
                + "this cycle? This will be finalized upon saving the match!", "Delete Cycle", JOptionPane.YES_NO_OPTION);

        //if the delete button was selected
        if (int_delete == JOptionPane.YES_OPTION)
        {
            //calculate the cycle number which is 1 less than the number of cycles
            int int_cycleNumber = this.mtch_currentMatch.int_numberOfBlueCycles-1;

            //loop through the blue teams
            for (int i = 3; i < Constants.int_NUMBER_OF_TEAMS; i++)
            {
                // check if the cycle already has been set to null
                if (mtch_currentMatch.mtch_cycles[int_cycleNumber][i] != null)
                {
                    try {
                        //add a clone of the object to the array of cycles to remove so the ob
                        this.arylst_cyclesToRemove.add(mtch_currentMatch.mtch_cycles[int_cycleNumber][i].clone());
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(MatchScoring.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //make the cycle null
                    mtch_currentMatch.mtch_cycles[int_cycleNumber][i] = null;
                }
            }

            //clear the cycle
            this.clearBlueCycle();

            //if this isnt the first cycle in the match
            if (int_cycleNumber > 0)
            {
                //decrease the number of blue cycles
                this.mtch_currentMatch.int_numberOfBlueCycles--;
                //restore the previous blue cycle
                this.restoreBlueCycle(this.lastBlueCycle());
            }

            //refresh the cycle number on screen
            refreshBasicElements();

            //update the on screen scores for the blue alliance
            this.updateBlueScores(); 
        }
    }//GEN-LAST:event_btn_deleteBlueCycleActionPerformed

    private void btn_deleteMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteMatchActionPerformed
        //ask the user to confirm the deletion of the team and get the number of the clicked button
        int int_delete = JOptionPane.showConfirmDialog(null, "Do you really want to delete all data for " 
                + "this match? This cannot be undone!", "Delete Match", JOptionPane.YES_NO_OPTION);

        //if the delete button was selected
        if (int_delete == JOptionPane.YES_OPTION)
        {
            //remove the match from the db
            this.mtch_currentMatch.removeFromDB();
            //pop to the root frame
            super.popToRoot();
        }
        
    }//GEN-LAST:event_btn_deleteMatchActionPerformed
    
    //take no parameters, returns the int value of the last blue cycle 
    private int lastBlueCycle()
    {
        //cacluate the last valid blue cycle number
        return ((mtch_currentMatch.int_numberOfBlueCycles-1)>= 0) ? 
                (mtch_currentMatch.int_numberOfBlueCycles-1) : 0; 
    }
    
    //take no parameters, returns the int value of the last red cycle 
    private int lastRedCycle()
    {
        //cacluate the last valid red cycle number
        return ((mtch_currentMatch.int_numberOfRedCycles-1)>= 0) ? 
                (mtch_currentMatch.int_numberOfRedCycles-1) : 0; 
    }   
    
    //takes no parameters, checks if the on screen red cycle is empty and returns a boolean indicating it
    private boolean checkRedCycleisEmpty()
    {
        //loop through the red alliance teams
        for (int i = 0; i < Constants.int_NUMBER_OF_TEAMS/2; i++)
        {
            //check to see if the cycle at position i is empty
            if (!checkCycleisEmpty(i))
            { 
                //the cycle was not empty
                return false;
            }
        }
        
        //the cycle is empty
        return true;
    }
    
    //takes no parameters, checks if the on screen blue cycle is empty and returns a boolean indicating it
    private boolean checkBlueCycleisEmpty()
    {
        //loop through the blue alliance teams
        for (int i = 3; i < Constants.int_NUMBER_OF_TEAMS; i++)
        {
            //check to see if the cycle at position i is empty
            if (!checkCycleisEmpty(i))
            { 
                //the cycle was not empty
                return false;
            }
        }
        
        //the cycle is empty
        return true;
    } 
    
    /*takes the team potision as a parameter, checks if the on screen cycle for 
     * the team at the position is empty and returns a boolean indicating its state*/
    private boolean checkCycleisEmpty(int int_position)
    {
        //check to see if any of the values are true, indicating a good cycle
        if (this.tglBtn_blueZoneButtons[int_position].isSelected() ||
        this.tglBtn_whiteZoneButtons[int_position].isSelected() ||
        this.tglBtn_redZoneButtons[int_position].isSelected() ||
        this.chkbx_catch[int_position].isSelected() ||
        this.chkbx_truss[int_position].isSelected() ||
        this.chkbx_lowGoal[int_position].isSelected() ||
        this.chkbx_highGoal[int_position].isSelected())
        {
            //the cycle has data
            return false;
        }
        //the cycle is empty
        return true;
    }
    
    /*takes no parameters. Adds the red cycle to the match object. returns nothing*/ 
    private void addRedCycleToMatch()
    {
        try 
        {            
            //instantiate a new match cycle to store the red cycle data
            MatchCycle cycle = new MatchCycle();
            //set the match number
            cycle.int_matchNumber = mtch_currentMatch.int_gameNumber;
            //loop through the teams in the red alliance
            for (int i = 0; i < Constants.int_NUMBER_OF_TEAMS/2; i++)
            {
                //set the team number
                cycle.int_teamNumber = mtch_currentMatch.int_teamNumbers[i];
                //make the cycle the number of cycles to make the numbering array like (starts at 0)
                cycle.int_cycleNumber = mtch_currentMatch.int_numberOfRedCycles-1;
                //set the blue zone state
                cycle.bool_blueZone = this.tglBtn_blueZoneButtons[i].isSelected();
                //set the white zone state
                cycle.bool_whiteZone = this.tglBtn_whiteZoneButtons[i].isSelected();
                //set the red zone state
                cycle.bool_redZone = this.tglBtn_redZoneButtons[i].isSelected();
                //set whether a catch occured
                cycle.bool_catch = this.chkbx_catch[i].isSelected();
                //set whether a truss occured
                cycle.bool_truss = this.chkbx_truss[i].isSelected();
                //set whether a low goal occured
                cycle.bool_lowGoal = this.chkbx_lowGoal[i].isSelected();
                //set whether a high goal occured
                cycle.bool_highGoal = this.chkbx_highGoal[i].isSelected();
                //set the cycle in the match to a clone of the object to prevent the next iteration of the loop from affecting the reference
                mtch_currentMatch.mtch_cycles[cycle.int_cycleNumber][i] = (MatchCycle)cycle.clone();
            }
            //increase the number of cycles
            mtch_currentMatch.int_numberOfRedCycles++;
            
        } catch (CloneNotSupportedException ex) 
        {
            //log the error
            Logger.getLogger(MatchScoring.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*takes no parameters. Adds the blue cycle to the match object. returns nothing*/ 
    private void addBlueCycleToMatch()
    {
        try 
        {
            //instantiate a new match cycle to store the blue cycle data
            MatchCycle cycle = new MatchCycle();
            //set the match number
            cycle.int_matchNumber = mtch_currentMatch.int_gameNumber;
            //loop through the blue teams
            for (int i = 3; i < Constants.int_NUMBER_OF_TEAMS; i++)
            {
                //set the team number
                cycle.int_teamNumber = mtch_currentMatch.int_teamNumbers[i];
                //make the cycle the number of cycles to make the numbering array like (starts at 0)
                cycle.int_cycleNumber = mtch_currentMatch.int_numberOfBlueCycles-1;
                //set the blue zone state
                cycle.bool_blueZone = this.tglBtn_blueZoneButtons[i].isSelected();
                //set the white zone state
                cycle.bool_whiteZone = this.tglBtn_whiteZoneButtons[i].isSelected();
                //set the red zone state
                cycle.bool_redZone = this.tglBtn_redZoneButtons[i].isSelected();
                //set whether a catch occured
                cycle.bool_catch = this.chkbx_catch[i].isSelected();
                //set whether a truss occured
                cycle.bool_truss = this.chkbx_truss[i].isSelected();
                //set whether a low goal occured
                cycle.bool_lowGoal = this.chkbx_lowGoal[i].isSelected();
                //set whether a high goal occured
                cycle.bool_highGoal = this.chkbx_highGoal[i].isSelected();
                //set the cycle in the match to a clone of the object to prevent the next iteration of the loop from affecting the reference
                mtch_currentMatch.mtch_cycles[cycle.int_cycleNumber][i] = (MatchCycle)cycle.clone();
            }
            //increase the number of cycles
            mtch_currentMatch.int_numberOfBlueCycles++;
            
        } catch (CloneNotSupportedException ex) 
        {
            //log the error
            Logger.getLogger(MatchScoring.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*takes the cycle number as a parameter. Adds the red cycle to the match object. returns nothing*/ 
    private void restoreRedCycle(int int_cycleNumber)
    {
        //loop through the teams in the red alliance
        for (int i = 0; i < Constants.int_NUMBER_OF_TEAMS/2; i++)
        {
            //restore the cycle for the team at position i
            restoreCycle(int_cycleNumber, i);
        }
        
        //refresh the cycle number on screen
        refreshBasicElements();

        //update the on screen scores for the red alliance
        this.updateRedScores();
    }
    
    /*takes the cycle number as a parameter. Adds the blue cycle to the match object. returns nothing*/ 
    private void restoreBlueCycle(int int_cycleNumber)
    {
        //loop through the blue teams
        for (int i = 3; i < Constants.int_NUMBER_OF_TEAMS; i++)
        {
            //restore the cycle for the team at position i
            restoreCycle(int_cycleNumber, i);
        }
        
        //refresh the cycle number on screen
        refreshBasicElements();

        //update the on screen scores for the blue alliance
        this.updateBlueScores();
    }
    
    /*takes no parameters, clears all red cycle check boxes and toggle buttons,
     returns nothing*/
    private void clearRedCycle()
    {
        //loop through all the red teams
        for (int i = 0; i < Constants.int_NUMBER_OF_TEAMS/2; i++)
        {
            //clear the cycle for the team at position i
            clearCycle(i);
        }
    }
    
    /*takes no parameters, clears all blue cycle check boxes and toggle buttons,
     returns nothing*/
    private void clearBlueCycle()
    {
        //loop through all the blue teams (from middle of array)
        for (int i = Constants.int_NUMBER_OF_TEAMS-1; i > (Constants.int_NUMBER_OF_TEAMS/2) - 1; i--)
        {
            //clear the cycle for the team at position i
            clearCycle(i);
        }
    }
    
    /*takes the cycle number and team position as parameters. Adds the team 
     * cycle at the given position to the match object. returns nothing*/ 
    private void restoreCycle(int int_cycleNumber, int int_position)
    {
        //instantiate a new match cycle to store the red cycle data
        MatchCycle cycle = mtch_currentMatch.mtch_cycles[int_cycleNumber][int_position];

        //check if the cycle if blank
        if (cycle == null) 
        {
            //return
            return;
        }

        //set the blue zone state
        this.tglBtn_blueZoneButtons[int_position].setSelected(cycle.bool_blueZone);

        //check if the toggle button is depressed
        String str_btnText = (cycle.bool_blueZone) ? "X" : "";
        //place the text in the toggle button for user experience purposes
        this.tglBtn_blueZoneButtons[int_position].setText(str_btnText);

        //set the white zone state
        this.tglBtn_whiteZoneButtons[int_position].setSelected(cycle.bool_whiteZone);

        //check if the toggle button is depressed
        str_btnText = (cycle.bool_whiteZone) ? "X" : "";
        //place the text in the toggle button for user experience purposes
        this.tglBtn_whiteZoneButtons[int_position].setText(str_btnText);

        //set the red zone state
        this.tglBtn_redZoneButtons[int_position].setSelected(cycle.bool_redZone);

        //check if the toggle button is depressed
        str_btnText = (cycle.bool_redZone) ? "X" : "";
        //place the text in the toggle button for user experience purposes
        this.tglBtn_redZoneButtons[int_position].setText(str_btnText);

        //set whether a catch occured
        this.chkbx_catch[int_position].setSelected(cycle.bool_catch);
        //set whether a truss occured
        this.chkbx_truss[int_position].setSelected(cycle.bool_truss);
        //set whether a low goal occured
        this.chkbx_lowGoal[int_position].setSelected(cycle.bool_lowGoal);
        //set whether a high goal occured
        this.chkbx_highGoal[int_position].setSelected(cycle.bool_highGoal);
    }
    
    /*takes no parameters. Adds the fouls to the match object. returns nothing*/
    private void addFoulsToMatch()
    {
        try {
            //create a new fouls object to store the data
            MatchFouls fouls = new MatchFouls();
            //set the match number in the foul object
            fouls.int_matchNumber = mtch_currentMatch.int_gameNumber;
            //loop through the teams
            for (int i = 0; i < Constants.int_NUMBER_OF_TEAMS; i++)
            {
                //set the team number in the foul object
                fouls.int_teamNumber = mtch_currentMatch.int_teamNumbers[i];
                //set the number of fouls in the foul object
                fouls.int_fouls = ((Integer)this.spnr_fouls[i].getValue()).intValue();
                //set the number of technical fouls in the foul object
                fouls.int_technicalFouls = ((Integer)this.spnr_technicalFouls[i].getValue()).intValue();
                //set the fouls in the match to a clone of the object to prevent the next iteration of the loop from affecting the reference
                mtch_currentMatch.mtch_fouls[i] = (MatchFouls)fouls.clone();
            }

        } catch (CloneNotSupportedException ex) {
            //log the error
            Logger.getLogger(MatchScoring.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*takes no parameters. Restores the foul data from the DB to the GUI. returns nothing*/
    private void restoreFouls()
    {
        /*get a clone of the fouls object as the spinners tend to remove all 
         * of the foul data from the match object after one iteration (possible swing bug)*/
        MatchFouls fouls[] = mtch_currentMatch.mtch_fouls.clone();
        
        //loop through the number of teams
        for (int i = 0; i < Constants.int_NUMBER_OF_TEAMS; i++)
        {
            //set the value of the fouls spinner
            spnr_fouls[i].setValue(new Integer(fouls[i].int_fouls));
            //set the value of the technical fouls
            spnr_technicalFouls[i].setValue(new Integer(fouls[i].int_technicalFouls));
        }
    }
    
    /*takes no parameters. Updates the autonomous object on the match, 
     * updates the on screen scores. returns nothing*/
    private void autonomousChanged ()
    {
        //add the autonomous values to the match
        this.addAutonomousToMatch();
        //update the blue scores on the screen
        this.updateBlueScores();
        //update the red scores on the screen
        this.updateRedScores();
    }
    
    /*takes no parameters. Adds the autonomous portion to the match object. returns nothing*/
    private void addAutonomousToMatch()
    {
        try {
            //create a new autonomous object to store the data
            MatchAutonomous autonomous = new MatchAutonomous();
            //set the match number in the autonomous object
            autonomous.int_matchNumber = mtch_currentMatch.int_gameNumber;
            //loop through the teams
            for (int i = 0; i < Constants.int_NUMBER_OF_TEAMS; i++)
            {
                //set the team number in the autonomous object
                autonomous.int_teamNumber = mtch_currentMatch.int_teamNumbers[i];
                //set the value of the mobility indicator in the autonomous object
                autonomous.bool_mobility = this.chkbx_AutonMobility[i].isSelected();
                //set the value of the low goal in the autonomous object
                autonomous.bool_lowGoal = this.chkbx_AutonLowGoal[i].isSelected();
                //set the value of the high goal in the autonomous object
                autonomous.bool_highGoal = this.chkbx_AutonHighGoal[i].isSelected();
                //set the value of the hot goal in the autonomous object
                autonomous.bool_hotGoal = this.chkbx_AutonHotGoal[i].isSelected();
                //set the autonomous part of the match to a clone of the object to prevent the next iteration of the loop from affecting the reference
                mtch_currentMatch.mtch_autonomous[i] = (MatchAutonomous)autonomous.clone();
            }
        } catch (CloneNotSupportedException ex) {
            //log the error
            Logger.getLogger(MatchScoring.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    /*takes no parameters. Restores the autonomous data from the DB to the GUI. 
     * returns nothing*/
    private void restoreAutonomous()
    {
        //loop through the teams
        for (int i = 0; i < Constants.int_NUMBER_OF_TEAMS; i++)
        {
            //create a new autonomous object to store the data
            MatchAutonomous autonomous = mtch_currentMatch.mtch_autonomous[i];
            //set the team number to that in the autonomous object
            mtch_currentMatch.int_teamNumbers[i] = autonomous.int_teamNumber ;
            //set the value of the mobility indicator to that in the autonomous object
            this.chkbx_AutonMobility[i].setSelected(autonomous.bool_mobility);
            //set the value of the low goal to that in the autonomous object
            this.chkbx_AutonLowGoal[i].setSelected(autonomous.bool_lowGoal);
            //set the value of the high goal to that in the autonomous object
            this.chkbx_AutonHighGoal[i].setSelected(autonomous.bool_highGoal);
            //set the value of the hot goal to that in the autonomous object
            this.chkbx_AutonHotGoal[i].setSelected(autonomous.bool_hotGoal);
        }
    }
    
    /*takes no parameters, updates the team numbers, match number, and cycle number,
     * to that set in the match object. returns nothing*/
    private void refreshBasicElements()
    {
        //set the match number
        lbl_title.setText("Match #" + mtch_currentMatch.int_gameNumber + " Scoring");
        
        //set red team numbers
        lbl_redTeam1.setText("" + mtch_currentMatch.int_teamNumbers[Constants.int_RED_TEAM_1]);
        lbl_redTeam2.setText("" + mtch_currentMatch.int_teamNumbers[Constants.int_RED_TEAM_2]);
        lbl_redTeam3.setText("" + mtch_currentMatch.int_teamNumbers[Constants.int_RED_TEAM_3]);
        
        //set blue team numbers
        lbl_blueTeam1.setText("" + mtch_currentMatch.int_teamNumbers[Constants.int_BLUE_TEAM_1]);
        lbl_blueTeam2.setText("" + mtch_currentMatch.int_teamNumbers[Constants.int_BLUE_TEAM_2]);
        lbl_blueTeam3.setText("" + mtch_currentMatch.int_teamNumbers[Constants.int_BLUE_TEAM_3]);
        
        //set the red and blue cycle numbers
        this.refreshCycleNumber();
    }
    
    /*takes no parameters, updates the cycle number to that set in the match object,
     returns nothing*/
    public void refreshCycleNumber()
    {
        //set the red cycle number
        lbl_redCycleNumber.setText("Cycle #" + mtch_currentMatch.int_numberOfRedCycles);
        //set the blue cycle number
        lbl_blueCycleNumber.setText("Cycle #" + mtch_currentMatch.int_numberOfBlueCycles);
    }
    
    
    /*takes the position of the team to clear as a parameter, clears the cycle 
     * for that team (on screen). returns nothing*/
    private void clearCycle(int int_position)
    {
        //clear the values of the red zone toggle button
        tglBtn_redZoneButtons[int_position].setSelected(false);
        //clear the red zone toggle button' text
        tglBtn_redZoneButtons[int_position].setText("");

        //clear the values of the white zone toggle button
        tglBtn_whiteZoneButtons[int_position].setSelected(false);
        //clear the white zone toggle button' text
        tglBtn_whiteZoneButtons[int_position].setText("");

        //clear the values of the blue zone toggle button
        tglBtn_blueZoneButtons[int_position].setSelected(false);
        //clear the blue zone toggle button' text
        tglBtn_blueZoneButtons[int_position].setText("");

        //clear the catch checkbox
        chkbx_catch[int_position].setSelected(false);
        //clear the truss checkbox
        chkbx_truss[int_position].setSelected(false);
        //clear the high goal checkbox
        chkbx_highGoal[int_position].setSelected(false);
        //clear the low goal checkbox
        chkbx_lowGoal[int_position].setSelected(false);
    }
    
    
    //take no parameters, calculates all points for the blue alliance, updates score labels, returns nothing
    private void updateBlueScores()
    {
        //calculate team 1's game points
        int int_blueT1Points = mtch_currentMatch.getPointsForTeamInPosition(Constants.int_BLUE_TEAM_1);
        //calculate team 2's game points
        int int_blueT2Points = mtch_currentMatch.getPointsForTeamInPosition(Constants.int_BLUE_TEAM_2);
        //calculate team 3's game points
        int int_blueT3Points = mtch_currentMatch.getPointsForTeamInPosition(Constants.int_BLUE_TEAM_3);
        
        //calculate team 1's autonomous points
        int int_blueT1AutonomousPoints = mtch_currentMatch.getAutonomousPointsForTeamInPosition(Constants.int_BLUE_TEAM_1);
        //calculate team 2's autonomous points
        int int_blueT2AutonomousPoints = mtch_currentMatch.getAutonomousPointsForTeamInPosition(Constants.int_BLUE_TEAM_2);
        //calculate team 3's autonomous points
        int int_blueT3AutonomousPoints = mtch_currentMatch.getAutonomousPointsForTeamInPosition(Constants.int_BLUE_TEAM_3);
        
        //calculate the assist points
        int int_blueAssistPoints = mtch_currentMatch.getAssistPointsForAllianceForTeamInPosition(Constants.int_BLUE_TEAM_1);
        //calculate the foul points
        int int_blueFoulPoints = mtch_currentMatch.getFoulPointsForAllianceForTeamInPosition(Constants.int_BLUE_TEAM_1);
        
        //update the team 1's points on screen
        this.lbl_blueT1Points.setText("" + int_blueT1Points);
        //update the team 2's points on screen
        this.lbl_blueT2Points.setText("" + int_blueT2Points);
        //update the team 3's points on screen
        this.lbl_blueT3Points.setText("" + int_blueT3Points);
        
        //update the team 1's autonomous points on screen
        this.lbl_blueT1AutonomousPoints.setText("" + int_blueT1AutonomousPoints);
        //update the team 2's autonomous points on screen
        this.lbl_blueT2AutonomousPoints.setText("" + int_blueT2AutonomousPoints);
        //update the team 3's autonomous points on screen
        this.lbl_blueT3AutonomousPoints.setText("" + int_blueT3AutonomousPoints);
        
        
        //update the assist points on screen
        this.lbl_blueAssistPoints.setText("Assist Points: " + int_blueAssistPoints);
        //update the foul points on screen
        this.lbl_blueFoulPoints.setText("Foul Points: " + int_blueFoulPoints);
        
        //calculate the blue score by adding all the points up
        this.int_lastCalculatedBlueScore = (int_blueT1Points + int_blueT2Points 
                + int_blueT3Points + int_blueT1AutonomousPoints + int_blueT2AutonomousPoints + 
                int_blueT3AutonomousPoints  + int_blueAssistPoints + int_blueFoulPoints);
        
        //update the total points on screen
        this.lbl_blueTotalPoints.setText("Total Points: " + int_lastCalculatedBlueScore);
        
        //check to see if the score update lead to a new team winning
        this.updateMatchStatus();
    }
    
    //take no parameters, calculates all points for the red alliance, updates score labels, returns nothing
    private void updateRedScores()
    {
        //calculate team 1's game points
        int int_redT1Points = mtch_currentMatch.getPointsForTeamInPosition(Constants.int_RED_TEAM_1);
        //calculate team 2's game points
        int int_redT2Points = mtch_currentMatch.getPointsForTeamInPosition(Constants.int_RED_TEAM_2);
        //calculate team 3's game points
        int int_redT3Points = mtch_currentMatch.getPointsForTeamInPosition(Constants.int_RED_TEAM_3);
        
        //calculate team 1's autonomous points
        int int_redT1AutonomousPoints = mtch_currentMatch.getAutonomousPointsForTeamInPosition(Constants.int_RED_TEAM_1);
        //calculate team 2's autonomous points
        int int_redT2AutonomousPoints = mtch_currentMatch.getAutonomousPointsForTeamInPosition(Constants.int_RED_TEAM_2);
        //calculate team 3's autonomous points
        int int_redT3AutonomousPoints = mtch_currentMatch.getAutonomousPointsForTeamInPosition(Constants.int_RED_TEAM_3);
        
        //calculate the assist points
        int int_redAssistPoints = mtch_currentMatch.getAssistPointsForAllianceForTeamInPosition(Constants.int_RED_TEAM_1);
        //calculate the foul points
        int int_redFoulPoints = mtch_currentMatch.getFoulPointsForAllianceForTeamInPosition(Constants.int_RED_TEAM_1);
        
        //update the team 1's autonomous points on screen
        this.lbl_redT1AutonomousPoints.setText("" + int_redT1AutonomousPoints);
        //update the team 2's autonomous points on screen
        this.lbl_redT2AutonomousPoints.setText("" + int_redT2AutonomousPoints);
        //update the team 3's autonomous points on screen
        this.lbl_redT3AutonomousPoints.setText("" + int_redT3AutonomousPoints);
        
        this.lbl_redT1Points.setText("" + int_redT1Points);
        this.lbl_redT2Points.setText("" + int_redT2Points);
        this.lbl_redT3Points.setText("" + int_redT3Points);
       
        //update the assist points on screen
        this.lbl_redAssistPoints.setText("Assist Points: " + int_redAssistPoints);
        //update the foul points on screen
        this.lbl_redFoulPoints.setText("Foul Points: " + int_redFoulPoints);
        
        //calculate the red score by adding all the points up
        this.int_lastCalculatedRedScore = (int_redT1Points + int_redT2Points 
                + int_redT3Points + int_redT1AutonomousPoints + int_redT2AutonomousPoints +
                + int_redT3AutonomousPoints + int_redAssistPoints + int_redFoulPoints);
        
        //update the total points on screen
        this.lbl_redTotalPoints.setText("Total Points: " + int_lastCalculatedRedScore);
        
        //check to see if the score update lead to a new team winning
        this.updateMatchStatus();
    }
    
    /*takes an array of check boxes, the event, and a boolean indicating if it is 
     * for the red team, unchecks all of the check boxes but one, returns nothing*/
    public void uncheckOneRowOfOtherBoxes(JCheckBox chkbx_boxesToCheck[], 
            java.awt.event.ActionEvent evt, boolean isRedTeam)
    {
        //varable for a check box that called this method
        JCheckBox chkbx_sender = (JCheckBox)evt.getSource();
        
        //define the low bound for the loop based on whether the team is red or blue alliance (refer to constants)  
        int int_lowerBound = (isRedTeam) ? 0 : Constants.int_NUMBER_OF_TEAMS / 2;
        //define the upper bound for the loop based on whether the team is on the red or blue alliance
        int int_upperBound = (isRedTeam) ? Constants.int_NUMBER_OF_TEAMS / 2 : Constants.int_NUMBER_OF_TEAMS;
        
        //loop through the check boxes
        for (int i = int_lowerBound; i < int_upperBound; i++)
        {
            //check to see if a check box other than the sender is selected
            if (chkbx_boxesToCheck[i].isSelected() && !chkbx_sender.equals(chkbx_boxesToCheck[i]))
            {
                //if found de select the send
                chkbx_sender.setSelected(false);
                //let the user know why the check box was deselected
                JOptionPane.showConfirmDialog(null, "Only one box in each row may"
                        + " be selected per cycle.", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    
    /*takes 2 arrays of check boxes, the event, and a boolean indicating if it is 
     * for the red team, unchecks all of the check boxes but one, returns nothing*/
    public void uncheckTwoRowsOfOtherBoxes(JCheckBox chkbx_boxesToCheck1[], 
            JCheckBox chkbx_boxesToCheck2[], java.awt.event.ActionEvent evt, boolean isRedTeam)
    {
        //varable for a check box that called this method
        JCheckBox chkbx_sender = (JCheckBox)evt.getSource();
        //integer for the lower bound of the loop
        int int_lowerBound = 0;
        //the upper bound is the average length of the two arrays
        int int_upperBound = (chkbx_boxesToCheck1.length + chkbx_boxesToCheck2.length)/2;
        JCheckBox chkbx_boxesToCheck[] = new JCheckBox[int_upperBound];
        //loop through the check boxes
        for (int i = 0; i < int_upperBound; i ++)
        {
            //if the check box belongs to the red alliance
            if (i < Constants.int_NUMBER_OF_TEAMS/2)
            {
                //determine the location for the check box in the global array
                int int_locationInArray = isRedTeam ? i : (i + Constants.int_NUMBER_OF_TEAMS/2);
                //add the check box to the array in the scope of this function
                chkbx_boxesToCheck[i] = chkbx_boxesToCheck1[int_locationInArray];
            }
            else //the check box belongs to the blue alliance
            {
                //determine the location for the check box in the global array
                int int_locationInArray = isRedTeam ? i - (Constants.int_NUMBER_OF_TEAMS/2) : i;
                //add the check box to the array in the scope of this function
                chkbx_boxesToCheck[i] = chkbx_boxesToCheck2[int_locationInArray];
            }
        }
        //loop through the local array of check boxes
        for (int i = int_lowerBound; i < int_upperBound; i++)
        {
            //check to see if a check box other than the sender is selected
            if (chkbx_boxesToCheck[i].isSelected() && !chkbx_sender.equals(chkbx_boxesToCheck[i]))
            {
                //deslect the sender
                chkbx_sender.setSelected(false);
                //let the user know why the check box was deselected
                JOptionPane.showConfirmDialog(null, "Only one goal may be be "
                        + "selected per cycle.", "Error", JOptionPane.PLAIN_MESSAGE);
                break;
            }
        }
    }
    
    //takes no parameters, assigns all team gui components to their respective arrays, returns nothing
    private void assignComponentsToArrays()
    {
        //this may seem tedious but it saves hundreds of lines of code later
        
        //assign all red team 1 elements to their respecive arrays
        tglBtn_redZoneButtons[Constants.int_RED_TEAM_1] = tglBtn_redTeam1RedZone;
        tglBtn_whiteZoneButtons[Constants.int_RED_TEAM_1] = tglBtn_redTeam1WhiteZone;
        tglBtn_blueZoneButtons[Constants.int_RED_TEAM_1] = tglBtn_redTeam1BlueZone;
        chkbx_truss[Constants.int_RED_TEAM_1] = chkbx_redTeam1Truss;
        chkbx_catch[Constants.int_RED_TEAM_1] = chkbx_redTeam1Catch;
        chkbx_highGoal[Constants.int_RED_TEAM_1] = chkbx_redTeam1HighGoal;
        chkbx_lowGoal[Constants.int_RED_TEAM_1] = chkbx_redTeam1LowGoal;
        spnr_fouls[Constants.int_RED_TEAM_1] = spnr_redTeam1Fouls;
        spnr_technicalFouls[Constants.int_RED_TEAM_1] = spnr_redTeam1TechFouls; 
        chkbx_AutonMobility[Constants.int_RED_TEAM_1] = chkbx_redTeam1Mobility;
        chkbx_AutonHighGoal[Constants.int_RED_TEAM_1] = chkbx_redTeam1AutonHighGoal;
        chkbx_AutonLowGoal[Constants.int_RED_TEAM_1] = chkbx_redTeam1AutonLowGoal;
        chkbx_AutonHotGoal[Constants.int_RED_TEAM_1] = chkbx_redTeam1HotGoal;
        
        //assign all red team 2 elements to their respecive arrays
        tglBtn_redZoneButtons[Constants.int_RED_TEAM_2] = tglBtn_redTeam2RedZone;
        tglBtn_whiteZoneButtons[Constants.int_RED_TEAM_2] = tglBtn_redTeam2WhiteZone;
        tglBtn_blueZoneButtons[Constants.int_RED_TEAM_2] = tglBtn_redTeam2BlueZone;
        chkbx_truss[Constants.int_RED_TEAM_2] = chkbx_redTeam2Truss;
        chkbx_catch[Constants.int_RED_TEAM_2] = chkbx_redTeam2Catch;
        chkbx_highGoal[Constants.int_RED_TEAM_2] = chkbx_redTeam2HighGoal;
        chkbx_lowGoal[Constants.int_RED_TEAM_2] = chkbx_redTeam2LowGoal;
        spnr_fouls[Constants.int_RED_TEAM_2] = spnr_redTeam2Fouls;
        spnr_technicalFouls[Constants.int_RED_TEAM_2] = spnr_redTeam2TechFouls;
        chkbx_AutonMobility[Constants.int_RED_TEAM_2] = chkbx_redTeam2Mobility;
        chkbx_AutonHighGoal[Constants.int_RED_TEAM_2] = chkbx_redTeam2AutonHighGoal;
        chkbx_AutonLowGoal[Constants.int_RED_TEAM_2] = chkbx_redTeam2AutonLowGoal;
        chkbx_AutonHotGoal[Constants.int_RED_TEAM_2] = chkbx_redTeam2HotGoal;
        
        //assign all red team 3 elements to their respecive arrays
        tglBtn_redZoneButtons[Constants.int_RED_TEAM_3] = tglBtn_redTeam3RedZone;
        tglBtn_whiteZoneButtons[Constants.int_RED_TEAM_3] = tglBtn_redTeam3WhiteZone;
        tglBtn_blueZoneButtons[Constants.int_RED_TEAM_3] = tglBtn_redTeam3BlueZone;
        chkbx_truss[Constants.int_RED_TEAM_3] = chkbx_redTeam3Truss;
        chkbx_catch[Constants.int_RED_TEAM_3] = chkbx_redTeam3Catch;
        chkbx_highGoal[Constants.int_RED_TEAM_3] = chkbx_redTeam3HighGoal;
        chkbx_lowGoal[Constants.int_RED_TEAM_3] = chkbx_redTeam3LowGoal;
        spnr_fouls[Constants.int_RED_TEAM_3] = spnr_redTeam3Fouls;
        spnr_technicalFouls[Constants.int_RED_TEAM_3] = spnr_redTeam3TechFouls;
        chkbx_AutonMobility[Constants.int_RED_TEAM_3] = chkbx_redTeam3Mobility;
        chkbx_AutonHighGoal[Constants.int_RED_TEAM_3] = chkbx_redTeam3AutonHighGoal;
        chkbx_AutonLowGoal[Constants.int_RED_TEAM_3] = chkbx_redTeam3AutonLowGoal;
        chkbx_AutonHotGoal[Constants.int_RED_TEAM_3] = chkbx_redTeam3HotGoal;
        
        
        
        //this may seem tedious but it saves hundreds of lines of code later
        
        //assign all blue team 1 elements to their respecive arrays
        tglBtn_redZoneButtons[Constants.int_BLUE_TEAM_1] = tglBtn_blueTeam1RedZone;
        tglBtn_whiteZoneButtons[Constants.int_BLUE_TEAM_1] = tglBtn_blueTeam1WhiteZone;
        tglBtn_blueZoneButtons[Constants.int_BLUE_TEAM_1] = tglBtn_blueTeam1BlueZone;
        chkbx_truss[Constants.int_BLUE_TEAM_1] = chkbx_blueTeam1Truss;
        chkbx_catch[Constants.int_BLUE_TEAM_1] = chkbx_blueTeam1Catch;
        chkbx_highGoal[Constants.int_BLUE_TEAM_1] = chkbx_blueTeam1HighGoal;
        chkbx_lowGoal[Constants.int_BLUE_TEAM_1] = chkbx_blueTeam1LowGoal;
        spnr_fouls[Constants.int_BLUE_TEAM_1] = spnr_blueTeam1Fouls;
        spnr_technicalFouls[Constants.int_BLUE_TEAM_1] = spnr_blueTeam1TechFouls; 
        chkbx_AutonMobility[Constants.int_BLUE_TEAM_1] = chkbx_blueTeam1Mobility;
        chkbx_AutonHighGoal[Constants.int_BLUE_TEAM_1] = chkbx_blueTeam1AutonHighGoal;
        chkbx_AutonLowGoal[Constants.int_BLUE_TEAM_1] = chkbx_blueTeam1AutonLowGoal;
        chkbx_AutonHotGoal[Constants.int_BLUE_TEAM_1] = chkbx_blueTeam1HotGoal;
        
        //assign all blue team 2 elements to their respecive arrays
        tglBtn_redZoneButtons[Constants.int_BLUE_TEAM_2] = tglBtn_blueTeam2RedZone;
        tglBtn_whiteZoneButtons[Constants.int_BLUE_TEAM_2] = tglBtn_blueTeam2WhiteZone;
        tglBtn_blueZoneButtons[Constants.int_BLUE_TEAM_2] = tglBtn_blueTeam2BlueZone;
        chkbx_truss[Constants.int_BLUE_TEAM_2] = chkbx_blueTeam2Truss;
        chkbx_catch[Constants.int_BLUE_TEAM_2] = chkbx_blueTeam2Catch;
        chkbx_highGoal[Constants.int_BLUE_TEAM_2] = chkbx_blueTeam2HighGoal;
        chkbx_lowGoal[Constants.int_BLUE_TEAM_2] = chkbx_blueTeam2LowGoal;
        spnr_fouls[Constants.int_BLUE_TEAM_2] = spnr_blueTeam2Fouls;
        spnr_technicalFouls[Constants.int_BLUE_TEAM_2] = spnr_blueTeam2TechFouls;
        chkbx_AutonMobility[Constants.int_BLUE_TEAM_2] = chkbx_blueTeam2Mobility;
        chkbx_AutonHighGoal[Constants.int_BLUE_TEAM_2] = chkbx_blueTeam2AutonHighGoal;
        chkbx_AutonLowGoal[Constants.int_BLUE_TEAM_2] = chkbx_blueTeam2AutonLowGoal;
        chkbx_AutonHotGoal[Constants.int_BLUE_TEAM_2] = chkbx_blueTeam2HotGoal;
        
        //assign all blue team 3 elements to their respecive arrays
        tglBtn_redZoneButtons[Constants.int_BLUE_TEAM_3] = tglBtn_blueTeam3RedZone;
        tglBtn_whiteZoneButtons[Constants.int_BLUE_TEAM_3] = tglBtn_blueTeam3WhiteZone;
        tglBtn_blueZoneButtons[Constants.int_BLUE_TEAM_3] = tglBtn_blueTeam3BlueZone;
        chkbx_truss[Constants.int_BLUE_TEAM_3] = chkbx_blueTeam3Truss;
        chkbx_catch[Constants.int_BLUE_TEAM_3] = chkbx_blueTeam3Catch;
        chkbx_highGoal[Constants.int_BLUE_TEAM_3] = chkbx_blueTeam3HighGoal;
        chkbx_lowGoal[Constants.int_BLUE_TEAM_3] = chkbx_blueTeam3LowGoal;
        spnr_fouls[Constants.int_BLUE_TEAM_3] = spnr_blueTeam3Fouls;
        spnr_technicalFouls[Constants.int_BLUE_TEAM_3] = spnr_blueTeam3TechFouls;
        chkbx_AutonMobility[Constants.int_BLUE_TEAM_3] = chkbx_blueTeam3Mobility;
        chkbx_AutonHighGoal[Constants.int_BLUE_TEAM_3] = chkbx_blueTeam3AutonHighGoal;
        chkbx_AutonLowGoal[Constants.int_BLUE_TEAM_3] = chkbx_blueTeam3AutonLowGoal;
        chkbx_AutonHotGoal[Constants.int_BLUE_TEAM_3] = chkbx_blueTeam3HotGoal;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_deleteBlueCycle;
    private javax.swing.JButton btn_deleteMatch;
    private javax.swing.JButton btn_deleteRedCycle;
    private javax.swing.JButton btn_endBlueCycle;
    private javax.swing.JButton btn_endRedCycle;
    private javax.swing.JButton btn_finishScoring;
    private javax.swing.JButton btn_mainMenu;
    private javax.swing.JCheckBox chkbx_blueTeam1AutonHighGoal;
    private javax.swing.JCheckBox chkbx_blueTeam1AutonLowGoal;
    private javax.swing.JCheckBox chkbx_blueTeam1Catch;
    private javax.swing.JCheckBox chkbx_blueTeam1HighGoal;
    private javax.swing.JCheckBox chkbx_blueTeam1HotGoal;
    private javax.swing.JCheckBox chkbx_blueTeam1LowGoal;
    private javax.swing.JCheckBox chkbx_blueTeam1Mobility;
    private javax.swing.JCheckBox chkbx_blueTeam1Truss;
    private javax.swing.JCheckBox chkbx_blueTeam2AutonHighGoal;
    private javax.swing.JCheckBox chkbx_blueTeam2AutonLowGoal;
    private javax.swing.JCheckBox chkbx_blueTeam2Catch;
    private javax.swing.JCheckBox chkbx_blueTeam2HighGoal;
    private javax.swing.JCheckBox chkbx_blueTeam2HotGoal;
    private javax.swing.JCheckBox chkbx_blueTeam2LowGoal;
    private javax.swing.JCheckBox chkbx_blueTeam2Mobility;
    private javax.swing.JCheckBox chkbx_blueTeam2Truss;
    private javax.swing.JCheckBox chkbx_blueTeam3AutonHighGoal;
    private javax.swing.JCheckBox chkbx_blueTeam3AutonLowGoal;
    private javax.swing.JCheckBox chkbx_blueTeam3Catch;
    private javax.swing.JCheckBox chkbx_blueTeam3HighGoal;
    private javax.swing.JCheckBox chkbx_blueTeam3HotGoal;
    private javax.swing.JCheckBox chkbx_blueTeam3LowGoal;
    private javax.swing.JCheckBox chkbx_blueTeam3Mobility;
    private javax.swing.JCheckBox chkbx_blueTeam3Truss;
    private javax.swing.JCheckBox chkbx_redTeam1AutonHighGoal;
    private javax.swing.JCheckBox chkbx_redTeam1AutonHighGoal1;
    private javax.swing.JCheckBox chkbx_redTeam1AutonHighGoal2;
    private javax.swing.JCheckBox chkbx_redTeam1AutonLowGoal;
    private javax.swing.JCheckBox chkbx_redTeam1AutonLowGoal1;
    private javax.swing.JCheckBox chkbx_redTeam1AutonLowGoal2;
    private javax.swing.JCheckBox chkbx_redTeam1Catch;
    private javax.swing.JCheckBox chkbx_redTeam1HighGoal;
    private javax.swing.JCheckBox chkbx_redTeam1HotGoal;
    private javax.swing.JCheckBox chkbx_redTeam1HotGoal1;
    private javax.swing.JCheckBox chkbx_redTeam1HotGoal2;
    private javax.swing.JCheckBox chkbx_redTeam1LowGoal;
    private javax.swing.JCheckBox chkbx_redTeam1Mobility;
    private javax.swing.JCheckBox chkbx_redTeam1Mobility1;
    private javax.swing.JCheckBox chkbx_redTeam1Mobility2;
    private javax.swing.JCheckBox chkbx_redTeam1Truss;
    private javax.swing.JCheckBox chkbx_redTeam2AutonHighGoal;
    private javax.swing.JCheckBox chkbx_redTeam2AutonHighGoal1;
    private javax.swing.JCheckBox chkbx_redTeam2AutonHighGoal2;
    private javax.swing.JCheckBox chkbx_redTeam2AutonLowGoal;
    private javax.swing.JCheckBox chkbx_redTeam2AutonLowGoal1;
    private javax.swing.JCheckBox chkbx_redTeam2AutonLowGoal2;
    private javax.swing.JCheckBox chkbx_redTeam2Catch;
    private javax.swing.JCheckBox chkbx_redTeam2HighGoal;
    private javax.swing.JCheckBox chkbx_redTeam2HotGoal;
    private javax.swing.JCheckBox chkbx_redTeam2HotGoal1;
    private javax.swing.JCheckBox chkbx_redTeam2HotGoal2;
    private javax.swing.JCheckBox chkbx_redTeam2LowGoal;
    private javax.swing.JCheckBox chkbx_redTeam2Mobility;
    private javax.swing.JCheckBox chkbx_redTeam2Mobility1;
    private javax.swing.JCheckBox chkbx_redTeam2Mobility2;
    private javax.swing.JCheckBox chkbx_redTeam2Truss;
    private javax.swing.JCheckBox chkbx_redTeam3AutonHighGoal;
    private javax.swing.JCheckBox chkbx_redTeam3AutonHighGoal1;
    private javax.swing.JCheckBox chkbx_redTeam3AutonHighGoal2;
    private javax.swing.JCheckBox chkbx_redTeam3AutonLowGoal;
    private javax.swing.JCheckBox chkbx_redTeam3AutonLowGoal1;
    private javax.swing.JCheckBox chkbx_redTeam3AutonLowGoal2;
    private javax.swing.JCheckBox chkbx_redTeam3Catch;
    private javax.swing.JCheckBox chkbx_redTeam3HighGoal;
    private javax.swing.JCheckBox chkbx_redTeam3HotGoal;
    private javax.swing.JCheckBox chkbx_redTeam3HotGoal1;
    private javax.swing.JCheckBox chkbx_redTeam3HotGoal2;
    private javax.swing.JCheckBox chkbx_redTeam3LowGoal;
    private javax.swing.JCheckBox chkbx_redTeam3Mobility;
    private javax.swing.JCheckBox chkbx_redTeam3Mobility1;
    private javax.swing.JCheckBox chkbx_redTeam3Mobility2;
    private javax.swing.JCheckBox chkbx_redTeam3Truss;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbl_blueAlliance;
    private javax.swing.JLabel lbl_blueAssistPoints;
    private javax.swing.JLabel lbl_blueCycleNumber;
    private javax.swing.JLabel lbl_blueFoulPoints;
    private javax.swing.JLabel lbl_blueT1AutonomousPoints;
    private javax.swing.JLabel lbl_blueT1Points;
    private javax.swing.JLabel lbl_blueT2AutonomousPoints;
    private javax.swing.JLabel lbl_blueT2Points;
    private javax.swing.JLabel lbl_blueT3AutonomousPoints;
    private javax.swing.JLabel lbl_blueT3Points;
    private javax.swing.JLabel lbl_blueTeam1;
    private javax.swing.JLabel lbl_blueTeam2;
    private javax.swing.JLabel lbl_blueTeam3;
    private javax.swing.JLabel lbl_blueTotalPoints;
    private javax.swing.JLabel lbl_foul;
    private javax.swing.JLabel lbl_foul1;
    private javax.swing.JLabel lbl_foul2;
    private javax.swing.JLabel lbl_foul3;
    private javax.swing.JLabel lbl_foul4;
    private javax.swing.JLabel lbl_foul5;
    private javax.swing.JLabel lbl_redAlliance;
    private javax.swing.JLabel lbl_redAlliance1;
    private javax.swing.JLabel lbl_redAlliance2;
    private javax.swing.JLabel lbl_redAlliance3;
    private javax.swing.JLabel lbl_redAlliance4;
    private javax.swing.JLabel lbl_redAssistPoints;
    private javax.swing.JLabel lbl_redCycleNumber;
    private javax.swing.JLabel lbl_redFoulPoints;
    private javax.swing.JLabel lbl_redT1AutonomousPoints;
    private javax.swing.JLabel lbl_redT1Points;
    private javax.swing.JLabel lbl_redT2AutonomousPoints;
    private javax.swing.JLabel lbl_redT2Points;
    private javax.swing.JLabel lbl_redT3AutonomousPoints;
    private javax.swing.JLabel lbl_redT3Points;
    private javax.swing.JLabel lbl_redTeam1;
    private javax.swing.JLabel lbl_redTeam2;
    private javax.swing.JLabel lbl_redTeam3;
    private javax.swing.JLabel lbl_redTotalPoints;
    private javax.swing.JLabel lbl_techFoul;
    private javax.swing.JLabel lbl_techFoul1;
    private javax.swing.JLabel lbl_techFoul2;
    private javax.swing.JLabel lbl_techFoul3;
    private javax.swing.JLabel lbl_techFoul4;
    private javax.swing.JLabel lbl_techFoul5;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JSpinner spnr_blueTeam1Fouls;
    private javax.swing.JSpinner spnr_blueTeam1TechFouls;
    private javax.swing.JSpinner spnr_blueTeam2Fouls;
    private javax.swing.JSpinner spnr_blueTeam2TechFouls;
    private javax.swing.JSpinner spnr_blueTeam3Fouls;
    private javax.swing.JSpinner spnr_blueTeam3TechFouls;
    private javax.swing.JSpinner spnr_redTeam1Fouls;
    private javax.swing.JSpinner spnr_redTeam1TechFouls;
    private javax.swing.JSpinner spnr_redTeam2Fouls;
    private javax.swing.JSpinner spnr_redTeam2TechFouls;
    private javax.swing.JSpinner spnr_redTeam3Fouls;
    private javax.swing.JSpinner spnr_redTeam3TechFouls;
    private javax.swing.JToggleButton tglBtn_blueTeam1BlueZone;
    private javax.swing.JToggleButton tglBtn_blueTeam1RedZone;
    private javax.swing.JToggleButton tglBtn_blueTeam1WhiteZone;
    private javax.swing.JToggleButton tglBtn_blueTeam2BlueZone;
    private javax.swing.JToggleButton tglBtn_blueTeam2RedZone;
    private javax.swing.JToggleButton tglBtn_blueTeam2WhiteZone;
    private javax.swing.JToggleButton tglBtn_blueTeam3BlueZone;
    private javax.swing.JToggleButton tglBtn_blueTeam3RedZone;
    private javax.swing.JToggleButton tglBtn_blueTeam3WhiteZone;
    private javax.swing.JToggleButton tglBtn_redTeam1BlueZone;
    private javax.swing.JToggleButton tglBtn_redTeam1RedZone;
    private javax.swing.JToggleButton tglBtn_redTeam1WhiteZone;
    private javax.swing.JToggleButton tglBtn_redTeam2BlueZone;
    private javax.swing.JToggleButton tglBtn_redTeam2RedZone;
    private javax.swing.JToggleButton tglBtn_redTeam2WhiteZone;
    private javax.swing.JToggleButton tglBtn_redTeam3BlueZone;
    private javax.swing.JToggleButton tglBtn_redTeam3RedZone;
    private javax.swing.JToggleButton tglBtn_redTeam3WhiteZone;
    // End of variables declaration//GEN-END:variables

}
