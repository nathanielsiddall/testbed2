import java.util.ArrayList;

public class operations {
    public void go(){

//        this parses the json file and returns a list of crimeobjects
             jsonParser json = new jsonParser();
        System.out.println("json parser is done");


//the address changer requires the arrylist of crime objects from jsonParser.class.
//it returns an array list of the addressess after they have been corrected for the XX issue.
    addressChanger address = new addressChanger();
    ArrayList<String> newAddresses = address.changeAddress(json);

        System.out.println("address is done");




    ChargeManipulator man = new ChargeManipulator();

    ArrayList<String> charges1 = man.collectCharges();
        System.out.println("collect charges done");
    ArrayList<chargeNumber> charges2 = man.changeCharges(charges1);
        System.out.println("change charges done");
    ArrayList<crimeObject> charges3 = man.addChargeNumber(charges2, json);
        System.out.println("add charge number done");

      int ch3Siz = charges3.size() - 1;

        System.out.println(charges3.size());
        System.out.println(charges3.get(ch3Siz).getChargeNumber());


    }
}
