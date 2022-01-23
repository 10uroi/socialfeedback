package com.socialfeed.back.service.impl;

import com.socialfeed.back.entity.Config;
import com.socialfeed.back.repository.ConfigRepository;
import com.socialfeed.back.service.ConfigService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class ConfigServiceImpl implements ConfigService {

    private static final Logger logger = LoggerFactory.getLogger(ConfigServiceImpl.class);

    private final ConfigRepository configRepository;

    public Config getConfigFindByKey(String key) {
        return configRepository.findByKey(key).orElse(null);
    }

    @Override
    public Config save(Config config) {
        if (config == null) return null;
        return configRepository.save(config);
    }

    public void initialize(String key, String value) {
        Config config = getConfigFindByKey(key);
        if (config == null) {
            config = new Config();
            config.setKey(key);
            config.setValue(value);

            if (save(config) != null) logger.info(key + " icin bilgi kayit edildi");
            else logger.error(key + " icin bilgi kayit edilemedi");
        } else logger.info(key + " icin bilgi zaten mevcut");
    }

}
