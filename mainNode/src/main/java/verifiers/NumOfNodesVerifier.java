package verifiers;

public class NumOfNodesVerifier {

    //check if the nodeNumber entered is an integer
    public static boolean verify( String number){

        try {
            Integer.parseInt(number);
        }
        catch (NumberFormatException e){
            return false;
        }

        return true;
    }
}
