package pi.factories;

import java.io.IOException;
import java.util.function.Function;
import pi.domain.StatusDTO;
import pi.shell.CommandExecutor;

public class Converters
{

    private static final String TEMP_SH = "/home/pi/temp.py";
    private static final String HUM_SH = "/home/pi/hum.py";

    public static final Function<Object, StatusDTO> STATUS = (Object o) -> {
        StatusDTO dto = new StatusDTO();
        try {
            dto.setHumidity(Long.valueOf(CommandExecutor.run(HUM_SH)));
            dto.setTemperature(Long.valueOf(CommandExecutor.run(TEMP_SH)));
            dto.setUptime(CommandExecutor.run("uptime"));
        } catch(IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return dto;
    };
}
