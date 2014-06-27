package com.theladders.avital.oc.collections;



import java.util.Collection;

/**
 * Created by atzubeli on 6/25/14.
 */
public class PrintToConsole implements ApplicationsPrinter {


    public void print(String string) {

        System.out.print(string+", ");

    }
}


