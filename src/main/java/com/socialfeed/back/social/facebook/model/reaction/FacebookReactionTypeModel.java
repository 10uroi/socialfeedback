package com.socialfeed.back.social.facebook.model.reaction;

import lombok.Data;

import java.util.List;

@Data
public class FacebookReactionTypeModel {

    private List<String> data;
    private FacebookReactionSummaryModel summary;

}
