package Models;

public class CrimesJson {

    private String addresses;
    private String crime;
    private String weight;
    private String dateTime;

    public CrimesJson(/*coordinates coordinates,*/  String addresses, String crime, String weight, String dateTime) {
        this.addresses = addresses;

        this.crime = crime;
        this.weight = weight;
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
