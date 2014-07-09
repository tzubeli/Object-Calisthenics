package com.theladders.avital.oc.print;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atzubeli on 6/25/14.
 */
public class ConsoleAppPrinter implements ApplicationsPrinter {

    private List<String> list = new ArrayList<>();


    public void createHeader() {

        System.out.println("Date    Jobseeker   Job     Employer");

    }

    public void print(String string) {

        list.add(string);

    }

    public void run() {

        if (list.size()>0)

            printList();

        System.out.println(" ");

    }

    private void printList(){

        for (int i = 0; i < 4; i++)

            System.out.print(list.get(i) + "\t");

    }

    public void clear(){

        list.clear();
    }

    public void close() {


    }


}


