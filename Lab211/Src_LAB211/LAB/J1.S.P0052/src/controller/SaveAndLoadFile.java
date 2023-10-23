package controller;

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import model.EastAsiaCountries;

/**
 * Save and LoadFile has two methods LoadFromFile and SaveToFile
 *
 * @author Admin
 */
public class SaveAndLoadFile {
    public void loadCountryFromFile(ArrayList<EastAsiaCountries> EastAsiaCountries) {
        EastAsiaCountries.clear();
        try {
            File eastAsiaCountries = new File("EastAsiaCountries.txt");
            // Check if empty or not empty before read data
            if (!eastAsiaCountries.exists()) {
                return;
            }
            //Read file
            FileReader readAsiaCountries = new FileReader(eastAsiaCountries);
            //Support for FileReader to read less memory consuming and quickly
            BufferedReader supportedAsiaCountries = new BufferedReader(readAsiaCountries);
            String details;
            //Loop if file has data
            while ((details = supportedAsiaCountries.readLine()) != null) {
                //The method then uses StringTokenizer to read the data from the file with space as a delimiter
                StringTokenizer readData = new StringTokenizer(details, " ");
                String countryTerrain = readData.nextToken().trim();
                String countryCode = readData.nextToken().trim();
                String countryName = readData.nextToken().trim();
                float totalArea = Float.parseFloat(readData.nextToken().trim());
                // Creates an object of EastAsiaCountries class with the data read from the file, then adds it to the ArrayList
                EastAsiaCountries EastasiaCountries = new EastAsiaCountries(countryTerrain, countryCode, countryName, totalArea);
                EastAsiaCountries.add(EastasiaCountries);

            }
            //Closes the BufferedReader and FileReader
            supportedAsiaCountries.close();
            readAsiaCountries.close();
            // If an exception occurs, it prints the exception message
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method saves a list of East Asia countries to a file named
     * "EastAsiaCountries.txt".
     *
     * @param eastAsiaCountriesList is takes an ArrayList of EastAsiaCountries
     */
    public void saveEastAsiaCountriesToFile(ArrayList<EastAsiaCountries> eastAsiaCountriesList) {

        try {
            File File = new File("EastAsiaCountries.txt");
            //FileWriter supports writing data as characters or character arrays to files
            FileWriter fileWriter = new FileWriter(File);
            //PrintWriter provides methods to write data including characters, strings
            PrintWriter printWriter = new PrintWriter(fileWriter);
            //It iterates through the eastAsiaCountriesList and for each EastAsiaCountries
            for (EastAsiaCountries loopAsiaCountries : eastAsiaCountriesList) {
                //Then writes these values to the file using the printWriter.println() method
                printWriter.println(loopAsiaCountries.getCountryTerrain() + " " + loopAsiaCountries.getCountryCode() + " " + loopAsiaCountries.getCountryName()
                        + " " + loopAsiaCountries.getTotalArea());

            }
            //After writing all the data, it closes the printWriter and fileWriter objects to release system resources.
            printWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
