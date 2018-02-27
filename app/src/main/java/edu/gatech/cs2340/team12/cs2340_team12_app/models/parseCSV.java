package edu.gatech.cs2340.team12.cs2340_team12_app.models;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import com.opencsv.CSVReader;

/**
 * Created by caleb on 2/27/2018.
 */

public class parseCSV {
    @SuppressWarnings("resource")
    public void parse(String csvFileName) throws Exception
    {
        //Build reader instance
        //Default seperator is comma
        //Default quote character is double quote
        //Start reading from line number 2 (line numbers start from zero)
        CSVReader reader = new CSVReader(new FileReader(csvFileName + ".csv"),
                ',' , '"' , 1);

        //Read CSV line by line and use the string array as you want
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                //Verifying the read data here
                System.out.println(Arrays.toString(nextLine));
            }
        }
    }
}
