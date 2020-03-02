package verifiers;

import java.io.File;

public class OutputFileVerifier {

    //check if the output directory exist
    public static boolean verify( String path){
        File file =new File(path);
        if ( !file.isDirectory()){
            return false;
        }
        return true;
    }
}
