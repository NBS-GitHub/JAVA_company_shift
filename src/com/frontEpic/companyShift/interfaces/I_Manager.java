package com.frontEpic.companyShift.interfaces;

import com.frontEpic.companyShift.main.Shift;

public interface I_Manager {
   public void giveOrder(Shift shift);
   public void endShift();
}
