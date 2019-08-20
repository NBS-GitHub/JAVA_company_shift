package com.frontEpic.companyShift.main;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Company {
   public static void main(String[] args) {

      // Array tasksArray contains the tasks to be executed during the shift.
      String[] tasksArray = new String[]{"Postpone the invoice due date somehow", "Bring me coffee", "Prepare the new marketing strategy", "Order a pizza", "Stop whispering the jokes", "Negotiate better conditions with our suppliers", "Tell me, how do you like your job here"};

      // List profitsList's content represents the amount of money earned for the tasks above.
      List<Integer> profitsList = new LinkedList<>(Arrays.asList(2,4,3,1,6,5,7));

      // Preparations
      Integer[] profitsArray = testProfitsListSize(profitsList, tasksArray);
      Map<String, Integer> tasksMap = prepareShift(tasksArray, profitsArray);

      // Instantiation and kickoff
      ExecutorService staff = Executors.newFixedThreadPool(3);
      Manager boss = new Manager("Mr.", "Wes", staff, tasksMap, tasksArray);
      Shift shift = new Shift(boss, staff, tasksMap, tasksArray, 200);

   }

   private static Map<String, Integer>  prepareShift(String[] tasksArray, Integer[] profitsArray) {
      Map<String, Integer> tasksMap = new LinkedHashMap<>();
      for(int i=0; i<tasksArray.length; i++)
         tasksMap.put(tasksArray[i], profitsArray[i]);

      return tasksMap;
   }

   private static Integer[] testProfitsListSize(List<Integer> profitsList, String[] tasksArray) {
      if(profitsList.size() < tasksArray.length) {
         for(int i=0; i<tasksArray.length; i++) {
            if(i >= profitsList.size()) {
               profitsList.add(1);
            }
         }
      }
      return profitsList.stream().toArray(el -> new Integer[el]);
   }

}
