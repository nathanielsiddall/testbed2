import java.io.FileNotFoundException;

public class main {

    public static void main(String[] args) throws FileNotFoundException {

        operations ops = new operations();
//ops.go is the trigger to run the main program
//        ops.go();

        CoordConverter coord = new CoordConverter();

        //ok this is how we do. the coordConverter is returning lats and long. the string variables below are returning what we want.
        // still need to figure out how to make it its own method and a list to loop all the addresses coming from th address changer.
        //also the wiring needs to be hidden back behind the operations.class

        String address = "1000 S FRIO ST";

        String lat = String.valueOf(coord.coordGetter(address).location.lat);
        String lng = String.valueOf(coord.coordGetter(address).location.lng);

        System.out.println(lat + " " + lng);
    }
}

