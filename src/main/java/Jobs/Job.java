package main.java.Jobs;

import main.java.User.Employer;

import java.util.ArrayList;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Job {

    Employer employer;

    JobDescription description;



    public Job(Employer employer, JobDescription description){

        this.employer = employer;
        this.description = description;


    }


    public boolean requiresResume(){

        return description.requiresResume();
    }

    public ArrayList<Object> getReportDetails(){

        ArrayList<Object> details = new ArrayList<>();
        details.add(this);
        details.add(employer);

        return details;
    }


    public String toString(){

        return description.toString();
    }

    public String toPrint(){

        return employer.toString()+ ": " + description.toString();

    }




}
