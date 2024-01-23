package uz.b2c.kapitalbank.observability.autoconfiguration;

import org.springframework.boot.actuate.autoconfigure.tracing.zipkin.ZipkinAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@AutoConfiguration
@ImportAutoConfiguration(exclude = ZipkinAutoConfiguration.class)
public class ObservabilityAutoConfiguration {
    public ObservabilityAutoConfiguration() {
        System.out.println("Init ObservabilityAutoConfiguration");
    }
}
