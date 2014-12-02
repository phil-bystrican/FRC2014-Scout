/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swc.robotics.scouting.system;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Project Name: SWC Robotics Scouting System 
 * File Name:	 SortData 
 * Programmer:   Phil Bystrican <Phil@PBApps.ca>
 * Teacher:	 Mr. K 
 * Date:         Mar 24, 2014 
 * Description:  JFrame used to sort and display the data collected by other parts of the app
 *
 */

public class SortData extends BaseJFrame {

    /**
     * Creates new form SortData
     */

    public SortData() 
    {
        initComponents();
        //instantiate a table row sorter 
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tbl_data.getModel());
        //add the sorter to the table
        tbl_data.setRowSorter(sorter);     
        //add a mouse listener to the table
        tbl_data.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent evnt) 
            {
                //if a minimum of a double click occured
                if (evnt.getClickCount() > 1) 
                {
                    //a double click event occured
                    DoubleClick(evnt);
                }
            }
         });
        
        //update the data table
        this.updateTable();
    }
    
    //takes no parameters, calculates the data for the table and displays it. Returns nothing.
    public void updateTable()
    {
        //get the table model from the table object
        DefaultTableModel dtm_model = (DefaultTableModel)tbl_data.getModel(); 
        //get the number of rows
        int int_numberOfRows = dtm_model.getRowCount(); 
        //remove all the rows from the table
        dtm_model.setNumRows(0); 
 
        
        //get the numbers of all matches stored in the DB
        int[] int_matchNumbers = DataBaseManager.loadMatchNumbers();
        
        //create a hashmap to store the row data by team number
        Map<Integer, Row> hshmp_data = new HashMap<Integer, Row>();

        //loop through the matches
        for (int i = 0; i < int_matchNumbers.length; i++) {
            //load the match from the database
            Match mtch_match = DataBaseManager.loadMatch(int_matchNumbers[i]);
            //loop through the teams that played in the match
            for (int j = 0; j < mtch_match.int_teamNumbers.length; j++) {
                //store the team number in a local variable for code simplification
                int int_teamNumber = mtch_match.int_teamNumbers[j];
                //check if the team already has an entry in the hashmap
                if (hshmp_data.containsKey(int_teamNumber)) 
                {
                    //load the row from the hashmap
                    Row rw_storedRow = hshmp_data.get(int_teamNumber);
                    //instantiate ints for the pieces of data to be collected
                    int int_wins = 0, int_losses = 0, int_ties = 0,
                            int_trusses = 0, int_catches = 0, int_highGoals = 0, int_lowGoals = 0,
                            int_teleopPoints = 0, int_autonomousPoints = 0, int_foulPoints = 0, int_allianceAssistPoints = 0;
                    
                    //loop through the match cycles
                    for (int k = 0; k < mtch_match.mtch_cycles.length; k++) {
                        //check to see if the cycle contains data
                        if (mtch_match.mtch_cycles[k][j] == null) 
                        {
                            //the match is null break the loop
                            break;
                        }
                        //if the match cycle contains a catch add 1 to the total number of catches
                        int_catches += mtch_match.mtch_cycles[k][j].bool_catch ? 1 : 0;
                        //if the match cycle contains a truss add 1 to the total number of truss
                        int_trusses += mtch_match.mtch_cycles[k][j].bool_truss ? 1 : 0;
                        //if the match cycle contains a high goal add 1 to the total number of high goal
                        int_highGoals += mtch_match.mtch_cycles[k][j].bool_highGoal ? 1 : 0;
                        //if the match cycle contains a low goal add 1 to the total number of low goal
                        int_lowGoals += mtch_match.mtch_cycles[k][j].bool_lowGoal ? 1 : 0;
                    }
                    //if the match ended in a tie, add 1 to the total number of ties
                    int_ties += (mtch_match.int_matchOutCome == Constants.int_TIE) ? 1 : 0;
                    
                    if (j < 3) //red alliance
                    {
                        //check if the match ended in a red win
                        if (mtch_match.int_matchOutCome == Constants.int_RED_WIN) 
                        {
                            //increase the number of wins
                            int_wins++;
                        } 
                        //check if the match ended in a blue win
                        else if (mtch_match.int_matchOutCome == Constants.int_BLUE_WIN) 
                        {
                            //increase the number of losses
                            int_losses++;
                        }
                    } else //blue alliance
                    {
                        //check if the match ended in a blue win
                        if (mtch_match.int_matchOutCome == Constants.int_BLUE_WIN) 
                        {
                            //increase the number of wins
                            int_wins++;
                        } 
                        //check if the match ended in a red win
                        else if (mtch_match.int_matchOutCome == Constants.int_RED_WIN) 
                        {
                            //increase the number of losses
                            int_losses++;
                        }
                    }
                    
                    //use the number of catches to calculate the tele-op points
                    int_teleopPoints += int_catches * Constants.int_CATCH_POINTS;
                    //use the number of trusses to calculate the tele-op points
                    int_teleopPoints += int_trusses * Constants.int_TRUSS_POINTS;
                    //use the number of high goals to calculate the tele-op points
                    int_teleopPoints += int_highGoals * Constants.int_HIGH_GOAL_POINTS;
                    //use the number of low goals to calculate the tele-op points
                    int_teleopPoints += int_lowGoals * Constants.int_LOW_GOAL_POINTS;

                    //add number of autonomous points from the match to the local variable
                    int_autonomousPoints += mtch_match.getAutonomousPointsForTeamInPosition(j);
                    //add number of foul points from the match to the local variable
                    int_foulPoints += mtch_match.getFoulPointsForTeamInPosition(j);
                    //add number of assist points from the match to the local variable
                    int_allianceAssistPoints += mtch_match.getAssistPointsForAllianceForTeamInPosition(j);

                    //add the data collected to the current data that exists in the row
                    rw_storedRow.addValuesToRow(int_wins, int_losses, int_ties, int_lowGoals, int_highGoals,
                            int_trusses, int_catches, int_teleopPoints, int_autonomousPoints, int_allianceAssistPoints, int_foulPoints);

                    //add the data to the hashmap
                    hshmp_data.put(int_teamNumber, rw_storedRow);
                    
                } else 
                {
                    //load the team from the database
                    FRCTeam team_currentTeam = DataBaseManager.loadTeam(int_teamNumber);
                    //set the team name
                    String str_teamName = team_currentTeam.str_teamName;
                    //instantiate ints for the pieces of data to be collected
                    int int_wins = 0, int_losses = 0, int_ties = 0,
                            int_trusses = 0, int_catches = 0, int_highGoals = 0, int_lowGoals = 0,
                            int_teleopPoints = 0, int_autonomousPoints = 0, int_foulPoints = 0, int_allianceAssistPoints = 0;

                    //loop through the match cycles
                    for (int k = 0; k < mtch_match.mtch_cycles.length; k++) {
                        //check to see if the cycle contains data
                        if (mtch_match.mtch_cycles[k][j] == null) 
                        {
                            //the match is null break the loop
                            break;
                        }
                        //if the match cycle contains a catch add 1 to the total number of catches
                        int_catches += mtch_match.mtch_cycles[k][j].bool_catch ? 1 : 0;
                        //if the match cycle contains a truss add 1 to the total number of truss
                        int_trusses += mtch_match.mtch_cycles[k][j].bool_truss ? 1 : 0;
                        //if the match cycle contains a high goal add 1 to the total number of high goal
                        int_highGoals += mtch_match.mtch_cycles[k][j].bool_highGoal ? 1 : 0;
                        //if the match cycle contains a low goal add 1 to the total number of low goal
                        int_lowGoals += mtch_match.mtch_cycles[k][j].bool_lowGoal ? 1 : 0;
                    }
                    //if the match ended in a tie, add 1 to the total number of ties
                    int_ties += (mtch_match.int_matchOutCome == Constants.int_TIE) ? 1 : 0;
                    
                    if (j < 3) //red alliance
                    {
                        //check if the match ended in a red win
                        if (mtch_match.int_matchOutCome == Constants.int_RED_WIN) 
                        {
                            //increase the number of wins
                            int_wins++;
                        } 
                        //check if the match ended in a blue win
                        else if (mtch_match.int_matchOutCome == Constants.int_BLUE_WIN) 
                        {
                            //increase the number of losses
                            int_losses++;
                        }
                    } else //blue alliance
                    {
                        //check if the match ended in a blue win
                        if (mtch_match.int_matchOutCome == Constants.int_BLUE_WIN) 
                        {
                            //increase the number of wins
                            int_wins++;
                        } 
                        //check if the match ended in a red win
                        else if (mtch_match.int_matchOutCome == Constants.int_RED_WIN) 
                        {
                            //increase the number of losses
                            int_losses++;
                        }
                    }

                    //use the number of catches to calculate the tele-op points
                    int_teleopPoints += int_catches * Constants.int_CATCH_POINTS;
                    //use the number of trusses to calculate the tele-op points
                    int_teleopPoints += int_trusses * Constants.int_TRUSS_POINTS;
                    //use the number of high goals to calculate the tele-op points
                    int_teleopPoints += int_highGoals * Constants.int_HIGH_GOAL_POINTS;
                    //use the number of low goals to calculate the tele-op points
                    int_teleopPoints += int_lowGoals * Constants.int_LOW_GOAL_POINTS;

                    //add number of autonomous points from the match to the local variable
                    int_autonomousPoints += mtch_match.getAutonomousPointsForTeamInPosition(j);
                    //add number of foul points from the match to the local variable
                    int_foulPoints += mtch_match.getFoulPointsForTeamInPosition(j);
                    //add number of assist points from the match to the local variable
                    int_allianceAssistPoints += mtch_match.getAssistPointsForAllianceForTeamInPosition(j);

                    //create the row object with the data collected
                    Row rw_currentRow = new Row(int_teamNumber, str_teamName, int_wins, int_losses, int_ties, int_lowGoals, int_highGoals,
                            int_trusses, int_catches, int_teleopPoints, int_autonomousPoints, int_allianceAssistPoints, int_foulPoints);

                    //add the data to the hashmap
                    hshmp_data.put(int_teamNumber, rw_currentRow);

                }
            }

        }
        //loop through the elements of the hashmap
        for (Integer Int_key : hshmp_data.keySet()) {
            //add the rows from the hashmap to the table
            dtm_model.addRow(hshmp_data.get(Int_key).toArray());
        }
    }
    
    //takes a mouse event as a parameter, opens the team in the clicked row, returns nothing 
    public void DoubleClick(MouseEvent evnt)
    {
        //get the row number of the double clicked row
        int int_row = tbl_data.rowAtPoint(new Point(evnt.getX(), evnt.getY()));

        //get the team number from the clicked row
        Integer Int_teamNumber = (Integer) tbl_data.getModel().getValueAt(int_row,0);

        //initialize the modify team jframe
        ModifyTeam jfrm_modifyMatch = new ModifyTeam(Int_teamNumber, true);
        //display the jframe
        this.pushFrame(jfrm_modifyMatch, this);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back(evt);
            }
        });

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Team #", "Team Name", "Matches Played", "Wins", "Losses", "Ties", "Trusses", "Catches", "Teleop Points", "Autonomous Points", "Alliance Assist Points", "Foul Points"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_data.setShowGrid(true);
        jScrollPane1.setViewportView(tbl_data);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(btn_back)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(btn_back)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //takes the event as a parameter, pops the frame, returns nothing
    private void back(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back
        //call the super class' back function 
        super.popFrame();
    }//GEN-LAST:event_back

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables
}


