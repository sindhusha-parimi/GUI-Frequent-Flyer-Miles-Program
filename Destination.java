
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


public class Destination 
{
  private String destcity;
  private int normiles;
  private int upgrmiles;
  private int freqmiles;
  private int startmon;
  private int endmon;
  
  public Destination(String destcity, int normiles, int freqmiles, int upgrmiles, int startmon, int endmon)
  {
    this.destcity = destcity;
    this.normiles = normiles;
    this.upgrmiles = upgrmiles;
    this.freqmiles = freqmiles;
    this.startmon = startmon;
    this.endmon = endmon;
  }
  
  public String getDestCity()
  {
    return destcity;
  }

  public int getnormiles()
  {
    return normiles;
  }
    
  public int getfreqmiles()
  {
    return freqmiles;
  }

  public int getupgrmiles()
  {
    return upgrmiles;
  }

  public int getstartmon()
  {
    return startmon;
  }

  public int getendmon()
  {
    return endmon;
  }
}