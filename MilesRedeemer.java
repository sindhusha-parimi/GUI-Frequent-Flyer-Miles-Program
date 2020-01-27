
/************************************************************
 *                                                          *
 *  CSCI 470/502          Assignment 8           Fall 2018  *                                             
 *                                                          *
 *  Programmers: 1.Sindhusha Devi Parimi      - Z1855951     *
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


import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class MilesRedeemer {

    private int remainingMiles = 0;
    private ArrayList<Destination> destinationList = new ArrayList<Destination>();
    
    public void readDestinations(Scanner fileScanner)
    {
      String record;
      while (fileScanner.hasNext())
      {
        record = fileScanner.nextLine();
        String [] arrayString = record.split(";");
        String [] monthsArray = arrayString[4].split("-");
        destinationList.add(new Destination(arrayString[0], Integer.parseInt(arrayString[1]),
                                            Integer.parseInt(arrayString[2]),
                                            Integer.parseInt(arrayString[3]),
                                            Integer.parseInt(monthsArray[0]),
                                            Integer.parseInt(monthsArray[1])));
      }
    } 

    public String[] getCityNames()
    {
      String[] cityName = new String[destinationList.size()];
      for(int i = 0; i < destinationList.size(); i++)
      {
        cityName[i] = destinationList.get(i).getDestCity();
      }
      Arrays.sort(cityName);
      return cityName;
    } 
    
    public Destination findDestination(String cityName)
    {
      for (Destination destination : destinationList)
      {
        if (destination.getDestCity().equals(cityName))
          return destination; 
      }
      return null; 
    }
    
    public ArrayList<String> redeemMiles(int miles, int month) 
    {
      int mileUsage;
      ArrayList<String> userInfo = new ArrayList<>();
      ArrayList<String> availableCityList = new ArrayList<String>();
      destinationList.sort((p1, p2) -> p2.getnormiles() - p1.getnormiles());
      remainingMiles = miles;
      for (Destination destination : destinationList)
      {
        if (month >= destination.getstartmon() && month <= destination.getendmon())
        {
          mileUsage = destination.getfreqmiles();
        }
        else 
        {
          mileUsage = destination.getnormiles();
        }
        if (mileUsage < remainingMiles) 
        {
          availableCityList.add(destination.getDestCity());
          remainingMiles -= mileUsage;
        }
      }

      if (!availableCityList.isEmpty()) 
      {
        int i = 0;
        ArrayList<String> flightClass = new ArrayList<String>();
        for (Destination destination : destinationList) 
        {
          if (i == availableCityList.size()) 
          {
            break;
          }
          if (availableCityList.get(i).equals(destination.getDestCity())) 
          {
            i++;
            if (destination.getupgrmiles() <= remainingMiles) 
            {
              remainingMiles -= destination.getupgrmiles();
              flightClass.add("First class");
            }
            else 
            {
              flightClass.add("Economy class");
            }
          }
        }

        int index = 0;
           
        for (String city : availableCityList) 
        {
          userInfo.add("* A Trip to " + city + ", " + flightClass.get(index));
          index++;
        }
      }

      return userInfo;
    } 

    public int getRemainingMiles() 
    {
      return remainingMiles;
    } 
} 