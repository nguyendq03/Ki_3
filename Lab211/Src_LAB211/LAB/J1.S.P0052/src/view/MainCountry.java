package view;

import model.EastAsiaCountries;
import Utils.GetData;
import controller.ManageEastAsiaCountries;
import java.util.ArrayList;

/**
 * MainCountry class for managing East Asia countries.
 * @author Admin
 */
public class MainCountry {

    public static void main(String[] args) {
        GetData getData = new GetData();
        ArrayList<EastAsiaCountries> EastAsiaCountriesList = new ArrayList<>();
        while (true) {
            // Step 1: Display menu
            ManageEastAsiaCountries.displayMenu();
            // Step 2: Input user's choice
            int choice = getData.getInt("Enter your choice: ", 1, 5);
            // Step 3: Perform function based on user's  choice
            switch (choice) {
                //Add country
                case 1:
                    ManageEastAsiaCountries.addCountryInformation(EastAsiaCountriesList);
                    break;
                //Display country just enter    
                case 2:
                    ManageEastAsiaCountries.getRecentlyEnteredInformation(EastAsiaCountriesList);
                    break;
                //Search information follow name country    
                case 3:
                    ManageEastAsiaCountries.searchInformationByName(EastAsiaCountriesList);
                    break;
                //Sort ascending follow EastAsiaCountriesList
                case 4:
                    ManageEastAsiaCountries.sortInformationByAscendingOrder(EastAsiaCountriesList);
                    break;
                //Exit program    
                case 5:
                    System.out.println("Successfully");
                    System.exit(0);
            }

        }
    }
}
