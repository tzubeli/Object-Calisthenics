package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.CountPrinterConsole;

/**
 * Created by atzubeli on 6/25/14.
 */
public interface Job {

     String toString();

     void print(ApplicationsPrinter printer);

     void print(CountPrinterConsole printer);




}
