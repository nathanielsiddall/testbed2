import Controllers.operations;

public class main {

    public static void main(String[] args){

        //ops.go is the trigger to run the main program
        operations ops = new operations();
        System.out.println("make sure that your input file is in JSON/input on the desktop");
                ops.go(ops.getStringInput("what is the input filename with no suffix?"),
                        ops.getStringInput("what is the output file name with no suffix?"));


    }
}