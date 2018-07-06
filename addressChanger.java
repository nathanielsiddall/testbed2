import java.util.ArrayList;

public class addressChanger {


    //these list and remove the duplicete crimes. and i think it numbers it too, i cant remember.
//         ChargeManipulator thing = new ChargeManipulator();

//        thing.collectCharges();

    //this is supposed to be changing the x's in the address but it isnt working. idk why.



public ArrayList<String> changeAddress(jsonParser address){

//    System.out.println(address.getJson().get(1).getSet());

    ArrayList<String>AddressList = new ArrayList<>();



    for (int i = 0; i < address.getJson().size(); i++) {

            String newAddress = address.getJson().get(i).getAddress().replace("X", "0");

//            System.out.println(newAddress);

            AddressList.add(newAddress);

//            System.out.println(i + " " + AddressList.get(i));


        }

    return AddressList;
}


}








