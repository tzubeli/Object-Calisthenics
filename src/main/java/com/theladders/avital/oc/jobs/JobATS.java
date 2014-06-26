package com.theladders.avital.oc.jobs;

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

    public void getReportDetails(){

        //TODO report stuff

        ArrayList<Object> details = new ArrayList<>();

        details.add(this);

        details.add(employer);

        //return details;
    }

    public void apply() {

    }

    public String toString(){

        return name.toString();
    }

    public void reportDetails() {

    }

    public String toPrint(){

        return employer.toString()+ ": " + name.toString();

    }




}
