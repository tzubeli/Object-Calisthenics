package com.theladders.avital.oc.print;

import com.theladders.avital.oc.jobs.Job;
import java.util.*;

/**
 * Created by atzubeli on 7/1/14.
 */
public class AggregateCount {

    private Map<Job, Integer> jobCount = new HashMap<>();

    public AggregateCount(){

    }

    private AggregateCount(Map<Job, Integer> jobCount){

        this.jobCount = jobCount;
    }


    public void add(Job job, int count) {

        jobCount.put(job, count);

    }


    public AggregateCount combinedWith(AggregateCount filtered){

        Map<Job, Integer> combined = new HashMap<>(jobCount);

        combined.putAll(filtered.jobCount);

        return new AggregateCount(combined);

    }

    public void printCount(ConsoleCountPrinter printer){

        printer.createHeader();

        for (Map.Entry<Job, Integer> entry : jobCount.entrySet()){

            entry.getKey().print(printer);

            printer.print(entry.getValue().toString());

            printer.run();

            printer.clear();
        }


    }


}
