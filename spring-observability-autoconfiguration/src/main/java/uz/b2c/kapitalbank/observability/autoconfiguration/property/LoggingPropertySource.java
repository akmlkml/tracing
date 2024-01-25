package uz.b2c.kapitalbank.observability.autoconfiguration.property;

import org.springframework.core.env.MapPropertySource;

import java.util.Map;

public class LoggingPropertySource extends MapPropertySource {
    public LoggingPropertySource() {
        super(
            "logging",
            Map.of(
                "logging.pattern.level",
                "%5p [${spring.application.name:},%X{traceId:-},%X{spanId:-},%X{sessionId:-}]")
        );
        System.out.println("Init logging config");
    }
}
