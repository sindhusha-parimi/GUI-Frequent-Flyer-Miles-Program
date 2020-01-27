
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

import javax.swing.JFrame;

public class MileRedemptionApp 
{
  public static void main(String[] args)
  {
    JFrame mile = new MileageRedemptionGUI();
    mile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mile.setVisible(true);
    mile.setSize(1200,600);
    mile.setLocationRelativeTo(null);
  }
}

