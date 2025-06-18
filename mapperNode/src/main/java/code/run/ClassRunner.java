package code.run;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassRunner {


    String directoryPath;
    String className;

    public ClassRunner(String directoryPath, String className) {
        this.directoryPath = directoryPath;
        this.className = className;
    }

    //load compiled class into the memory
    public Class<?> run( ){

        Class<?> thisClass= null;
        try {

            URL[] urls = getUrlArray();

            ClassLoader loader = new URLClassLoader(urls);
            thisClass = loader.loadClass(className);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return thisClass;
    }

    //return directory path as an URL array
    private URL[] getUrlArray() throws MalformedURLException {

        File file =new File(directoryPath);
        URL url = file.toURL();
        URL[] urls = new URL[] { url };
        return urls;

    }
}
