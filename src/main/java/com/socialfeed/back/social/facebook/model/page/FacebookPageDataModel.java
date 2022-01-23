package com.socialfeed.back.social.facebook.model.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FacebookPageDataModel {

    @JsonProperty("access_token")
    private String accessToken;

    private String category;

    @JsonProperty("category_list")
    private List<FacebookPageCategoryModel> categoryList;

    private String name;
    private String id;
    private List<String> tasks;

}
