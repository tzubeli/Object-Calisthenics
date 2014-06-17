package com.example.objectcalisthenics.Report;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by atzubeli on 6/17/14.
 */
public class CSVGenerator implements ReportGenerator {


    public void print(ApplicationReport report, String fileName) {

        try {
            FileWriter writer = new FileWriter(fileName+".csv");

            writer.append(report.toString());  //TODO commas

            writer.flush();
            writer.close();

        }
        catch(IOException e) {

            e.printStackTrace();
        }

    }
}
