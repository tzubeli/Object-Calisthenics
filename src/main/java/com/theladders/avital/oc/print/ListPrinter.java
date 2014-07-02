package com.theladders.avital.oc.print;

/**
 * Created by atzubeli on 6/30/14.
 */
public interface ListPrinter<Job> {

    void createHeader();

    void print(String string);

    void run();

    void clear();

}