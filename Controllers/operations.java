package Controllers;

import Controllers.ChargeManipulator;
import Controllers.CoordConverter;
import Controllers.addressChanger;
import Controllers.jsonParser;
import Models.CrimesJson;
import Models.chargeNumber;
import Models.coordinates;
import Models.crimeObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class operations {

//this takes the name of the crimes and converts it through a switch statement into c numbered crime weight.
    public String weightCalculator(String id) {

        int strID = parseInt(id);
        String weight = "";

        switch (strID) {
            case 0://0 THEFT OF SERVICE $100 TO < $750
                weight = "1";
                break;
            case 1://1 THEFT $100 TO < $750
                weight = "1";
                break;
            case 2://2 BURG BLDG W-INTENT COMMIT THEFT
                weight = "1";
                break;
            case 3://3 THEFT UNDER $100
                weight = "1";
                break;
            case 4://4 ROBBERY INDIVIDUAL
                weight = "9";
                break;
            case 5://5 THEFT $750 TO < $2,500
                weight = "1";
                break;
            case 6://6 THEFT OF SERVICE UNDER $100
                weight = "1";
                break;
            case 7://7 AGG ROBBERY INDIVIDUAL
                weight = "10";
                break;
            case 8://8 IDENTITY THEFT BY ELECTRONIC DEVICE
                weight = "8";
                break;
            case 9://9 BURG HAB INTENT THEFT/FELONY
                weight = "0";
                break;
            case 10://10 THEFT $2,500 TO < $30,000
                weight = "2";
                break;
            case 11://11 THEFT $2,500 TO < $30,000 VEHICLE
                weight = "8";
                break;
            case 12://12 ROBBERY BUSINESS
                weight = "6";
                break;
            case 13://13 ATT BURG COIN-OP MACHINE
                weight = "1";
                break;
            case 14://14 BURGLARY BUILDING-INTENT THEFT/FELONY
                weight = "3";
                break;
            case 15://15 THEFT OF SERVICE $2,500 TO < $30,000
                weight = "1";
                break;
            case 16://16 BURGLARY BUILDING-NO FORCE
                weight = "3";
                break;
            case 17://17 THEFT FIREARM
                weight = "1";
                break;
            case 18://18 BURGLARY HABITATION-NO FORCE
                weight = "z";
                break;
            case 19://19 BURG HAB-INTENT COMMIT ASSAULT
                weight = "9";
                break;
            case 20://20 SEXUAL ASSAULT
                weight = "10";
                break;
            case 21://21 THEFT $2,500 TO < $30,000 (ATT)
                weight = "1";
                break;
            case 22://22 THEFT PERSON
                weight = "8";
                break;
            case 23://23 MURDER/19.02 PC/F1
                weight = "8";
                break;
            case 24://24 THEFT UNDER $2,500 ENHANCED
                weight = "1";
                break;
            case 25://25 THEFT $30,000 TO < $150,000
                weight = "1";
                break;
            case 26://26 AGG ROBBERY INDIVIDUAL-VEHICLE
                weight = "9";
                break;
            case 27://27 BURG COIN-OP MACHINE
                weight = "1";
                break;
            case 28://28 THEFT $1,500 TO <$10,000 (CARGO)
                weight = "1";
                break;
            case 29://29 BURG HAB-INT COM FEL-NO FORCE
                weight = "5";
                break;
            case 30://30 THEFT $30,000 TO < $150,000 VEHICLE
                weight = "8";
                break;
            case 31://31 THEFT ALUM/BRONZE/COPPER <$20,000
                weight = "1";
                break;
            case 32://32 AGG ROBBERY BUSINESS
                weight = "7";
                break;
            case 33://33 KIDNAPPING
                weight = "10";
                break;
            case 34://34 THEFT $100 TO <750-ELDERLY
                weight = "3";
                break;
            case 35://35 BURG HAB-INTENT COMMIT FEL-FORCE
                weight = "7";
                break;
            case 36://36 SEXUAL ASSAULT - CHILD
                weight = "10";
                break;
            default:weight = "5";
                break;
        }
        return weight;
    }

//this was supposed to be the interface for the CoordConverter. see the class for more details.
    public ArrayList<coordinates> coordConverter(ArrayList<String> addresses) {
        CoordConverter coord = new CoordConverter();
        ArrayList<coordinates> coords = new ArrayList<>();

        for (int i = 0; i < addresses.size(); i++) {

            String theAddress = addresses.get(i);
        }
        return coords;
    }

//primary run function.
    // it runs JsonParser, which takes the .json file and converts it into a usable java object.
    //then it runs it through thecharge manipulator to get the crime numbers and weights.
    //then it runs it through the address changer to convert the addresses to get a usable number.
    //it the converts it into a JSON format with Gson
    //it will sout the file to be polished and inputted into a .json file/
    public void go() {
        jsonParser json = new jsonParser();
        System.out.println("json parser done");
        addressChanger address = new addressChanger();
        ChargeManipulator chargeManipulator = new ChargeManipulator();

        ArrayList<String> charges1 = chargeManipulator.collectCharges();
        ArrayList<chargeNumber> charges2 = chargeManipulator.changeCharges(charges1);

        ArrayList<String> newAddresses = address.changeAddress(json);
        System.out.println("finished fixing the address");

        ArrayList<crimeObject> charges3 = chargeManipulator.addChargeNumber(charges2, json);
        System.out.println("finished numbering the charges");

        ArrayList<CrimesJson> finalJson = new ArrayList<>();


        for (int i = 0; i < newAddresses.size(); i++) {

            String dateTime = json.getJson().get(i).getDTG();
            String weight = weightCalculator(charges3.get(i).getChargeNumber());
            String charge = charges3.get(i).getChargeNumber();

            CrimesJson thing = new CrimesJson(newAddresses.get(i), charge, weight, dateTime);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            finalJson.add(thing);
            System.out.println(gson.toJson(finalJson));
        }
        System.out.println("finished creating the json object");
    }
}



