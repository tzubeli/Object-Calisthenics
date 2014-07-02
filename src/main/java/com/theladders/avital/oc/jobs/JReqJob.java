package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.ConsoleCountPrinter;
import com.theladders.avital.oc.print.ListPrinter;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Name;

/**
 * Created by atzubeli on 6/25/14.
 */
public class JReqJob implements Job{

    private Employer employer;

    private Name name;


    public JReqJob(Employer employer, Name name){

        this.employer = employer;
        this.name = name;

    }

    public String toString(){

        return name.toString();
    }

    public void print(ApplicationsPrinter printer){

        name.print(printer);

        employer.print(printer);

        printer.run();

    }

    public void print(ConsoleCountPrinter printer){

        employer.print(printer);

        name.print(printer);

    }

    public void print(ListPrinter printer){

        employer.print(printer);

        name.print(printer);

        printer.run();
    }
}