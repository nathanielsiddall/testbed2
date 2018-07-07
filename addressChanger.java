import java.util.ArrayList;

public class addressChanger {

    public ArrayList<String> changeAddress(jsonParser address){

        ArrayList<String>AddressList = new ArrayList<>();

        for (int i = 0; i < address.getJson().size(); i++) {

        String newAddress = address.getJson().get(i).getAddress().replace("X", "0");
        AddressList.add(newAddress);
        }
        return AddressList;
    }
}








