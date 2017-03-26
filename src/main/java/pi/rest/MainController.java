package pi.rest;

import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pi.domain.StatusDTO;
import pi.shell.CommandExecutor;

@RestController
@RequestMapping("/rest-api")
public class MainController {
    
    @GetMapping("/status")
    public @ResponseBody StatusDTO status() throws IOException, InterruptedException {
        StatusDTO status = new StatusDTO();
        
        status.setUptime(CommandExecutor.run("uptime"));
        
        return status;
    }
}
