package controller;
import model.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Collections;
import Utils.GetData;
/**
 * ManageEastAsiaCountries class has 4 methods following with the requirement 
 *
 * @author Admin
 */
public class ManageEastAsiaCountries {

    /**
     * displayMenu function will display 5 choices for user want to input
     */
    public static void displayMenu() {
        System.out.println("                                                                          ");
        System.out.println("                                   MENU                                   ");
        System.out.println("==========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("==========================================================================");
    }

    /**
     * This method adds information of 3 new East Asia countries to the existing
     * list of countries. It prompts the user to input the country, code, name,
     * total, area and terrain of each country. It checks for duplicate country
     * codes and ensures that the input is valid. The method then adds the new
     * country information to the list and saves it to a file. Input the
     * information of 11 country
     * 
     * @param EastAsiaCountriesList the list of existing East Asia countries
     */
    public static void addCountryInformation(ArrayList<EastAsiaCountries> EastAsiaCountriesList) {
        //Initialize object to save and load file 
        SaveAndLoadFile saveandloadFile = new SaveAndLoadFile();
        //Initialize object getData to check user's input
        GetData getData = new GetData();
        //Load Country from file
        saveandloadFile.loadCountryFromFile(EastAsiaCountriesList);
        // Loop input 11 time
        for (int i = 1; i <= 1; i++) {
            //Initialize isDuplicate 
            boolean isDuplicate = false;
            String countryCode = "";
            //Use do-while if isDuplicate is false
            do {
                //Input countryCode by user
                countryCode = getData.getString("Enter code of country: ");
                //isDuplicate is false to run the loop
                isDuplicate = false;
                //Loop for information of user's input
                for (EastAsiaCountries country : EastAsiaCountriesList) {
                    //Check if user's input code equals countryCode
                    if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                        System.out.println("Error: Country code already exists, please input again!");
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);
            //Input countryName of user's input
            String countryName = getData.getString("Enter name of country: ").replaceAll("[^a-zA-Z\\s]", "");
            //Input totalArea of user's input
            float totalArea = (float) getData.getFloat("Enter total Area: ", 0, Float.MAX_VALUE);
            //Input terrainCountry of user's input
            String terrainCountry = getData.getString("Enter terrain of country: ").replaceAll("[^a-zA-Z\\s]", "");
            //Add information of use's input to ArrayList
            EastAsiaCountriesList.add(new EastAsiaCountries(terrainCountry, countryCode, countryName, totalArea));
            System.out.println("Add Successfully!");
            //Save information to file
            saveandloadFile.saveEastAsiaCountriesToFile(EastAsiaCountriesList);
            System.out.println("Save to file successfully!");

        }
    }

    /**
     * getRecentlyEnteredInformation function display information of user's
     * input
     *
     * @param EastAsiaCountriesList return information of user's input
     */
    public static void getRecentlyEnteredInformation(ArrayList<EastAsiaCountries> EastAsiaCountriesList) {
        //Check if eastAsiaCountries is empty
        if (EastAsiaCountriesList.size() == 0) {
            System.out.println("No country have been added yet, Please input information country !");
            return;
        }
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        //Loop to display information of user's input
        for (EastAsiaCountries eastAsiaCountries : EastAsiaCountriesList) {
            eastAsiaCountries.display();
        }
    }

    
    /**
     * This is a method that searches for information about a country in a list
     * of East Asian countries based on the input name.
     * 
     * @param EastAsiaCountriesList  returns information in ArrayList
     */
    public static void searchInformationByName(ArrayList<EastAsiaCountries> EastAsiaCountriesList) {
        GetData getData = new GetData();
        //Allowed user to input countryName
        String countryName = getData.getString("Enter the country name you want to search for: ");
        boolean found = false;
        //Loop to all countryName in ArrayList
        for (EastAsiaCountries eastAsiaCountries : EastAsiaCountriesList) {
            //If countryName of user's input equals user's input had been
            if (eastAsiaCountries.getCountryName().equalsIgnoreCase(countryName)) {
                //Display follow format
                System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
                //Display of information of user's search
                eastAsiaCountries.display();
                found = true;
                break;
            }
        }
        //If ArrayList has any country of user's input existed
        if (!found) {
            System.out.println("Country name does not exist !");
        }
    }

    /**
     * This is a method that sorts a list of East Asia countries in ascending
     * order based on their names
     * 
     * @param EastAsiaCountriesList return Array List of country
     */
    public static void sortInformationByAscendingOrder(ArrayList<EastAsiaCountries> EastAsiaCountriesList) {
        SaveAndLoadFile saveandLoadFile = new SaveAndLoadFile();
        //Use collection to sort
        Collections.sort(EastAsiaCountriesList);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        //Loop for eastAsiaCountriesList
        for (EastAsiaCountries eastAsiaCountries : EastAsiaCountriesList) {
            //After sorting, display information
            eastAsiaCountries.display();
        }
        // Saving sorted country after sort
        saveandLoadFile.saveEastAsiaCountriesToFile(EastAsiaCountriesList);
    }

}
