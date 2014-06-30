package com.theladders.avital.oc.collections;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by atzubeli on 6/25/14.
 */
public class PrintToCSVReport implements ApplicationsPrinter {

    List<String> list = new ArrayList<>();


    public void print(String string) {

        list.add(string);



    }

    public void run() {

        try {
            FileWriter writer = new FileWriter("applicationReport.csv");

            writer.append("date, ");
            writer.append("jobseeker, ");
            writer.append("job, ");
            writer.append("employer");
            writer.append('\n');
            writer.append('\n');

            for (int i=0; i<3; i++){

                writer.append(list.get(i) + ", ");
            }
            writer.append(list.get(3));
            writer.append('\n');

            writer.flush();
            writer.close();

        }
        catch(IOException e) {

            e.printStackTrace();
        }



    }


}
