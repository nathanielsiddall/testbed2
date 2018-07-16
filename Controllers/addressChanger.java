package Controllers;

import java.util.ArrayList;

public class addressChanger {

//this converts the address from the 10XX main street format to the 1000 mainstreet format, and adds san antonio tx to the end
    public ArrayList<String> changeAddress(jsonParser address){

        ArrayList<String>AddressList = new ArrayList<>();

        for (int i = 0; i < address.getJson().size(); i++) {

            String newAddress = address.getJson().get(i).getAddress().replace("X", "0");
            AddressList.add(newAddress + " " + "San Antonio TX");
        }
        return AddressList;
    }

}








