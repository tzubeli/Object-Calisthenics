package com.theladders.avital.oc.print;

/**
 * Created by atzubeli on 7/2/14.
 */
public interface AggregateCountPrinter {

    void createHeader();

    void print(String string);

    void run();

    void clear();


}
