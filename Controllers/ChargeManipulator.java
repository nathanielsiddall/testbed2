package Controllers;

import Models.chargeNumber;
import Models.crimeObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class ChargeManipulator {

//this returns a list of the charges with no duplicates.
    public ArrayList<String> collectCharges(String inputFileName) {

        JsonParser thing = new JsonParser(inputFileName);
        LinkedHashSet<String> list = new LinkedHashSet<>();

        for (int i = 0; i < thing.getJson().size(); i++) {

            String charge = thing.getJson().get(i).getCharge();
            list.add(charge);
        }
        ArrayList<String> numberedList = new ArrayList<>();

        Iterator<String> setIterator = list.iterator();

        int i = 0;
        while (setIterator.hasNext()) {
            numberedList.add(setIterator.next());

            i++;
        }
        return numberedList;
    }
//this takes that numbered list and adds numbers to it.
    public ArrayList<chargeNumber> changeCharges(ArrayList<String> list){

        ArrayList<chargeNumber> charges = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            String si =String.valueOf(i);
            charges.add(new chargeNumber(list.get(i), si));
        }
        return charges;
    }

//this takes the list from changeCharges and the json crimeobject and returns a new crime object with chargenumbers added.
    public ArrayList<crimeObject> addChargeNumber(ArrayList<chargeNumber> chargeNumbers, JsonParser crimeObject){
        ArrayList<crimeObject> crimes = new ArrayList<>();

        for (int i = 0; i < crimeObject.getJson().size(); i++) {

            for (int j = 0; j < chargeNumbers.size(); j++) {
                String CO = crimeObject.getJson().get(i).getCharge();
                String CN = chargeNumbers.get(j).getCharge();

                if (CO.equals(CN)){
                    crimes.add(new crimeObject(
                            crimeObject.getJson().get(i).getReportNumber(),
                            crimeObject.getJson().get(i).getCharge(),
                            crimeObject.getJson().get(i).getDTG(),
                            crimeObject.getJson().get(i).getAddress(),
                            chargeNumbers.get(j).getId()
                            )
                    );
                }
            }
        }
        return crimes;
    }
}





