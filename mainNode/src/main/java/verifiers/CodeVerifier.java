package verifiers;

import writers.TextFileWriter;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class CodeVerifier {

    private static String path="/";
    private static String filePath;

   //save the code on a java file, the checks if it compiles correctly
    public static boolean verify( String code, String className){

        filePath = path+ className+".java";
        saveFile(code);
        boolean isCorrectlyCompiled= compile();
        return isCorrectlyCompiled;
    }

    //create java file and save the code to it
    private static void saveFile(String code){

        TextFileWriter.write(filePath, code);
    }

    //compile java file,  return true if the compilation succeeded, and false otherwise
    public static boolean compile(){

        File sourceFile = new File(filePath);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(
                null, null, null);

        try {
            fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays
                    .asList(new File(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean success = compiler.getTask(null, fileManager, null, null, null,
                fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile)))
                .call();

        return success;
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        CodeVerifier.path = path;
    }



}
