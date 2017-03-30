package pi.rest;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pi.domain.StatusDTO;
import pi.factories.Converters;
import pi.factories.Factory;
import pi.service.GpioServiceBean;
import pi.shell.CommandExecutor;

@RestController
@RequestMapping("/rest-api")
public class MainController {
    
    @Autowired
    private GpioServiceBean gpioService;
    
    @GetMapping("/status")
    public @ResponseBody StatusDTO status() throws IOException, InterruptedException {
        return Factory.create(null, Converters.STATUS);
    }
    
    @GetMapping("/shell")
    public String shell(@RequestParam(value = "cmd", defaultValue = "") String command) throws InterruptedException, IOException {
        return CommandExecutor.run(command);
    }
    
    @GetMapping("/led")
    public void led(@RequestParam(value = "state", defaultValue = "false") boolean state) {
        gpioService.led(state);
    }
}
