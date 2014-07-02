package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.CountPrinterConsole;
import com.theladders.avital.oc.print.ListPrinter;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Name;

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

    public void print(ApplicationsPrinter printer){

        name.print(printer);

        employer.print(printer);

        printer.run();

    }

    public void print(CountPrinterConsole printer){

        employer.print(printer);

        name.print(printer);

    }

    public void print(ListPrinter printer){

        employer.print(printer);

        name.print(printer);

        printer.run();
    }


}
