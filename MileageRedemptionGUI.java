
/************************************************************
 *                                                          *
 *  CSCI 470/502          Assignment 8           Fall 2018  *                                             
 *                                                          *
 *  Programmer: 1.Sindhusha Devi Parimi      - Z1855951     *
 *              2.Kameswari Sravya Vinnakota - Z1859225     *
 *                                                          *
 *  Date Due:   11/30/2018 11:59 PM                         *                          
 *                                                          *
 *  Purpose:   To create GUI for the Mile Redemption App    *
 *             where user can enter his accumulated miles   *
 *             with desired month of travel and get the     *
 *             Destinations he can travel to                *
 *             with the miles available.                    *
 ***********************************************************/ 

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SpinnerListModel;
import java.text.DateFormatSymbols;


public class MileageRedemptionGUI extends javax.swing.JFrame 
{
   private JButton Bu1;
    private JLabel La1;
    private JLabel La2;
    private JLabel La3;
    private JLabel La4;
    private JLabel La5;
    private JLabel La6;
    private JLabel La7;
    private JList<String> Li1;
    private JPanel Pa1;
    private JPanel Pa2;
    private JScrollPane SPa1;
    private JScrollPane SPa2;
    private JSpinner SPin1;
    private JTextArea TArea1;
    private JTextField TField1;
    private JTextField TField2;
    private JTextField TField3;
    private JTextField TField4;
    private JTextField TField5;
    private JTextField TField6;
    
    MilesRedeemer mire = new MilesRedeemer();
    String [] months = getMonthStrings();
    
