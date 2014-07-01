package com.theladders.avital.oc.print;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by atzubeli on 7/1/14.
 */
public class PrintToHTMLReport implements ApplicationsPrinter{

    List<String> list = new ArrayList<>();
    FileWriter writer;


    public void createHeader() {

        try {
            writer = new FileWriter("applicationReport.html");

            writer.append("<!DOCTYPE html>\n<html>\n<body>\n<table border=\"2\">\n<tr>\n");

            writer.append("<th>Date</th>\n");
            writer.append("<th>Jobseeker</th>\n");
            writer.append("<th>Job </th>\n");
            writer.append("<th>Employer</th>\n");
            writer.append("<tr>\n");

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

            for (int i=0; i<4; i++){

                writer.append("<td>"+list.get(i) + "</td>\n");
            }

            writer.append('\n');
            writer.append("</tr>");

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

            writer.append("</table>\n</body>\n</html>\n");

            writer.flush();
            writer.close();

        }
        catch(IOException e) {

            e.printStackTrace();
        }

    }

}
