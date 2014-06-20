package com.example.objectcalisthenics.Report;

import java.util.ArrayList;

/**
 * Created by atzubeli on 6/20/14.
 */
public class ApplicationReports {

    ArrayList<Object[]> listOfReports = new ArrayList<Object[]>();

    public void addReport(Object[] details){

        listOfReports.add(details);

    }
}
