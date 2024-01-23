package uz.b2c.kapitalbank.observability.autoconfiguration;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import uz.b2c.kapitalbank.observability.autoconfiguration.property.LoggingPropertySource;

@Configuration
public class PropertySourcePreparedListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        LoggingPropertySource propertySource = new LoggingPropertySource();
        System.out.println("Loading last config");
        environment.getPropertySources().addLast(propertySource);
    }
}