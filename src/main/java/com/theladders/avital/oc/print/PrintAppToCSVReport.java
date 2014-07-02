package com.theladders.avital.oc.print;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by atzubeli on 6/25/14.
 */
public class PrintAppToCSVReport implements ApplicationsPrinter {

    private List<String> list = new ArrayList<>();
    private FileWriter writer;


    public void createHeader() {

        try {
            writer = new FileWriter("applicationReport.csv");

            writer.append("date, ");
            writer.append("jobseeker, ");
            writer.append("job, ");
            writer.append("employer");
            writer.append('\n');
            writer.append('\n');

        }
        catch(IOException e) {

            e.printStackTrace();
        }
    }

    public void print(String string) {

        list.add(string);

    }

    public void run() {

        try {

            for (int i=0; i<3; i++){

                writer.append(list.get(i) + ", ");
            }
            writer.append(list.get(3));
            writer.append('\n');



        }
        catch(IOException e) {

            e.printStackTrace();
        }

    }

    public void clear(){

        list.clear();
    }

    public void close() {

        try {

        writer.flush();
        writer.close();

        }
        catch(IOException e) {

            e.printStackTrace();
        }

    }


}
