package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.print.ListPrinter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by atzubeli on 7/8/14.
 */
public class ResultList {

    private ArrayList<Job> success = new ArrayList<>();
    private ArrayList<Job> failure = new ArrayList<>();


   public void addSuccess(Job job){

       success.add(job);

   }

    public void addFailure(Job job){

        failure.add(job);

    }

    public void printResultList(ListPrinter printer){

        printer.createHeader("Failed Applications");

        Collections.sort(failure);

        for (Job job : failure){

            job.print(printer);
            printer.clear();
        }

        printer.createHeader("Successful Applications");

        Collections.sort(success);

        for (Job job : success){

            job.print(printer);
            printer.clear();
        }

    }

    public int getNumberOfFailures(){

        return failure.size();
    }


}
