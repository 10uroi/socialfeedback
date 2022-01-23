package com.socialfeed.back.social.facebook.model.page;

import com.socialfeed.back.social.facebook.model.paging.FacebookPagingModel;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class FacebookPageModel {

    private List<FacebookPageDataModel> data;
    private FacebookPagingModel paging;

}
