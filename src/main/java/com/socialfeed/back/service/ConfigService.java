package com.socialfeed.back.service;

import com.socialfeed.back.entity.Config;

public interface ConfigService {

    Config getConfigFindByKey(String key);

    Config save(Config config);

    void initialize(String key, String value);

}