//Row class, used only within this file
class Row extends Object {
    //instantiate an int object for the team number
    Integer Int_teamNumber = new Integer(0);
    //instantiate a string for the team name 
    String str_teamName = "";
    //instantiate an int object for the number of matches played
    Integer Int_matchesPlayed = new Integer(0);
    //instantiate an int object for the number of matches won
    Integer Int_wins = new Integer(0);
    //instantiate an int object for the number of matches lost
    Integer Int_losses = new Integer(0);
    //instantiate an int object for the number of matches tied
    Integer Int_ties = new Integer(0);
    //instantiate an int object for the number of low goals scored
    Integer Int_lowGoals = new Integer(0);
    //instantiate an int object for the number of high goals scored
    Integer Int_highGoals = new Integer(0);
    //instantiate an int object for the number of trusses scored
    Integer Int_trusses = new Integer(0);
    //instantiate an int object for the number of catches scored
    Integer Int_catches = new Integer(0);
    //instantiate an int object for the team's teleop points
    Integer Int_teleopPoints = new Integer(0);
    //instantiate an int object for the team's autonomous points
    Integer Int_autonomousPoints = new Integer(0);
    //instantiate an int object for the team's alliance's points
    Integer Int_alliancePoints = new Integer(0);
    //instantiate an int object for the team's foul points
    Integer Int_foulPoints = new Integer(0);

