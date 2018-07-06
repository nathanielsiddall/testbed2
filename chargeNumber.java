public class chargeNumber {
    private String charge;
    private String id;

    public chargeNumber(String charge, String id) {
        this.charge = charge;
        this.id = id;
    }

    public String getCharge() {
        return charge;
    }

    public String getSet() {
        String set = charge+ " " + id;

        return set;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
