package com.theladders.avital.oc.collections;

import java.util.Collection;

/**
 * Created by atzubeli on 6/25/14.
 */
public class PrintToConsole implements CollectionPrinter {


    public void print(Collection collection) {

        for (Object object : collection){

            System.out.println(object.toString());
        }


    }
}

