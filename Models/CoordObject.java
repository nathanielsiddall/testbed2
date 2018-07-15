package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.stream.Location;

public class CoordObject {

    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("locationType")
    @Expose
    private String locationType;
    @SerializedName("viewport")

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

}
