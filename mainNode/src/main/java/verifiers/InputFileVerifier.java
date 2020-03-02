package verifiers;

import java.io.File;

public class InputFileVerifier {

    //check if the input file exist
    public static boolean verify( String path){
        File file =new File(path);
        if (!file.exists() || file.isDirectory()){
            return false;
        }
        return true;
    }
}
