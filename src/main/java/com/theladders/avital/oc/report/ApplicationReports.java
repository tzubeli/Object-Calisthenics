package com.theladders.avital.oc.report;

import java.util.ArrayList;

/**
 * Created by atzubeli on 6/20/14.
 */
public class ApplicationReports {

    List<Object[]> listOfReports = new ArrayList<Object[]>();

    public void addReport(Object[] details){

        listOfReports.add(details);

    }
}
