package pi.rest;

import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pi.domain.StatusDTO;

@RestController
@RequestMapping("/rest-api")
public class MainController {
    
    @GetMapping("/status")
    public @ResponseBody StatusDTO status() throws IOException, InterruptedException {
        StatusDTO status = new StatusDTO();
        
        status.setUptime("test result");
//        //Build command 
//        List<String> commands = new ArrayList<String>();
//        commands.add("uptime");
//
//        //Run macro on target
//        ProcessBuilder pb = new ProcessBuilder(commands);
//        pb.directory(new File("/home/pi"));
//        pb.redirectErrorStream(true);
//        Process process = pb.start();
//        
//        //Read output
//        StringBuilder out = new StringBuilder();
//        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String line = null, previous = null;
//        while ((line = br.readLine()) != null)
//            if (!line.equals(previous)) {
//                previous = line;
//                out.append(line).append('\n');
//                System.out.println(line);
//            }
//
//        //Check result
//        if (process.waitFor() == 0) {
//            System.out.println("Success!");
//            System.exit(0);
//        }
//        
//        System.out.println("commands: " + commands);
//        System.out.println("output: " + out);
//        
//        status.setUptime(out.toString());
        
        return status;
    }
}
