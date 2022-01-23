package com.socialfeed.back.social.facebook.model.post;

import com.socialfeed.back.social.facebook.model.paging.FacebookPagingModel;
import lombok.Data;

import java.util.List;

@Data
public class FacebookPostModel {

    private List<FacebookPostDataModel> data;
    private FacebookPagingModel paging;

}
