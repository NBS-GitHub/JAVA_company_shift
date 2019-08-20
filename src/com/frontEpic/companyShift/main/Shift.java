package com.frontEpic.companyShift.main;

import com.frontEpic.companyShift.interfaces.I_Shift;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public class Shift implements I_Shift {

   private Manager boss;
   private Random random = new Random();
   private int targetProfit;
   private int realProfit = 0;

   public Shift(Manager boss, ExecutorService staff, Map<String, Integer> taskMap, String[] tasksArray, int targetProfit) {
      this.boss = boss;
      this.targetProfit = targetProfit;
      startShift();
   }

   public int getRealProfit() {
      return realProfit;
   }

   public void setRealProfit(int newRealProfit) {
      this.realProfit = newRealProfit;
   }

   @Override
   public void startShift() {
      while(true) {
         try {
            if(realProfit >= targetProfit) {
               boss.endShift();
               break;
            } else {
               boss.giveOrder(this);
//               realProfit += 40;
               Thread.sleep(random.nextInt(1000));
            }
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

}
