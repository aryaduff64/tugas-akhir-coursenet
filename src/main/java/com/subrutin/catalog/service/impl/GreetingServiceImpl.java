package com.subrutin.catalog.service.impl;

import com.subrutin.catalog.config.ApplicationProperties;
import com.subrutin.catalog.config.CloudProperties;
import com.subrutin.catalog.service.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.TimeZone;

@Service
public class GreetingServiceImpl implements GreetingService {

    private ApplicationProperties appProperties;

    private CloudProperties cloudProperties;

    public GreetingServiceImpl(ApplicationProperties appProperties, CloudProperties cloudProperties) {
        this.appProperties = appProperties;
        this.cloudProperties = cloudProperties;
    }

    @Override
    public String sayGreeting() {
        System.out.println(cloudProperties.getApiKey());
        TimeZone timezone = TimeZone.getTimeZone(appProperties.getTimezone());
        return appProperties.getWelcomeText()+", our timezone :"+timezone.getDisplayName()+
                ", our currency:"+appProperties.getCurrency();
    }
}
