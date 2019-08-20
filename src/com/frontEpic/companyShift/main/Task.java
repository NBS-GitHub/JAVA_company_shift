package com.frontEpic.companyShift.main;

import java.util.Random;

public class Task implements Runnable {

   private String currentTask;
   private int currentProfit;
   private Shift shift;
   private Random random = new Random();

   public Task(String currentTask, int currentProfit, Shift shift) {
      this.currentTask = currentTask;
      this.currentProfit = currentProfit;
      this.shift = shift;
   }

   @Override
   public void run() {
      try {
         Thread.sleep(random.nextInt(3000));
         System.out.printf("The staff says: The task \"%s\" is done.\n", currentTask);
         shift.setRealProfit(currentProfit + shift.getRealProfit());
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

}
