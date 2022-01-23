package com.socialfeed.back.social.facebook.model.post;

import lombok.Data;

@Data
public class FacebookPostDataModel {

    private String status_type;
    private String message;
    private String created_time;
    private String id;

}
