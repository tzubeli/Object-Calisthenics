package com.example.objectcalisthenics.Report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by atzubeli on 6/17/14.
 */
public class HTMLGenerator implements ReportGenerator {

    public void print(ApplicationReport report, String fileName) {

        try {
            FileWriter fileWriter = new FileWriter(fileName+".html");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("<html><head><title>Application Report</title></head><body>");
            bufferedWriter.write(report.toString());
            bufferedWriter.write("</body></html>");

            bufferedWriter.close();


            //HTML TABLE
        }
        catch(IOException e) {

            e.printStackTrace();
        }

    }
}