    /*constructor, takes the team number, team name, number of: wins, losses, ties, 
    low goals. high goals, truss throws, catches, teleop points, autonomous points, 
    * alliance points, and foul points as parameters. Creates a new row object with the input.
    Returns the new row object.*/
    public Row(int _int_teamNumber, String _str_teamName, int _int_wins,
            int _int_losses, int _int_ties, int _int_lowGoals, int _int_highGoals, int _int_trusses, int _int_catches, int _int_teleopPoints,
            int _int_autonomousPoints, int _int_alliancePoints, int _int_foulPoints) {
        //cast the team number parameter to an Integer
        this.Int_teamNumber = new Integer(_int_teamNumber);
        //set the team name to the inputed parameter
        this.str_teamName = _str_teamName;
        //set the number of matches to 1 as this is a new instance
        this.Int_matchesPlayed = 1;
        //cast the wins parameter to an Integer
        this.Int_wins = new Integer(_int_wins);
        //cast the losses parameter to an Integer
        this.Int_losses = new Integer(_int_losses);
        //cast the ties parameter to an Integer
        this.Int_ties = new Integer(_int_ties);
        //cast the low goals parameter to an Integer
        this.Int_lowGoals = new Integer(_int_lowGoals);
        //cast the high goals parameter to an Integer
        this.Int_highGoals = new Integer(_int_highGoals);
        //cast the trusses parameter to an Integer
        this.Int_trusses = new Integer(_int_trusses);
        //cast the catches parameter to an Integer
        this.Int_catches = new Integer(_int_catches);
        //cast the telop points parameter to an Integer
        this.Int_teleopPoints = new Integer(_int_teleopPoints);
        //cast the autonomous points parameter to an Integer
        this.Int_autonomousPoints = new Integer(_int_autonomousPoints);
        //cast the alliance points parameter to an Integer
        this.Int_alliancePoints = new Integer(_int_alliancePoints);
        //cast the fouls points parameter to an Integer
        this.Int_foulPoints = new Integer(_int_foulPoints);
    }

