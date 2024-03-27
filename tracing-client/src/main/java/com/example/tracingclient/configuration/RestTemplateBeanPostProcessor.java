//package com.example.tracingclient.configuration;
//
//import com.example.tracingclient.configuration.interceptor.RequestLoggingInterceptor;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//@Slf4j
//@Component
//@AllArgsConstructor
//public class RestTemplateBeanPostProcessor implements BeanPostProcessor, Ordered {
//    RequestLoggingInterceptor loggingInterceptor;
//
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if (bean instanceof RestTemplate) {
//            ((RestTemplate) bean).getInterceptors()
//                .add(loggingInterceptor);
//        }
//        return bean;
//    }
//
//    @Override
//    public int getOrder() {
//        return LOWEST_PRECEDENCE;
//    }
//}
