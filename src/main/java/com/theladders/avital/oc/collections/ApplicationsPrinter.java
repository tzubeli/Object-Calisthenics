package com.theladders.avital.oc.collections;

import com.theladders.avital.oc.jobApplications.ApplicationsList;

import java.io.IOException;

/**
 * Created by atzubeli on 6/25/14.
 */
public interface ApplicationsPrinter {

    public void createHeader();

    public void print(String string);

    public void run();

    public void close();





    }