    /*takes the number of: wins, losses, ties, 
    low goals. high goals, truss throws, catches, teleop points, autonomous points, 
    * alliance points, and foul points as parameters and adds them to the current values in the Row. */
    public void addValuesToRow(int _int_wins, int _int_losses, int _int_ties, int _int_lowGoals,
            int _int_highGoals, int _int_trusses, int _int_catches, int _int_teleopPoints,
            int _int_autonomousPoints, int _int_alliancePoints, int _int_foulPoints) 
    {
        //increase the number of matches the object contains
        this.Int_matchesPlayed++;
        //add the numbers of wins to the current number of wins and casts it to an Integer
        this.Int_wins = new Integer(Int_wins + _int_wins);
        //add the numbers of losses to the current number of losses and casts it to an Integer
        this.Int_losses = new Integer(Int_losses + _int_losses);
        //add the numbers of ties to the current number of ties and casts it to an Integer
        this.Int_ties = new Integer(Int_ties + _int_ties);
        //add the numbers of low goals to the current number of low goals and casts it to an Integer
        this.Int_lowGoals = new Integer(Int_lowGoals + _int_lowGoals);
        //add the numbers of high goals to the current number of high goals and casts it to an Integer
        this.Int_highGoals = new Integer(Int_highGoals + _int_highGoals);
        //add the numbers of trusses to the current number of trusses and casts it to an Integer
        this.Int_trusses = new Integer(Int_trusses + _int_trusses);
        //add the numbers of catches to the current number of catches and casts it to an Integer
        this.Int_catches = new Integer(Int_catches + _int_catches);
        //add the numbers of teleop points to the current number of teleop points and casts it to an Integer
        this.Int_teleopPoints = new Integer(Int_teleopPoints + _int_teleopPoints);
        //add the numbers of autonomous points to the current number of autonomous points and casts it to an Integer
        this.Int_autonomousPoints = new Integer(Int_autonomousPoints + _int_autonomousPoints);
        //add the numbers of alliance points to the current number of alliance points and casts it to an Integer
        this.Int_alliancePoints = new Integer(Int_alliancePoints + _int_alliancePoints);
        //add the numbers of foul points to the current number of foul points and casts it to an Integer
        this.Int_foulPoints = new Integer(Int_foulPoints + _int_foulPoints);
    }
    
    //takes no parameters, returns the locals variables in an array of object for display in the table
    public Object[] toArray() {
        /*turn the data fields into an array of objects for use in the table*/
        Object[] obj_row = {Int_teamNumber, str_teamName, Int_matchesPlayed, Int_wins, Int_losses,
            Int_ties, Int_trusses, Int_catches, Int_teleopPoints, Int_autonomousPoints, Int_alliancePoints, Int_foulPoints};
        //return the array
        return obj_row;
    }
}