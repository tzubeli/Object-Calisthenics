package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.print.AggregateCountPrinter;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.ConsoleCountPrinter;
import com.theladders.avital.oc.print.ListPrinter;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Name;

/**
 * Created by atzubeli on 6/25/14.
 */
public class JReqJob extends Job{


    public JReqJob(Employer employer, Name name){

        super(employer, name);
    }

}
