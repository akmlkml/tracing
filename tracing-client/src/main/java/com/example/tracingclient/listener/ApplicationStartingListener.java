package com.example.tracingclient.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.appender.mom.kafka.KafkaAppender;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class ApplicationStartingListener implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        log.info("Handling ApplicationStartingEvent here!");
    }
}
