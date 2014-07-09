package com.theladders.avital.oc.print;

/**
 * Created by atzubeli on 6/30/14.
 */
public interface ListPrinter {

    void createHeader(String... args);

    void print(String string);

    void run();

    void clear();

}