package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.collections.ApplicationsPrinter;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Name;

import java.util.ArrayList;

/**
 * Created by atzubeli on 5/21/14.
 */
public class JobATS implements Job{

    Employer employer;

    Name name;


    public JobATS(Employer employer, Name name){

        this.employer = employer;
        this.name = name;

    }

    public String toString(){

        return name.toString();
    }

    public String toPrint(){

        return employer.toString()+ ": " + name.toString();

    }

    public void print(ApplicationsPrinter printer){

        name.print(printer);

        employer.print(printer);

        printer.run();


    }




}
