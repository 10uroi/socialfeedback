package com.socialfeed.back.social.facebook.mapper;

import com.socialfeed.back.social.facebook.entity.FacebookPage;
import com.socialfeed.back.social.facebook.entity.FacebookPost;
import com.socialfeed.back.social.facebook.entity.FacebookReaction;
import com.socialfeed.back.social.facebook.model.page.FacebookPageDataModel;
import com.socialfeed.back.social.facebook.model.page.FacebookPageModel;
import com.socialfeed.back.social.facebook.model.post.FacebookPostDataModel;
import com.socialfeed.back.social.facebook.model.post.FacebookPostModel;
import com.socialfeed.back.social.facebook.model.reaction.FacebookReactionModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FacebookMapper {

    public static List<FacebookPage> getFacebookPage(FacebookPageModel facebookPageModel) {
        List<FacebookPage> facebookPageList = new ArrayList<>();
        for (FacebookPageDataModel fa : facebookPageModel.getData()) {
            facebookPageList.add(FacebookPage.builder()
                    .dataId(fa.getId())
                    .accessToken(fa.getAccessToken())
                    .category(fa.getCategory())
                    .name(fa.getName())
                    .dbCreateDate(new Date())
                    .tasks(fa.getTasks().stream().collect(Collectors.joining(",")))
                    .after(facebookPageModel.getPaging().getCursors().getAfter())
                    .before(facebookPageModel.getPaging().getCursors().getBefore()).build());
        }
        return facebookPageList;
    }

    public static List<FacebookPost> getFacebookPost(FacebookPostModel facebookPostModel) {
        List<FacebookPost> facebookPostList = new ArrayList<>();
        if (facebookPostModel != null && facebookPostModel.getData() != null)
            for (FacebookPostDataModel fa : facebookPostModel.getData()) {
                try {
                    facebookPostList.add(FacebookPost.builder()
                            .dataId(fa.getId())
                            .dbCreateDate(new Date())
                            .message(fa.getMessage())
                            .createdTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(fa.getCreated_time()))
                            .statusType(fa.getStatus_type())
                            .after(facebookPostModel.getPaging().getCursors().getAfter())
                            .before(facebookPostModel.getPaging().getCursors().getBefore()).build());
                } catch (Exception e) {
                }
            }
        return facebookPostList;
    }

    public static FacebookReaction getFacebookReaction(FacebookReactionModel facebookReactionModel) {
        return FacebookReaction.builder()
                .dataId(facebookReactionModel.getId())
                .totalCount(facebookReactionModel.getReactions().getSummary().getTotal_count())
                .dbCreateDate(new Date())
                .build();
    }
}
