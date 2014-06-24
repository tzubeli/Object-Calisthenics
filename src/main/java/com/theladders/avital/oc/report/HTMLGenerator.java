package com.theladders.avital.oc.report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by atzubeli on 6/17/14.
 */
public class HTMLGenerator implements ReportGenerator {

    public void print(Object[] reportDetails) {

        try {
            FileWriter fileWriter = new FileWriter("ApplicationReport.html");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("<html><head><title>Application Report</title></head><body>");

            bufferedWriter.write("</body></html>");

            bufferedWriter.close();


            //HTML TABLE
        }
        catch(IOException e) {

            e.printStackTrace();
        }

    }
}
