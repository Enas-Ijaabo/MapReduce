package code.compiler;

import writers.FileWriter;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class CodeCompiler {

    private String filePath;
    private String code;

    public CodeCompiler( String code, String path, String className) {
        filePath = path+ className+".java";
        this.code= code;
    }

    //save the code on a java file, then compile it
    public  void compile(){

        saveFile(code);
        compileClass();
    }

    //create java file and save the code to it
    private void saveFile(String code){

        FileWriter.writeFile(filePath, code);
    }

    //compile java file,  return true if the compilation succeeded, and false otherwise
    private boolean compileClass(){

        File sourceFile = new File(filePath);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(
                null, null, null);

        try {
            fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays
                    .asList(new File("/")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean success = compiler.getTask(null, fileManager, null, null, null,
                fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile)))
                .call();

        return success;
    }


}
