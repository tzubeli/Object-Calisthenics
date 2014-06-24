package com.theladders.avital.oc.report;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by atzubeli on 6/17/14.
 */
public class CSVGenerator implements ReportGenerator {


    public void print(Object[] reportDetails) {

        try {
            FileWriter writer = new FileWriter("ApplicationReport.csv");

            writer.append("Job, Employer, Jobseeker, Resume, Date");

            writer.append("--------------------------------------");

            for (int i = 0; i<reportDetails.length; i++){

                if (reportDetails[i] == null) {
                    writer.append("none");
                    continue;
                }

                writer.append(reportDetails[i].toString()+", ");
                System.out.println(reportDetails[i].toString());
            }

            writer.flush();
            writer.close();

        }
        catch(IOException e) {

            e.printStackTrace();
        }

    }
}
