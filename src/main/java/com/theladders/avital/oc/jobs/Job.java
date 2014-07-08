package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.print.AggregateCountPrinter;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.ListPrinter;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Name;

/**
 * Created by atzubeli on 6/25/14.
 */
public abstract class Job implements Comparable<Job> {

    private Employer employer;

    private Name name;


    public Job(Employer employer, Name name){

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

    public void print(AggregateCountPrinter printer){

        employer.print(printer);

        name.print(printer);

    }

    public void print(ListPrinter printer){

        employer.print(printer);

        name.print(printer);

        printer.run();
    }

    public int compareTo(Job other) {

        return name.compareTo(other.name);

    }
}