    public MileageRedemptionGUI() 
    {   
      super("Mile Redemption App");
       
      try 
      {
        JFileChooser chooser = new JFileChooser(".");
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
          Scanner fileScanner = new Scanner (chooser.getSelectedFile()); 
          mire.readDestinations(fileScanner);
          Redemption();
          getContentPane().setBackground(new Color(153,204,204));
          setdescription();
        }
      }
      catch (FileNotFoundException e) 
      {
        JOptionPane.showMessageDialog(null, "File not found.");
      } 
    }
    
    private String[] getMonthStrings() 
    {
      String[] months = new DateFormatSymbols().getMonths();
      int lastIndex = months.length - 1;
      if (months[lastIndex] == null || months[lastIndex].length() <= 0) 
      {
        String[] monthStrings = new String[lastIndex];
        System.arraycopy(months, 0, monthStrings, 0, lastIndex);
        return monthStrings;
      } 
      else 
      {
        return months;
      }
    } 
    
    private void setdescription()
    {
      Li1.addListSelectionListener(g -> 
                                      {
                    Destination cityInfo; 
                    cityInfo = mire.findDestination(Li1.getSelectedValue());
                    TField1.setText(String.valueOf(cityInfo.getnormiles()));
                    TField2.setText(String.valueOf(cityInfo.getupgrmiles()));
                    TField3.setText(String.valueOf(cityInfo.getfreqmiles()));
                    TField4.setText(months[cityInfo.getstartmon()-1] + " to " + months[cityInfo.getendmon()-1]);
      });
        
      Bu1.addActionListener(g -> 
                                 {
        try { 
          ArrayList<String> redeemTickets;
          int milesAcc = Integer.parseInt(TField5.getText());
          String month = (String) SPin1.getValue();
          int monthNum = 0;
 
          if ( months[0]== month)
            monthNum = 1;      

          if ( months[1] == month)
            monthNum = 2;

          if ( months[2] == month)
            monthNum = 3;

          if ( months[3] == month)
            monthNum = 4;
                        
          if ( months[4] == month)
            monthNum = 5;

          if ( months[5] == month)
            monthNum = 6;

          if ( months[6] == month)
            monthNum = 7;

          if ( months[7] == month)
            monthNum = 8;

          if ( months[8] == month)
            monthNum = 9;

          if ( months[9] == month)
            monthNum = 10;
                        
          if ( months[10] == month)
            monthNum = 11;

          if ( months[11] == month)
            monthNum = 12;

          redeemTickets = mire.redeemMiles(milesAcc, monthNum);
          
          TArea1.setText("Your accumulated miles can be used to redeem the following air tickets\n\n");
                  
          if (redeemTickets.size()== 0)
          {
            TArea1.append("Your miles are not valid for any ticket.");
          }
          
          for( String redeemTicket: redeemTickets)
          {
            TArea1.append(redeemTicket);
            TArea1.append("\n");
          }
          TField6.setText(String.valueOf(mire.getRemainingMiles()));
        } 
        catch(NumberFormatException e)
        {
          TArea1.setText("Please enter valid accumulated miles.");
          TField6.setText("");
        }
      });
    }

    @SuppressWarnings("unchecked")
    private void Redemption() 
    {
      Pa1 = new JPanel();
      SPa1 = new JScrollPane();
      Li1 = new JList<>(mire.getCityNames());
      TField1 = new JTextField();
      La1 = new JLabel("Required Miles ");
      La2 = new JLabel("Miles for Upgrading ");
      TField2 = new JTextField();
      La3 = new JLabel("Frequent Flyer Miles ");
      TField3 = new JTextField();
      La4 = new JLabel("Frequent Flyer Months");
      TField4 = new JTextField();
      Pa2 = new JPanel();
      La5 = new JLabel("Your Accumulated Miles ");
      TField5 = new JTextField();
      La6 = new JLabel("Month of Departure");
      SPin1 = new JSpinner(new SpinnerListModel(months));
      SPa2 = new JScrollPane();
      TArea1 = new JTextArea();
      Bu1 = new JButton();
      La7 = new JLabel("Your Remaining Miles ");
      TField6 = new JTextField();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setBackground(new java.awt.Color(153, 204, 204));

      Pa1.setBackground(new java.awt.Color(150, 150, 200));

      Li1.setName("cityList"); 
      SPa1.setViewportView(Li1);

      GroupLayout Pa1Layout = new GroupLayout(Pa1);
      Pa1.setLayout(Pa1Layout);
      Pa1Layout.setHorizontalGroup(
                                       Pa1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                         .addGroup(Pa1Layout.createSequentialGroup()
                                                     .addContainerGap()
                                                     .addGroup(Pa1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                 .addComponent(SPa1, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                                                 .addGroup(GroupLayout.Alignment.LEADING, Pa1Layout.createSequentialGroup()
                                                                             .addGroup(Pa1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                         .addComponent(La2, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                                                                         .addComponent(La1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                             .addGap(24, 24, 24)
                                                                             .addGroup(Pa1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                         .addComponent(TField2)
                                                                                         .addComponent(TField1)))
                                                                 .addGroup(GroupLayout.Alignment.LEADING, Pa1Layout.createSequentialGroup()
                                                                             .addGroup(Pa1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                         .addComponent(La3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                                                         .addComponent(La4, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                                                                             .addGap(18, 18, 18)
                                                                             .addGroup(Pa1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                         .addComponent(TField3)
                                                                                         .addComponent(TField4, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))))
                                                     .addGap(6, 6, 6))
                                      );
      Pa1Layout.setVerticalGroup(
                                     Pa1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                       .addGroup(Pa1Layout.createSequentialGroup()
                                                   .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                   .addComponent(SPa1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                   .addGroup(Pa1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                               .addComponent(TField1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                               .addComponent(La1))
                                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                   .addGroup(Pa1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                               .addComponent(TField2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                               .addComponent(La2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                                   .addGap(16, 16, 16)
                                                   .addGroup(Pa1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                               .addComponent(La3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                                               .addComponent(TField3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                   .addGroup(Pa1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                               .addComponent(La4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                               .addGroup(Pa1Layout.createSequentialGroup()
                                                                           .addComponent(TField4, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                                                           .addGap(4, 4, 4))))
                                    );
      
      Pa2.setBackground(new java.awt.Color(153, 204, 204));
     
      TArea1.setColumns(10);
      TArea1.setRows(5);
      SPa2.setViewportView(TArea1);
      
      Bu1.setText("Redeem Tickets");

      GroupLayout Pa2Layout = new GroupLayout(Pa2);
      Pa2.setLayout(Pa2Layout);
      Pa2Layout.setHorizontalGroup(
                                       Pa2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                         .addComponent(SPa2)
                                         .addGroup(Pa2Layout.createSequentialGroup()
                                                     .addGroup(Pa2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                 .addGroup(Pa2Layout.createSequentialGroup()
                                                                             .addGroup(Pa2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                         .addGroup(Pa2Layout.createSequentialGroup()
                                                                                                     .addGap(105, 105, 105)
                                                                                                     .addComponent(La5)
                                                                                                     .addGap(14, 14, 14))
                                                                                         .addGroup(GroupLayout.Alignment.TRAILING, Pa2Layout.createSequentialGroup()
                                                                                                     .addContainerGap()
                                                                                                     .addComponent(La6)
                                                                                                     .addGap(9, 9, 9)))
                                                                             .addGroup(Pa2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                         .addGroup(Pa2Layout.createSequentialGroup()
                                                                                                     .addGap(21, 21, 21)
                                                                                                     .addComponent(SPin1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
                                                                                         .addComponent(TField5, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
                                                                 .addGroup(Pa2Layout.createSequentialGroup()
                                                                             .addGap(105, 105, 105)
                                                                             .addComponent(La7, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                             .addComponent(TField6, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
                                                                 .addGroup(Pa2Layout.createSequentialGroup()
                                                                             .addGap(206, 206, 206)
                                                                             .addComponent(Bu1)))
                                                     .addContainerGap(202, Short.MAX_VALUE))
                                      );
      Pa2Layout.setVerticalGroup(
                                     Pa2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                       .addGroup(Pa2Layout.createSequentialGroup()
                                                   .addGap(13, 13, 13)
                                                   .addGroup(Pa2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                               .addComponent(La5)
                                                               .addComponent(TField5, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                   .addGroup(Pa2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                               .addComponent(La6)
                                                               .addComponent(SPin1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                   .addComponent(Bu1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                   .addComponent(SPa2, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                   .addGroup(Pa2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                               .addComponent(La7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                               .addComponent(TField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                   .addContainerGap())
                                    );
      
      GroupLayout layout = new GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                  .addGroup(layout.createSequentialGroup()
                                              .addComponent(Pa1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                              .addComponent(Pa2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                               );
      layout.setVerticalGroup(
                              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(Pa1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Pa2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                             );
      
        
      Pa1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Destinations") );
      Pa2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Redeem Miles") );
        
      pack();
    }

    
}