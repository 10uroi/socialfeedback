package com.socialfeed.back.schedulejob;

import com.socialfeed.back.social.facebook.service.FacebookService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
@RequiredArgsConstructor
public class ServiceJob {

    private final FacebookService facebookService;

    @Async
    @Scheduled(cron = "0 0 21 * * *")
    public void scheduleFacebookJob() {
        System.out.println("Deneme");
        facebookService.getFacebookPageJob();
    }

}
