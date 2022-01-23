package com.socialfeed.back.social.facebook.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.socialfeed.back.configuration.Properties;
import com.socialfeed.back.social.facebook.model.page.FacebookPageModel;
import com.socialfeed.back.social.facebook.model.post.FacebookPostModel;
import com.socialfeed.back.social.facebook.model.reaction.FacebookReactionModel;
import com.socialfeed.back.social.facebook.model.reaction.FacebookReactionTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FacebookRequest {

    private static final Logger logger = LoggerFactory.getLogger(FacebookRequest.class);

    public FacebookPageModel getFacebookPage(String me, String accessToken) {
        try {
            HttpResponse<String> jsonResponse
                    = Unirest.get(Properties.FACEBOOK_API_LINK + me + "/accounts?access_token=" + accessToken)
                    .header("accept", "application/json")
                    .asString();
            if (jsonResponse.getStatus() != 200) return null;
            return new ObjectMapper().reader().forType(FacebookPageModel.class).readValue(jsonResponse.getBody());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public FacebookPostModel getFacebookPost(String pageId, String accessToken) {
        try {
            HttpResponse<String> jsonResponse
                    = Unirest.get(Properties.FACEBOOK_API_LINK + "/v12.0/"+pageId+"/posts?fields=status_type,message,created_time&access_token=" + accessToken)
                    .header("accept", "application/json")
                    .asString();
            if (jsonResponse.getStatus() != 200) return null;
            return new ObjectMapper().reader().forType(FacebookPostModel.class).readValue(jsonResponse.getBody());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public FacebookReactionModel getFacebookReaction(String postId, String accessToken, FacebookReactionTypeEnum facebookReactionTypeEnum) {
        try {
            HttpResponse<String> jsonResponse
                    = Unirest.get(Properties.FACEBOOK_API_LINK + "/v12.0/"+postId+"?fields=reactions.type("+facebookReactionTypeEnum.name()+").limit(0).summary(total_count)&access_token=" + accessToken)
                    .header("accept", "application/json")
                    .asString();
            if (jsonResponse.getStatus() != 200) return null;
            return new ObjectMapper().reader().forType(FacebookReactionModel.class).readValue(jsonResponse.getBody());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

}
