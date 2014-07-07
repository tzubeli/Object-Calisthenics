package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.print.AggregateCountPrinter;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.ListPrinter;

/**
 * Created by atzubeli on 6/25/14.
 */
public interface Job {

     void print(ApplicationsPrinter printer);

     void print(AggregateCountPrinter printer);

     void print(ListPrinter printer);
}
