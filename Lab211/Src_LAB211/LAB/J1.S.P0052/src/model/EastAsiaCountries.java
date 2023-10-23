package model;
/**
 * The above code defines a class called "EastAsiaCountries" which extends the
 * "Country" class and implements the "Comparable" interface.
 *
 * @author Admin
 */
public class EastAsiaCountries extends Country implements Comparable<EastAsiaCountries> {
    //Create  contains a private attribute called "countryTerrain"
    private String countryTerrain;
    /**
     * Create constructors, with no parameter.
     */
    public EastAsiaCountries() {
    }
    /**
     * This is a constructor for the EastAsiaCountries class, which is a
     * subclass of the Country class. It calls the superclass constructor to set
     * the country code, name, and total area.
     *
     * @param countryTerrain is String for terrain of country
     * @param countryCode is String for code of country
     * @param countryName is String for name of country
     * @param totalArea is float for sum of area
     */
    public EastAsiaCountries(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }
    /**
     * The getter method returns the value of the country terrain
     */
    public String getCountryTerrain() {
        return countryTerrain;
    }
    /**
     * The setter method sets the value of the country terrain to the specified
     * input.
     *
     * @param countryTerrain is String for terrain of country
     */
    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }
    /**
     * The class overrides the "display" method to display the country code,
     * country name, total area, and country terrain in a formatted manner.
     */
    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.0f%-25s\n", this.countryCode,
                this.countryName, this.totalArea, this.countryTerrain);
    }
    /**
     * Overrides the "compareTo" method to compare two EastAsiaCountries objects
     * based on their country names.Implement method compareTo in Comparable(java.lang)
     *
     * @param o the object to be compared.
     */
    @Override
    public int compareTo(EastAsiaCountries o) {
        return this.getCountryName().compareTo(o.getCountryName());
    }

}
