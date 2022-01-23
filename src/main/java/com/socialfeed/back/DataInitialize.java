package com.socialfeed.back;

import com.socialfeed.back.configuration.Properties;
import com.socialfeed.back.entity.Config;
import com.socialfeed.back.service.ConfigService;
import com.socialfeed.back.social.facebook.service.FacebookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DataInitialize {

    private static final Logger logger = LoggerFactory.getLogger(DataInitialize.class);

    private final ConfigService configService;

    @EventListener(ApplicationStartedEvent.class)
    public void facebookTokenInitialize() {
        configService.initialize(Properties.FACEBOOK_TOKEN_KEY, Properties.FACEBOOK_TOKEN_VALUE);
        configService.initialize(Properties.FACEBOOK_APP_ID_KEY, Properties.FACEBOOK_APP_ID_VALUE);
        configService.initialize(Properties.FACEBOOK_APP_SECRET_KEY, Properties.FACEBOOK_APP_SECRET_VALUE);
        configService.initialize(Properties.FACEBOOK_ME_KEY, Properties.FACEBOOK_ME_VALUE);

        test();
    }

    private final FacebookService facebookService;

    public void test() {
        facebookService.getFacebookPageJob();
    }

}
