import java.util.ArrayList;
import java.util.List;

public class crimeObject {
    private String reportNumber;
    private String charge;
    private String DTG;
    private String address;
    private String chargeNumber;

    public String getChargeNumber() {
        return chargeNumber;
    }

    public void setChargeNumber(String chargeNumber) {
        this.chargeNumber = chargeNumber;
    }

    public crimeObject(String reportNumber, String charge, String DTG, String address, String chargeNumber) {
        this.reportNumber = reportNumber;
        this.charge = charge;
        this.DTG = DTG;
        this.address = address;
        this.chargeNumber = chargeNumber;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getDTG() {
        return DTG;
    }

    public void setDTG(String DTG) {
        this.DTG = DTG;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




}




