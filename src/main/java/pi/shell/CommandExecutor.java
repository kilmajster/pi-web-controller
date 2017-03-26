package pi.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExecutor {

    public static String run(String command) throws InterruptedException, IOException {
        Process p = Runtime.getRuntime().exec(command);
        p.waitFor();

        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        StringBuffer sb = new StringBuffer();

        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        
        return sb.toString();
    }
}
