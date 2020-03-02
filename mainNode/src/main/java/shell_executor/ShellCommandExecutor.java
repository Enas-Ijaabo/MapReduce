package shell_executor;

import java.io.IOException;

public class ShellCommandExecutor {

    private static String shellPath= "/bin/bash";

    //execute a the command on the shell that path defined in the attribute shellPath
    public static synchronized void executeCommand( String command){

        try {
            Process process = Runtime.getRuntime().exec(
                    new String[]{shellPath, "-c", command} );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getShellPath() {
        return shellPath;
    }

    public static void setShellPath(String shellPath) {
        ShellCommandExecutor.shellPath = shellPath;
    }
}
