package com.theladders.avital.oc.print;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atzubeli on 7/1/14.
 */
public class CountPrinterConsole {

    List<String> list = new ArrayList<>();


    public void createHeader() {

        System.out.println("Employer    Job     Count");

    }

    public void print(String string) {

        list.add(string);

    }

    public void run() {

        if (list.size()>0){

            for (int i=0; i<3; i++){

                System.out.print(list.get(i) + "\t");
            }}
        System.out.println(" ");

    }

    public void clear(){

        list.clear();
    }


}
