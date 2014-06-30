package com.theladders.avital.oc.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atzubeli on 6/25/14.
 */
public class PrintToConsole implements ApplicationsPrinter {

    List<String> list = new ArrayList<>();


    public void createHeader() {

        System.out.println("Date    Jobseeker   Job     Employer");

    }

    public void print(String string) {

        list.add(string);

    }

    public void run() {

        for (int i=0; i<4; i++){

            System.out.print(list.get(i) + "\t");
        }
        System.out.println(" ");

    }

    public void close() {


    }
}


