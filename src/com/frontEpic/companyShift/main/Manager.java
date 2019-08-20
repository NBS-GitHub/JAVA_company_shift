package com.frontEpic.companyShift.main;

import com.frontEpic.companyShift.interfaces.I_Manager;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public class Manager implements I_Manager {

   private String title;
   private String name;
   private ExecutorService staff;
   private Map<String, Integer> tasksMap;
   private String[] tasksArray;
   private Random random = new Random();

   public Manager(String title, String name, ExecutorService staff, Map<String, Integer> tasksMap, String[] tasksArray) {
      this.title = title;
      this.name = name;
      this.staff = staff;
      this.tasksMap = tasksMap;
      this.tasksArray = tasksArray;
   }

   @Override
   public void giveOrder(Shift shift) {
      String currentTask = tasksArray[random.nextInt(tasksArray.length)];
      int  currentProfit = tasksMap.get(currentTask);
      System.out.printf("%s %s says: \"%s\"!\n", title, name, currentTask);
      staff.execute(new Thread(new Task(currentTask, currentProfit, shift)));
   }

   @Override
   public void endShift() {
      System.out.printf("\n\t%s %s says: Alright people, we've earned a heap of money today. You can collect the garbage, clean the stack of pizza plates and we are closing it up!\n", title, name);
      System.out.printf("\tThe staff says: Oh no, but if we have to... Maybe we will just finish our current tasks, %s %s?\n", title, name);
      System.out.printf("\t%s %s says: Good idea! Lock the office, when you're done.\n\n", title, name);
      staff.shutdown();
   }

}
