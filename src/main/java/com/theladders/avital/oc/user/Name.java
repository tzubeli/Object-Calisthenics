package com.theladders.avital.oc.user;

import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.CountPrinterConsole;

/**
 * Created by atzubeli on 6/13/14.
 */
public class Name {

    String name;

    public Name(String name){

        this.name = name;

    }

    public String toString() {

        return name;
    }


    public void print(ApplicationsPrinter printer) {

        printer.print(name);
    }

    public void print(CountPrinterConsole printer){

        printer.print(name);

    }



}
