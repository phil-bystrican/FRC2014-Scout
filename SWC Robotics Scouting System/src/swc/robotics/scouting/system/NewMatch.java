/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package swc.robotics.scouting.system;

/**
 * Project Name: SWC Robotics Scouting System
 * File Name:	 NewMatch
 * Programmer:	 Phil Bystrican <Phil@PBApps.ca>
 * Teacher:	 Mr. K
 * Date:         Mar 6, 2014
 * Description:  JFrame used to setup the basic match data such as match number, and team numbers
 **/
public class NewMatch extends BaseJFrame {

    /** Creates new form NewMatch */
    public NewMatch() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        btn_continue = new javax.swing.JButton();
        lbl_teamNumber = new javax.swing.JLabel();
        lbl_teamName = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        lbl_teamName1 = new javax.swing.JLabel();
        lbl_teamName2 = new javax.swing.JLabel();
        spnr_redT1 = new javax.swing.JSpinner();
        spnr_redT2 = new javax.swing.JSpinner();
        spnr_redT3 = new javax.swing.JSpinner();
        spnr_blueT3 = new javax.swing.JSpinner();
        spnr_blueT2 = new javax.swing.JSpinner();
        spnr_blueT1 = new javax.swing.JSpinner();
        spnr_matchNumber = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lbl_title.setBackground(new java.awt.Color(255, 255, 255));
        lbl_title.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_title.setText("New Game");

        btn_continue.setText("Continue to Scoring");
        btn_continue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_continueActionPerformed(evt);
            }
        });

        lbl_teamNumber.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_teamNumber.setForeground(new java.awt.Color(255, 255, 255));
        lbl_teamNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_teamNumber.setText("Match Number");

        lbl_teamName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_teamName.setForeground(new java.awt.Color(255, 255, 255));
        lbl_teamName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_teamName.setText("Team Numbers");

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back(evt);
            }
        });

        lbl_teamName1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_teamName1.setForeground(new java.awt.Color(255, 204, 204));
        lbl_teamName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_teamName1.setText("Red Alliance");

        lbl_teamName2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        lbl_teamName2.setForeground(new java.awt.Color(204, 204, 255));
        lbl_teamName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_teamName2.setText("Blue Alliance");

        spnr_redT1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        spnr_redT2.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        spnr_redT3.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        spnr_blueT3.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        spnr_blueT2.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        spnr_blueT1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        spnr_matchNumber.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(btn_back)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 56, Short.MAX_VALUE)
                        .add(lbl_title, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 253, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btn_continue, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(lbl_teamNumber, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(lbl_teamName1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 183, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(lbl_teamName2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, spnr_redT3)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, spnr_redT2)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, spnr_redT1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 183, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, spnr_blueT3)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, spnr_blueT2)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, spnr_blueT1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 183, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(0, 0, Short.MAX_VALUE))
                    .add(spnr_matchNumber)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lbl_teamName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbl_title)
                    .add(btn_back))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lbl_teamNumber)
                .add(1, 1, 1)
                .add(spnr_matchNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lbl_teamName)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbl_teamName1)
                    .add(lbl_teamName2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(spnr_redT1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, 0)
                        .add(spnr_redT2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, 0)
                        .add(spnr_redT3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(spnr_blueT1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, 0)
                        .add(spnr_blueT2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, 0)
                        .add(spnr_blueT3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(btn_continue))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*takes the event as a parameter. Saves the match to the db and loads the match scoring jframe. returns nothing*/
    private void btn_continueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_continueActionPerformed
        //create a new match object to hold the match data
        Match mtch_currentMatch = new Match();

        //put the match number in a seperate int
        mtch_currentMatch.int_gameNumber = ((Integer) spnr_matchNumber.getValue()).intValue();

        //put the 1st red team in a seperate int
        mtch_currentMatch.int_teamNumbers[Constants.int_RED_TEAM_1] = ((Integer) spnr_redT1.getValue()).intValue();
        //put the 2nd red team in a seperate int
        mtch_currentMatch.int_teamNumbers[Constants.int_RED_TEAM_2] = ((Integer) spnr_redT2.getValue()).intValue();
        //put the 3rd red team in a seperate int
        mtch_currentMatch.int_teamNumbers[Constants.int_RED_TEAM_3] = ((Integer) spnr_redT3.getValue()).intValue();

        //put the 1st blue team in a seperate int
        mtch_currentMatch.int_teamNumbers[Constants.int_BLUE_TEAM_1] = ((Integer) spnr_blueT1.getValue()).intValue();
        //put the 2nd blue team in a seperate int
        mtch_currentMatch.int_teamNumbers[Constants.int_BLUE_TEAM_2] = ((Integer) spnr_blueT2.getValue()).intValue();
        //put the 3rd blue team in a seperate int
        mtch_currentMatch.int_teamNumbers[Constants.int_BLUE_TEAM_3] = ((Integer) spnr_blueT3.getValue()).intValue();

        //add/replace the match in the database
        mtch_currentMatch.addMetaToDB();

        //initialize the match scoring jframe
        MatchScoring jfrm_matchScoring = new MatchScoring(mtch_currentMatch.int_gameNumber);
        //display the jframe
        super.pushFrame(jfrm_matchScoring, this);
    }//GEN-LAST:event_btn_continueActionPerformed

    /*takes the event as a parameter. Pops the frame. returns nothing*/
    private void back(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back
        //call the super class' back function 
        super.popFrame();
    }//GEN-LAST:event_back

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_continue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_teamName;
    private javax.swing.JLabel lbl_teamName1;
    private javax.swing.JLabel lbl_teamName2;
    private javax.swing.JLabel lbl_teamNumber;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JSpinner spnr_blueT1;
    private javax.swing.JSpinner spnr_blueT2;
    private javax.swing.JSpinner spnr_blueT3;
    private javax.swing.JSpinner spnr_matchNumber;
    private javax.swing.JSpinner spnr_redT1;
    private javax.swing.JSpinner spnr_redT2;
    private javax.swing.JSpinner spnr_redT3;
    // End of variables declaration//GEN-END:variables

}