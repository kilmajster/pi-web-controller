package pi.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import pi.shell.CommandExecutor;

@Service
public class GpioServiceBean {

    public void led(boolean state) {
        System.out.println("state: " + state);
        try {
            CommandExecutor.run("gpio mode 1 out");
            
            if (state) {
                CommandExecutor.run("gpio write 1 1");
            } else {
                CommandExecutor.run("gpio write 1 0");
            }
        } catch (InterruptedException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
