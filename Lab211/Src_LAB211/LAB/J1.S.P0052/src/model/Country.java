package model;

/**
 * This is a Java class called "Country" which contains three protected instance
 * variables: "countryCode", "countryName", and "totalArea".
 * @author Admin
 */
public class Country {
    protected String countryCode;
    protected String countryName;
    protected float totalArea;
    /**
     * Create constructors, one with no parameters
     */
    public Country() {
    }
    /**
     * Create constructors, with three parameters
     *
     * @param countryCode is code of country
     * @param countryName is name of country
     * @param totalArea is sum area
     */
    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }
    /**
     * Create constructors, one with no parameters
     *
     * @return values take from code of country
     */
    public String getCountryCode() {
        return countryCode;
    }
    /**
     * Create constructors, with a parameter
     *
     * @param countryCode is code of country have set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    /**
     * Create constructors, with no parameter
     *
     * @return name of country
     */
    public String getCountryName() {
        return countryName;
    }
    /**
     * Create constructors, with a parameter
     *
     * @param countryName is name of country have set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    /**
     * Create constructors, with no parameter
     *
     * @return sum of area
     */
    public float getTotalArea() {
        return totalArea;
    }
    /**
     * Create constructors, with a parameter
     *
     * @param totalArea is sum of area have set
     */
    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }
    /**
     * This method displays the country code, country name, and total area in a
     * formatted manner.
     */
    public void display(){
        System.out.printf("%-10s%-25s%-20.0f\n", this.countryCode,
                this.countryName, this.totalArea);
    }
}
