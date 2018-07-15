package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Crime {

    @SerializedName("reportNumber")
    @Expose
    private String reportNumber;
    @SerializedName("charge")
    @Expose
    private String charge;
    @SerializedName("DTG")
    @Expose
    private String dTG;
    @SerializedName("address")
    @Expose
    private String address;

    public Crime(String reportNumber, String charge, String dTG, String address, String chargeNumber) {
        this.reportNumber = reportNumber;
        this.charge = charge;
        this.dTG = dTG;
        this.address = address;
        this.chargeNumber = chargeNumber;
    }

    private String chargeNumber;

    public String getReportNumber() {
        return reportNumber;
    }

    public String getSet(){

        String set =reportNumber+ " "+ "\n" + charge+ " "+ "\n" + dTG+ " "+ "\n" + address + " "+ "\n"+ "\n";

        return set;
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
        return dTG;
    }

    public void setDTG(String dTG) {
        this.dTG = dTG;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getChargeNumber() {
        return chargeNumber;
    }

    public void setChargeNumber(String chargeNumber) {
        this.chargeNumber = chargeNumber;
    }
}