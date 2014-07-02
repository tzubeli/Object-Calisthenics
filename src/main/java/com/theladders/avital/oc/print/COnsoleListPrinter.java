package com.theladders.avital.oc.print;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atzubeli on 6/30/14.
 */
public class ConsoleListPrinter implements ListPrinter {

    private List<String> list = new ArrayList<>();

    public void createHeader() {

        System.out.println("Employer    Job");

    }

    public void print(String string) {

        list.add(string);

    }

    public void run() {

        System.out.println(list.get(0)+":\t"+list.get(1));

    }

    public void clear(){

        list.clear();
    }

    public void close() {


    }
}
