package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Name;

/**
 * Created by atzubeli on 6/25/14.
 */
public class JobJReq implements Job{


    Employer employer;

    Name name;


    public JobJReq(Employer employer, Name name, JobManager jobManager){


        this.employer = employer;
        this.name = name;

        jobManager.createJobKey(employer, this);

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


    }
}
