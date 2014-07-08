package com.theladders.avital.oc.user;

import com.theladders.avital.oc.print.AggregateCountPrinter;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.ConsoleCountPrinter;
import com.theladders.avital.oc.print.ListPrinter;

/**
 * Created by atzubeli on 6/13/14.
 */
public class Name {

    private String name;

    public Name(String name){

        this.name = name;

    }

    public String toString() {

        return name;
    }


    public void print(ApplicationsPrinter printer) {

        printer.print(name);
    }

    public void print(AggregateCountPrinter printer){

        printer.print(name);

    }
    public void print(ListPrinter printer){

        printer.print(name);

    }

    public int compareTo(Name other){

        return this.name.compareTo(other.name);
    }




}
